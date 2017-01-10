package Chapter_21;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Create two linked hash sets {"George","Jim", "John", "Blake", "Kevin", 
 * "Michael"} and {"George", "Katie","Kevin", "Michelle", "Ryan"} and find their
 * union, difference, and intersection. (You can clone the sets to preserve the 
 * original sets from being changed by these set methods.)
 * @author Mike
 */
public class Exercise_01 {   
    public static void main(String args[]) {
        
        // Create two linked hash sets
        LinkedHashSet<String> set1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        LinkedHashSet<String> set2 = new LinkedHashSet<>(Arrays.asList("George", "Katie","Kevin", "Michelle", "Ryan"));
        
        // Display original sets
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println();
        
        // Union
        LinkedHashSet<String> union = (LinkedHashSet<String>)set1.clone();
        union.addAll(set2);
        System.out.println("Union: " + union);
     
        // Difference
        LinkedHashSet<String> difference = (LinkedHashSet<String>)set1.clone();
        LinkedHashSet<String> difference2 = (LinkedHashSet<String>)set2.clone();
        difference.removeAll(set2);
        difference2.removeAll(set1);
        difference.addAll(difference2);
        System.out.println("Difference: " + difference);
        
        // Intersection
        LinkedHashSet<String> intersection = (LinkedHashSet<String>)set1.clone();
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
    }
}
