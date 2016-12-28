package Chapter_13;

import java.util.ArrayList;

public class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int getSize() {
        return list.size();
    }
    
    public Object peek() {
        return list.get(getSize() - 1);
    }
    
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    
    public void push(Object o) {
        list.add(o);
    }
    
    @Override
    public Object clone() {
        try {
            MyStack stackClone = (MyStack)super.clone();
            stackClone.list = (ArrayList<Object>)(list.clone());
            return stackClone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
    
    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        MyStack stack2 = (MyStack)stack1.clone();
        System.out.println("Stack 1: " + stack1);
        System.out.println("Stack 2: " + stack2);
    }
}
