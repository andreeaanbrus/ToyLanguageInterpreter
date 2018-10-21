package Model.ADT;

import java.util.HashMap;

public class MyDictionary<K, V> implements IDictionary<K, V> {

    private HashMap<K,V> dictionary;

    public MyDictionary(){
        dictionary = new HashMap<>();
    }

    @Override
    public V get(K key) {
        return dictionary.get(key);
    }

    @Override
    public V put(K key, V value) {
        return dictionary.put(key, value);
    }

    @Override
    public V remove(K key) {
        return dictionary.remove(key);
    }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    public String toString(){
        String res = "";
        for(K key : dictionary.keySet())
            res += key.toString() + " -> " + dictionary.get(key) + "\n";
        return res;
    }
}
