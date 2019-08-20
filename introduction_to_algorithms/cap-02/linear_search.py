#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: abrantesasf
"""


def linear_search(l, n):
    """
    Faz a busca por um número n em uma lista l, utilizando um simples
    algoritmo de busca linear.

       Descrição: esta função implementa um algoritmo LINEAR SEARCH
                  (busca linear), que procura um valor numérico inteiro
                  em uma lista de inteiros. A função retorna o índice
                  i tal que l[i] = n, se o número for encontrado, ou
                  retorna None.
      Requisitos: -
          Inputs: l     = lista de números
         Outputs: -
         Returns: Se n for encontrado:
                     retorna i tal que l[i] = n
                  Se n não for encontrado
                     retorna None
     Observações: -
    Complexidade: O(n)
      Limitações: não inclui checagens e validações
           To do: -
     Referências: Cormen TH. et al. Introduction to Algorithms, 3. ed., 2009.
      Pogramador: Abrantes Araújo Silva Filho
       Copyright: -
       Licensing: -
       Sugestões: abrantesasf@gmail.com
      Orientação: ---
             URL: https://github.com/abrantesasf/algoritmos/tree/master/introduction_to_algorithms/cap-02
    """
    for i in range(len(l)):
        if l[i] == n:
            return i
    return None


lista = [4, 6, 1, 3, 0, 9, 100]
print(linear_search(lista, 0))
print(linear_search(lista, 4))
print(linear_search(lista, 99))
