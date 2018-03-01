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
    elif type(n) != int:
        return print('O número de discos deve ser um número inteiro')
    
    # Qual o número mínimo de movimentos?
    passos = 2**n - 1
    
    # Contador de passagens pelo loop (para poder determinar
    # a inversão correta das torres) e sequences de comparação:
    passagem = 1
    seq1 = range(1, passos, 3)
    seq2 = range(2, passos, 3)
    tipoSeq = 0

    # Contador para impressão do número de cada etapa da solução
    contador = 1
    
    # Contadores para verificar quantos discos já estão em cada torre
    discosOrigem = n
    discosDestino = 0
    discosAuxiliar = 0
    
    # Se n for ímpar:
    if n % 2 != 0:
        
        # Inicia loop
        while contador <= passos:
            
            # Determina ordem das torres
            if passagem in seq1:
                tipoSeq  = 1
                origem   = 'TORRE-1'
                destino  = 'TORRE-3'
                auxiliar = 'TORRE-2'
                if passagem > 1:
                    temp = discosOrigem
                    discosOrigem = discosDestino
                    discosDestino = discosAuxiliar
                    discosAuxiliar = temp
            elif passagem in seq2:
                tipoSeq  = 2
                origem   = 'TORRE-3'
                destino  = 'TORRE-2'
                auxiliar = 'TORRE-1'                
                temp           = discosOrigem
                discosOrigem   = discosDestino
                discosDestino  = discosAuxiliar
                discosAuxiliar = temp
            else:
                tipoSeq  = 3
                origem   = 'TORRE-2'
                destino  = 'TORRE-1'
                auxiliar = 'TORRE-3'
                temp = discosOrigem
                discosOrigem   = discosDestino
                discosDestino  = discosAuxiliar
                discosAuxiliar = temp
            
            # Inicia movimentos para n ímpar:
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            discosOrigem  -= 1
            discosDestino += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
            contador += 1
            discosOrigem   -= 1
            discosAuxiliar += 1
            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
            contador += 1
            discosDestino  -= 1
            discosAuxiliar += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            discosOrigem  -= 1
            discosDestino += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
            contador += 1
            discosAuxiliar -= 1
            discosOrigem   += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            contador += 1
            discosAuxiliar -= 1
            discosDestino  += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            contador += 1
            discosOrigem  -= 1
            discosDestino += 1
            
            # Verifica se todos os discos já estão no destino
            if (n - discosDestino == 0):
                return print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')
            elif (n - discosDestino == 1) and (destino == 'TORRE-3'):
                print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
                contador += 1
                discosDestino += 1
                return print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')
            else:
                if tipoSeq == 1:
                    print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
                    contador += 1
                    discosOrigem   -= 1
                    discosAuxiliar += 1
                elif tipoSeq == 2:
                    print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
                    contador += 1
                    discosAuxiliar -= 1
                    discosOrigem += 1
                elif tipoSeq == 3:
                    print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
                    contador += 1
                    discosOrigem   -= 1
                    discosAuxiliar += 1
                
            # Incrementa a passagem
            passagem += 1
                
#                
#            if contador < passos:
#                origem   = 'TORRE-3'
#                destino  = 'TORRE-2'
#                auxiliar = 'TORRE-1'
#                print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
#                contador += 1
#            
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
#            contador += 1
#            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
#            contador += 1
#            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#        if contador < passos:
#            origem   = 'TORRE-2'
#            destino  = 'TORRE-1'
#            auxiliar = 'TORRE-3'
#            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
#            contador += 1
#            
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
#            contador += 1
#            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
#            contador += 1
#            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
#            contador += 1
#            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
#            contador += 1
#        if contador < passos:
#            origem   = 'TORRE-1'
#            destino  = 'TORRE-3'
#            auxiliar = 'TORRE-2'
#            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
#            contador += 1
#                    
#    print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')

hanoiIterativo(7)

for i in range(1, 100, 3):
    print(i)
