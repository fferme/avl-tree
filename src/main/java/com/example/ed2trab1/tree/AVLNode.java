package main.java.com.example.ed2trab1.tree;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AVLNode {
    String word;
    Map<File, List<Integer>> occurrences;
    AVLNode left;
    AVLNode right;
    int height;

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
