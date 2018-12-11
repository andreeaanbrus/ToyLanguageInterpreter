package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    @Override
    public HashMap<K, V> getContent(){
        return dictionary;
    }

    @Override
    public void setContent(HashMap<K, V> newDictionary){
        this.dictionary = newDictionary;
    }

    @Override
    public Set<Map.Entry<K,V>> entrySet(){
        return dictionary.entrySet();
    }

    @Override
    public Boolean containsKey(K key){
        return dictionary.containsKey(key);
    }

    @Override
    public Collection<V> values(){
        return dictionary.values();
    }

    @Override
    public IDictionary<K, V> deepcopy() {
        MyDictionary<K, V> clone = new MyDictionary<>();
        for(K key: dictionary.keySet())
            clone.put(key, dictionary.get(key));
        return clone;
    }
}
