package Chapter_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Exercise 21.2
 * Write a program that reads words from a text file and displays all the 
 * non-duplicate words in ascending order. The text file is passed as a 
 * command-line argument.
 * @author Michael Martin
 */
public class Exercise_02 {    
    /** Prints the unique words in a text file */
    public static void displayUniqueWords(File file) throws FileNotFoundException {
        Set<String> uniqueSet = new LinkedHashSet<>();
        
        // Scans textfile and adds words to linked hash set
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            uniqueSet.add(word.toLowerCase());
        }     
        
        // Print each word from the linked hash set
        for (String word : uniqueSet) {
            System.out.println(word);
        }
    }
    
    /** Testing */
    public static void main(String[] args) {
        // Display error message if user inputs wrong number of arguments
        if (args.length != 1) {
            System.out.println("Useage: java Exercise_02 fileName.txt");
            System.exit(0);
        }
        
        // Try to display unique words in text file
        try {
            File file = new File(args[0]);
            displayUniqueWords(file);
        }
        // Display exception message if file does not exist
        catch (FileNotFoundException ex) {
            System.out.println("File " + args[0] + " does not exist.");
        }
    }
}
