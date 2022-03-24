package interfaces;

public class TestThrow {
	static void validate(int age) {
	if(age<18)
	{
		throw new ArithmeticException("not volid");
	}
	else
	{
		System.out.println("Welcome to vote");
	}
}
	public static void main(String[] args)
	{
		validate(19);
		System.out.println("rest of the code..");
	}
}
