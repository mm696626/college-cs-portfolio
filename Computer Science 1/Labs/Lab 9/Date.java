public class Date
{
    private int month;
    private int day;
    private int year; //a four digit number.
    public Date(int m, int d, int y)
    {
       month = m;
       day = d;
       year = y;
    }
    public Date(Date d)
    {
      month = d.month;
      day = d.day;
      year = d.year;
    
    }
    public int getMonth()
    {
      return month;
    }
    public int getDay()
    {
      return day;
    }
    public int getYear()
    {
      return year;
    }
    public void setMonth(int m)
    {
      month = m;
    }
    public void setDay(int d)
    {
      day = d;
    }
    public void setYear(int y)
    {
      year = y;
    }
    public String toString()
    {
      return(" Date: " + month + " " + day + ", " + year);
    
    }
}    