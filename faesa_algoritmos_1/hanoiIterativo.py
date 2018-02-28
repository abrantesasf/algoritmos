#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb 27 23:34:35 2018
@author: abrantesasf
"""

def hanoiIterativo(n):
    """
    hanoiIterativo:
    função para resolver o problema das Torres de Hanoi, com 3 torres
    e n discos, de forma iterativa
    
    Pré-requisitos: nenhum
            Inputs: um inteiro >= 3
           Outputs: a seqüência numerada de passos indicando a movimentação
                    do disco superior (ou único disco) de cada torre que deve
                    ser feita para resolver o problema.
        Limitações: não incluí checagens e validações
         Sugestões: Abrantes Araújo Silva Filho
                    abrantesasf@gmail.com
       Referências: Atividade na aula do Prof. 
        Orientação: ---
    """
    
    # Checa discos
    if n <= 2:
        return print('O número de discos deve ser >= 3')
    elif n % 2 == 0:
        return print('No momento, n deve ser ímpar')
    
    # Qual o número mínimo de movimentos?
    passos = 2**n -1
    if n >= 7:
        print('ATENÇÃO: esta função está em desenvolvimento e CONTÉM ERROS para n >= 7')
    print('Para ' + str(n) + ' discos, são mecessários ' + str(passos) + ' passos:')
    
    # Indica a configuração inicial das torres:
    origem   = 'TORRE-1'
    destino  = 'TORRE-3'
    auxiliar = 'TORRE-2'
    
    contador = 1
    
    while contador <= passos:
        print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
        contador += 1
        print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
        contador += 1
        print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
        contador += 1
        print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
        contador += 1
        print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
        contador += 1
        print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
        contador += 1
        print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
        contador += 1
        if contador < passos:
            origem   = 'TORRE-3'
            destino  = 'TORRE-2'
            auxiliar = 'TORRE-1'
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            contador += 1
            
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
            contador += 1
            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
        if contador < passos:
            origem   = 'TORRE-2'
            destino  = 'TORRE-1'
            auxiliar = 'TORRE-3'
            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
            contador += 1
            
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
            contador += 1
            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
        if contador < passos:
            origem   = 'TORRE-1'
            destino  = 'TORRE-3'
            auxiliar = 'TORRE-2'
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            contador += 1
                    
    print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')

hanoiIterativo(5)
