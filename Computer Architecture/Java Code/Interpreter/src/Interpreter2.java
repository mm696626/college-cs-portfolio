//----------------------------------------------------------------------
/*
  file  : Interpreter2.java
  date  : 10/24/19
  author: Matt McCullough
  description: Simulates an interpreter (part 2)
*/
//----------------------------------------------------------------------
public class Interpreter2 {

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
    static final int LDI = 500; //load the AC with the value x
    static final int LDM = 600; //load the AC with the value in memory location y
    static final int ST = 700; //store the value in the AC  in memory location y
    
    
    public static void main(String[] args)
    {
    	 int  m2[] = {  9,
                 -5,
                 CLR,    0,
                 ADDI,  17,
                 ADDI,   2,
                 ST,     0,
                 ADDM,   0,
                 ADDM,   1,
                 CLR,    0,
                 HALT,   0
   };
    	 interpret( m2, 2 ); 
    	 
    	 System.out.println();
    	 int  m3[] = {  9,
                 20,
                 CLR,    0,
                 LDI,  23,
                 ADDI,   2,
                 ST,     1,
                 LDM,   0,
                 ADDM,   1,
                 HALT,   0
   };
    	 
    	 interpret( m3, 2 ); 
    	 
    	 
    	 System.out.println();
    	 int  m4[] = {  9,
                 99,
                 CLR,    0,
                 ADDI,  7,
                 ADDM,   1,
                 ST,     0,
                 ADDM,   0,
                 LDI,   1,
                 CLR,    0,
                 HALT,   0
   };
    	 interpret( m4, 2 ); 
    	 
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
            if(instr_type == ST)
            {
            	data = data_loc;
            }
            execute( instr_type, data, memory );  //execute instruction
            if(debug_bit == true)
            	System.out.println("PC: " + PC + " AC: " + AC);
            PC++; //increment PC again here instead of at the beginning so instructions execute correctly - increment by 2
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
    	if(opcode == LDI)
    	{
    		return PC;
    	}
    	if(opcode == LDM)
    	{
    		return memory[PC];
    	}
    	if(opcode == ST)
    	{
    		return memory[PC];
    	}
    	else
    		return -1;
    }
    //------------------------------------------------------------------
    private static void execute ( int type, int data, int[] memory ) 
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
    	if(instr_type == LDI)
    	{
    		AC = data;
    	}
    	if(instr_type == LDM)
    	{
    		AC = data;
    	}
    	if(instr_type == ST)
    	{
    		memory[data] = AC;
    	}
    }

}
