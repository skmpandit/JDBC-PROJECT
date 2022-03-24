package interfaces;

import java.io.IOException;

class N
{
	void methods() throws IOException
	{
		System.out.println("hi");
	}
}
public class Test {
	public static void main(String[] args) throws IOException
	{
		N m=new N();
		m.methods();
		System.out.println("Normal flows");
	}
}
