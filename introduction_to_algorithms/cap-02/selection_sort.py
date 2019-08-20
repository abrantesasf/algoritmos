#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: abrantesasf
"""


def selection_sort(l):
    """
    Faz a ordenação de números em uma lista l, utilizando um algoritmo simples
    de SELECTION SORT. A lista que é recebida como parâmetro é ordenada
    in-place.

       Descrição: esta função implementa um algoritmo de SELECTION SORT
                  (ordenação por seleção), um algoritmo eficiente para
                  ordenar um número pequeno de elementos. A lista de números é
                  ordenada de modo crescente.
      Requisitos: -
          Inputs: l (lista de números)
         Outputs: Imprime a lista ordenada.
         Returns: -
     Observações: -
    Complexidade: O(n^2)
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
    for i in range(len(l) - 1):
        menor = i
        for j in range(i + 1, len(l)):
            if l[j] < l[menor]:
                menor = j
        l[menor], l[i] = l[i], l[menor]
    print(l)


a = [3, 0, 6, 1, 9, 0, 0, 77]
selection_sort(a)
print(a)
