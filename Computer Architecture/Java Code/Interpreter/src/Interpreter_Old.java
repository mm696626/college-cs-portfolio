
//----------------------------------------------------------------------
/*
  file  : Interpreter.java
  date  :
  author:
  description:
*/
//----------------------------------------------------------------------
public class Interpreter_Old {

    static int  PC;          //program counter holds address of next instr
    static int  AC;          //the accumulator - a register for doing arithmetic
    static boolean run_bit = true;  //a bit that can be turned off to halt the machine
    static boolean debug_bit = false;  //a bit that can be turned on for debugging
    static int  instr;       //a holding register for the current instruction
    static int  instr_type;  //the instruction type (opcode)
    static int  data_loc;    //the address of the data, or -1 if none
    static int  data;        //holds the current operand

    public static void main(String[] args)
    {
    	//0 is CLR, 1 is ADDI X, 2 IS ADDM y, 3 is HALT
    	 int  m2[] = {  2,
                 -5,
                 15,
                 0,        //"program" starts here
                 1,  12,
                 1,   7,
                 2,   0,
                 2,   1,
                 0,
                 3
   };
    	 interpret( m2, 3 );       //start at CLR
  

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
            execute( instr_type, data );//execute instruction
            if(debug_bit == true) // if debug mode is on, print AC after every instruction
            	System.out.println(AC);
        }
    }
    //------------------------------------------------------------------
    //since our instruction set is so simple, we'll let the opcode and 
    // instruction type be the same.
    private static int get_instr_type ( int opcode ) 
    { 
    	return opcode; 
    }
    //------------------------------------------------------------------
    private static int find_data ( int opcode, int type, int memory[] ) 
    {
    	int data = 0;
    	if(type==0) // CLR
    		return data;
    	if(type==1) // ADDI x
    		return memory[PC+1];
    	if(type==2) // ADDM y
    	{
    		int placeInMem = memory[PC+2];
    		data = memory[placeInMem];
    		return data;
    	}
    	else //HALT
    	{
    		return 0;
    	}
    		
    }
    //------------------------------------------------------------------
    private static void execute ( int type, int data ) 
    {		
    	if(type==0)
    		AC=0;
    	if(type==1)
    	{
    		AC+=data;
    	}
    	if(type==2)
    	{
    		AC+=data;
    	}
    	if(type==3)
    	{
    		
    		System.out.println("PC is: " + PC);
    		System.out.println("AC is: " + AC);
    		System.exit(0);
    	}
    }

}
//----------------------------------------------------------------------