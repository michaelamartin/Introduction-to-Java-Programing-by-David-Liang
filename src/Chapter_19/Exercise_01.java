package Chapter_19;

import java.util.Arrays;

public class Exercise_01 {
    
    public class GenericStack<E> {
        private E[] array;
        private int elements = 0;

        public GenericStack() {
            array = (E[])new Object[10];
        }

        public GenericStack(int size) {
            array = (E[])new Object[size];
        }

        public int getSize() {
            return elements;
        }

        public E peek() {
            if (elements == 0)
                return null;
            else
                return array[elements - 1];
        }

        public void push(E o) {
            // Double size of array if array is full
            if (array.length == elements)
                array = Arrays.copyOf(array, array.length * 2);
            array[elements++] = o;
        }

        public E pop() {
            if (elements == 0)
                return null;
            else {
                // Halve size of array if the array is only a quarter full or less
                if (elements <= (array.length / 4))
                    array = Arrays.copyOf(array, array.length / 2);
                E o = array[elements - 1];
                array[elements - 1] = null;
                elements--;
                return o;
            }
        }

        public boolean isEmpty() {
            return elements == 0;
        }

        @Override
        public String toString() {
            if (array[0] == null)
                return "empty";
            else {
                String output = "[";
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == null)
                        break;
                    output += array[i] + "";
                    if (i < elements - 1)
                        output += ", ";
                }
                output += "]";
                return output;
            }
        }
    }
    
    /** Testing */
    public static void main(String[] args) {
        GenericStack<Integer> stack = new Exercise_01().new GenericStack(2);
        System.out.println("size: " + stack.getSize());
        System.out.println("empty: " + stack.isEmpty());
        System.out.println(stack.toString());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.toString());
        stack.push(3);
        System.out.println(stack.toString());
        System.out.println("size: " + stack.getSize());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.toString());
        System.out.println("size: " + stack.getSize());
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("size: " + stack.getSize()); 
    }
}
