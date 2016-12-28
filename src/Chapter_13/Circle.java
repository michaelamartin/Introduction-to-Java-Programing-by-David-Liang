package Chapter_13;

public class Circle extends GeometricObject {
    /** The radius of the circle */
    private double radius;
  
    /** Default constructor creates circle with default radius of 1 */
    public Circle() {
        this(1.0);
    }
    
    /** Overloaded constructor creates circle with defined radius
     * @param radius */
    public Circle(double radius) {
        this.radius = radius;
    }
    
    /** Overloaded constructor creates circle with defined radius, color, 
     * and fill */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /** Returns radius */
    public double getRadius() {
        return radius;
    }

    @Override // Implements the getArea method defined in GeometricObject
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override // Implements the getPerimeter method defined in GeometricObject
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override // Implements the compareTo method defined in Comparable
    public int compareTo(GeometricObject object) {
    if (getRadius() > ((Circle)object).getRadius())
        return 1;
    else if (getRadius() < ((Circle)object).getRadius())
        return -1;
    else
        return 0;
    }

    /** Testing */
    public static void main(String[] args) {
        GeometricObject c1 = new Circle(5, "green", true);
        GeometricObject c2 = new Circle(1, "red", false);
        System.out.println("Circle 1: " + c1);
        System.out.println("Circle 2: " + c2);
        System.out.println();
        System.out.println("Max circle: " + GeometricObject.max(c1, c2));
    }
  }