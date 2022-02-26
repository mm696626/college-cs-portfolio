public class MilitaryPerson {

    private String firstName;
    private String lastName;
    private String rank;
    private String serialNumber;
    private String branch;
    private boolean active;

    public MilitaryPerson()
    {
        firstName = "Matt";
        lastName = "McCullough";
        rank = "Corporate";
        serialNumber = "1234";
        branch = "The Greatest";
        active = false;
    }

    public MilitaryPerson(String f, String l, String r, String s, String b, boolean a)
    {
        firstName = f;
        lastName = l;
        rank = r;
        serialNumber = s;
        branch = b;
        active = a;
    }

    public String getBranch()
    {
        return branch;
    }
    public void setBranch(String b)
    {
        branch = b;
    }




    public String toString()
    {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nRank: " + rank + "\nSerial Number: " + serialNumber + "\nBranch: " + branch + "\nActive: " + active;
    }




    public static void main(String[] args)
    {
        MilitaryPerson p1 = new MilitaryPerson("Dwight", "Eisenhower", "General", "DDE-123", "Army", false);
        MilitaryPerson p2 = new MilitaryPerson("John Paul", "Jones", "Admiral", "JPJ-234", "Navy", false);

        System.out.println(p1);
        System.out.println();
        System.out.println(p2);

    }

}

