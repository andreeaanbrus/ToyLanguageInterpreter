package Model.ADT;

import java.util.Collection;

public interface IDictionary<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
    public Collection<K> keySet();
}
