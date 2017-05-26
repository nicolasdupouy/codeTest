#!/opt/bin/python3

from SortedDictionary import *

import unittest

class SortedDictionaryTest(unittest.TestCase):

    def setUp(self):
        self.fruits = SortedDictionary()
        self.fruits["apple"] = 52
        self.fruits["peach"] = 34
        self.fruits["strawberry"] = 128
        self.fruits["melon"] = 15

    def test_SortedDictionary_should_be_represented(self):
        self.assertEqual("{'apple': 52, 'peach': 34, 'strawberry': 128, 'melon': 15}", repr(self.fruits))

if __name__ == '__main__':
    unittest.main()
