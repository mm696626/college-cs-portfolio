//Pac-Man JavaScript by Matt McCullough
//Internet App Development
"use strict";

const empty = 0, dot = 1, pacman = 2, fruit = 3, powerPellet = 4, wall = 5;
const up = 1, down = 2, left = 3, right = 4;

class PACMAN {

    constructor ( rows, cols ) {

        this.chomp = false; //if pacman is chomping

        this.paused = false; //pause the game

        this.rotationAngle = 0; //pacman rotation
        this.direction = 4; //direction facing

        this.invincible = false; //power pellet state (spawns one on the map)
        this.invincibilityTimer = 0; //time for how long you are invincible for

        //loop
        this.moveID = 0;
        this.ghostMoveID = 0;

        //score
        this.score = 0;
        this.lives = 3; //lives counter

        //audio engine
        this.audio = new Audio();

        //custom pacmanColor
        this.pacmanColor = "yellow";

        //pacman x and y position
        this.x = 0;
        this.y = 0;

        //ghost x and y position
        this.ghostX = -10;
        this.ghostY = -10;

        this.rows = rows;
        this.cols = cols;

        //allocate the board. (a 2d array is an array of arrays.)
        this.board      = new Array();
        for (var r = 0; r < this.rows; r++) {
            this.board[ r ] = new Array();
        }
    }


    customPacmanColor()
    {
        var red = prompt("Set red value (0-255)");

        while (isNaN(red) || red < 0 || red > 255 || red === null)
        {
            var red = prompt("Set red value (0-255)");
        }

        var green = prompt("Set green value (0-255)");

        while (isNaN(green) || green < 0 || green > 255 || green === null)
        {
            var green = prompt("Set green value (0-255)");
        }

        var blue = prompt("Set blue value (0-255)");

        while (isNaN(blue) || blue < 0 || blue > 255 || blue === null)
        {
            var blue = prompt("Set blue value (0-255)");
        }

        this.pacmanColor = "rgb(" + red + ", " + green + ", " + blue + ")";
    }

    playAudio(fileName)
    {
      //set volume
      var volumeValue = document.getElementById("volume").value;
      var volume = parseInt(volumeValue);

      //update volume text
      document.getElementById("volumeValue").innerHTML = volume + "% Volume";

      //play audio at volume
      this.audio = new Audio(fileName);
      this.audio.volume = volume/100;
      this.audio.play();
    }

    pauseGame()
    {
        if (this.paused == true) //pause game
        {
            clearInterval(this.moveID);
            clearInterval(this.ghostMoveID);
        }
        else //unpause game
        {
            this.moveID = setInterval("g.movePACMAN()", 170);
            this.ghostMoveID = setInterval("g.moveGhost()", 375);
        }
    }
    moveGhost()
    {
        var oldGhostX = this.ghostX;
        var oldGhostY = this.ghostY;


        var xDistance = Math.abs(this.ghostX - this.x);
        var yDistance = Math.abs(this.ghostY - this.y);

        if (this.invincible == false) //chase
        {
            if (xDistance > yDistance)
            {
                if (this.ghostX < this.x)
                    this.ghostX++;
                if (this.ghostX > this.x)
                    this.ghostX--;
            }
            else
            {
                if (this.ghostY > this.y)
                    this.ghostY--;
                if (this.ghostY < this.y)
                    this.ghostY++;
            }
        }
        else //run away
        {
          if (xDistance < yDistance)
          {
              if (this.ghostX < this.x)
                  this.ghostX--;
              if (this.ghostX > this.x)
                  this.ghostX++;
          }
          else
          {
              if (this.ghostY > this.y)
                  this.ghostY++;
              if (this.ghostY < this.y)
                  this.ghostY--;
          }
        }

        //ghost stuck in wall on the edges checks
        if (this.ghostX == 0 && this.board[this.ghostX][this.ghostY] == wall)
            this.ghostX = 1;
        if (this.ghostY == 0 && this.board[this.ghostX][this.ghostY] == wall)
            this.ghostY = 1;
        if (this.ghostX == this.rows-1 && this.board[this.ghostX][this.ghostY] == wall)
            this.ghostX = this.rows-2;
        if (this.ghostY == this.cols-1 && this.board[this.ghostX][this.ghostY] == wall)
            this.ghostY = this.cols-2;

        //OOB checks
        if (this.ghostX < 0)
            this.ghostX = 0;
        if (this.ghostX >= this.rows)
            this.ghostX = this.rows-1;

        if (this.ghostY < 0)
            this.ghostY = 0;
        if (this.ghostY >= this.cols)
            this.ghostY = this.cols-1;

    }

