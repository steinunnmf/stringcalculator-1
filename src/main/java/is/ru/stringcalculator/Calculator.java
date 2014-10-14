package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if (text.startsWith("//"))
		{
			String[] numbers = newdelimiter(text);
			List<String> negatives = new ArrayList<String>();
			
			for (String number : numbers)
			{
				if (toInt(number) < 0)
				{
					negatives.add(number);
				}
			}
			if (!negatives.isEmpty())
			{
				throw new IllegalArgumentException("Negatives not allowed:" + negatives);
			}
			else
			{
				return sum(numbers);
			}
		}
		else if(text.contains(",") || text.contains("\n")){
			String[] numbers = splitNumbers(text);
			List<String> negatives = new ArrayList<String>();
			
			for (String number : numbers)
			{
				if (toInt(number) < 0)
				{
					negatives.add(number);
				}
			}
			if (!negatives.isEmpty())
			{
				throw new IllegalArgumentException("Negatives not allowed:" + negatives);
			}
			else
			{
				return sum(numbers);
			}
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] newdelimiter(String numbers){ 
		Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
		m.matches();
		String delimiter = m.group(1);
		String text = m.group(2);
		return text.split(delimiter);
	}
	
	private static String[] splitNumbers(String numbers){
		String regexp = "[,\\n]";
		
		return numbers.split(regexp);
	}
	
    private static int sum(String[] numbers){
    	int total = 0;
        for(String number : numbers){
        	if (toInt(number) < 1001)
        	{
        		total += toInt(number);
        	}
        }
		return total;
    }
}