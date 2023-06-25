package main.java.com.example.ed2trab1.tree;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe para representar um nó da árvore AVL
public class AVLNode {
    String word;                       // Palavra
    Map<File, List<Integer>> occurrences;  // Mapeamento de arquivos e linhas onde a palavra ocorre
    AVLNode left;                      // Filho esquerdo
    AVLNode right;                     // Filho direito
    int height;                        // Altura do nó

    // Construtor
    public AVLNode(String word, File file, int lineNumber) {
        this.word = word;
        this.occurrences = new HashMap<>();
        List<Integer> lines = new ArrayList<>();
        lines.add(lineNumber);
        this.occurrences.put(file, lines);
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
