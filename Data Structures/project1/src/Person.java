
public class Person {
	private int age;
	private String name;
	public Person()
	{
		age = 10;
		name = "Bob";
	}
	public Person(int a, String n)
	{
		age = a;
		name = n;
	}
	public Person(Person other)
	{
		age = other.age;
		name = other.name;
	}
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public void setAge(int a)
	{
		age=a;
	}
	public void setName(String n)
	{
		name=n;
	}
	public void walk()
	{
		System.out.println("I am walking now");
	}
}
