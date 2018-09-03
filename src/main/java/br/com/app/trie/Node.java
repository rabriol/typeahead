package br.com.app.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Node {
    private Map<Character, Node> children = new HashMap<>();
    private boolean isEnd = false;

    public Node(){}

    public Node getChildren(Character ch) {
        if (!children.containsKey(ch)) {
            children.put(ch, new Node());
        }

        return children.get(ch);
    }

    public Set<Character> getChildrenKeys() {
        return children.keySet();
    }

    public void setIsEnd() {
        isEnd = true;
    }

    public boolean isEndOfTree() {
        return isEnd;
    }
}
