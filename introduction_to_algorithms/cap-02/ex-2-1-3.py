#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar  4 11:56:27 2018

@author: abrantesasf
"""

def buscaNumero(l, n):
    """
    buscaNumero:
    função para indicar o índice da localização de um número
    em uma lista de números
    
    Pré-requisitos: nenhum
            Inputs: 1) uma lista l de números
                    2) um número n a ser buscado na lista
           Outputs: o índice i da localização do numero n na lista,
                    ou None se a lista não conter n
        Limitações: não incluí checagens e validações
         Sugestões: Abrantes Araújo Silva Filho
                    abrantesasf@gmail.com
       Referências: Cap. 02 do Introduction to Algorithms, do Cormen
        Orientação: ---
            GitHub: https://github.com/abrantesasf/algoritmos/tree/master/introduction_to_algorithms/cap-02
    """
    for i in range(0, len(l)):
        if l[i] == n:
            return print('O índice do número ' + str(n) + ' é: ' + str(i))
    return None

lista = [1, 4, 6, 2, 8, 6, 10]
buscaNumero(lista, 8)
buscaNumero(lista, 5)
