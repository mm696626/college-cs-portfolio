public class Board_OLD {

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

    public Board_OLD()
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

    public Board_OLD(Board_OLD original)
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



    public void placePiece(int r, int c)
    {
        //@TODO do diagonals and polish bugs (this is really buggy)

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


            //left
            if(r>0 && board[r-1][c] == pieceToFlip) //check the piece next to it is opposite color
            {
                for(int i=r-1; i>=0; i--)
                {
                    if(board[i][c] == piece){
                        for(int x=r-1; x>=0; x--)
                        {

                            switchPiece(x,c);
                        }
                    }
                }
            }

            //up

            if(c>0 && board[r][c-1] == pieceToFlip) //check the piece next to it is opposite color
            {
                //check to the left
                for(int i=c-1; i>=0; i--)
                {
                    if(board[r][i] == piece){
                        for(int x=c-1; x>=0; x--)
                        {
                            switchPiece(r,x);
                        }
                    }
                }
            }



            //right
            if(r<7 && board[r+1][c] == pieceToFlip) //check the piece next to it is opposite color
            {
                //check to the right
                for(int i=r+1; i<rows; i++)
                {
                    if(board[i][c] == piece){
                        for(int x=r+1; x<rows; x++)
                        {
                            switchPiece(x,c);
                        }
                    }
                }
            }


            //down

            if(c<7 && board[r][c+1] == pieceToFlip) //check the piece next to it is opposite color
            {
                //check to the right
                for(int i=c+1; i<cols; i++)
                {
                    if(board[r][i] == piece){
                        for(int x=c+1; x<cols; x++)
                        {
                            switchPiece(r,x);
                        }
                    }
                }
            }

        }


        if(validTurn == true)
        {
            if(blacksTurn==true)
                blacksTurn=false;
            else
                blacksTurn=true;
        }


    }


}
