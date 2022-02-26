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
    public void setPiece ( int r, int c, Piece p )
    {
        piece[r][c] = p;
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
    public static int getRank ( Piece p ) {
        if(p == Piece.rRat || p == Piece.bRat)
        {
            return 1;
        }
        if(p == Piece.rCat || p == Piece.bCat)
        {
            return 2;
        }
        if(p == Piece.rDog || p == Piece.bDog)
        {
            return 3;
        }
        if(p == Piece.rWolf || p == Piece.bWolf)
        {
            return 4;
        }

        if(p == Piece.rLeopard || p == Piece.bLeopard)
        {
            return 5;
        }
        if(p == Piece.rTiger || p == Piece.bTiger)
        {
            return 6;
        }
        if(p == Piece.rLion || p == Piece.bLion)
        {
            return 7;
        }
        if(p == Piece.rElephant || p == Piece.bElephant)
        {
            return 8;
        }

        else
            return 0;
    }
    //-----------------------------------------------------------------------
    // return the rank of the piece at the specified position (or 0 for none).
    // rat is 1, cat is 2, dog is 3, wolf is 4, leopard is 5, tiger is 6, lion
    // is 7, elephant is 8, regardless of color.
    // @todo v2
    public int getRank ( int r, int c ) {
        if(piece[r][c] == Piece.rRat || piece[r][c] == Piece.bRat)
        {
            return 1;
        }
        if(piece[r][c] == Piece.rCat || piece[r][c] == Piece.bCat)
        {
            return 2;
        }
        if(piece[r][c] == Piece.rDog || piece[r][c] == Piece.bDog)
        {
            return 3;
        }
        if(piece[r][c] == Piece.rWolf || piece[r][c] == Piece.bWolf)
        {
            return 4;
        }

        if(piece[r][c] == Piece.rLeopard || piece[r][c] == Piece.bLeopard)
        {
            return 5;
        }
        if(piece[r][c] == Piece.rTiger || piece[r][c] == Piece.bTiger)
        {
            return 6;
        }
        if(piece[r][c] == Piece.rLion || piece[r][c] == Piece.bLion)
        {
            return 7;
        }
        if(piece[r][c] == Piece.rElephant || piece[r][c] == Piece.bElephant)
        {
            return 8;
        }

        else
            return 0;
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public GameColor getColor( int r, int c )
    {
        if(piece[r][c] == Piece.rLion)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rTiger)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rDog)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rCat)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rRat)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rLeopard)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rWolf)
        {
            return GameColor.Red;
        }
        if(piece[r][c] == Piece.rElephant)
        {
            return GameColor.Red;
        }


        //check for blue
        if(piece[r][c] == Piece.bLion)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bTiger)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bDog)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bCat)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bRat)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bLeopard)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bWolf)
        {
            return GameColor.Blue;
        }
        if(piece[r][c] == Piece.bElephant)
        {
            return GameColor.Blue;
        }

        else
            return GameColor.None;
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public static GameColor getColor( Piece p ) {
        if(p == Piece.rLion)
        {
            return GameColor.Red;
        }
        if(p == Piece.rTiger)
        {
            return GameColor.Red;
        }
        if(p == Piece.rDog)
        {
            return GameColor.Red;
        }
        if(p == Piece.rCat)
        {
            return GameColor.Red;
        }
        if(p == Piece.rRat)
        {
            return GameColor.Red;
        }
        if(p == Piece.rLeopard)
        {
            return GameColor.Red;
        }
        if(p == Piece.rWolf)
        {
            return GameColor.Red;
        }
        if(p == Piece.rElephant)
        {
            return GameColor.Red;
        }


        //check for blue
        if(p == Piece.bLion)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bTiger)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bDog)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bCat)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bRat)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bLeopard)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bWolf)
        {
            return GameColor.Blue;
        }
        if(p == Piece.bElephant)
        {
            return GameColor.Blue;
        }
        return GameColor.None;
    }
    //-----------------------------------------------------------------------
    // returns true if this spot does not have any (moveable) piece on it;
    // false otherwise or if out of bounds.
    // @todo v2
    public boolean isEmpty ( int r, int c ) {

        if(piece[r][c] == Piece.rbNone)
            return true;
        else
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



    protected boolean isValidMove ( int fromRow, int fromCol, int toRow, int toCol ) {
        // \todo v3

        //check whose turn it is and disallow move if its not your turn
        if(bluesTurn==true)
        {
            if(getColor(getPiece(fromRow,fromCol)) != GameColor.Blue)
            {
                return false;
            }
        }
        if(bluesTurn == false)
        {
            if(getColor(getPiece(fromRow,fromCol)) == GameColor.Blue)
            {
                return false;
            }
        }
        //check if tile you are moving to is the same
        if(fromRow==toRow && fromCol==toCol)
        {
            return false;
        }

        //check if board tile is a den (disallow animals moving into own dens)
        if(getBoard(toRow,toCol) == Base.cRDen || getBoard(toRow,toCol) == Base.cBDen)
        {
            if(getColor(getPiece(fromRow,fromCol)) == GameColor.Red && getBoard(toRow,toCol) == Base.cRDen)
            {
                return false;
            }
            if(getColor(getPiece(fromRow,fromCol)) == GameColor.Blue && getBoard(toRow,toCol) == Base.cBDen)
            {
                return false;
            }
        }


        //check if board tile is a trap
        if(getBoard(toRow,toCol) == Base.cRTrap || getBoard(toRow,toCol) == Base.cBTrap)
        {
            if(getPiece(toRow,toCol) != Piece.rbNone) //check if piece is in a trap
            {
                //check if trap is opposite color
                if(getColor(getPiece(toRow,toCol)) == GameColor.Blue && getBoard(toRow,toCol) == Base.cRTrap)
                {
                    //limit movement here (movement limit check again to make sure capture is being done from 1 tile away)
                    if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
                    {
                        setPiece(toRow,toCol,getPiece(fromRow,fromCol)); //set piece to the mover
                        setPiece(fromRow,fromCol,Piece.rbNone); //set piece to the mover
                        return true;
                    }

                }
                if(getColor(getPiece(toRow,toCol)) == GameColor.Red && getBoard(toRow,toCol) == Base.cBTrap)
                {
                    //limit movement here (movement limit check again to make sure capture is being done from 1 tile away)
                    if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
                    {
                        setPiece(toRow,toCol,getPiece(fromRow,fromCol)); //set piece to the mover
                        setPiece(fromRow,fromCol,Piece.rbNone); //set piece to the mover
                        return true;
                    }

                }
            }
        }


        //check if tile behind, to the left, to the right, or in front is a water and the tile to next to is a ground tile
        if(getPiece(fromRow,fromCol) == Piece.bLion || getPiece(fromRow,fromCol) == Piece.rLion || getPiece(fromRow,fromCol) == Piece.bTiger || getPiece(fromRow,fromCol) == Piece.rTiger)
        {


            if ((fromCol == 0 || fromCol == 3 || fromCol == 6) && (fromRow > 2 && fromRow < 6)) {

                if (Math.abs(toCol - fromCol) == 3 && (toRow == fromRow)) {
                    // check if there's a rat in the river blocking the jump (there should only be rats in the water, so the general check works here)
                    for (int i = 1; i < 3; i++) {
                        int sign = (toCol - fromCol) % 2;
                        if (getPiece(fromRow,fromCol+sign*i) != Piece.rbNone) {
                            return false;
                        }
                    }
                }
            }




            if ((fromRow == 2 || fromRow == 6) && (fromCol == 1 || fromCol == 2 || fromCol == 4 || fromCol == 5)) {
                if (Math.abs(toRow - fromRow) == 4 && (fromCol == toCol)) {
                    // check if there's a rat in the river blocking the jump (there should only be rats in the water, so the general if a piece check works here)
                    for (int i = 1; i < 4; i++) {
                        int sign = (toRow - fromRow) % 3;
                        if (getPiece(fromRow + sign * i,fromCol) != Piece.rbNone) {
                            return false;
                        }
                    }




                }
            }
            //check for capture after jump
            if(getPiece(toRow,toCol) != Piece.rbNone) //check if piece is there
            {
                if(getRank(getPiece(fromRow,fromCol)) >= getRank(getPiece(toRow,toCol))) //check if rank of attacker is >= defender
                {
                    //forgot to limit movement(limited now)

                    //check if piece is different color
                    if(getColor(getPiece(fromRow,fromCol)) != getColor(getPiece(toRow,toCol))) {

                        if((Math.abs(toRow - fromRow) == 4 && (fromCol == toCol)) || (Math.abs(toCol - fromCol) == 3 && (toRow == fromRow))) //check for tiles where pieces can be after jump
                        {
                            setPiece(toRow, toCol, getPiece(fromRow, fromCol)); //set piece to the attacker
                            setPiece(fromRow, fromCol, Piece.rbNone); //delete piece that was there
                            return true;
                        }

                    }
                }
                else
                    return false;
            }

            //no piece means good move (still check 1 space movement though)
            else
            {
                //forgot to limit movement (limited now)

                //jump water
                if((Math.abs(toRow - fromRow) == 4 && (fromCol == toCol)) || (Math.abs(toCol - fromCol) == 3 && (toRow == fromRow))) //check for tiles where pieces can be after jump
                {
                    setPiece(toRow, toCol, getPiece(fromRow, fromCol)); //set piece to the attacker
                    setPiece(fromRow, fromCol, Piece.rbNone); //delete piece that was there
                    return true;
                }

            }




        }



        //special rat case goes here
        if(getPiece(fromRow,fromCol) == Piece.bRat || getPiece(fromRow,fromCol) == Piece.rRat)
        {

            //check if rat is on water currently
            if(getBoard(fromRow,fromCol) == Base.cWater)
            {
                if(getPiece(toRow,toCol) == Piece.bElephant || getPiece(toRow,toCol) == Piece.rElephant)
                {
                    return false; //elephant cannot be attacked when rat is on water
                }
            }
            //rat can move on water
            if(getBoard(toRow,toCol) == Base.cWater)
            {
                //forgot to limit movement (limited now)
                if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
                {
                    setPiece(toRow,toCol,getPiece(fromRow,fromCol)); //set piece to the attacker
                    setPiece(fromRow,fromCol,Piece.rbNone); //delete piece that was there
                    return true;
                }

            }
            if(getPiece(toRow,toCol) == Piece.bElephant || getPiece(toRow,toCol) == Piece.rElephant)
            {
                //check if piece is different color
                if(getColor(getPiece(fromRow,fromCol)) != getColor(getPiece(toRow,toCol)))
                {
                    //forgot to limit movement (limited now)
                    if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
                    {
                        setPiece(toRow,toCol,getPiece(fromRow,fromCol)); //set piece to the attacker
                        setPiece(fromRow,fromCol,Piece.rbNone); //delete piece that was there
                        return true;
                    }

                }
            }
        }

        //inverse case elephant to rat
        if(getPiece(fromRow,fromCol) == Piece.bElephant || getPiece(fromRow,fromCol) == Piece.rElephant)
        {
            if(getPiece(toRow,toCol) == Piece.bRat || getPiece(toRow,toCol) == Piece.rRat)
            {
                return false;
            }
        }


        //check if tile is not a water tile (non-special case movement)
        if(getPiece(toRow,toCol) == Piece.rbNone && getBoard(toRow,toCol) != Base.cWater) //check if no piece is there and isn't a water tile
        {
            if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
            {
                setPiece(toRow,toCol,getPiece(fromRow,fromCol)); //set piece to the mover
                setPiece(fromRow,fromCol,Piece.rbNone); //set piece to the mover
                return true;
            }
            else
                return false;
        }


        //normal pieces cannot move on water (rat case has been executed at this point)
        if(getBoard(toRow,toCol) == Base.cWater)
        {
            return false;
        }

        if(getPiece(toRow,toCol) != Piece.rbNone) //check if piece is there
        {
            if(getRank(getPiece(fromRow,fromCol)) >= getRank(getPiece(toRow,toCol))) //check if rank of attacker is >= defender
            {
                if(getColor(getPiece(fromRow,fromCol)) != getColor(getPiece(toRow,toCol))) {

                    //movement limit check again to make sure capture is being done from 1 tile away
                    if((Math.abs(toRow-fromRow) == 1 && toCol-fromCol == 0) || (Math.abs(toCol-fromCol) == 1 && toRow-fromRow == 0))
                    {
                        setPiece(toRow, toCol, getPiece(fromRow, fromCol)); //set piece to the attacker
                        setPiece(fromRow, fromCol, Piece.rbNone); //delete piece that was there
                        return true;
                    }

                }
            }
            else
                return false;
        }

        return false;
    }
    //-----------------------------------------------------------------------
    // perform the specified move but only if it's valid. unlike the above
    // function, this function will make sure that it is the
    // appropriate player's turn. if the move is performed, the player's turn
    // is changed to the other player.
    // return true if the proposed move is valid; false otherwise.
    //
    public boolean doMove ( int fromRow, int fromCol, int toRow, int toCol ) {
        if(isValidMove(fromRow,fromCol,toRow,toCol) == true)
        {
            if(bluesTurn==true)
                bluesTurn=false;
            else
                bluesTurn=true;

            return true;
        }
        else
            return false;
    }


}  //end class Board
