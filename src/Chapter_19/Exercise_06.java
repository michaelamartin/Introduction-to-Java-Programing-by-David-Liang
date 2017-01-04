package Chapter_19;

public class Exercise_06 {
    
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j].compareTo(max) > 0)
                    max = list[i][j];
            }
        }
        return max;
    }
    
    /** Testing */
    public static void main(String[] args) {
        Integer[][] list = new Integer[3][3];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                list[i][j] = (int)(Math.random() * 100);
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("max: " + max(list));
    }
}
