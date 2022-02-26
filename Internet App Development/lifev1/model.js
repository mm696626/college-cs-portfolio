/**
 * @file model.js
 * @fileOverview Conway's Game of Life (this file implements the model).
 * <p align="justify">
 * (See <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life">Conway's Game of Life</a>
 * on wikipedia; <a href="https://www.youtube.com/watch?v=R9Plq-D1gEk">this</a>
 * is interesting too on youtube.) Please do the following:
 * </p>
 * <ol>
 * <li> implement the @todo in initializeBoard. put in different initial
 *    configurations to test your code. </li>
 *
 * <li> implement the @todo in nextGeneration. </li>
 *
 * <li> test your code and make sure it works. (you don't need to send me
 *    any outputs or test results. i will thoroughly test it myself.) </li>
 *
 * <li> jsdoc-ument all of this code (yours and mine) properly including any
 *    private members and/or methods. use both javadoc and doxygen to
 *    generate documentation using the same/one source code file. </li>
 * </ol>
 * <pre>
 *     for docs: 1. install node.js.
 *               2. then install jsdoc: npm install -g jsdoc
 *               3. then run jsdoc by clicking on docs.bat.
 *                  output in will appear in out/.
 * </pre>
 * <p><b> Copyright � George J. Grevera, 2017.  All rights reserved. </b></p>
 * @author george j. grevera, ph.d. and new code by Matt McCullough
 */
"use strict";
/**
 * @class
 */
class ConwaysGameOfLife {

    /**
     * this method clears the board (i.e., sets all entries to false).
     * @todo complete this method.
     */
    clear ( ) {

        for(var i=0; i<this.rows; i++)
        {
            for(var j=0; j<this.cols; j++)
            {
                this.board[i][j] = false;
            }
        }

    }
    //-----------------------------------------------------------------------
    /**
     * this method creates a new instance of Conway's Game of Life.
     * @param {number} rows is the number of rows in the board.
     * @param {number} cols is the number of cols in the board.
     */
    constructor ( rows, cols ) {
        console.log( "constructor called." );
        //class vars
        this.generation = 0;
        this.rows       = rows;
        this.cols       = cols;
        //allocate the board. (a 2d array is an array of arrays.)
        this.board      = new Array();
        for (var r = 0; r < this.rows; r++) {
            this.board[ r ] = new Array();
        }

        this.clear();
        this.initializeBoard("random");
        //console.log(this.toString());

    }
    //-----------------------------------------------------------------------
    /**
     * this function sets the initial (starting) board configration.
     * @todo add your code here to initialize the board so _you_ can
     * test your nextGeneration method. example below.
     * @param {string} which indicates the desired initial pattern.
     */
    initializeBoard ( which ) {
        console.log( "initializeBoard called." );
        this.generation = 0;

        this.clear();

        switch (which) {
              case "random" :
                  for(var i = 0; i< this.rows; i++)
                  {
                      for(var j = 0; j<this.cols; j++)
                      {
                          var rand = Math.round(Math.random()); //generates a 0 or an 1

                          if(rand == 0)
                              this.board[i][j] = false;
                          else
                              this.board[i][j] = true;
                      }
                  }
                  break;
              case "reset" :
                  this.clear();
                  for(var i = 0; i<this.rows; i++)
                  {
                      for(var j = 0; j<this.cols; j++)
                      {
                          if(i%2 == 0)
                            this.board[i][j] = true;
                          else
                            this.board[i][j] = false;
                      }
                  }
                  break;

              default:
                  this.clear();
                  this.board[ Math.round(this.rows/2) ][ Math.round(this.cols/2) ] = true;
                  this.board[ Math.round((this.rows/2)+1) ][ Math.round(this.cols/2) ] = true;
                  this.board[ Math.round(this.rows/2) ][ Math.round((this.cols/2)+1) ] = true;
                  this.board[ Math.round((this.rows/2)+1) ][ Math.round((this.cols/2)+1) ] = true;
                  break;
        }
    }


    //-----------------------------------------------------------------------
    /**
     * this function gets the board value at the specified position. if the
     * specifed position is out of bounds, false is returned.
     * @param {number} r is the row.
     * @param {number} c is the col.
     * @returns {boolean} true if alive; false otherwise.
     */
    get ( r, c ) {
        if (r < 0)             return false;
        if (r >= this.rows)    return false;
        if (c < 0)             return false;
        if (c >= this.cols)    return false;
        return this.board[ r ][ c ];
    }
    //.......................................................................
    /**
     * this function replaces the current generation with the next.
     * see http://en.wikipedia.org/wiki/Conway's_Game_of_Life (especially
     * Rules) for a description of how to calculate the next generation.
     * @todo add your code in the place indicated below.
     */
    nextGeneration ( ) {
        ++this.generation;
        console.log( "creating next generation " + this.generation + "." );

        //create space for the next generation
        var next = new Array();
        for (var r = 0; r < this.rows; r++) {
            next[ r ] = new Array();
        }



        var neighbors = this.countNeighbors(); //count neighbors


        for(var i = 0; i < this.rows; i++)
        {
            for(var j = 0; j < this.cols; j++)
            {
              if(neighbors[i][j] < 2 && this.board[i][j] == true) //any live cell with less than 2 dies
                  next[i][j] = false;
              else if((neighbors[i][j] == 3 || neighbors[i][j] == 2) && this.board[i][j] == true) //live cell with 2 or 3 stays
                  next[i][j] = true;
              else if(neighbors[i][j] > 3 && this.board[i][j] == true) //live cell with more than 3 neighbors dies
                  next[i][j] = false;
              else if(neighbors[i][j] == 3 && this.board[i][j] == false) //dead cell with 3 neighbors gets reborn
                  next[i][j] = true;
              else
                  next[i][j] = false; //fill in empty values with blank cells
            }
        }

        this.board = next;  //replace old generation with new one

    }

    countNeighbors() {
      var neighborCount = 0; //count of neighbors in current cell


      //create new neighbor array
      var neighbors = new Array();
      for (var r = 0; r < this.rows; r++) {
          neighbors[ r ] = new Array();
      }


      for(var i = 0; i< this.rows; i++)
      {
          for(var j = 0; j < this.cols; j++)
          {
              neighborCount=0;

              //count all neighbors near cell
              if(this.get(i-1,j-1))
                  neighborCount++;
              if(this.get(i,j-1))
                  neighborCount++;
              if(this.get(i+1,j-1))
                  neighborCount++;
              if(this.get(i-1,j))
                  neighborCount++;
              if(this.get(i+1,j))
                  neighborCount++;
              if(this.get(i-1,j+1))
                  neighborCount++;
              if(this.get(i,j+1))
                  neighborCount++;
              if(this.get(i+1,j+1))
                  neighborCount++;

              neighbors[i][j] = neighborCount;
          }
      }

      return neighbors;
    }
    //-----------------------------------------------------------------------
    /**
     * this function returns a string that represents this object instance.
     * @todo add contents of board to s.
     */
    toString ( ) {
        var s = "";
        s += "gen  = " + this.generation + ", ";
        s += "rows = " + this.rows + ", ";
        s += "cols = " + this.cols + "\n";

        //todo add contents of board to s here.
        for(var i = 0; i<this.rows; i++)
        {
            for(var j = 0; j<this.rows; j++)
            {
                s += this.board[i][j] + " ";
            }

            s += "\n";
        }

        return s;
    }

}
