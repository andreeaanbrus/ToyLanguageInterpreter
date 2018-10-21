package Model.ADT;

import java.util.Stack;

public class MyStack<T> implements IStack<T> {

    private Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<T>();
    }

    @Override
    public void push(T element) {
        stack.push(element);
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String toString(){
        String s = "";
        for(T elem : stack)
            s +=  elem.toString();
        return s;
    }
}
