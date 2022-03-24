package interfaces;
interface A4
{
	void show();
	void display();
}
public class Demo9 implements A4
{
	public void show()
	{
		System.out.println("I am sonu kumar mahto");
	}
	public void display()
	{
		System.out.println("How are you");
	}
	public static void main(String[] args)
	{
		Demo9 d=new Demo9();
		d.show();
		d.display();
	}
}
