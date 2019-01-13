
def cutList(l, cutNumber):
    lWithoutStart = l[cutNumber:]
    lWithoutEnd = l[: -cutNumber]
    return (lWithoutStart, lWithoutEnd, 'N')

if __name__ == '__main__':
    A = [1, 2, 3]
    B = A
    C = A[:]
 
    B[0] = 5
    C[1] = 78

    longList = [1,2,3,4,5,6,7,8,9,10]
    result = cutList(longList, 1)

    M = [[[0] * 2] * 5] * 3
    M[0][1][1] = 4

    print(result)