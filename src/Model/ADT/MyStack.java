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
        StringBuilder s = new StringBuilder();
        for(T elem : stack)
            s.append(elem.toString()).append(" ");
        return s.toString();
    }
}
