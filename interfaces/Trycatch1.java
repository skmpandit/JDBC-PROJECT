package interfaces;

public class Trycatch1 {
	public static void main(String[] args)
	{
		try
		{
			int arr[]= {1,2,3,4};
			System.out.println(arr[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("We are in catch Block");
		}
	}
}
