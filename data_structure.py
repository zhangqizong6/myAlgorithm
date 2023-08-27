import math
import pprint
import random
from typing import List
class TreeNode:
    class Type:
        Left="Left"
        Right="Right"
        Root="Root"

    def __init__(self,type_,object_name=""):
        self.parent:TreeNode = None
        self.type_=type_
        self.object_name=object_name
        self.left:TreeNode = None
        self.right:TreeNode = None
        self.layer=0
        self.index=None
        self.max_layer=None
        self.max_left_layer=None
        self.max_right_layer=None
    @classmethod
    def left_node(cls):
        return cls(TreeNode.Type.Left)
    @classmethod
    def right_node(cls):
        return cls(TreeNode.Type.Right)

    def create_left(self):
        self.left=TreeNode.left_node()
        self.left.layer=self.layer+1
        return self.left
    def create_right(self):


        self.right=TreeNode.right_node()
        self.right.layer = self.layer + 1
        return self.right

    def create_both(self):
        self.left=TreeNode.left_node()
        self.left.layer=self.layer+1
        self.right=TreeNode.right_node()
        self.right.layer = self.layer + 1
        return self.left,self.right

    def get_max_layer(self):
        if self.max_layer is None:
            nodes=self.preorder()
            layers=[]
            for node in nodes:
                layers.append(node.layer)
            self.max_layer=max(layers)

        return self.max_layer

    def get_right_max_layer(self):
        if self.max_right_layer is None:
            nodes=self.right.preorder()
            layers=[]
            for node in nodes:
                if node.type_==TreeNode.Type.Right:
                    layers.append(node.layer)
            self.max_right_layer=max(layers)

        return self.max_right_layer

    def get_left_max_layer(self):
        if self.max_left_layer is None:
            nodes=self.left.preorder()
            layers=[]
            for node in nodes:
                if node.type_==TreeNode.Type.Left:
                    layers.append(node.layer)
            self.max_left_layer = max(layers)
        return self.max_left_layer

    @classmethod
    def inorder(cls,max_count):
        TreeNode.Count=0
        TreeNode.MAX_COUNT=max_count

        def _f(nodes:List[TreeNode]):
            layer_nodes=[]

            for node in nodes:
                left_node = TreeNode()
                layer_nodes.append(left_node)
                node.left=left_node

                right_node = TreeNode()
                layer_nodes.append(right_node)
                node.right = right_node
            _f(layer_nodes)
        instance=cls()
        try:
            _f([instance])
        except TreeNode.FullException:
            return instance
    def preorder(self):
        nodes:List[TreeNode]=[]
        def _f(node:TreeNode):
            if not node:
                return
            nodes.append(node)
            # print(node)
            _f(node.left)
            _f(node.right)
        _f(self)
        return nodes

    def __str__(self):
        if self.parent:
            return f"{'--'*self.layer}{self.type_}TreeNode(layer={self.layer},index={self.index},parent={self.parent.index})"
        else:
            return f"{'--'*self.layer}{self.type_}TreeNode(layer={self.layer},index={self.index})"


class Tree:
    class FullException(Exception):
        pass
    def __init__(self,max_count=99999):
        self.count=0
        self.max_count=max_count
        self.max_layer=0
        self.root=None
    def add_child(self,node:TreeNode):
        node.index = self.count
        self.count+=1

        if self.count>self.max_count:
            raise Tree.FullException


    @classmethod
    def random(cls,max_count):

        tree=Tree(max_count)
        def _f(nodes:List[TreeNode],layer=0):
            layer_nodes=[]
            r=random.randint(0,2)
            for node in nodes:
                if r==0:
                    left=TreeNode(TreeNode.Type.Left)
                    node.left=left
                    left.parent = node
                    layer_nodes.append(left)
                    tree.add_child(left)
                    left.layer=layer

                elif r==1:
                    right = TreeNode(TreeNode.Type.Right)
                    node.right = right
                    layer_nodes.append(right)
                    right.parent=node
                    tree.add_child(right)
                    right.layer=layer

                else:
                    left = TreeNode(TreeNode.Type.Left)
                    node.left = left
                    left.parent=node
                    tree.add_child(left)
                    layer_nodes.append(left)
                    left.layer=layer

                    right = TreeNode(TreeNode.Type.Right)
                    node.right = right
                    layer_nodes.append(right)
                    right.parent=node
                    tree.add_child(right)
                    right.layer=layer

            tree.max_layer+=1
            _f(layer_nodes,layer+1)

        instance=TreeNode(TreeNode.Type.Root)
        try:
            tree.add_child(instance)
            tree.max_layer += 1

            tree.root = instance
            _f([instance])
        except Tree.FullException:
            return tree

    def to_json(self):
        def _f(node):
            print(node)
            j = {}
            if node.left:
                j[TreeNode.Type.Left]=_f(node.left)
            if node.right:
                j[TreeNode.Type.Right] = _f(node.right)
            return j

        return _f(self.root)
    @classmethod
    def from_json(cls,j:dict):
        tree=cls()
        instance=TreeNode(TreeNode.Type.Root)
        tree.add_child(instance)
        tree.root=instance
        tree.max_layer += 1
        def _f(node,_j):
            _j_left = _j.get(TreeNode.Type.Left)
            if _j_left is not None:
                left = node.create_left()
                tree.add_child(left)
                _f(left, _j_left)
            _j_right = _j.get(TreeNode.Type.Right)
            if _j_right is not None:
                right = node.create_right()
                tree.add_child(right)
                _f(right, _j_right)
            tree.max_layer+=1
        _f(instance,j)
        return tree



if __name__ == '__main__':
    tree = Tree.random(10)
    j=tree.to_json()
    new_tree=Tree.from_json(j)
    nodes=new_tree.root.preorder()
    for node in nodes:
        print(node)
    # tree.preorder()
    # print(tree)
    # print(tree.left,tree.right)
