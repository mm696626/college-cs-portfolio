//Pac-Man GUI JavaScript by Matt McCullough
//Internet App Development
"use strict";

function getScale ( ) {
    var w = window.innerWidth;
    var h = window.innerHeight;
    //we don't want to be more than 95% of max possible size.
    var maxWidth  = 0.95 * w;
    var maxHeight = 0.95 * h - 50;  //leave room at the bottom for buttons
    //calc scale factors (independently in both directions)
    var sc1 = maxWidth  / g.cols;
    var sc2 = maxHeight / g.rows;
    //maintain square cells
    var scale = sc1;
    if (sc2 < scale)    scale = sc2;
    //maintain minimum cell size
    if (scale < 4)      scale = 4;
    return scale;
}


function paint ( ) {

    var scale = getScale();
    //set the canvas size to exactly fit the board
    var canvas = document.getElementById( "can" );

    //get images
    var ghostImage = document.getElementById("ghost");
    var weakGhostImage = document.getElementById("weakghost");
    var fruitImage = document.getElementById("fruit");

    canvas.width  = g.cols * scale + 1;
    canvas.height = g.rows * scale + 1;

    var ctx = canvas.getContext( "2d" );
    ctx.fillStyle = "black";
    ctx.fillRect( 0, 0, canvas.width, canvas.height );
    ctx.beginPath();
    for (var r = 0; r < g.rows; r++) {
        for (var c = 0; c < g.cols; c++) {

            if (g.board[r][c] == 1) { //draw dots
                ctx.fillStyle = 'yellow';
                ctx.arc(c*scale, r*scale, scale/8, 0, 2 * Math.PI);
                ctx.fill();
                ctx.closePath();
                ctx.beginPath();
            }

            if (g.board[r][c] == 2)  { //draw Pacman

              ctx.fillStyle = g.pacmanColor;

              if (g.chomp == false) //open
              {
                ctx.arc(c*scale, r*scale, scale/2, (Math.PI/7) + g.rotationAngle, (-Math.PI/7) + g.rotationAngle);
                ctx.lineTo(c*scale,r*scale);
                ctx.fill();
                ctx.closePath();
                ctx.beginPath();
              }
              else //close
              {
                ctx.arc(c*scale, r*scale, scale/2, 0, 2 * Math.PI);
                ctx.fill();
                ctx.closePath();
                ctx.beginPath();
              }

            }

            if (g.board[r][c] == 3)  { //draw fruit
              ctx.drawImage(fruitImage, (c*scale) - 5, (r*scale) - 5, scale/2, scale/2);
            }

            if (g.board[r][c] == 4)  { //draw power pellet
              ctx.fillStyle = 'yellow';
              ctx.arc(c*scale, r*scale, scale/4, 0, 2 * Math.PI);
              ctx.fill();
              ctx.closePath();
              ctx.beginPath();
            }

            if (g.board[r][c] == 5) { //draw walls
                ctx.fillStyle = 'blue';
                ctx.fillRect( c*scale, r*scale, scale, scale );
            }

            //draw ghost
            if(r == g.ghostX && c == g.ghostY)
            {

              if(g.invincible == false)
                ctx.drawImage(ghostImage, (c*scale) - 5, (r*scale) - 5, scale/1.5, scale/1.5);
              else
                ctx.drawImage(weakGhostImage, (c*scale) - 5, (r*scale) - 5, scale/1.5, scale/1.5);
            }

        }
    }
}
//---------------------------------------------------------------------------
