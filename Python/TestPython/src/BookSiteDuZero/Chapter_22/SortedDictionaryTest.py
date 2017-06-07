#!/opt/bin/python3

from SortedDictionary import *

import unittest

class SortedDictionaryTest(unittest.TestCase):

    FRUITS_REPRESENTATION_AFTER_DEFINITION = "{'apple': 52, 'peach': 34, 'strawberry': 128, 'melon': 15}"
    FRUITS_REPRESENTATION_AFTER_SORT = "{'apple': 52, 'melon': 15, 'peach': 34, 'strawberry': 128}"

    def setUp(self):
        self.fruits = SortedDictionary()
        self.fruits["apple"] = 52
        self.fruits["peach"] = 34
        self.fruits["strawberry"] = 128
        self.fruits["melon"] = 15

    def test_dictionary_should_be_represented(self):
        self.assertEqual(SortedDictionaryTest.FRUITS_REPRESENTATION_AFTER_DEFINITION, repr(self.fruits))

    def test_value_should_be_accessible_by_key(self):
        appleValue = self.fruits["apple"]
        self.assertEqual(52, appleValue)

        strawberryValue = self.fruits["strawberry"]
        self.assertEqual(128, strawberryValue)


    def test_dictionary_should_be_sorted(self):
        self.fruits.sort()
        self.assertEqual(SortedDictionaryTest.FRUITS_REPRESENTATION_AFTER_SORT, str(self.fruits))

if __name__ == '__main__':
    unittest.main()
