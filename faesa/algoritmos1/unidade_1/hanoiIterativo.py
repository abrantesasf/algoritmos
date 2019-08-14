#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar  1 13:35:32 2018
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
       Referências: Atividade na aula do Prof. Howard Roatti
        Orientação: Prof. Howard Roatti
            GitHub: https://github.com/abrantesasf/algoritmos/tree/master/faesa_algoritmos_1
    """
    
    # Checa discos
    if n <= 2:
        return print('O número de discos deve ser >= 3')
    elif type(n) != int:
        return print('O número de discos deve ser um número inteiro')
    
    # Qual o número mínimo de movimentos?
    passos = 2**n - 1
    print('Para ' + str(n) + ' discos, são mecessários ' + str(passos) + ' passos:')
    
    # Seqüência desejada final:
    listaDesejada = []
    for i in range(n, 0, -1):
        listaDesejada.append(i)
    
    # Listas para conter os discos
    listaOrigem = []
    listaDestino = []
    listaAuxiliar = []
    
    # Inicia a torre de origem
    listaOrigem = listaDesejada.copy()
    
    # Contador de passagens pelo loop (para poder determinar
    # a inversão correta das torres) e sequences de comparação:
    passagem = 1
    seq1 = range(1, passos, 3)
    seq2 = range(2, passos, 3)

    # Contador para impressão do número de cada etapa da solução
    contador = 1
    
    # Se n for ímpar:
    if n % 2 != 0:
        
        # Inicia loop
        while contador <= passos:
            
            # Rearranjo da ordem das torres e das listas de discos
            if passagem in seq1:
                origem   = 'TORRE-1'
                destino  = 'TORRE-3'
                auxiliar = 'TORRE-2'
                # Só rearranja a ordem se não é a primeira passagem pelo loop
                if passagem > 1:
                    temp = listaOrigem.copy()
                    listaOrigem = listaDestino.copy()
                    listaDestino = listaAuxiliar.copy()
                    listaAuxiliar = temp.copy()
            elif passagem in seq2:
                origem   = 'TORRE-3'
                destino  = 'TORRE-2'
                auxiliar = 'TORRE-1'
                temp = listaOrigem.copy()
                listaOrigem = listaDestino.copy()
                listaDestino = listaAuxiliar.copy()
                listaAuxiliar = temp.copy()
            else:
                origem   = 'TORRE-2'
                destino  = 'TORRE-1'
                auxiliar = 'TORRE-3'
                temp = listaOrigem.copy()
                listaOrigem = listaDestino.copy()
                listaDestino = listaAuxiliar.copy()
                listaAuxiliar = temp.copy()
            
            # Inicia movimentos para n ímpar:
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            listaDestino.append(listaOrigem.pop())
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
            listaAuxiliar.append(listaOrigem.pop())
            contador += 1
            print(str(contador) + ' -- da ' + destino + ' para a ' + auxiliar)
            listaAuxiliar.append(listaDestino.pop())
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            listaDestino.append(listaOrigem.pop())
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
            listaOrigem.append(listaAuxiliar.pop())
            contador += 1
            print(str(contador) + ' -- da ' + auxiliar + ' para a ' + destino)
            listaDestino.append(listaAuxiliar.pop())
            contador += 1
            print(str(contador) + ' -- da ' + origem + ' para a ' + destino)
            listaDestino.append(listaOrigem.pop())
            contador += 1
            
            # Acabou?
            if listaDestino == listaDesejada:
                return print('Fim! Os ' + str(passos) + ' passos foram executados. Parabéns!')
            # OK, não acabou. Então temos que verifidcar algumas coisas antes
            # de decidir qual o próximo movimento antes do loop recomeçar.
            # A listaAuxiliar está vazia?
            elif (len(listaAuxiliar) == 0):
                print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
                listaAuxiliar.append(listaOrigem.pop())
                contador += 1
            # Se a listaAuxiliar não está vazia, a listaOrigem está vazia?
            elif (len(listaOrigem) == 0):
                print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
                listaOrigem.append(listaAuxiliar.pop())
                contador += 1
            # Se nem a listaAuxiliar nem a listaOrigem estiverem vaziar:
            elif (len(listaAuxiliar) > 0) and (len(listaOrigem) > 0):
                # O disco no topo da listaAuxiliar é maior do que o disco no
                # topo da listaOrigem?
                if (listaAuxiliar[-1] > listaOrigem[-1]):
                    print(str(contador) + ' -- da ' + origem + ' para a ' + auxiliar)
                    listaAuxiliar.append(listaOrigem.pop())
                    contador += 1
                # O disco no topo da listaAuxiliar é menor do que o disco no
                # topo da lista Origem:
                else:
                    print(str(contador) + ' -- da ' + auxiliar + ' para a ' + origem)
                    listaOrigem.append(listaAuxiliar.pop())
                    contador += 1
            
            # Incrementa a passagem para reordenar as torres/listas
            passagem += 1
            
            # AQUI REINICIA O LOOP!!!!!
            
    # Se n for par:    
    else:
        return print('DESCULPE! Ainda não implementado para n = par. Use n = ímpar.')

hanoiIterativo(7)
