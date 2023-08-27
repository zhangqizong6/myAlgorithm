# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'D:/yjc/USD/pxr/usdImaging/usdviewq/preferencesUI.ui',
# licensing of 'D:/yjc/USD/pxr/usdImaging/usdviewq/preferencesUI.ui' applies.
#
# Created: Thu Apr  6 11:40:20 2023
#      by: pyside2-uic  running on PySide2 5.12.6
#
# WARNING! All changes made in this file will be lost!

from PySide2 import QtCore, QtGui, QtWidgets

class Ui_Preferences(object):
    def setupUi(self, Preferences):
        Preferences.setObjectName("Preferences")
        Preferences.resize(295, 99)
        self.verticalLayout = QtWidgets.QVBoxLayout(Preferences)
        self.verticalLayout.setObjectName("verticalLayout")
        self.prefsOverButtonsLayout = QtWidgets.QVBoxLayout()
        self.prefsOverButtonsLayout.setObjectName("prefsOverButtonsLayout")
        self.horizontalLayout_3 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_3.setObjectName("horizontalLayout_3")
        self.fontSizeLabel = QtWidgets.QLabel(Preferences)
        self.fontSizeLabel.setObjectName("fontSizeLabel")
        self.horizontalLayout_3.addWidget(self.fontSizeLabel)
        self.fontSizeSpinBox = QtWidgets.QSpinBox(Preferences)
        self.fontSizeSpinBox.setMinimum(6)
        self.fontSizeSpinBox.setProperty("value", 10)
        self.fontSizeSpinBox.setObjectName("fontSizeSpinBox")
        self.horizontalLayout_3.addWidget(self.fontSizeSpinBox)
        spacerItem = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.horizontalLayout_3.addItem(spacerItem)
        self.prefsOverButtonsLayout.addLayout(self.horizontalLayout_3)
        spacerItem1 = QtWidgets.QSpacerItem(20, 40, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.prefsOverButtonsLayout.addItem(spacerItem1)
        self.line = QtWidgets.QFrame(Preferences)
        self.line.setFrameShape(QtWidgets.QFrame.HLine)
        self.line.setFrameShadow(QtWidgets.QFrame.Sunken)
        self.line.setObjectName("line")
        self.prefsOverButtonsLayout.addWidget(self.line)
        self.horizontalLayout_2 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_2.setObjectName("horizontalLayout_2")
        spacerItem2 = QtWidgets.QSpacerItem(40, 20, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.horizontalLayout_2.addItem(spacerItem2)
        self.buttonBox = QtWidgets.QDialogButtonBox(Preferences)
        self.buttonBox.setStandardButtons(QtWidgets.QDialogButtonBox.Apply|QtWidgets.QDialogButtonBox.Cancel|QtWidgets.QDialogButtonBox.Ok)
        self.buttonBox.setObjectName("buttonBox")
        self.horizontalLayout_2.addWidget(self.buttonBox)
        self.prefsOverButtonsLayout.addLayout(self.horizontalLayout_2)
        self.verticalLayout.addLayout(self.prefsOverButtonsLayout)

        self.retranslateUi(Preferences)
        QtCore.QMetaObject.connectSlotsByName(Preferences)

    def retranslateUi(self, Preferences):
        Preferences.setWindowTitle(QtWidgets.QApplication.translate("Preferences", "Preferences", None, -1))
        Preferences.setProperty("comment", QtWidgets.QApplication.translate("Preferences", "\n"
"     Copyright 2020 Pixar                                                                   \n"
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
        self.fontSizeLabel.setText(QtWidgets.QApplication.translate("Preferences", "Font Size", None, -1))

