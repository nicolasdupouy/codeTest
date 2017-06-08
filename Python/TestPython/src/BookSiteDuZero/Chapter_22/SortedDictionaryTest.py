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

        self.vegetables = SortedDictionary(carot = 26, bean = 48)


    # --- Special methods : accessibility ---
    # __getitem__
    def test_value_should_be_accessible_by_key(self):
        appleValue = self.fruits["apple"]
        self.assertEqual(52, appleValue)

        strawberryValue = self.fruits["strawberry"]
        self.assertEqual(128, strawberryValue)

    # __setitem__
    def test_value_should_be_modifiable_by_key(self):
        self.fruits["melon"] = 10
        self.assertEqual(10, self.fruits["melon"])

        self.fruits["melon"] = 15

    # __setitem__ (+ __delitem__)
    def test_value_should_be_addable(self):
        self.fruits["banana"] = 8
        self.assertEqual(8, self.fruits["banana"])

        del self.fruits["banana"]

    # __delitem__
    def test_unexisting_value_deletion_should_fail(self):
        with self.assertRaises(KeyError):
            del self.fruits["banana"]


    # --- Special methods : representation ---
    # __repr__
    def test_dictionary_should_be_represented(self):
        self.assertEqual(SortedDictionaryTest.FRUITS_REPRESENTATION_AFTER_DEFINITION, repr(self.fruits))

    # __str__
    def test_dictionary_should_be_printed_on_terminal(self):
        self.assertEqual(SortedDictionaryTest.FRUITS_REPRESENTATION_AFTER_DEFINITION, str(self.fruits))

    # --- Misc ---
    def test_dictionary_should_be_sorted(self):
        self.fruits.sort()
        self.assertEqual(SortedDictionaryTest.FRUITS_REPRESENTATION_AFTER_SORT, str(self.fruits))

if __name__ == '__main__':
    unittest.main()
