package Chapter_13;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];
    private static int NUMERATOR = 0;
    private static int DENOMINATOR = 1;  
    
    /** Construct a rational with default properties */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }
    
    /** Construct a rational with specified numerator and denominator
     * @param numerator
     * @param denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        r[NUMERATOR] = BigInteger.valueOf(denominator.signum()).
                multiply(numerator).divide(gcd);
        r[DENOMINATOR] = denominator.abs().divide(gcd);
    }
    
    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = new BigInteger("1");
        
        BigInteger k = new BigInteger("1");
        while (k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0) {
            BigInteger mod1 = n1.mod(k);
            BigInteger mod2 = n2.mod(k);
            if (mod1.equals(BigInteger.ZERO) && mod2.equals(BigInteger.ZERO))
                gcd = k;
            k = k.add(BigInteger.ONE);
        }
        return gcd;
    }
    
    /** Return numerator */
    public BigInteger getNumerator() {
        return r[NUMERATOR];
    }
    
    /** Return denominator */
    public BigInteger getDenominator() {
        return r[DENOMINATOR];
    }
    
    /** Add a rational number to this rational
     * @param secondRational */
    public Rational add(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator()).
                add(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    
    /** Subtract a rational number from this rational
     * @param secondRational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator()).
                subtract(r[DENOMINATOR].multiply(secondRational.getNumerator()));
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    
    /** Multiply a rational number by this rational
     * @param secondRational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getNumerator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    
    /** Divide a rational number by this rational
     * @param secondRational */
    public Rational divide(Rational secondRational) {
        BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator());
        BigInteger d = r[DENOMINATOR].multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }
    
    @Override // Override the defualt toString method in the Object class
    public String toString() {
        if (r[DENOMINATOR].equals(BigInteger.ONE))
            return r[NUMERATOR] + "";
        else if (r[NUMERATOR].equals(BigInteger.ZERO))
            return r[NUMERATOR] + "";
        else
            return r[NUMERATOR] + "/" + r[DENOMINATOR];
    }
    
    @Override // Override the defualt equals method in the Object class
    public boolean equals(Object other) {
        return (this.subtract((Rational)(other))).getNumerator().equals(BigInteger.ZERO);
    }
    
    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int)doubleValue();
    }
    
    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }
    
    @Override // Implement the abstract doubleValue method in Number
    public double doubleValue() {
        return r[NUMERATOR].doubleValue() / r[DENOMINATOR].doubleValue();
    }
    
    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }
    
    // Convert rational number to bigInteger
    public BigInteger bigIntegerValue() {
        return r[NUMERATOR].divide(r[DENOMINATOR]);
    }
    
    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if(this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }
    
    /** Testing
     * @param args */
    public static void main(String[] args) {
        BigInteger bi1, bi2, bi3, bi4;
        bi1 = new BigInteger("3");
        bi2 = new BigInteger("9");
        bi3 = new BigInteger("4");
        bi4 = new BigInteger("12");
        Rational rational1 = new Rational(bi1, bi2);
        Rational rational2 = new Rational(bi3, bi4);
        System.out.println(rational1.subtract(rational2));
    }
}