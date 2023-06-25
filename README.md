# Árvore AVL de Busca de Palavras em Arquivos

Este é um projeto Java desenvolvido como parte de um trabalho para a disciplina de Estrutura de Dados II na faculdade UERJ-ZO. O objetivo principal é implementar uma árvore AVL para buscar palavras em arquivos.

O programa é capaz de ler um conjunto de arquivos grandes em um diretório específico e construir uma árvore AVL. Cada nó da árvore contém uma palavra encontrada nos arquivos, juntamente com as informações sobre os arquivos e as linhas onde a palavra ocorre.

A árvore AVL é uma estrutura de dados balanceada que permite uma busca eficiente. Ela mantém a altura da árvore equilibrada através de rotações, o que garante um tempo de busca e inserção de palavras otimizado.

Esse projeto utiliza os princípios de estrutura de dados e implementação de árvores AVL em Java para realizar a busca de palavras nos arquivos. Essa implementação pode ser útil em cenários onde é necessário pesquisar informações específicas em grandes conjuntos de dados textuais.

## Funcionalidades

- Leitura de arquivos em um diretório específico.
- Processamento de palavras e remoção de caracteres especiais.
- Construção de uma árvore AVL para armazenar as palavras e suas ocorrências.
- Busca por uma palavra na árvore AVL.
- Exibição das ocorrências de uma palavra específica em um arquivo de texto de saída, juntamente com as linhas em que ocorrem.

## Personalização

- Diretório de entrada: Por padrão, o programa lê os arquivos em um diretório específico (`input`). Você pode alterar o diretório modificando a variável `directoryPath` na classe `Main`.
- Palavra de busca: Por padrão, o programa busca a palavra "exemplo". Para buscar outra palavra, altere a variável `searchWord` na classe `Main`.
