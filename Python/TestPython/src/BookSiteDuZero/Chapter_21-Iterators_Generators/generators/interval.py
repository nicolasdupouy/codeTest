
def interval(lowerBound, upperBound):
        while (lowerBound <= upperBound):
            receivedValue = (yield lowerBound)
            if receivedValue is not None:
                lowerBound = receivedValue
            else:
                lowerBound += 1