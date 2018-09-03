package br.com.app.trie;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node current = root;

        for (Character ch : word.toCharArray()) {
            current = current.getChildren(ch);
        }

        current.setIsEnd();

    }

    public List<String> predict(String word) {
        if (!StringUtils.hasText(word)) {
            return Collections.emptyList();
        }

        Node current = getRemainingTree(word);

        if (current == null) {
            return Collections.emptyList();
        }

        List<String> words = new ArrayList<>();

        concatWords(new StringBuilder(word), current, words);

        return words;
    }

    private void concatWords(StringBuilder sb, Node tree, List<String> words) {
        if (tree.isEndOfTree()) {
            words.add(sb.toString());
        }

        for (Character ch : tree.getChildrenKeys()) {
            sb.append(ch);

            concatWords(sb, tree.getChildren(ch), words);

            sb.deleteCharAt(sb.length()-1);
        }
    }

    private Node getRemainingTree(String word) {
        Node current = root;

        for (Character ch : word.toCharArray()) {
            current = current.getChildren(ch);
        }

        return current;
    }
}
