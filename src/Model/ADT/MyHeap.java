package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyHeap<V> implements IHeap<V> {
    private MyDictionary<Integer,V> heap;
    private Integer freeLocation;
    public MyHeap(){
        heap = new MyDictionary<>();
        freeLocation = 0;
    }
    public V get(Integer key){
        return heap.get(key);
    }


    @Override
    public Integer allocate(V value) {
        freeLocation ++;
        heap.put(freeLocation, value);
        System.out.println(heap.toString());
        return freeLocation;
    }

    @Override
    public String toString() {
        String s = "";
        for(Integer key : heap.keySet()){

            s += key.toString();
            s += "->";
            s += heap.get(key).toString();
            s +=  "\n";
        }

        return s;
    }

    public void update(Integer address, V value) {
        heap.put(address, value);
    }

    public HashMap<Integer, V> getContent(){
        return heap.getContent();
    }

    public void setContent(HashMap<Integer, V> newHeap) {
        heap.setContent(newHeap);
    }
}
