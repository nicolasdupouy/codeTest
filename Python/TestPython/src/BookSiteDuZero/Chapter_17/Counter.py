class Counter:

    createdObjects = 0

    def __init__(self):
        Counter.createdObjects += 1

    def displayCreationNumber(self):
        print("{} objects created.", Counter.createdObjects)