#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar  4 15:44:44 2018
@author: abrantesasf

Exemplos de 3 algoritmos de LINEAR SEARCH, em ordem crescente de 
eficiência:
    1) linearSearch: é o mais ineficiente dos três, pois:
                        - para cada iteração do loop, executa 2 testes: o teste
                          do próprio loop, para saber se i está no range, e o 
                          teste do if
                        - é obrigatório percorrer todos os elementos do array
                          até que uma resposta seja retornada
                          
    2) betterLinearSearch: é melhor do que o anterior pois, apesar de ainda
                        precisar de 2 testes em cada iteração do loop, já não
                        é mais necessário percorrer todos os elementos do array
                        para retornar uma resposta (assim que um elemento é
                        encontrado, o processamento é interrompido)
    
    3) sentinelLinearSearch: é o mais eficiente dos três, apesar de ser um pouco
                        mais complexo para escrever. Aqui, novamente, é
                        obrigatorio que o loop percorra todos os elementos
                        do array, mas a cada iteração do loop apenas 1 único
                        teste é executado (l[i] != n). Após o fim do loop
                        um outro teste único é realizado para ternar o índice
                        ou None.
"""

def linearSearch(l, n):
    resposta = None
    
    for i in range(0, len(l)):
        if l[i] == n:
            resposta = i
    
    return resposta

num = [9, 3, 8, 7, 1]
linearSearch(num, 2)
linearSearch(num, 1)


def betterLinearSearch(l, n):
    for i in range(0, len(l)):
        if l[i] == n:
            return print(i)
    return None

num = [9, 3, 8, 7, 1]
betterLinearSearch(num, 2)
betterLinearSearch(num, 1)


def sentinelLinearSearch(l, n):
    ultimo = l[-1]
    l[-1] = n
    
    i = 0
    while l[i] != n:
        i += 1
    
    l[-1] = ultimo
    
    if (i < len(l) - 1) or (l[-1] == n):
        return print(i)
    else:
        return None

num = [9, 3, 8, 7, 1, 0]
sentinelLinearSearch(num, 99999)
sentinelLinearSearch(num, 1)
sentinelLinearSearch(num, 0)
sentinelLinearSearch(num, 5)
