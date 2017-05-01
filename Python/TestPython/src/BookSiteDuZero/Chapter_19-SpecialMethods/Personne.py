class Personne:

    def __init__(self, firstName, lastName):
        self.firstName = firstName
        self.lastName = lastName
        self.age = 33

    def __repr__(self):
        return "[__repr__] firstName: {}, lastName: {}, age: {}".format(self.firstName, self.lastName, self.age);

    def __str__(self):
        return "[__str__] firstName: {}, lastName: {}, age: {}".format(self.firstName, self.lastName, self.age);
