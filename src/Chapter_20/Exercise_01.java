package Chapter_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Exercise_01 {
    
    private static void ReadData(String fileName) {
        try {
            File file = new File(fileName);           
            Scanner input = new Scanner(file);
            PriorityQueue<String> queue = new PriorityQueue<>();
            while(input.hasNext()) {
                String word = input.next().toLowerCase();
                if (Character.isLetter(word.charAt(0))) {
                    queue.offer(word);
                }
            } 
            while (queue.size() > 0)
                System.out.println(queue.remove() + " ");
        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
    
    /** Testing
     * @param args */  
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Useage: java Exercise_01 fileName.txt");
            System.exit(0);
        }
        ReadData(args[0]);
    }
}
