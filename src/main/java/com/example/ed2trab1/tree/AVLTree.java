package main.java.com.example.ed2trab1.tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class AVLTree {
    private AVLNode root;
    Logger logger = Logger.getLogger(AVLTree.class.getName());

    // Método para obter a altura de um nó
    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Método para obter o fator de balanceamento de um nó
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Método para atualizar a altura de um nó
    private void updateHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    // Método para realizar uma rotação simples à esquerda
    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.right;
        AVLNode leftSubtree = newRoot.left;

        newRoot.left = node;
        node.right = leftSubtree;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    // Método para realizar uma rotação simples à direita
    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.left;
        AVLNode rightSubtree = newRoot.right;

        newRoot.right = node;
        node.left = rightSubtree;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    // Método para balancear a árvore após a inserção de um nó
    private AVLNode balanceNode(AVLNode node, String word, File file, int lineNumber) {
        if (node == null)
            return new AVLNode(word, file, lineNumber);

        // Inserção na subárvore esquerda
        if (word.compareTo(node.word) < 0)
            node.left = balanceNode(node.left, word, file, lineNumber);
        // Inserção na subárvore direita
        else if (word.compareTo(node.word) > 0)
            node.right = balanceNode(node.right, word, file, lineNumber);
        // A palavra já existe no nó
        else {
            List<Integer> lines = node.occurrences.getOrDefault(file, new ArrayList<>());
            lines.add(lineNumber);
            node.occurrences.put(file, lines);
            return node;
        }

        updateHeight(node);

        int balance = getBalance(node);

        // Caso de rotação à esquerda
        if (balance > 1 && word.compareTo(node.left.word) < 0)
            return rotateRight(node);

        // Caso de rotação à direita
        if (balance < -1 && word.compareTo(node.right.word) > 0)
            return rotateLeft(node);

        // Caso de rotação dupla à esquerda
        if (balance > 1 && word.compareTo(node.left.word) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso de rotação dupla à direita
        if (balance < -1 && word.compareTo(node.right.word) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Método público para inserir uma palavra na árvore
    public void insert(String word, File file, int lineNumber) {
        root = balanceNode(root, word, file, lineNumber);
    }

    // Método para realizar uma busca na árvore
    private AVLNode searchNode(AVLNode node, String word) {
        if (node == null || node.word.equals(word))
            return node;

        if (word.compareTo(node.word) < 0)
            return searchNode(node.left, word);

        return searchNode(node.right, word);
    }

    // Método público para buscar uma palavra na árvore
    public AVLNode search(String word) {
        return searchNode(root, word);
    }

    // Método para exibir todas as ocorrências de uma palavra em um arquivo
    private void displayOccurrences(AVLNode node, String searchWord) {
        if ((node != null) && (!searchWord.isEmpty())) {
            if (node.word.equals(searchWord)) {
                String fileName = "wordOccurrences-" + searchWord + ".txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("./files/output/" + fileName))) {
                    writer.write("Palavra: " + node.word);
                    writer.newLine();
                    writer.newLine();
                    for (Map.Entry<File, List<Integer>> entry : node.occurrences.entrySet()) {
                        File file = entry.getKey();
                        List<Integer> lines = entry.getValue();
                        writer.write("Arquivo: " + file.getName());
                        writer.newLine();
                        writer.write("Ocorrências: " + lines.size());
                        writer.newLine();
                        writer.write("Linhas: " + lines);
                        writer.newLine();
                        writer.newLine();
                    }
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
            displayOccurrences(node.left, searchWord);
            displayOccurrences(node.right, searchWord);
        }
    }

    // Método público para exibir todas as ocorrências da palavra
    public void displayOccurrences(String searchWord) {
        displayOccurrences(root, searchWord);
    }
}
