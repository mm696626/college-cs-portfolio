public class Board {

    private int rows = 8;
    private int cols = 8;
    private int[][] board = new int[rows][cols];

    private boolean blacksTurn = true;

    /*
    Unavailable = 0
    Empty = 1
    Black = 2
    White = 3
     */

    public Board()
    {
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                board[i][j] = 0;
            }
        }

        board[3][3] = 3;
        board[4][3] = 2;
        board[3][4] = 2;
        board[4][4] = 3;

    }

    public Board(Board original)
    {
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                board[i][j] = original.board[i][j];
            }
        }
    }

    public int getPiece(int r, int c)
    {
        if(r>=0 && c>=0 && r<rows && c<cols)
        {
            return board[r][c];
        }

        return 0;

    }

    public int countWhite()
    {
        int count = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(board[i][j] == 3)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public int countBlack()
    {
        int count = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(board[i][j] == 2)
                {
                    count++;
                }
            }
        }
        return count;
    }

    private void switchPiece(int r, int c)
    {
        if(board[r][c] == 2 && blacksTurn == false)
            board[r][c] = 3;

        if(board[r][c] == 3 && blacksTurn == true)
            board[r][c] = 2;
    }


    private void direction(int row, int column, int xDir, int yDir)
    {
        int color=0;
        if(blacksTurn == true)
            color = 2;
        else
            color = 3;

        int currentRow= row + xDir;
        int currentCol = column + yDir;

        if (currentRow==8 || currentRow<0 || currentCol==8 || currentCol<0)
        {
            return;
        }

        while (board[currentRow][currentCol]== 2 || board[currentRow][currentCol]==3)
        {
            if (board[currentRow][currentCol]==color)
            {
                while(!(row==currentRow && column==currentCol))
                {
                    board[currentRow][currentCol]=color;
                    currentRow=currentRow-xDir;
                    currentCol=currentCol-yDir;
                }
                break;
            }

            else
            {
                currentRow=currentRow + xDir;
                currentCol=currentCol + yDir;
            }

            if (currentRow<0 || currentCol<0 || currentRow==8 || currentCol==8)
            {
                break;
            }
        }
    }

    public void placePiece(int r, int c)
    {

        boolean validTurn = true;
        int piece;
        int pieceToFlip;
        int start;

        if(this.blacksTurn == true)
            piece = 2;
        else
            piece = 3;


        if(this.blacksTurn == true)
            pieceToFlip = 3;
        else
            pieceToFlip = 2;


        if(board[r][c] != 0){
            validTurn = false;
        }

        if(r>=0 && c>=0 && r<rows && c<cols && board[r][c] == 0)
        {

            board[r][c] = piece; //place piece


            //check above & below
            direction(r, c, 0, -1);
            direction(r, c, 0, 1);

            //check right & right
            direction(r, c, 1,0);
            direction(r, c, -1, 0);

            //check corners
            direction(r, c, 1,1);
            direction(r, c, 1,-1);
            direction(r, c, -1,1);
            direction(r, c, -1,-1);


        }


        if(validTurn == true)
        {
            if(blacksTurn==true)
                blacksTurn=false;
            else
                blacksTurn=true;
        }


    }

    public String toString()
    {
        String output = "";
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(board[i][j] == 0)
                {
                    output+="X ";
                }
                if(board[i][j] == 2)
                {
                    output+="B ";
                }
                if(board[i][j] == 3)
                {
                    output+="W ";
                }

            }
            output+="\n";
        }

        return output;
    }



}
