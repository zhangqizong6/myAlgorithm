from cc.dcc.usd.System import parpare_usdview_env
from cc.std.os import OS
from cc.std.sys import Sys

cur_dir = OS.dirnameTimes(__file__)

parpare_usdview_env(rf"{cur_dir}\usd_39\lib",fr"{cur_dir}\usd_39\bin")

if not Sys.isFrozen():
    uic=r"C:\repo\myAlgorithm\venv\Scripts\pyside2-uic.exe"
    OS.system(rf"cd /d {cur_dir} && {uic} main.ui -o main_ui.py")


