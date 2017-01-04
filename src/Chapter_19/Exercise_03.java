package Chapter_19;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_03 {
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        
        ArrayList<E> setList = new ArrayList<E>();
        for (E element : list) {
            if (!setList.contains(element))
                setList.add(element);
        }
        return setList;
    }

    /** Testing */
    public static void main(String args[]) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(1, 2, 3, 4, 5, 1, 3, 5));
        System.out.println("Orignal list: " + intList);
        System.out.println("Modified list: " + removeDuplicates(intList));
    }
}
