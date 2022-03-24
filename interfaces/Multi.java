package interfaces;

interface D
{
	void show();
}
interface X
{
	void show();
}
public class Multi implements D,X    
{
	public void show()
	{
		System.out.println("Hello");
	}
	public static void main(String[] args)
	{
		Multi m=new Multi();
		m.show();
	}
}
