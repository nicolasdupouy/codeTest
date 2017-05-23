#!/opt/bin/python3

from SortedDictionary import *

import unittest

class SortedDictionaryTest(unittest.TestCase):

    def test_SortedDictionary_should_be_represented(self):
        fruits = SortedDictionary()
        fruits["apple"] = 52
        fruits["peach"] = 34
        fruits["strawberry"] = 128
        fruits["melon"] = 15
        self.assertEqual("{'apple': 52, 'peach': 34, 'strawberry': 128, 'melon': 15}", fruits)

if __name__ == '__main__':
    unittest.main()
