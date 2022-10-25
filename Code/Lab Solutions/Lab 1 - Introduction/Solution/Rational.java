/**
 * A class that represents a rational number. 
 * 
 * @author Charles Hoot 
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        
 * @version 4.1 (Modified for the Solution)
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE
//>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>
    private int numerator;
    private int denominator;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        // ADD CODE TO THE CONSTRUCTOR
//>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>
        numerator = 1;
        denominator = 1;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
        // ADD CODE TO THE ALTERNATE CONSTRUCTOR
//>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>
 		numerator = n;
        denominator = d;
        if(denominator == 0)
            throw new ZeroDenominatorException("Can not have a zero denominator");
        normalize();
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return numerator;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return denominator;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return new Rational(-1*numerator, denominator);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return new Rational(denominator, numerator);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        int resultDenominator = denominator*other.denominator;
        int resultNumerator = numerator*other.denominator + other.numerator*denominator;
        
        return new Rational(resultNumerator, resultDenominator);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return add(other.negate());
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        int resultDenominator = denominator*other.denominator;
        int resultNumerator = numerator*other.numerator ;
        
        return new Rational(resultNumerator, resultDenominator);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
//>>>>>> REPLACEMENT >>>>>>>>>>>>>>>>>>
        return multiply(other.invert());
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
     
 
 
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize()
    {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER
//>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>
        int absNumerator = Math.abs(numerator);
        int absDenominator = Math.abs(denominator);
        int signDenominator = denominator/absDenominator;
        
        int divideBy = gcd(absNumerator, absDenominator);
        numerator = (numerator / divideBy) * signDenominator;
        denominator = (denominator / divideBy) * signDenominator;
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
