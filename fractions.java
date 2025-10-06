public class Fraction implements Comparable<Fraction>
{
    private final long top;
    private final long bottom;

    public Fraction(long numerator, long denominator) {
        top = numerator;
        bottom = denominator;
    }

    @Override
    public int hashCode() { return 17 * Long.hashCode(top) + Long.hashCode(bottom); }    
    @Override
    public boolean equals(Object o) { return compareTo((Fraction)o) == 0; }    
    @Override
    public int compareTo(Fraction f2){ return Long.compare(top * f2.bottom, f2.top * bottom); }
    
    // Your work here!
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //Add two fractions
    public Fraction add(Fraction f2) {    
        long newTop = this.top * f2.bottom + f2.top * this.bottom;
        long newBottom = this.bottom * f2.bottom;

        long gcd = gcd(Math.abs(newTop), newBottom);
        return new Fraction(newTop / gcd, newBottom / gcd);
    }
    
    //...and make this class string representable
    @Override
    public String toString() {
    return top + "/" + bottom;
  } 
}
