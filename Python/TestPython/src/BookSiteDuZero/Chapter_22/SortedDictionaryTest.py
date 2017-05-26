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

    def test_dictionary_should_be_represented(self):
        self.assertEqual("{'apple': 52, 'peach': 34, 'strawberry': 128, 'melon': 15}", repr(self.fruits))

    def test_dictionary_should_be_sorted(self):
        self.fruits.sort()
        self.assertEqual("{'melon': 15, 'peach': 34, 'apple': 52, 'strawberry': 128}", str(self.fruits))

if __name__ == '__main__':
    unittest.main()
