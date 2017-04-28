class Personne:

    def __init__(self, firstName, lastName):
        self.firstName = firstName
        self.lastName = lastName
        # The Christ age by default
        self._age = 33

    def _get_age(self):
        print("{} {} is {} years old.".format(self.firstName, self.lastName, self._age))
        return self._age

    def _set_age(self, new_age):
        self._age = new_age
        print("{} {} new age is now set to {}.".format(self.firstName, self.lastName, self._age))

    age = property(_get_age, _set_age)