package Chapter_13;

import java.text.DecimalFormat;

public class Triangle extends GeometricObject {
    private double a;
    private double b;
    private double c;
    
    /** Default constructor creates a triangle with all sides set to 1 */
    public Triangle() {
        this(1,1,1);
    }
    
    /** Overloaded constructor creates a triangle with sides defined
     * @param a
     * @param b
     * @param c */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /** Overloaded constructor creates a triangle with sides defined and sets
     color to white, filled
     * @param a
     * @param b
     * @param c
     * @param color
     * @param filled */
    public Triangle(double a, double b, double c, String color, boolean filled) { 
        super(color, filled);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /** Return side a */
    public double getA() {
        return a;
    }
    
    /** Set a new side a */
    public void setA(double a) {
        this.a = a;
    }
    
     /** Return side b */
    public double getB() {
        return b;
    }
    
    /** Set a new side b */
    public void setB(double b) {
        this.b = b;
    }
    
    /** Return side c */
    public double getC() {
        return c;
    }
    
    /** Set a new side c */
    public void setC(double c) {
        this.c = c;
    }
    
    /** Return area */
    public double getArea() {
        double s = (a + b + c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
    /** Return perimeter */
    public double getPerimeter() {
        return a + b + c;
    }
    
    /** Testing */
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        
        GeometricObject triangle1 = new Triangle(5, 5, 5, "green", true);        
        String triangle1Area = formatter.format(triangle1.getArea());
        String triangle1Perimeter = formatter.format(triangle1.getPerimeter());
        System.out.println("Triangle: " + triangle1);
        System.out.println("Triangle area: " + triangle1Area);
        System.out.println("Triangle perimeter: " + triangle1Perimeter);
        System.out.println();
        
        GeometricObject triangle2 = new Triangle();
        String triangle2Area = formatter.format(triangle2.getArea());
        String triangle2Perimeter = formatter.format(triangle2.getPerimeter());
        System.out.println("Triangle: " + triangle2);
        System.out.println("Triangle area: " + triangle2Area);
        System.out.println("Triangle perimeter: " + triangle2Perimeter);
    }
}
