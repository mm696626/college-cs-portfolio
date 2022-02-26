
public class Computer {
	private String manufacturer;
	private String processor;
	private int ramSize;
	private int diskSize;
	private double processorSpeed;
	
	public Computer()
	{
		
	}
	public Computer(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed)
	{
		this.manufacturer = manufacturer;
		this.processor = processor;
		this.ramSize = ramSize;
		this.diskSize = diskSize;
		this.processorSpeed = processorSpeed;
	}
	public int getRamSize()
	{
		return ramSize;
	}
	public String toString()
	{
		String result = "Manufacturer: " + manufacturer + "\nCPU: " + processor + 
				"\nRAM: " + ramSize + "\nDisk: " + diskSize + 
				"\nProcessor Speed: " + processorSpeed;
		return result;
		
	}
}
