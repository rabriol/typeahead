package br.com.app.services;

import br.com.app.trie.Trie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAheadService {
    private Trie trie = new Trie();

    public List<String> predict(String word) {
        return trie.predict(word);
    }

    public void insert(String word) {
        trie.insert(word);
    }
}
