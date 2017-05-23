class SortedDictionary:

    def __init__(self):
        self._keys = []
        self._values = []

    def __setitem__(self, key, value):
        self._keys.append(key)
        self._values.append(value)
