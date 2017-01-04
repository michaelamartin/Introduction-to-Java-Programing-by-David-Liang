package Chapter_19;

import java.util.Arrays;

public class Exercise_07 {
    
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        Arrays.sort(list);
        int low = 0;
        int high = list.length - 1;
        
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key.compareTo(list[mid]) < 0)
                high = mid - 1;
            else if (key.compareTo(list[mid]) == 0)
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }
    
    /** Testing */
    public static void main(String[] args) {
        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        System.out.println("Key located at index " + binarySearch(list, 3) + ".");
    }
}
