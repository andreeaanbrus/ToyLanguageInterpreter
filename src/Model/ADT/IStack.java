package Model.ADT;

public interface IStack<T> {
    void push(T element);
    T pop();
    boolean isEmpty();
}
