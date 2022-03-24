package interfaces;

import java.io.IOException;

public class TestThrows {
	void m() throws IOException
	{
		throw new IOException("Device error");
	}
	void n() throws  IOException
	{
		m();
	}
	void p()
	{
		try
		{
			n();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
	}
	public static void main(String[] args)
	{
		TestThrows obj1=new TestThrows();
		obj1.p();
		System.out.println("Normal flow");
	}
}
