package Chapter_13;

import java.text.DecimalFormat;

public class Square extends GeometricObject implements Colorable {
    private double length;
    
    /** Default constructor creates square object with default length of 1 */
    public Square() {
        this(1);
    };
    
    /** Overloaded constructor creates a square with defined length
     * @param length */
    public Square(double length) {
        this.length = length;
    }
    
    /** Return area */
    @Override // Implements the getArea method defined in GeometricObject
    public double getArea() {
        return Math.pow(length, 2);
    }

    @Override // Implements the getPerimeter method defined in GeometricObject
    public double getPerimeter() {
        return 4 * length;
    }
    
    @Override // Implement the howToColor method defined in Colorable
    public void howToColor() {
       System.out.println("Color all four sides."); 
    }
    
    /** Testing
     * @param args */
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        
        GeometricObject s = new Square(5);      
        String sArea = formatter.format(s.getArea());
        String sPerimeter = formatter.format(s.getPerimeter());
        System.out.println("Square: " + s);
        System.out.println("Square area: " + sArea);
        System.out.println("Square perimeter: " + sPerimeter);
        System.out.println();
        ((Square)s).howToColor();
    }
}
