class ItRevStr:

    def __init__(self, stringToReverse):
        self.stringToReverse = stringToReverse
        self.position = len(stringToReverse)

    def __next__(self):
        if self.position == 0:
            raise StopIteration
        self.position -= 1
        return self.stringToReverse[self.position]