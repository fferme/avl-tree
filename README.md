# Árvore AVL de Busca de Palavras em Arquivos

Este é um projeto Java que implementa uma árvore AVL para busca de palavras em arquivos. O programa lê um conjunto de arquivos grandes em um diretório especificado e cria uma árvore AVL, onde cada nó contém uma palavra encontrada nos arquivos, juntamente com os arquivos e as linhas onde a palavra ocorre. Projeto feito como trabalho para disciplina de Estrutura de Dados II na faculdade UERJ-ZO.

## Funcionalidades

- Leitura de arquivos em um diretório específico.
- Processamento de palavras e remoção de caracteres especiais.
- Construção de uma árvore AVL para armazenar as palavras e suas ocorrências.
- Busca por uma palavra na árvore AVL.
- Exibição das ocorrências de uma palavra específica em um arquivo de texto de saída, juntamente com as linhas em que ocorrem.

## Personalização

- Diretório de entrada: Por padrão, o programa lê os arquivos em um diretório específico (`input`). Você pode alterar o diretório modificando a variável `directoryPath` na classe `Main`.
- Palavra de busca: Por padrão, o programa busca a palavra "exemplo". Para buscar outra palavra, altere a variável `searchWord` na classe `Main`.
