package Chapter_21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * (Count consonants and vowels) Write a program that prompts the user to enter 
 * a text file name and displays the number of vowels and consonants in the 
 * file. Use a set to store the vowels A, E, I, O, and U.
 * @author Michael Martin
 */
public class Exercise_04 {
    public static void main(String[] args) {
        // Scan input text file
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text file: ");
        String filename = input.nextLine();
        
        // Display vowel and consonant counts
        try {
            File file = new File(filename);
            int[] letterCounts = letterCounts(file);
            System.out.println("Vowel count: " + letterCounts[0]);
            System.out.println("Consonant count: " + letterCounts[1]);
        }
        // Display exception message if file does not exist
        catch (FileNotFoundException ex) {
            System.out.println("File does not exist.");
        }
    }
    
   /** 
    * Reads a text file and returns an array containing the number
    * of vowels and the number of consonants. 
    */ 
    public static int[] letterCounts(File file) throws FileNotFoundException {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int vowelCount = 0;
        int consonantCount = 0;
        
        // Read the given text file and convert it into a string.
        Scanner input = new Scanner(new FileInputStream(file));
        String text = "";
        while (input.hasNext()) {
            text += input.nextLine().toLowerCase() + "\n";
        }
        // Tally up number of vowels found in text
        for (char i : text.toCharArray()) {
            if (Character.isAlphabetic(i)) {
                if (set.contains(i)) {
                    vowelCount++;
                }
                else {
                    consonantCount++;
                }
            }
        }
        return new int[]{vowelCount, consonantCount};
    }
}
