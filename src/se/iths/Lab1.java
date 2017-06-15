package se.iths;

import java.util.Random;

/**
 * This class acts as the System Under Test (SUT) for a JUnit lab.
 * 
 * @author Johan Ström
 *
 */
public class Lab1 {
	private static int callCounter = 0;
	
	public int add(int number1, int number2)
	{
		callCounter++;
		return number1 + number2;
	}
	
	public int subtract(int number1, int number2)
	{
		callCounter++;
		return number1 - number2;
	}
	
	public int multiply(int number1, int number2)
	{
		callCounter++;
		return number1 * number2;
	}
	
	public int divide(int number1, int number2)
	{
		callCounter++;
		return number1 / number2;
	}
	
	public String reverse(String original)
	{
		callCounter++;
		String reverse = "";
		int length = original.length();
		for ( int i = length - 1 ; i >= 0 ; i-- )
	    {
			reverse = reverse + original.charAt(i);
	    }
		return reverse;
	      
	}
	
	public String quote()
	{
		callCounter++;
		Random rand = new Random();
		int number = rand.nextInt(8) + 1;
		
		switch(number)
		{
		case 1:
			return "We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein";
		case 2:
			return "A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare";
		case 3:
			return "You must be the change you wish to see in the world. - Mahatma Gandhi";
		case 4:
			return "In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.";
		case 5:
			return "Choose a job you love, and you will never have to work a day in your life. - Confucius";
		case 6:
			return "To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde";
		case 7:
			return "Without music, life would be a mistake. - Friedrich Nietzsche";
		default:
			return "I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams";
		}
	}
	
	public static int getCounter()
	{
		return callCounter;
	}
}
