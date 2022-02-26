//----------------------------------------------------------------------
/*
  file  : Interpreter.java
  date  : 10/16/19
  author: Matt McCullough
  description: Simulates an interpreter
*/
//----------------------------------------------------------------------
public class Interpreter {

    static int  PC;          //program counter holds address of next instr
    static int  AC;          //the accumulator - a register for doing arithmetic
    static boolean    run_bit = true;  //a bit that can be turned off to halt the machine
    static boolean debug_bit = true; //a bit for debugging (prints AC)
    static int  instr;       //a holding register for the current instruction
    static int  instr_type;  //the instruction type (opcode)
    static int  data_loc;    //the address of the data, or -1 if none
    static int  data;        //holds the current operand
    
    static final int CLR = 100;//set the value in the AC to 0
    static final int ADDI = 200; //add the value x to the AC
    static final int ADDM = 300; //add the value in memory location y to AC
    static final int HALT = 400; //instruction which halts the processor

    
    
    
    public static void main(String[] args)
    {
    	 int  m2[] = {  2,
                 -5,
                 15,
                 CLR,        //"program" starts here
                 ADDI,  12,
                 ADDI,   7,
                 ADDM,   0,
                 ADDM,   1,
                 CLR,
                 HALT
    	 };
    	 interpret( m2, 3 );       //start at CLR //after this executes PC is: 14, AC is: 0
    	 
    	 
    	 
    	 System.out.println();
    	 
    	 
    	 int  m3[] = {  2,
                 50,
                 23,
                 CLR,        //"program" starts here
                 ADDM,  1,
                 ADDI,  15,
                 ADDM,  2,
                 ADDI,  12,
                 HALT,
                 CLR
    	 };
    	 interpret( m3, 3 );       //start at CLR 
    	 
    	 System.out.println();
    	 
    	 
    	 int  m4[] = {  -22,
                 77,
                 88,
                 CLR,        //"program" starts here
                 ADDM,  0,
                 ADDI,  42,
                 CLR,
                 ADDM,  1,
                 ADDI,  12,
                 HALT
    	 };
    	 interpret( m4, 3 );       //start at CLR 
    	 
    }
    //------------------------------------------------------------------
    //This procedure interprets programs for a simple machine.  The machine
    //has a register AC (accumulator), used for arithmetic.  The interpreter
    //keeps running until the run bit is turned off by the HALT instruction.
    //The state of a process running on this machine consists of the memory,
    //the program counter, the run bit, and the AC.  The input parameters
    //consist of the memory image and the starting address.
    
    
    public static void interpret ( int memory[], int starting_address ) {
        PC = starting_address;
        run_bit = true;
        while (run_bit) {
            instr = memory[PC];  //fetch next instruction into instr
            PC = PC + 1;  //increment program counter
            instr_type = get_instr_type( instr );  //determine instruction type
            data_loc = find_data( instr, instr_type, memory );  //locate data (-1 if none)
            if (data_loc >= 0)  {  //if data_loc is -1, there is no operand
                data = memory[data_loc];  //fetch the data
            }
            execute( instr_type, data );  //execute instruction
            if(debug_bit == true)
            	System.out.println(AC);
        }
    }
    //------------------------------------------------------------------
    //since our instruction set is so simple, we'll let the opcode and 
    // instruction type be the same.
    private static int get_instr_type ( int opcode ) 
    { return opcode; 
    
    }
    //------------------------------------------------------------------
    private static int find_data ( int opcode, int type, int memory[] ) 
    {
    	if(opcode ==ADDI)
    	{
    		return PC;
    	}
    	if(opcode == ADDM)
    	{
    		return memory[PC];
    	}
    	else
    		return -1;
    }
    //------------------------------------------------------------------
    private static void execute ( int type, int data ) 
    {
    	if(instr_type == CLR)
    	{
    		AC=0;
    	}
    	if(instr_type == ADDI)
    	{
    		AC+=data;
    	}
    	if(instr_type == ADDM)
    	{
    		AC+=data;
    	}
    	if(instr_type == HALT)
    	{
    		run_bit = false;
    	}
    }

}
/*
 * Sample Outputs:
 * m2 OUTPUT 
 * 0
 * 12
 * 12
 * 12
 * 19
 * 19
 * 21
 * 21
 * 16
 * 16
 * 0
 * 0
 * 
 * m3 output
 * 0
 * 50
 * 50
 * 65
 * 65
 * 88
 * 88
 * 100
 * 100
 * 100
 * 
 * m4 output
 * 0
 * -22
 * -22
 * 20
 * 20
 * 0
 * 77
 * 77
 * 89
 * 89
 * 89
 */
//----------------------------------------------------------------------