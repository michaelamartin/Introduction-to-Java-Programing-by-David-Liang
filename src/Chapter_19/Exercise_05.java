package Chapter_19;

import java.util.Arrays;

public class Exercise_05 {
    
    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0)
                max = list[i];
        }
        return max;
    }
    
    /** Testing */
    public static void main(String[] args) {
        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * 100);
        }
        
        String[] list2 = new String[3];
        list2[0] = "New York";
        list2[1] = "Los Angeles";
        list2[2] = "Chicago";
        
        // Print randomized array
        System.out.println("list 1: " + Arrays.toString(list));
        System.out.println("list 1 max: " + max(list));
        
        // Print randomized array
        System.out.println("list 2: " + Arrays.toString(list2));
        System.out.println("list 2 max: " + max(list2));
    }   
}
