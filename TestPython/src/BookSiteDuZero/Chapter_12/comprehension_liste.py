#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

if __name__ == '__main__':
    qtt_a_retirer=7
    fruits_stockés = [15, 3, 18, 21]
    
    new_list = [nb_fruits-qtt_a_retirer for nb_fruits in fruits_stockés if nb_fruits > qtt_a_retirer]
    print(new_list)