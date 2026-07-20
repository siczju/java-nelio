# Desalocação de memória - Garbage Collector - Escopo Local

## Garbage Collector
    -> É um processo que automatiza o gerenciamento de memória de um programa em execução
    -> Ele monitora os objetos alocados dinamicamente pelo programa no heap, desalocando aqueles que não estão mais
        sendo utilizados
    -> Então ele vai monitorar os objetos no heap, e quando ele encontrar objetos (instâncias) que não estão sendo
        referenciadas, ele vai desalocar, liberando a memória.

## Desalocação por Escopo (variáveis estáticas dentro de métodos/if/for/while)
    -> Objetos alocados dinamicamente quando não possuem mais referência para eles, serão desalocados pelo garbage collector
    -> Variáveis locais são desalocadas imediatamente assim que seu escopo local sai de execução