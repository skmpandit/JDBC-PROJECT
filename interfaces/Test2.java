package interfaces;

import java.io.IOException;

class M
{
	void method() throws IOException
	{
		throw new IOException("Error there");
	}
}
public class Test2 {
	public static void main(String[] args) throws IOException
	{
		M m=new M();
		m.method();
		System.out.println("Normal flow");
	}
}
