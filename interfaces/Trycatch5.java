package interfaces;

public class Trycatch5 {
	public static void main(String[] args)
	{
		try
		{
			int arr[]= {1,3,5,7};
			System.out.println(arr[1]);
		}
		finally
		{
			System.out.println("Finally block");
		}
	}
}
