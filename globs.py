from cc.std.shutil import Shutil
from cc.std.os import OS

temp_dir=OS.join(OS.tempdir(),"__USD__")
Shutil.rmtree(temp_dir)
OS.makedirs(temp_dir)
current_dir=OS.dirnameTimes(__file__)
output_dir=OS.join(current_dir,"output")
_3rd_party=OS.join(current_dir,"3rd_party")
ffmpeg_path=OS.join(_3rd_party,"ffmpeg.exe")

usd_files_dir=OS.join(current_dir,"usd_files")
examples_dir=OS.join(usd_files_dir,"examples")
