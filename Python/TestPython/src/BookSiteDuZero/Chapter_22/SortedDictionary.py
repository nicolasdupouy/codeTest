class SortedDictionary:

    def __init__(self, **parameters):
        self._keys = []
        self._values = []

        for a,b in enumerate(parameters):
            self._keys.append(b)
            self._values.append(parameters[b])


    # --- Special methods : accessibility ---
    def __getitem__(self, key):
        if key not in self._keys:
            raise KeyError("Unavailable key {0}".format(key))
        else:
            index = self._keys.index(key)
            return self._values[index]

    def __setitem__(self, key, value):
        if key in self._keys:
            index = self._keys.index(key)
            self._values[index] = value
        else:
            self._keys.append(key)
            self._values.append(value)

    def __delitem__(self, key):
        if key not in self._keys:
            raise KeyError("Unavailable key {0}".format(key))
        else:
            index = self._keys.index(key)
            del self._keys[index]
            del self._values[index]


    # --- Special methods : arithmetic ---
    def __add__(self, other):
        newSortedDictionary = SortedDictionary()
        for key, value in self.items():
            newSortedDictionary[key] = value

        for key, value in other.items():
            newSortedDictionary[key] = value

        return newSortedDictionary


    def items(self):
        for i, key in enumerate(self._keys):
            value = self._values[i]
            yield (key, value)


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
