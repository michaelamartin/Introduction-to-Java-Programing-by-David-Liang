package Chapter_19;

import java.util.Arrays;

public class Exercise_04 {
    
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (E element : list) {
            if (element.compareTo(key) == 0)
                return Arrays.asList(list).indexOf(element);
        }
        return -1;
    } 
    
    /** Testing */
    public static void main(String[] args) {
        Integer[] list = new Integer[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        System.out.println(linearSearch(list, 0));
        System.out.println(linearSearch(list, 99));
        System.out.println(linearSearch(list, 100));
    }
}
