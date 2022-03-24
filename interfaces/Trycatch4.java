package interfaces;

public class Trycatch4 {
	public static void main(String[] args)
	{
		try
		{
			int arr[]= {1,3,5,7};
			System.out.println(arr[10]);
		}
		finally
		{
			System.out.println("Finally block");
		}
	}
}
