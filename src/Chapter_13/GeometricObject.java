package Chapter_13;


import java.text.DecimalFormat;

public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }
    
    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    /** Return color */
    public String getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
    
    @Override
    public int compareTo(GeometricObject o) {
    if (getArea() > o.getArea())
        return 1;
    else if (getArea() < o.getArea())
        return -1;
    else
        return 0;
  }
    
    /** Compares to GeometricObject objects and determines which is larger */
    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return (o1.compareTo(o2) >= 0) ? o1 : o2; 
    }
    
    /** Sums the areas of all the geometric objects in an array */
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (GeometricObject object : a) {
            sum += object.getArea();
        }
        return sum;
    }
    
    /** Abstract method getArea */
    public abstract double getArea();
    
    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
        
    /** Main method */
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        
        GeometricObject triangle1 = new Triangle(5, 5, 5, "green", true);               
        GeometricObject triangle2 = new Triangle();
        GeometricObject square1 = new Square();
        GeometricObject square2 = new Square(5);
        GeometricObject octagon = new Octagon(5);
        GeometricObject[] array = {triangle1, triangle2, square1, square2, octagon};
        System.out.println("Total Area: " + formatter.format(sumArea(array)));
    }
}
