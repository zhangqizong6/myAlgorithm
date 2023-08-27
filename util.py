import importlib

from cc.pyside2.widgets.uipy_main.Message import Message
from cc.std.os import OS
from cc.std.shutil import Shutil
from cc.std.sys import Sys

import factory
import globs
from data_structure import Tree
from pxr.Usdviewq import AppController
from main_ui import Ui_MainWindow

def _reload(func):
    def _f(*args,**kwargs):
        if not Sys.isFrozen():
            importlib.reload(factory)
        return func(*args,**kwargs)
    return _f

class _ReloadMeta(type):
    def __new__(meta, name, bases, class_dict):
        cls = type.__new__(meta, name, bases, class_dict)
        for attr in dir(cls):
            if attr.startswith("__"):
                continue
            value=getattr(cls,attr)

            if callable(value):
                setattr(cls,attr,_reload(value))


        return cls


class Util:
    def __init__(self,ui,usdview_controller:AppController):
        self.ui:Ui_MainWindow= ui
        self.usdview_controller = usdview_controller



    def _open_file_in_usdview(self, tree_stage_path):
        self.usdview_controller._parserData.usdFile = str(tree_stage_path)
        self.usdview_controller._mainWindow.setWindowTitle(tree_stage_path)
        self.usdview_controller._reopenStage()

    def create_random_tree(self):

        self.tree_fac=factory.UsdTreeFactory(OS.join(globs.examples_dir,self.ui.comboBox_3.currentText()))
        tree = Tree.random(int(self.ui.lineEdit.text() or 10))
        tree_stage_path=self.tree_fac.create_tree(tree)

        self._open_file_in_usdview(tree_stage_path)
    def create_in_order_tree(self):

        self.tree_fac=factory.UsdTreeFactory(OS.join(globs.examples_dir,self.ui.comboBox_3.currentText()))
        tree = Tree.create_in_order(int(self.ui.lineEdit.text() or 10))
        tree_stage_path=self.tree_fac.create_tree(tree)
        self._open_file_in_usdview(tree_stage_path)

    def generate_anim(self):
        if self.tree_fac is None:
            Message.info(self,"请先创建一棵树再生成动画")
            return
        self.tree_fac.generate_pre_order_anim()
        self.usdview_controller._reopenStage()

    def save_mp4(self):
        cache_dir = OS.join(globs.temp_dir, "_cache")
        Shutil.rmtree(cache_dir)
        OS.makedirs(cache_dir)
        maximum = self.usdview_controller._ui.frameSlider.maximum()
        minimum = self.usdview_controller._ui.frameSlider.minimum()
        image_type="jpg"

        for f in range(minimum, maximum):
            self.usdview_controller._setFrameIndex(f)
            self.usdview_controller.saveFrame(OS.join(cache_dir,f"{f}.{image_type}"),image_type)
        print(cache_dir)
        output_path=OS.join(globs.output_dir,'output.mp4')
        fps=24
        cmd = rf"cd /d {cache_dir} && {globs.ffmpeg_path} -r {fps} -f  image2 -i %d.{image_type} {output_path} -y"
        print(cmd)
        OS.system(cmd)



