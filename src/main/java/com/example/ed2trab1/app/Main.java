package main.java.com.example.ed2trab1.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.java.com.example.ed2trab1.tree.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Diretório contendo os arquivos a serem processados
        String directoryPath = "./files/input/";

        // Leitura dos arquivos no diretório
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
                        String line;
                        int lineNumber = 1;

                        while ((line = reader.readLine()) != null) {
                            // Processamento das palavras na linha
                            String[] words = line.split("\\s+");

                            for (String word : words) {
                                // Remoção de caracteres especiais
                                word = word.replaceAll("[^a-zA-Z0-9]", "");

                                // Inserção da palavra na árvore
                                if (!word.isEmpty()) {
                                    avlTree.insert(word, file, lineNumber);
                                }
                            }
                            lineNumber++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Exibição das ocorrências da palavra
        String searchWord = "cavalo";
        avlTree.displayOccurrences(searchWord);
    }
}
