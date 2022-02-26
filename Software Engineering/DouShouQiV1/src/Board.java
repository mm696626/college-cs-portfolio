/**
 * @brief Board (Model in M-V-C)
 *
 * rule book:
 *   use this initial setup.
 *   http://veryspecial.us/free-downloads/AncientChess.com-DouShouQi.pdf
 *
 * video of game play & nice picture of initial board setup:
 *   use this (same as above) initial setup.
 *   http://ancientchess.com/page/play-doushouqi.htm
 *
 * play online:
 *   But do NOT use this setup!  Dog and wolf are interchanged.
 *   http://liacs.leidenuniv.nl/~visjk/doushouqi/
 *   Note: Dog and wolf are in different positions.
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */

//Author of new Code: Matt McCullough
public class Board {

    /// constants for the size of the board
    public static final int   fRows = 9;  ///< # of board rows
    public static final int   fCols = 7;  ///< # of board cols

    /// the (underlying) playing board. board[0][0] is the upper left corner.
    protected Base  board[][] = new Base[ fRows ][ fCols ];

    /// the moveable pieces on the playing board. board[0][0] is the upper left corner.
    protected Piece piece[][] = new Piece[ fRows ][ fCols ];

    protected boolean  bluesTurn = true;  ///< by convention, blue goes first
    //-----------------------------------------------------------------------
    /** @brief init the board.
     *
     *  by convention, red will initially be in the top half (0,0) of the
     *  board, and blue will start in the bottom half. be careful. the
     *  opposite sides do not mirror each other!
     *  @todo v1
     */
    public Board ( ) {
        //init the underlying board
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                board[i][j] = Base.cGround;
            }
        }
        this.board[0][2] = Base.cRTrap;
        this.board[0][3] = Base.cRDen;
        this.board[0][4] = Base.cRTrap;
        this.board[1][3] = Base.cRTrap;

        this.board[3][1] = Base.cWater;
        this.board[3][2] = Base.cWater;
        this.board[3][4] = Base.cWater;
        this.board[3][5] = Base.cWater;
        this.board[4][1] = Base.cWater;
        this.board[4][2] = Base.cWater;
        this.board[4][4] = Base.cWater;
        this.board[4][5] = Base.cWater;
        this.board[5][1] = Base.cWater;
        this.board[5][2] = Base.cWater;
        this.board[5][4] = Base.cWater;
        this.board[5][5] = Base.cWater;

        this.board[7][3] = Base.cBTrap;
        this.board[8][2] = Base.cBTrap;
        this.board[8][3] = Base.cBDen;
        this.board[8][4] = Base.cBTrap;



        // ...

        for(int i=0; i<piece.length; i++)
        {
            for(int j=0; j<piece[0].length; j++)
            {
                piece[i][j] = Piece.rbNone;
            }
        }

        //place the pieces
        this.piece[0][0] = Piece.rLion; //red lion
        this.piece[0][6] = Piece.rTiger; //red tiger
        this.piece[1][1] = Piece.rDog; //red dog
        this.piece[1][5] = Piece.rCat; //red cat
        this.piece[2][0] = Piece.rRat; //red rat
        this.piece[2][2] = Piece.rLeopard; //red leopard
        this.piece[2][4] = Piece.rWolf; //red wolf
        this.piece[2][6] = Piece.rElephant; //red elephant

        //blue
        this.piece[6][0] = Piece.bElephant; //blue elephant
        this.piece[6][2] = Piece.bWolf; //blue wolf
        this.piece[6][4] = Piece.bLeopard; //blue leopard
        this.piece[6][6] = Piece.bRat; //blue rat
        this.piece[7][1] = Piece.bCat; //blue cat
        this.piece[7][5] = Piece.bDog; //blue dog
        this.piece[8][0] = Piece.bTiger; //blue tiger
        this.piece[8][6] = Piece.bLion; //blue lion




        // ...

    }
    //-----------------------------------------------------------------------
    /** @returns the specific (moveable) piece (e.g., bWolf or rbNone) at the
     *  indicated position.
     *  @todo v1
     */
    public Piece getPiece ( int r, int c ) {
        if(piece[r][c] != Piece.rbNone)
        {
            return piece[r][c];
        }
        return Piece.rbNone;
    }
    //-----------------------------------------------------------------------
    /** @brief set the piece at the specified position (r,c).
     *  @param p should/must be rbNone or rRat ... rElephant or bRat ... bElephant.
     *  this function should NOT change the board contents (e.g., cWater) at
     *  the specified location.
     *  @todo v2
     */
    public void setPiece ( int r, int c, Piece p ) {
    }
    //-----------------------------------------------------------------------
    /** @returns what appears on the underlying board at the specified position
     *  (e.g., cWater), or cNone if out of bounds.
     * @todo v1
     */
    public Base getBoard ( int r, int c ) {
        if(board[r][c] != Base.cNone)
        {
            return board[r][c];
        }
        return Base.cNone;
    }
    //-----------------------------------------------------------------------
    // given a piece, return its rank (or 0 for an unknown piece).
    // rat is 1, cat is 2, dog is 3, wolf is 4, leopard is 5, tiger is 6, lion
    // is 7, elephant is 8, regardless of color.
    // @todo v2
    public int getRank ( Piece p ) {
        return 0;
    }
    //-----------------------------------------------------------------------
    // return the rank of the piece at the specified position (or 0 for none).
    // rat is 1, cat is 2, dog is 3, wolf is 4, leopard is 5, tiger is 6, lion
    // is 7, elephant is 8, regardless of color.
    // @todo v2
    public int getRank ( int r, int c ) {
        return 0;
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public GameColor getColor( int r, int c ) {
        return GameColor.None;
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public GameColor getColor( Piece p ) {
        return GameColor.None;
    }
    //-----------------------------------------------------------------------
    // returns true if this spot does not have any (moveable) piece on it;
    // false otherwise or if out of bounds.
    // @todo v2
    public boolean isEmpty ( int r, int c ) {
        return false;
    }
    //-----------------------------------------------------------------------
    // returns a string representing the board that can be pretty-printed.
    // it should look something like the following:
    //
    //     --...-        --...-     \n
    //    |      |      |      |    \n
    //    .      .      .      .     .
    //    .      .      .      .     .
    //    .      .      .      .     .
    //    |      |      |      |    \n
    //     --...-        --...-     \n
    //
    // the left side of the string should be the underlying board.
    // the right side should be the pieces at their specific locations.
    // put the first 3 characters of the name at each location
    // (e.g., rLi for the red lion, and bEl for the blue elephant).
    //
    // if you have a better idea, please let me know!
    @Override
    public String toString ( ) {
        // @todo v1
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == Base.cGround) {
                    output += "Gr ";
                }
                if (board[i][j] == Base.cBTrap) {
                    output += "BT ";
                }
                if (board[i][j] == Base.cBDen) {
                    output += "BD ";
                }
                if (board[i][j] == Base.cRTrap) {
                    output += "RT ";
                }
                if (board[i][j] == Base.cRDen) {
                    output += "RD ";
                }
                if (board[i][j] == Base.cWater) {
                    output += "Wa ";
                }
                if (board[i][j] == Base.cNone) {
                    output += "NO ";
                }
            }

            output+="\t";

            for(int j=0; j<piece[0].length; j++)
            {
                if(piece[i][j] == Piece.rbNone)
                {
                    output+="N/A ";
                }
                if(piece[i][j] == Piece.bCat)
                {
                    output+="bCa ";
                }
                if(piece[i][j] == Piece.bLion)
                {
                    output+="bLi ";
                }
                if(piece[i][j] == Piece.bTiger)
                {
                    output+="bTi ";
                }
                if(piece[i][j] == Piece.bRat)
                {
                    output+="bRa ";
                }
                if(piece[i][j] == Piece.bLeopard)
                {
                    output+="bLe ";
                }
                if(piece[i][j] == Piece.bWolf)
                {
                    output+="bWo ";
                }
                if(piece[i][j] == Piece.bDog)
                {
                    output+="bDo ";
                }
                if(piece[i][j] == Piece.bElephant)
                {
                    output+="bEl ";
                }
                if(piece[i][j] == Piece.rElephant)
                {
                    output+="rEl ";
                }
                if(piece[i][j] == Piece.rWolf)
                {
                    output+="rWo ";
                }
                if(piece[i][j] == Piece.rLeopard)
                {
                    output+="rLe ";
                }
                if(piece[i][j] == Piece.rRat)
                {
                    output+="rRa ";
                }
                if(piece[i][j] == Piece.rCat)
                {
                    output+="rCa ";
                }
                if(piece[i][j] == Piece.rTiger)
                {
                    output+="rTi ";
                }
                if(piece[i][j] == Piece.rDog)
                {
                    output+="rDo ";
                }
                if(piece[i][j] == Piece.rLion)
                {
                    output+="rLi ";
                }


            }
            output += "\n";
        }

        return output;
    }

}  //end class Board
