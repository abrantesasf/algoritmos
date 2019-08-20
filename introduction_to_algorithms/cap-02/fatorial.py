#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: abrantesasf
"""


def fatorial_iterativo(n):
    """
    Calcula o fatorial (n!) de um número n.

       Descrição: esta função implementa um algoritmo iterativo para o cálculo
                  do fatorial de um número n (n!).
      Requisitos: -
          Inputs: n (número inteiro)
         Outputs: -
         Returns: n!
     Observações: -
    Complexidade: O(?)
      Limitações: não inclui checagens e validações
           To do: -
     Referências: -
      Pogramador: Abrantes Araújo Silva Filho
       Copyright: -
       Licensing: -
       Sugestões: abrantesasf@gmail.com
      Orientação: ---
             URL: https://github.com/abrantesasf/algoritmos/tree/master/introduction_to_algorithms/cap-02
    """
    resultado = 1
    for i in range(1, n+1):
        resultado *= i
    return resultado


print(fatorial_iterativo(5))
