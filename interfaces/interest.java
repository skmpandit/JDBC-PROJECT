package interfaces;

interface Bank
{
	float rate();
}
class Demo implements Bank
{
	public float rate()
	{
		return 5.5f;
	}
}
class Bank2 implements Bank
{
	public float rate()
	{
		return 7.1f;
	}
}
public class interest 
{
	public static void main(String[] args)
	{
		Bank b=new Demo();
		Bank b2=new Bank2();
		System.out.println("Rate1 "+b.rate());
		System.out.println("Rate2 "+b2.rate());
	}
}
