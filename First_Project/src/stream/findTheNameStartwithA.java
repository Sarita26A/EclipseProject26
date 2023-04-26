package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.checkerframework.checker.units.qual.s;

public class findTheNameStartwithA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names=new ArrayList<>() ;
		names.add("Rahul");
		names.add("Anita");
		names.add("Hello");
		names.add("Ankita");
		names.add("Abhijeet");
		/*int count=0;
		for(int i=0;i<names.size();i++) 
		{
			String actualName=names.get(i);
			if(actualName.startsWith("A")) 
			{
				count++;
			}
			/*if(names.get(i).charAt(0)=='A') 
			{
				count++;
			}*/
		//}
		//System.out.println(count);
		//findUsingStream(names);
		//collectStream();
		printUniqueNumber();

	}
	public static void findUsingStream(List<String> name)
	{
		//there is no life for intermediate op if there is no terminal op
		//Terminal op will only get executed if intermediate op returns true(filter is intermediate op here)
		//we can create stream using stream package
		//how to use Stream filter in stream api
		
		Long count=name.stream().filter(s->s.startsWith("A")).count();
		Long count1=Stream.of("Ankita","Anil","Sarita","Ram","Adam").filter(s->s.startsWith("A")).count();
		System.out.println(count + " " +count1);
		//print the name where name length is more than 4
		name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//To see only first result
		//name.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		//print the name where name length is more than 4 into uppercase
		//name.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Print the name which starts with "A" in sorted order
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merge two list and print in sorted order
		List<String> name1=Arrays.asList("Shikha","Soma","Mona");
		Stream<String>mergedStream=Stream.concat(name.stream(), name1.stream());
		mergedStream.sorted().forEach(s->System.out.println(s));
	}
	public static void collectStream() 
	{
		//There is a list manipulate the list return it back as new list
		List<String>newStream=Stream.of("Suhana","Abhijeet","Ankita","Roma").filter(s->s.endsWith("a"))
				.map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(newStream);
	}
	public static void printUniqueNumber() 
	{
		//Print unique number from the array
		Integer[] arr= {1,2,3,23,3,2};
		//List<Integer> list=Arrays.asList(arr);
		List<Integer> number=Arrays.asList(3,2,1,5,6,5,9,2,4);
		//number.stream().distinct().forEach(s->System.out.println(s));
		//Sort the array and print the element at 3rd index
		
		List<Integer>sortedArray=number.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedArray.get(2));
	}
}
