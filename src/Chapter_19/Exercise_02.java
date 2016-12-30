package Chapter_19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_02 {
    
    public class GenericStack<E> extends ArrayList<E> {
    
        public int getSize() {
            return size();
        }

        public E peek() {
            return get(getSize() - 1);
        }

        public void push(E o) {
            add(o);
        }

        public E pop() {
            E o = get(getSize() - 1);
            remove(getSize() - 1);
            return o;
        }

        @Override
        public String toString() {
            return "stack: " + super.toString();
        }
    }
    
    /** Testing */
    public static void main(String[] args) {

        GenericStack<String> stack = new Exercise_02().new GenericStack<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 strings: ");
        for (int i = 0; i < 5; i++)
            stack.push(input.next());

        // Reverse stack
        Collections.reverse(stack);
        System.out.println(stack.toString());

    }
}
