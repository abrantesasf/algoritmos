#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 11:07:04 2018
@author: abrantesasf
"""

def insertionSort2(l, ordem = 'asc'):
    """
    insertionSort2:
    função para realizar um sort com o algoritmo INSERTION SORT, com a opção
    de especificar se o sort será realizado em ordem ascendente (padrão) ou
    em ordem descendente.
    
    Pré-requisitos: nenhum
            Inputs: 1) l = uma lista de números
                    2) ordem = uma string que pode ser 'asc' ou 'desc'
                               e determina se o sort será realizado em
                               ordem ascendente (padrão) ou descencente.
           Outputs: imprime a lista ordenada
        Limitações: não incluí checagens e validações
         Sugestões: Abrantes Araújo Silva Filho
                    abrantesasf@gmail.com
       Referências: Cormen, Thomas H. et al. Introduction to Algorithms,
                    3. ed., 2009.
        Orientação: ---
               URL: https://github.com/abrantesasf/algoritmos/tree/master/introduction_to_algorithms/cap-02
    """
    # Inicia Loop com o SEGUNDO número da lista:
    for j in range(1, len(l)):
        # Pega o VALOR do segundo número da lista
        atual = l[j]
        
        # Cria índice para o NÚMERO ANTERIOR na lista
        i = j - 1
        
        # Verifica ordem ascendente ou descentende
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
            return print('A ordem deve ser especificada como \'asc\' ou \'desc\'')
            
        # Se i < 0, então não há mais nenhum número anterior,
        # e podemos colocar o anterior com o valor atual
        l[i + 1] = atual
        
    # Retorna a lista ordenada
    return print(l)

a = [5, 2, 4, 6, 1, 3, 9, 11, 4, 0, 2, 4, 1, 9, 100]
insertionSort2(a, 'desc')
insertionSort2(a, 'asc')

b = [31, 41, 59, 26, 41, 58]
insertionSort2(b)

c = [3, 1, 4, 2]
insertionSort2(c, 'desc')
