class SortedDictionary:

    def __init__(self):
        self._keys = []
        self._values = []


    # --- Special methods : accessibility ---
    def __getitem__(self, key):
        if key not in self._keys:
            raise KeyError("Unavailable key {0}".format(key))
        else:
            index = self._keys.index(key)
            return self._values[index]

    def __setitem__(self, key, value):
        self._keys.append(key)
        self._values.append(value)


    # --- Special methods : representation ---
    def __repr__(self):
        numberOfElements = len(self._keys)

        representation = "{"
        for i, key in enumerate(self._keys):
            representation += "'" + key + "': "
            representation += str(self._values[i])

            if i+1 < numberOfElements:
                representation += ", "

        return representation + "}"

    def __str__(self):
        return repr(self)


    # --- Misc ---
    def sort(self):
        sortedKeys = sorted(self._keys)
        sortedValues = []
        for key in sortedKeys:
            sortedValues.append(self[key])

        self._keys = sortedKeys
        self._values = sortedValues
