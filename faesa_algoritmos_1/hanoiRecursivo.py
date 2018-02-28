#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb 28 00:40:13 2018
@author: abrantesasf
"""

def hanoiRecursivo(n):
    """
    hanoiRecursivo:
    função para resolver o problema das Torres de Hanoi,
    com 3 torres e n discos, de forma recursiva.
    
    Pré-requisitos: nenhum
            Inputs: um inteiro >= 3
           Outputs: a seqüência numerada de passos indicando a movimentação
                    do disco superior (ou único disco) de cada torre que deve
                    ser feita para resolver o problema.
           Retorno: nenhum
        Limitações: não incluí checagens e validações
         Sugestões: Abrantes Araújo Silva Filho
                    abrantesasf@gmail.com
       Referências: 1) a base desse algoritmo foi ensinada no curso MITx 6.00.1x
                       (Introduction to Computer Science and Programming Using
                       Python, disponível no edX)
                    2) a maneira de utilizar um contador em uma função recursiva
                       em Python foi sugerida pelo usuário "uselpa" na seguinte
                       discussão no StackOverflow:
                       https://stackoverflow.com/questions/15052704/how-to-create-a-counter-inside-a-recursive-function
        Orientação: ---
    """
    passos = 2**n -1
    print('Para ' + str(n) + ' discos, são mecessários ' + str(passos) + ' passos:')
    
    def recursivo(n, origem, destino, auxiliar, contador):
        if n == 1:
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
        else:
            contador = recursivo(n-1, origem, auxiliar, destino, contador)
            contador = recursivo(1, origem, destino, auxiliar, contador)
            contador = recursivo(n-1, auxiliar, destino, origem, contador)
        return contador
            
    recursivo(n, 'TORRE-1', 'TORRE-3', 'TORRE-2', contador = 0)
    
    print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')
    
Hanoi(7)
