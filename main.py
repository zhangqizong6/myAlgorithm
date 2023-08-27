import importlib
import os,env

import PySide2
from PySide2 import QtWidgets
from PySide2 import QtGui
from PySide2 import QtCore
from cc.dcc.usd.Stage import UsdStage
from cc.dcc.usd.System import open_usdview
from cc.pyside2.Common import processSleep
from cc.pyside2.widgets.uipy_main.Message import Message
from cc.std.os import OS
from cc.std.sys import Sys

from data_structure import Tree
from pxr.Usdviewq import AppController

import globs
import factory
from enums import AlgorithmType
from main_ui import Ui_MainWindow
import cc.icons_rc

import util


class MainWindow(QtWidgets.QMainWindow,Ui_MainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setupUi(self)
        self.init_usdview()
        self.init_ui()
        self.init_attrs()
        self.init_conn()

    def init_conn(self):
        self.pushButton.clicked.connect(lambda :importlib.reload(util) and self.util.create_random_tree())
        self.pushButton_2.clicked.connect(lambda :importlib.reload(util) and self.util.create_in_order_tree())
        self.pushButton_3.clicked.connect(lambda :importlib.reload(util) and self.util.generate_anim())
        self.pushButton_4.clicked.connect(lambda :importlib.reload(util) and  self.util.save_mp4())

    def init_ui(self):
        self.setWindowTitle("算法可视化~prprpr 0.01")
        self.setWindowIcon(QtGui.QIcon(":/assets/resource/ppr.png"))
        self.comboBox.addItems(AlgorithmType.get_map().values())

        # self.update_algorithm_names()
        self.update_usd_files()
        self.update_anim_comboBox()
        self.update_video_comboBox()
    def update_video_comboBox(self):
        self.comboBox_2.addItems(["gif","mp4"])

    def update_anim_comboBox(self):
        self.comboBox_4.addItem("前序遍历")

    def init_attrs(self):
        self.tree_fac:factory.UsdTreeFactory=None
        self.util=util.Util(self,self.usdview_controller)

    def init_usdview(self):
        empty_usda_path=OS.join(globs.usd_files_dir, "empty.usda")
        if OS.not_exist(empty_usda_path):
            with open(empty_usda_path,"w") as f:
                f.write("#usda 1.0")

        self.usdview_controller:AppController=open_usdview(empty_usda_path,isExecuting=False)
        self.usdview_controller._mainWindow.setSizePolicy(QtWidgets.QSizePolicy.Ignored, QtWidgets.QSizePolicy.Ignored)
        # self.usdview_controller._ui.primStageSplitter.setSizes([0,1])
        # self.usdview_controller._ui.topBottomSplitter.setSizes([0])
        self.usdview_controller.setViewerMode(True)
        self.verticalLayout.addWidget(self.usdview_controller._mainWindow)

    def update_usd_files(self):
        self.comboBox_3.addItems(OS.listdir(globs.examples_dir))




    def closeEvent(self, event:PySide2.QtGui.QCloseEvent) -> None:
        self.usdview_controller._mainWindow.closeEvent(event)
        super().closeEvent(event)






if __name__ == '__main__':
    app=QtWidgets.QApplication()
    window=MainWindow()
    window.show()
    app.exec_()
    pass