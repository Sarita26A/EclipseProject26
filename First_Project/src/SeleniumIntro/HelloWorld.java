package SeleniumIntro;

public class HelloWorld {


	public HelloWorld() 
	{
		int num=10;
		int sum=num+10;
		System.out.print(sum);
	}
	public static void main(String args[]) 
	{
		HiWorld hi=new HiWorld();
	}
	
	

}
class HiWorld extends HelloWorld
{
	public HiWorld() 
	
	{
		super();
		System.out.println("Hello");
	}
	
	
}



