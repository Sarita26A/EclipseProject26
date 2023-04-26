package SeleniumIntro;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeWordInAscendingOrder {
	public static void main(String args[]) 
	{
		String str="Hello! How are you doing";
		arrangeWordInasc(str);
	}
	
	public static void arrangeWordInasc(String str) 
	{
		String[] string=str.split(" ");
		Comparator<String> lengthComparator=new Comparator<>() 
		{

			@Override
			public int compare(String o1, String o2) {
				
				return Integer.compare(o1.length(),o2.length());
			}	
			
		};
		Arrays.sort(string,lengthComparator);
		System.out.println(Arrays.deepToString(string));
			
	}

}
