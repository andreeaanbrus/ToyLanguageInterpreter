package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface IDictionary<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
    Collection<K> keySet();
    HashMap<K, V> getContent();
    void setContent(HashMap<K, V> newDictionary);
    Set<Map.Entry<K,V>> entrySet();
    Boolean containsKey(K key);
    Collection<V> values();
}
