
public class TestProgram {

	public static void main(String[] args) {
		Computer device1 = new Computer("Dell", "AMD", 8,512,3.4);
		Notebook device2 = new Notebook("Apple", "Intel", 16,512,3.4,15,3);
		System.out.println("Device1: ");
		System.out.println(device1.toString());
		System.out.println("Device2: ");
		System.out.println(device2.toString());
		
		Notebook device3 = new Notebook(12,34,5.6,5,8);
		System.out.println("Device3: ");
		System.out.println(device3.toString());
		
		
	}

}
