import time,env
from typing import List

from cc.dcc.usd.Attribute import UsdAttribute, pl_SdfValueTypeNames
from cc.dcc.usd.Prim import copyPrim2Prim
from cc.dcc.usd.UsdCmdsHint import UsdPrimHint
from cc.dcc.usd.common import joinPrimPaths
from cc.dcc.usd.Stage import UsdStage
from cc.std.os import OS

import globs
from data_structure import TreeNode, Tree
from pxr import Gf


class UsdTreeFactory:
    def __init__(self,usd_node_path,usd_type="usda"):
        self.usd_node_path=usd_node_path
        self.usd_name = OS.basename(self.usd_node_path)

        self.stage=UsdStage.open(self.usd_node_path)
        self.usd_type=usd_type
        self.default_prim=self.stage.GetDefaultPrim()
        self._retrieve_extent()
    def _retrieve_extent(self):
        min_x,min_y,min_z,max_x,max_y,max_z=None,None,None,None,None,None
        for prim in self.stage.TraverseAll():
            extent_attr=prim.GetAttribute("extent").Get()
            if extent_attr is None:
                continue
            ever_min_x, ever_min_y, ever_min_z=extent_attr[0]
            ever_max_x, ever_max_y, ever_max_z=extent_attr[1]
            if min_x is None:
                min_x,min_y,min_z=extent_attr[0]
                max_x,max_y,max_z=extent_attr[1]
            else:
                if ever_min_x<min_x:
                    min_x=ever_min_x
                if ever_min_y < min_y:
                    min_y = ever_min_y
                if ever_min_z < min_z:
                    min_z = ever_min_z

                if ever_max_x > max_x:
                    max_x = ever_max_x
                if ever_max_y > max_y:
                    max_y = ever_max_y
                if ever_max_z > max_z:
                    max_z = ever_max_z

        print(min_x,min_y,min_z,max_x,max_y,max_z)

        self.extent=[min_x,min_y,min_z],[max_x,max_y,max_z]
        self.width = abs(self.extent[1][0] - self.extent[0][0])


    def create_tree(self, tree:Tree, output_path=None):
        print(tree.to_json())
        usd_tree_stage_path=output_path or OS.join(globs.temp_dir,f"{self.usd_name}_tree.{self.usd_type}")
        print(usd_tree_stage_path)
        self.usd_tree_stage=UsdStage.new(usd_tree_stage_path)
        self.usd_tree_stage.Reload()
        root_path = joinPrimPaths("tree")
        tree_prim=self.usd_tree_stage.DefinePrim(root_path)
        self.usd_tree_stage.SetDefaultPrim(tree_prim)
        first_prim=self.usd_tree_stage.DefinePrim(joinPrimPaths(root_path, self.usd_name))
        self._duplicated_default(first_prim)

        # tree=Tree.from_json({'Right': {'Left': {}, 'Right': {}}})

        # for i in range(max_count):
        #

        def _f(objs:List[UsdPrimHint], nodes: List[TreeNode],layer=0):
            next_nodes = []
            next_objects = []

            for idx, node in enumerate(nodes):
                if node.left:
                    next_nodes.append(node.left)
                if node.right:
                    next_nodes.append(node.right)
            for idx, node in enumerate(nodes):
                if node.left and node.left.right:
                    # left_interval = 2 ** (node.left.right.get_max_layer() - node.layer - 1)
                    left_interval = (len(node.left.right.preorder())) + self.width
                else:
                    left_interval = self.width
                if node.right and node.right.left:
                    # right_interval = 2 ** (node.right.left.get_max_layer() - node.layer - 1)
                    right_interval = (len(node.right.left.preorder())) + self.width
                else:
                    right_interval = self.width

                parent_object = objs[idx]
                parent_t = UsdAttribute.get_translate(parent_object)
                if node.left:
                    left_index=str(node.left.index)
                    left_child_t = [parent_t[0] - left_interval, parent_t[1]-1, parent_t[2]]
                    left_object = self._duplicated_default(self.usd_tree_stage.DefinePrim(OS.join(root_path, f"{self.usd_name}_{left_index}")))
                    UsdAttribute.set_translate(left_object,left_child_t)
                    UsdAttribute.xformOpOrder(left_object,[UsdAttribute.XformOp.translate])
                    next_objects.append(left_object)

                if node.right:
                    right_index=str(node.right.index)
                    right_child_t = [parent_t[0] + right_interval, parent_t[1] -1, parent_t[2]]
                    right_object = self._duplicated_default(self.usd_tree_stage.DefinePrim(OS.join(root_path, f"{self.usd_name}_{right_index}")))
                    UsdAttribute.set_translate(right_object,right_child_t)
                    UsdAttribute.xformOpOrder(right_object,[UsdAttribute.XformOp.translate])
                    next_objects.append(right_object)
            if not next_nodes:
                return
            _f(next_objects, next_nodes,layer+1)

        _f([first_prim], [tree.root])

        self.usd_tree_stage.SetMetadata("upAxis","Y")
        self.usd_tree_stage.Save()

        return usd_tree_stage_path


    def _duplicated_default(self, prim):
        copyPrim2Prim(self.default_prim,prim)
        return prim

    def generate_pre_order_anim(self):
        current_frame=0
        anim_interval=4
        scale_scale=1/anim_interval
        self.usd_tree_stage.SetStartTimeCode(0)
        for ever in self.usd_tree_stage.GetDefaultPrim().GetChildren():
            scale_attr=ever.CreateAttribute(UsdAttribute.XformOp.scale, pl_SdfValueTypeNames.Float3,custom=False)
            scale_attr.Set(Gf.Vec3f([0,0,0]))
            for f in range(anim_interval+1):
                s=scale_scale * (f)
                scale_attr.Set(Gf.Vec3f([s,s,s]),current_frame+f)
            current_frame+=anim_interval
            UsdAttribute.xformOpOrder(ever,[UsdAttribute.XformOp.translate,UsdAttribute.XformOp.scale])
        self.usd_tree_stage.SetEndTimeCode(current_frame)
        self.usd_tree_stage.SetFramesPerSecond(24)
        self.usd_tree_stage.Save()





if __name__ == '__main__':
    fac=UsdTreeFactory(OS.join(globs.examples_dir,"pig.usd"))
    fac.create_tree(1)

