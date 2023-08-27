from cc.dcc.usd.System import parpare_usdview_env
from cc.std.os import OS
from cc.std.sys import Sys

parpare_usdview_env(r"D:\learning\USD_build_py39\lib",r"D:\learning\USD_build_py39\bin")

if not Sys.isFrozen():
    OS.system(rf"cd /d {OS.dirnameTimes(__file__)} && D:\learning\venv\Scripts\pyside2-uic.exe main.ui -o main_ui.py")


