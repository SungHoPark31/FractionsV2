package FractionsV2;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This is the Driver class for both the fraction Classes. This will read in 
 * the text file, split the fraction into 2 integers, use the fraction class
 *  and the fraction counter class and put them in the ObjectList class and 
 *  print it out.
 * 
 * @author Sung Ho Park 
 * Class CSS 143 B 
 * Assignment: FractionsV2
 *
 */
public class Driver {
	public static void main(String[] args) {
		// Initialize
		Scanner input = null;

		// Find the file, if not, throw the exception
		try {
			input = new Scanner(new FileInputStream("fractions.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(0);
		}

		// Initialize and declare the instance of the object from the
		// ObjectList class.
		ObjectList myObject = new ObjectList();

		// This is to make sure the size length is getting what I want.
		// int elementLength = myObject.size();

		// If the txt file has a line do this...
		while (input.hasNextLine()) {
			// Read the line and split it with "/"
			String readingLine = input.nextLine();
			String[] readSplit = readingLine.split("/");

			// Change the numerator and the denominator to integers because it
			// was originally a String
			int numerator = Integer.parseInt(readSplit[0]);
			int denominator = Integer.parseInt(readSplit[1]);

			// If the denominator is 0, then check it and move on
			if (denominator == 0) {
				System.out.println(numerator + "/" + denominator
						+ " is not valid");
			} 
			else 
			{
				if (numerator < 0 && denominator < 0) 
				{
					// If both of the num and denom is a fraction, then
					// convert negative to positive.
					numerator = Math.abs(numerator);
					denominator = Math.abs(denominator);
				}

				// Use the GCD method to get the GCD of numerator and 
				//denominator
				int reducedGCD = gcd(numerator, denominator);

				int reducedNum = numerator / reducedGCD;
				int reducedDeno = denominator / reducedGCD;

				// Make an instance of the class Fraction and have it return a
				// String that makes it a fraction
				Fraction fractionObject = 
										new Fraction(reducedNum, reducedDeno);
				boolean found = false;

				// For every line of the text file, compare it to a new 
				//fraction and if an equivalent fraction is found, then add 
				//the counter
				for (int i = 0; i < myObject.size(); i++) 
				{
					// Create a temporary Object
					Object temp = myObject.get(i);

					// Type cast the temporary object so that this will return
					// the FractionCounter object. This connects the ObjectList
					// and FractionCounter.
					FractionCounter counter = (FractionCounter) temp;

					if (counter.compareAndIncrement(fractionObject)) 
					{
						found = true;
						break;
					}
				}
				// If an equivalent fraction is not found, then just add the
				// fraction to the ObjectList
				if (!found) 
				{
					FractionCounter addToCount = 
										new FractionCounter(fractionObject);
					myObject.add(addToCount);
				}
			}
		}

		// Prints out the ObjectList so that we can see the fraction
		// and how many times the fraction occurred in the text file
		for (int i = 0; i < myObject.size(); i++) {
			System.out.println(myObject.get(i));
		}
		// Close the file.
		input.close();
	}

	/**
	 * 
	 * Taken from 
	 * http://www.vogella.com/tutorials/JavaAlgorithmsEuclid/article.html
	 * 
	 * This will give the Greatest common divisor of the numerator and the
	 * denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 * @return The Greatest Common Divisor. It should return a value that is
	 *         numerator % denominator.
	 * 
	 * Example: 3/6 has a GCD of 3. 15/2 doesn't have one 36/27 has a
	 *          GCD of 9.
	 */
	public static int gcd(int numerator, int denominator) 
	{
		if (denominator == 0) 
		{
			return numerator;
		}
		return gcd(denominator, numerator % denominator);
	}
}