    movePACMAN()
    {

        if (this.invincibilityTimer > 0)
        {
            this.invincibilityTimer--;
        }
        else
        {
            this.invincible = false;
        }

        //update HUD
        document.getElementById("scoreAndLivesInfo").innerHTML = "Score: " + this.score + " Lives: " + this.lives;

        if (this.x == this.ghostX && this.y == this.ghostY && this.invincible == false)
        {
            this.lives--; //lose a life

            //play death sound and stop game
            this.playAudio('death.wav');

            if (this.lives <= 0)
            {
                clearInterval(this.moveID);
                clearInterval(this.ghostMoveID);

                //update HUD on game over
                document.getElementById("scoreAndLivesInfo").innerHTML = "GAME OVER! Your score was: " + this.score + "!";
            }
            else
            {
                //re place pacman on top of game board
                this.board[this.x][this.y] = empty;
                this.x = this.rows/2;
                this.y = this.cols/2;

                this.board[this.x][this.y] = pacman;

                this.ghostX = 0;
                this.ghostY = 0;
            }

        }


        if (this.x == this.ghostX && this.y == this.ghostY && this.invincible == true)
        {
            //play ghost eat sound and stop game
            this.playAudio('eatghost.wav');

            this.score += 800;

            clearInterval(this.ghostMoveID);
            this.ghostX = -10;
            this.ghostY = -10;
            setTimeout("g.restartGhostMove()", 5000);
        }

        this.chomp = !this.chomp; //eating animation

        //play eating sound
        if (this.chomp == true)
        {
            this.playAudio('eat.wav');
        }
        else
        {
            this.playAudio('eat2.wav');
        }


        var oldX = this.x;
        var oldY = this.y;

        if (this.direction == up)
        {
            this.rotationAngle = 3*Math.PI/2;

            if (this.x > 0)
              this.x--;
        }

        if (this.direction == down)
        {
            this.rotationAngle = Math.PI/2;

            if (this.x < this.rows-1)
              this.x++;
        }

        if (this.direction == left)
        {
            this.rotationAngle = Math.PI;

            if (this.y > 0)
              this.y--;
        }

        if (this.direction == right)
        {
            this.rotationAngle = 0;

            if (this.y < this.cols - 1)
              this.y++;
        }

        if (this.board[this.x][this.y] == dot)
        {
            this.playAudio("dot.wav");
            this.score += 10;
        }

        if (this.board[this.x][this.y] == fruit)
        {
            this.playAudio('fruit.wav');
            this.score += 100;
        }

        if (this.board[this.x][this.y] == powerPellet)
        {
            this.invincible = true;
            this.invincibilityTimer = 30;
            this.playAudio('powerpellet.wav');
            this.score += 1000;
        }

        //wrap around checks
        if (this.x == 0 && this.direction == up)
          this.x = this.rows-1;
        if (this.x == this.rows-1 && this.direction == down)
          this.x = 0;
        if (this.y == 0 && this.direction == left)
          this.y = this.cols-1;
        if (this.y == this.cols-1 && this.direction == right)
          this.y = 0;

        if (this.board[this.x][this.y] != wall) //if no wall in the way
        {
            this.board[oldX][oldY] = empty;
            this.board[this.x][this.y] = pacman; //move pacman
        }
        else
        {
            //reset Pacman position to before the wall
            this.x = oldX;
            this.y = oldY;
        }



        if (this.checkifBoardEmpty())
        {
            this.generateNewBoard();
        }

        paint();
}

    restartGhostMove()
    {
        this.ghostMoveID = setInterval("g.moveGhost()", 375);
    }


    initializeBoard() {

      this.moveID = setInterval("g.movePACMAN()", 170);
      this.ghostMoveID = setInterval("g.moveGhost()", 375);

      //reset all board squares
      for (var i = 0; i< this.rows; i++)
      {
          for (var j = 0; j<this.cols; j++)
          {
             this.board[i][j] = empty;
          }
      }

      //place dots
      for (var i = 0; i< this.rows; i++)
      {
          for (var j = 0; j<this.cols; j++)
          {
              var rand = Math.round(Math.random()); //generates a 0 or an 1

              if (rand == 0)
                  this.board[i][j] = dot;
          }
      }

      var fruitNum = this.generateRandomNumber(5, 10);

      for (var i = 0; i<fruitNum; i++)
      {
        //place 5-10 random fruits
        this.board[this.generateRandomNumber(0,this.rows-1)][this.generateRandomNumber(0,this.cols-1)] = fruit;
      }

      var powerPelletNum = this.generateRandomNumber(2, 5);

      for (var i = 0; i<powerPelletNum; i++)
      {
        //place 2-5 random power pellets
          this.board[this.generateRandomNumber(0,this.rows-1)][this.generateRandomNumber(0,this.cols-1)] = powerPellet;
      }

      //place pacman on top of game board
      this.x = this.rows/2;
      this.y = this.cols/2;
      this.board[this.x][this.y] = pacman;

      //build walls
      for (var i = 0; i<this.rows; i++)
      {
          this.board[i][0] = wall;
      }
      for (var i = 0; i<this.cols; i++)
      {
          this.board[0][i] = wall;
      }

      //build walls
      for (var i = 0; i<this.rows; i++)
      {
          this.board[i][this.cols-1] = wall;
      }
      for (var i = 0; i<this.cols; i++)
      {
          this.board[this.rows-1][i] = wall;
      }

      //add wrap around tiles
      this.board[(this.rows/2) - 1][0] = empty;
      this.board[this.rows/2][0] = empty;

      this.board[0][(this.cols/2)-1] = empty;
      this.board[0][this.cols/2] = empty;

      this.board[(this.rows/2)-1][this.cols-1] = empty;
      this.board[this.rows/2][this.cols-1] = empty;

      this.board[this.rows-1][this.cols/2] = empty;
      this.board[this.rows-1][(this.cols/2)-1] = empty;
    }

    reset()
    {
        clearInterval(this.moveID); //stop timer
        clearInterval(this.ghostMoveID); //stop timer
        this.ghostX = 0;
        this.ghostY = 0;
        this.invincible = false; //reset invincible state
        this.invincibilityTimer = 0; //reset invincibilityTimer
        this.initializeBoard(); //reinitalize board
        paint();
    }

    //generate new board when all dots are gone
    generateNewBoard()
    {
        //stop timer and generate new board and keep pacman there
        this.reset();
    }

    checkifBoardEmpty()
    {
      for (var i = 0; i<this.rows; i++)
      {
        for (var j = 0; j<this.cols; j++)
        {
            if (this.board[i][j] == dot || this.board[i][j] == fruit || this.board[i][j] == powerPellet)
                return false;
        }
      }

      return true;
    }

    //Returns an integer random number between min (included) and max (included)
    generateRandomNumber(min, max)
    {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
