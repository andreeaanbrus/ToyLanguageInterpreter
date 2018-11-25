package Model.ADT;

import java.util.HashMap;

public interface IHeap<V> {
    Integer allocate(V value);
    HashMap<Integer, V> getContent();
    void update(Integer address, V value);
    void setContent(HashMap<Integer, V> newHeap);

}
