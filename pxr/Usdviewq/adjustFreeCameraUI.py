# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'D:/yjc/USD/pxr/usdImaging/usdviewq/adjustFreeCameraUI.ui',
# licensing of 'D:/yjc/USD/pxr/usdImaging/usdviewq/adjustFreeCameraUI.ui' applies.
#
# Created: Thu Apr  6 11:40:17 2023
#      by: pyside2-uic  running on PySide2 5.12.6
#
# WARNING! All changes made in this file will be lost!

from PySide2 import QtCore, QtGui, QtWidgets

class Ui_AdjustFreeCamera(object):
    def setupUi(self, AdjustFreeCamera):
        AdjustFreeCamera.setObjectName("AdjustFreeCamera")
        AdjustFreeCamera.resize(331, 140)
        self.verticalLayout = QtWidgets.QVBoxLayout(AdjustFreeCamera)
        self.verticalLayout.setObjectName("verticalLayout")
        self.horizontalLayout = QtWidgets.QHBoxLayout()
        self.horizontalLayout.setObjectName("horizontalLayout")
        self.verticalLayout_2 = QtWidgets.QVBoxLayout()
        self.verticalLayout_2.setObjectName("verticalLayout_2")
        self.overrideNear = QtWidgets.QCheckBox(AdjustFreeCamera)
        self.overrideNear.setFocusPolicy(QtCore.Qt.NoFocus)
        self.overrideNear.setObjectName("overrideNear")
        self.verticalLayout_2.addWidget(self.overrideNear)
        self.overrideFar = QtWidgets.QCheckBox(AdjustFreeCamera)
        self.overrideFar.setFocusPolicy(QtCore.Qt.NoFocus)
        self.overrideFar.setObjectName("overrideFar")
        self.verticalLayout_2.addWidget(self.overrideFar)
        self.horizontalLayout.addLayout(self.verticalLayout_2)
        self.verticalLayout_3 = QtWidgets.QVBoxLayout()
        self.verticalLayout_3.setObjectName("verticalLayout_3")
        self.nearSpinBox = QtWidgets.QDoubleSpinBox(AdjustFreeCamera)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Preferred, QtWidgets.QSizePolicy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.nearSpinBox.sizePolicy().hasHeightForWidth())
        self.nearSpinBox.setSizePolicy(sizePolicy)
        self.nearSpinBox.setDecimals(3)
        self.nearSpinBox.setMinimum(0.0)
        self.nearSpinBox.setMaximum(1000000000000.0)
        self.nearSpinBox.setSingleStep(1.0)
        self.nearSpinBox.setObjectName("nearSpinBox")
        self.verticalLayout_3.addWidget(self.nearSpinBox)
        self.farSpinBox = QtWidgets.QDoubleSpinBox(AdjustFreeCamera)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Preferred, QtWidgets.QSizePolicy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.farSpinBox.sizePolicy().hasHeightForWidth())
        self.farSpinBox.setSizePolicy(sizePolicy)
        self.farSpinBox.setDecimals(3)
        self.farSpinBox.setMinimum(0.0)
        self.farSpinBox.setMaximum(1000000000000.0)
        self.farSpinBox.setSingleStep(1.0)
        self.farSpinBox.setObjectName("farSpinBox")
        self.verticalLayout_3.addWidget(self.farSpinBox)
        self.horizontalLayout.addLayout(self.verticalLayout_3)
        self.verticalLayout.addLayout(self.horizontalLayout)
        self.horizontalLayout_2 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_2.setObjectName("horizontalLayout_2")
        self.lockFreeCamAspect = QtWidgets.QCheckBox(AdjustFreeCamera)
        self.lockFreeCamAspect.setFocusPolicy(QtCore.Qt.NoFocus)
        self.lockFreeCamAspect.setObjectName("lockFreeCamAspect")
        self.horizontalLayout_2.addWidget(self.lockFreeCamAspect)
        self.freeCamAspect = QtWidgets.QDoubleSpinBox(AdjustFreeCamera)
        self.freeCamAspect.setDecimals(3)
        self.freeCamAspect.setMinimum(0.0)
        self.freeCamAspect.setSingleStep(0.1)
        self.freeCamAspect.setObjectName("freeCamAspect")
        self.horizontalLayout_2.addWidget(self.freeCamAspect)
        self.verticalLayout.addLayout(self.horizontalLayout_2)
        self.horizontalLayout_3 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_3.setObjectName("horizontalLayout_3")
        self.freeCamFovLabel = QtWidgets.QLabel(AdjustFreeCamera)
        self.freeCamFovLabel.setFocusPolicy(QtCore.Qt.NoFocus)
        self.freeCamFovLabel.setObjectName("freeCamFovLabel")
        self.horizontalLayout_3.addWidget(self.freeCamFovLabel)
        self.freeCamFov = QtWidgets.QDoubleSpinBox(AdjustFreeCamera)
        self.freeCamFov.setDecimals(3)
        self.freeCamFov.setMinimum(0.0)
        self.freeCamFov.setMaximum(180.0)
        self.freeCamFov.setSingleStep(1.0)
        self.freeCamFov.setObjectName("freeCamFov")
        self.horizontalLayout_3.addWidget(self.freeCamFov)
        self.verticalLayout.addLayout(self.horizontalLayout_3)

        self.retranslateUi(AdjustFreeCamera)
        QtCore.QMetaObject.connectSlotsByName(AdjustFreeCamera)

    def retranslateUi(self, AdjustFreeCamera):
        AdjustFreeCamera.setWindowTitle(QtWidgets.QApplication.translate("AdjustFreeCamera", "Adjust Free Camera", None, -1))
        AdjustFreeCamera.setProperty("comment", QtWidgets.QApplication.translate("AdjustFreeCamera", "\n"
"     Copyright 2016 Pixar                                                                   \n"
"                                                                                            \n"
"     Licensed under the Apache License, Version 2.0 (the \"Apache License\")      \n"
"     with the following modification; you may not use this file except in                   \n"
"     compliance with the Apache License and the following modification to it:               \n"
"     Section 6. Trademarks. is deleted and replaced with:                                   \n"
"                                                                                            \n"
"     6. Trademarks. This License does not grant permission to use the trade                 \n"
"        names, trademarks, service marks, or product names of the Licensor                  \n"
"        and its affiliates, except as required to comply with Section 4(c) of               \n"
"        the License and to reproduce the content of the NOTICE file.                        \n"
"                                                                                            \n"
"     You may obtain a copy of the Apache License at                                         \n"
"                                                                                            \n"
"         http://www.apache.org/licenses/LICENSE-2.0                                         \n"
"                                                                                            \n"
"     Unless required by applicable law or agreed to in writing, software                    \n"
"     distributed under the Apache License with the above modification is                    \n"
"     distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY   \n"
"     KIND, either express or implied. See the Apache License for the specific               \n"
"     language governing permissions and limitations under the Apache License.               \n"
"  ", None, -1))
        self.overrideNear.setText(QtWidgets.QApplication.translate("AdjustFreeCamera", "Override Near", None, -1))
        self.overrideFar.setText(QtWidgets.QApplication.translate("AdjustFreeCamera", "Override Far", None, -1))
        self.lockFreeCamAspect.setText(QtWidgets.QApplication.translate("AdjustFreeCamera", "Aspect Ratio", None, -1))
        self.freeCamFovLabel.setText(QtWidgets.QApplication.translate("AdjustFreeCamera", "FOV (degrees)", None, -1))

