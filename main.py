import importlib
import os,env

import PySide2
from PySide2 import QtWidgets
from PySide2 import QtGui
from PySide2 import QtCore
from cc.dcc.usd.Stage import UsdStage
from cc.dcc.usd.System import open_usdview
from cc.std.os import OS
from cc.std.sys import Sys
from pxr.Usdviewq import AppController

import globs
import factory
from enums import AlgorithmType
from main_ui import Ui_MainWindow


class MainWindow(QtWidgets.QMainWindow,Ui_MainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setupUi(self)
        self.init_usdview()
        self.init_ui()
        self.init_conn()
    def init_conn(self):
        self.pushButton.clicked.connect(self.create_random_tree)

    def init_ui(self):
        self.comboBox.addItems(AlgorithmType.get_map().values())

        self.update_algorithm_names()
        self.update_usd_files()


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
    def update_algorithm_names(self):
        self.comboBox_2.addItems(AlgorithmType.get_details()[self.comboBox.currentIndex()])

    def create_random_tree(self):
        if not Sys.isFrozen():
            importlib.reload(factory)
        self.tree_fac=factory.UsdTreeFactory(OS.join(globs.examples_dir,self.comboBox_3.currentText()))
        tree_stage_path=self.tree_fac.create_random_tree(int(self.lineEdit.text() or 10))
        self.usdview_controller._parserData.usdFile = str(tree_stage_path)
        self.usdview_controller._mainWindow.setWindowTitle(tree_stage_path)
        self.usdview_controller._reopenStage()

    def closeEvent(self, event:PySide2.QtGui.QCloseEvent) -> None:
        self.usdview_controller._mainWindow.closeEvent(event)
        super().closeEvent(event)






if __name__ == '__main__':
    app=QtWidgets.QApplication()
    window=MainWindow()
    window.show()
    app.exec_()
    pass