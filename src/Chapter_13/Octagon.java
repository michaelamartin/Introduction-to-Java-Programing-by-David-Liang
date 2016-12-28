package Chapter_13;

public class Octagon extends GeometricObject implements Cloneable {
    private double side;
    
    /** Create an octagon with sides of a defined length */
    public Octagon(double side) {
        this.side = side;
    }

    /** Create a default octagon object with sides of length 1 */
    public Octagon() {
        this(1.0);
    }
    
    @Override // Implements the getArea method defined in GeometricObject
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }
    
    @Override // Implements the getPerimeter method defined in GeometricObject
    public double getPerimeter() {
        return 8 * side;
    }
    
    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(GeometricObject object) {
    if (getArea() > ((Octagon)object).getArea())
        return 1;
    else if (getArea() < ((Circle)object).getArea())
        return -1;
    else
        return 0;
    }
    
    @Override
    /** 
     * Override the protected clone method defined in the Object class and
     * strengthen its accessibility 
     * @throws java.lang.CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /** Testing */
    public static void main(String[] args) {
        GeometricObject o1 = new Octagon(5);
        GeometricObject o2 = new Octagon(1);
        System.out.println("Octagon 1: " + o1);
        System.out.println("Octagon 2: " + o2);
        System.out.println();
    }
}