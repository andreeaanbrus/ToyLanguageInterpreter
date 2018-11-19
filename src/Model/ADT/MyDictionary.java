package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import Exception.ADTException;

public class MyDictionary<K, V> implements IDictionary<K, V> {

    private HashMap<K,V> dictionary;

    public MyDictionary(){
        dictionary = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if(dictionary.get(key) == null)
            throw new ADTException("Invalid key");
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

    @Override
    public Collection<K> keySet(){
        return this.dictionary.keySet();
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for(K key : dictionary.keySet())
            res.append(key.toString()).append(" -> ").append(dictionary.get(key)).append("\n");
        return res.toString();
    }

    HashMap<K, V> getContent(){
        return dictionary;
    }

    public void setContent(HashMap<K, V> newDictionary){
        this.dictionary = newDictionary;
    }

    public Collection<V> values(){
        return dictionary.values();
    }
}
