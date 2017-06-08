from ItRevStr import *

class RevStr(str):
    def __iter__(self):
        return ItRevStr(self)