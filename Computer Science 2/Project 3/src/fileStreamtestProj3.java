import java.io.*;

public class fileStreamtestProj3{
    public static void main (String args[])throws IOException{ //copy line 1, 4, 6, 8, and 12(Will be last line) for project
    int []arr1={1,2,3,4,5};
    PrintWriter os=null;

    os = new PrintWriter( new FileOutputStream("output.txt"));
    for ( int i=0; i<arr1.length; i++){
        os.println( arr1[i]); //write the bytes
    }
    os.close ();//must close because we use a buffered write - this forces the buffer out to file
    
   }    
}