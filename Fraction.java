package FractionsV2;

//import java.io.FileInputStream;
//import java.util.Scanner;
//import java.io.FileNotFoundException;

/**
 * This is the fraction class. When the fraction class is called, it 
 * will take parameters of integers, numerator and denominator.
 * The fraction class will return the numerator and the denominator 
 * as a fraction string. 
 * 
 * @author Sung Ho Park
 * Class CSS 143 B 
 * Assignment: FractionsV2
 *
 */
public class Fraction 
{
	//Instance Variables
	private int numerator;
	private int denominator;
	
	/**
	 * Empty Constructor
	 */
	public Fraction()
	{
		
	}
	
	/**
	 * This will set the parameters as the instance variables in the class
	 * 
	 * @param numer
	 * @param denom
	 */
	public Fraction(int numer, int denom)
	{
		this.numerator = numer;
		this.denominator = denom;
		
	}
	
	/**
	 * The parameter of the object will be compared to the instance variables
	 * and depending on the object that it is being compared to, it will 
	 * return true or false. 
	 * 
	 * @param object
	 * @return
	 */
	public boolean equals(Fraction object)
	{
		if(this.numerator == object.numerator && 
				this.denominator == object.denominator)
		{
			return true;
		}
		return false;
	}
	
	@Override
	/**
	 * This returns the fraction as a string using information from the 
	 * instance variables. 
	 */
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	
	//Getters and setters for each instance variable.
	
	public int getNumerator()
	{
		return numerator;
	}

	public void setNumerator(int numerator) 
	{
		this.numerator = numerator;
	}

	public int getDenominator() 
	{
		return denominator;
	}

	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
	}
}
