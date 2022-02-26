
public class Notebook extends Computer
{
	private double screenSize;
	private double weight;
	
	
	public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight)
	{
		super(manufacturer, processor, ramSize, diskSize, processorSpeed);
		this.screenSize = screenSize; 
		this.weight = weight;
	}
	
	public Notebook(int ramSize, int diskSize, double processorSpeed, double screenSize, double weight)
	{
		this("Lenovo", "Intel", ramSize,diskSize,processorSpeed, screenSize, weight);
	}//method overloading
	
	public String toString()
	{
		String result = super.toString() + "\nScreen Size: " + screenSize + "\nWeight: " + weight;
		return result;
	}//overriding
}
