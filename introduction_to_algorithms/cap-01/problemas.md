# Problem 1-1: Comparison of running times

For each function _f(n)_ and time _t_ in the following table, determine the largest
size _n_ of a problema that can be solved in time _t_, assuming that the algorithm to
solve the problem takes _f(n)_ microsseconds.

|                 | 1 second | 1 minute | 1 hour | 1 day | 1 month | 1 year | 1 century |
|-----------------|:--------:|:--------:|:------:|:-----:|:-------:|:------:|:---------:|
| ![](imagens/logn.png) |          |          |        |       |         |        |           |
| ![](imagens/raizn.png) |          |          |        |       |         |        |           |
| ![](imagens/n.png) |          |          |        |       |         |        |           |
| ![](imagens/nlogn.png) |          |          |        |       |         |        |           |
| ![](imagens/n2.png) |          |          |        |       |         |        |           |
| ![](imagens/n3.png) |          |          |        |       |         |        |           |
| ![](imagens/2n.png) |          |          |        |       |         |        |           |
| ![](imagens/nfat.png) |          |          |        |       |         |        |           |

## Reposta
Considerando que ![](imagens/transformacoes.png), o maior número _n_ quando _f(n) = n_
é dado diretamente por:

|                 | 1 second | 1 minute | 1 hour | 1 day | 1 month | 1 year | 1 century |
|-----------------|:--------:|:--------:|:------:|:-----:|:-------:|:------:|:---------:|
| ![](imagens/n.png) | ![](imagens/10a6.png) | ![](imagens/610a7.png) | ![](imagens/3610a9.png) | ![](imagens/86410a10.png) | ![](imagens/262810a12.png) | ![](imagens/315410a13.png) | ![](imagens/315410a15.png) |

Quando _f(n) = \sqrt{n}_, o maior _n_ é dado pela inversa da função, ou seja, por _n^2_. Assim:

|                 | 1 second | 1 minute | 1 hour | 1 day | 1 month | 1 year | 1 century |
|-----------------|:--------:|:--------:|:------:|:-----:|:-------:|:------:|:---------:|
| ![](imagens/raizn.png) | ![](imagens/10a12.png) | ![](imagens/3610a15.png) | ![](imagens/) | ![](imagens/) | ![](imagens/) | ![](imagens/) | ![](imagens/) |
| ![](imagens/n.png) | ![](imagens/10a6.png) | ![](imagens/610a7.png) | ![](imagens/3610a9.png) | ![](imagens/86410a10.png) | ![](imagens/262810a12.png) | ![](imagens/315410a13.png) | ![](imagens/315410a15.png) |