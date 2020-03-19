package FractionsV2;

/**
 * The FractionCounter class will take the object values from the class
 * Fraction and return an object that has the numerator/denominator and a
 * count of. This will be returned as a toString method. Also, this class
 * takes the class of Fraction and compares the instance fraction to see
 * if they are the same. If they are the same, add 1 to the counter.
 * 
 * @author Sung Ho Park
 * Class CSS 143 B 
 * Assignment: FractionsV2
 *
 */
public class FractionCounter 
{
	//Instance variables
	private int count = 1;
	private Fraction fractionClass = new Fraction();
	
	/**
	 * Constructor that takes a fraction class and sets it as the instance 
	 * object
	 * 
	 * @param theFraction
	 */
	public FractionCounter(Fraction theFraction)
	{
		this.fractionClass = theFraction;
	}
	
	/** 
	 * This takes the instance object fractionClass and compares it to the 
	 * new Fraction to see if they match. If they do, then add to the counter
	 * and return true. 
	 * 
	 * @param newFraction
	 * @return
	 */
	public boolean compareAndIncrement(Fraction newFraction)
	{
		if(fractionClass.getNumerator() == newFraction.getNumerator()
			&& fractionClass.getDenominator() == newFraction.getDenominator())
		{
			count += 1;
			return true;
		}
		
		return false;
		
	}
	
	@Override
	/**
	 * Returns the string numerator/denominator and a count of occurrences
	 * that the fraction has. 
	 */
	public String toString()
	{
		return fractionClass.getNumerator() + "/" 
				+ fractionClass.getDenominator() + " has a count of " + count;
	}
	
}
