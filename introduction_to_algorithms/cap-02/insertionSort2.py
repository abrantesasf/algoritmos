#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 11:07:04 2018
@author: abrantesasf
"""


def insertion_sort2(l, ordem='asc'):
    """
    Faz a ordenação de uma lista de números em ordem ascendente ou
    descendente utilizando o algoritmo de INSERTION SORT. A lista que é
    recebida como parâmetro é modificada in-place.

       Descrição: esta função implementa o algoritmo de INSERTION SORT
                  (ordenação por inserção), um algoritmo eficiente para
                  ordenar um número pequeno de elementos, com um
                  parâmetro opcional para ordenar a lista em ordem
                  crescente ou decrescente. O padrão é realizar a
                  ordenação em ordem crescente.
      Requisitos: -
          Inputs: l     = lista de números
                  ordem = <asc|desc>
         Outputs: imprime a lista ordenada
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

    # Inicia Loop com o SEGUNDO número da lista:
    for j in range(1, len(l)):
        # Pega o VALOR do segundo número da lista
        atual = l[j]

        # Cria índice para o NÚMERO ANTERIOR na lista
        i = j - 1

        # Verifica ordem ascendente ou descendente
        if ordem == 'asc':
            # Inicia while verificando se o índice é >= 0 E se o
            # valor do número anterior na lista é maior do que o número atual
            while i >= 0 and l[i] > atual:
                # Se o número ANTERIOR é MAIOR do que o ATUAL,
                # torna o número ATUAL = ANTERIOR
                l[i + 1] = l[i]

                # Diminui o índice para checar o segundo anterior
                i = i - 1
        elif ordem == 'desc':
            # Inicia while verificando se o índice é >= 0 E se o
            # valor do número anterior na lista é menor do que o número atual
            while i >= 0 and l[i] < atual:
                # Se o número ANTERIOR é MENOR do que o ATUAL,
                # torna o número ATUAL = ANTERIOR
                l[i + 1] = l[i]

                # Diminui o índice para checar o segundo anterior
                i = i - 1
        else:
            return print('ERRO: a ordem deve ser especificada como \'asc\' ou \'desc\'')

        # Se i < 0, então não há mais nenhum número anterior,
        # e podemos colocar o anterior com o valor atual
        l[i + 1] = atual

    # Retorna a lista ordenada
    print(l)


a = [5, 2, 4, 6, 1, 3, 9, 11, 4, 0, 2, 4, 1, 9, 100]
b = [31, 41, 59, 26, 41, 58]
c = [3, 1, 4, 2]
insertion_sort2(a, 'desc')
insertion_sort2(a, 'asc')
insertion_sort2(b)
insertion_sort2(c, 'desc')
insertion_sort2(c, 'errado')
print(a)
