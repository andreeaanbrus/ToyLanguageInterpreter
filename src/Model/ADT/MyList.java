package Model.ADT;

import java.util.ArrayList;

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

    public String toString(){
        String res = "";
        for(T elem : list)
            res += elem.toString();
        return res;
    }
}
