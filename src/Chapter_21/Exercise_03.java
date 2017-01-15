package Chapter_21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Exercise 21.3
 * (Count the keywords in Java source code) Revise the program in Listing 21.7. 
 * If a keyword is in a comment or in a string, don’t count it. Pass the Java 
 * file name from the command line. Assume that the Java source code is correct 
 * and line comments and paragraph comments do not overlap.
 * @author Michael Martin
 */
public class Exercise_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file: ");
        String filename = input.nextLine();
        
        // Try to display unique words in text file
        try {
            File file = new File(filename);
            System.out.println(countKeywords(file));
        }
        // Display exception message if file does not exist
        catch (FileNotFoundException ex) {
            System.out.println("File does not exist.");
        }
    }
    
    // Filters comments and blocks
    public static String filterCB(String s) {
        Stack<Character> stack = new Stack<>();
        String filtered = "";
        boolean comment = false;
        boolean block = false;
        for (int i = 0; i < s.length(); i++) {
            String string = Character.toString(s.charAt(i));
            if (comment == true && string.equals("\n")) {
                comment = false;
            }
            else if (block == true && s.charAt(i) == '/' && s.charAt(i - 1) == '*') {
                    block = false;
            }
            else if (!stack.isEmpty()) {
                if (stack.peek() == '/') {
                    if (s.charAt(i) == '/') {
                        stack.pop();
                        comment = true;
                    }
                    else if (s.charAt(i) == '*') {
                        stack.pop();
                        block = true;
                    }
                    else {
                        filtered += stack.pop();
                        filtered += s.charAt(i);
                    }
                }
            }
            else if (stack.isEmpty()) {
                if (s.charAt(i) == '/') {
                    stack.push(s.charAt(i));
                }
                else
                filtered += s.charAt(i);
            }
        }
        return filtered;
    }
    
    // Filters strings
    public static String filterString(String s) {
        Stack<Character> stack = new Stack<>();
        String filtered = "";
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '\"' && s.charAt(i) == '\"') {
                        stack.pop();
                }
                else if (stack.peek() == '\\') {
                    stack.pop();
                }
                else if (s.charAt(i) == '\\') {
                    stack.push(s.charAt(i));
                }
            }
            else if (stack.isEmpty()) {
                if (s.charAt(i) == '\"' || s.charAt(i) == '\\') {
                    stack.push(s.charAt(i));
                }
                else
                filtered += s.charAt(i);
            }
        }
        return filtered;
    }

    public static int countKeywords(File file) throws FileNotFoundException {
        // Array of all Java keywords + true, false, and null
        String[] keywordString = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        // Read the given text file and convert it into a string.
        Scanner input = new Scanner(new FileInputStream(file));
        String words = "";
        while (input.hasNext()) {
            //\r\n is used for to create new line in a Windows txt file
            words += input.nextLine() + "\r\n";
        }
        
        // Create a new text file containing the filtered output
        PrintWriter filtered = new PrintWriter("filtered.txt");
        words = filterCB(filterString(words));  // filter comments, blocks, and strings
        filtered.print(words);
        filtered.close();
        
        // Create a new text file containing the keywords
        PrintWriter keywords = new PrintWriter("keywords.txt");
        for (String word : words.split("\\W+")) {
            if (keywordSet.contains(word)) {
                keywords.println(word + "\n");
                count++;
            }
        }
        keywords.close();   // close the PrintWriter stream
        return count;   // output the number of keywords in the terminal
    }
}