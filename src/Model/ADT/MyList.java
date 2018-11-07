package Model.ADT;

import java.util.ArrayList;
import Exception.ADTException;

public class MyList<T> implements IList<T> {
    private ArrayList<T> list;
    public MyList(){
        list = new ArrayList<T>();
    }
    @Override
    public boolean add(T elem) {

        return list.add(elem);
    }

    @Override
    public boolean remove(T elem) {
        return list.remove(elem);
    }

    @Override
    public T get(int index) {
            return list.get(index);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for(T elem : list)
            res.append(elem.toString()).append(" ");
        return res.toString();
    }
}
