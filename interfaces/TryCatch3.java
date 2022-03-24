package interfaces;

public class TryCatch3 {
	public static void main(String[] args)
	{
		try
		{
			int a=100/0;
			System.out.println(a);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("we are here");
		}
		catch(ArithmeticException e)
		{
			System.out.println("Nex catch block");
		}
	}
}
