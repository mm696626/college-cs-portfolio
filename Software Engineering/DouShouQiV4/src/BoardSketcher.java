import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
/**
 * @brief BoardSketcher (View in M-V-C)
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */
class BoardSketcher extends JPanel implements MouseInputListener, KeyListener {

    public static final int initialSize = 50;

    private int      size = initialSize;
    private int      xOff, yOff;
    private JFrame   f = null;
    private Board    b = null;

    private int      fromR = -1, fromC = -1, toR = -1, toC = -1;

    private boolean  soundOn = true;
    private enum Sound { firstClick, secondClick, badMove, capture, winner, loser }

    private Image    piece[] = new Image[ Piece.values().length ];  //images of various pieces

    private boolean  namesOn = true;
    private boolean  rankOn  = true;
    //-----------------------------------------------------------------------
    BoardSketcher ( JFrame f, Board b ) {
        this.f = f;
        this.b = b;

        String title = "Dou Shou Qi (Jungle Chess): " + ((b.bluesTurn) ? "blues turn" : "reds turn");
        f.setTitle( title );

        //load the images for the (moveable) board pieces
        piece[ Piece.rbNone.ordinal()    ] = null;

        piece[ Piece.rRat.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/rRat.png"      );
        piece[ Piece.rCat.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/rCat.png"      );
        piece[ Piece.rDog.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/rDog.png"      );
        piece[ Piece.rWolf.ordinal()     ] = Toolkit.getDefaultToolkit().getImage( "graphics/rWolf.png"     );
        piece[ Piece.rLeopard.ordinal()  ] = Toolkit.getDefaultToolkit().getImage( "graphics/rLeopard.png"  );
        piece[ Piece.rTiger.ordinal()    ] = Toolkit.getDefaultToolkit().getImage( "graphics/rTiger.png"    );
        piece[ Piece.rLion.ordinal()     ] = Toolkit.getDefaultToolkit().getImage( "graphics/rLion.png"     );
        piece[ Piece.rElephant.ordinal() ] = Toolkit.getDefaultToolkit().getImage( "graphics/rElephant.png" );

        piece[ Piece.bRat.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/bRat.png"      );
        piece[ Piece.bCat.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/bCat.png"      );
        piece[ Piece.bDog.ordinal()      ] = Toolkit.getDefaultToolkit().getImage( "graphics/bDog.png"      );
        piece[ Piece.bWolf.ordinal()     ] = Toolkit.getDefaultToolkit().getImage( "graphics/bWolf.png"     );
        piece[ Piece.bLeopard.ordinal()  ] = Toolkit.getDefaultToolkit().getImage( "graphics/bLeopard.png"  );
        piece[ Piece.bTiger.ordinal()    ] = Toolkit.getDefaultToolkit().getImage( "graphics/bTiger.png"    );
        piece[ Piece.bLion.ordinal()     ] = Toolkit.getDefaultToolkit().getImage( "graphics/bLion.png"     );
        piece[ Piece.bElephant.ordinal() ] = Toolkit.getDefaultToolkit().getImage( "graphics/bElephant.png" );

        addMouseListener( this );
        addKeyListener( this );    //why doesn't this work?
        f.addKeyListener( this );  //this works.
    }
    //-----------------------------------------------------------------------
    public void paint ( Graphics g ) {
        //System.out.println( "paint" );
        if (b == null)    return;
        //System.out.println( "board: \n" + this.b + "\n" );
        String title = "Dou Shou Qi (Jungle Chess): " + ((b.bluesTurn) ? "blues turn" : "reds turn");
        f.setTitle( title );

        //change individual cell size as size of window varies
        Dimension frameSize = this.f.getSize();
        Insets in = this.f.getInsets();
        double w = (frameSize.getWidth()  - in.left - in.right  - 1) / Board.fCols;
        double h = (frameSize.getHeight() - in.top  - in.bottom - 1) / Board.fRows;
        this.size = (int) Math.min( h, w );  //updated cell size

        //calc offsets to center entire board in window
        this.xOff = ((int)(frameSize.getWidth()  - in.left - in.right  - 1) - Board.fCols*size) / 2;
        this.yOff = ((int)(frameSize.getHeight() - in.top  - in.bottom - 1) - Board.fRows*size) / 2;

        //draw individual board squares (backgrounds/base)
        for (int r=0; r<Board.fRows; r++) {
            for (int c=0; c<Board.fCols; c++) {
                Base v = b.getBoard( r, c );
                if (v == null)    continue;
                switch (v) {
                    case cBDen :
                        g.setColor( Color.black );
                        break;
                    case cBTrap :
                        g.setColor( Color.gray );
                        break;
                    case cGround :
                        g.setColor( new Color(10,180,50) );
                        break;
                    case cRDen :
                        g.setColor( Color.red );
                        break;
                    case cRTrap :
                        g.setColor( Color.pink );
                        break;
                    case cWater :
                        g.setColor( new Color(10,120,150) );
                        break;
                    default:
                        g.setColor( Color.yellow );
                        break;
                }
                g.fillRect( c*size + xOff, r*size + yOff, size, size );
            }
        }

        //draw strings on board to indicate pieces and their ranks
        Rectangle2D rect = setFontSize( g );
        g.setColor( Color.lightGray );
        for (int r=0; r<Board.fRows; r++) {
            for (int c=0; c<Board.fCols; c++) {
                Piece v = b.getPiece( r, c );
                if (v == null)    continue;
                String p = null;
                switch (v) {
                    case bCat      :  p = "bCat";  break;
                    case bDog      :  p = "bDog";  break;
                    case bElephant :  p = "bEle";  break;
                    case bLeopard  :  p = "bLeo";  break;
                    case bLion     :  p = "bLio";  break;
                    case bRat      :  p = "bRat";  break;
                    case bTiger    :  p = "bTig";  break;
                    case bWolf     :  p = "bWol";  break;

                    case rCat      :  p = "rCat";  break;
                    case rDog      :  p = "rDog";  break;
                    case rElephant :  p = "rEle";  break;
                    case rLeopard  :  p = "rLeo";  break;
                    case rLion     :  p = "rLio";  break;
                    case rRat      :  p = "rRat";  break;
                    case rTiger    :  p = "rTig";  break;
                    case rWolf     :  p = "rWol";  break;
                }
                if (p != null) {
                    if (p.charAt( 0 ) == 'r')
                        g.setColor( Color.red );
                    else
                        g.setColor( Color.darkGray );

                    int x = c * size + xOff;
                    int y = r * size + yOff;
                    //center
                    if (this.namesOn) {
                        //int dx = (int)(size-rect.getWidth()) / 2;
                        int dx = 0;
                        int dy = (int)(rect.getHeight() / 2);  // size/2
                        g.drawString( p, x+dx, y+dy );
                    }
                    int  rank = b.getRank( r, c );
                    if (this.rankOn) {
                        int dx = (int)(size - rect.getWidth()/4);
                        int dy = size;
                        g.drawString( ""+rank, x+dx, y+dy );
                    }
                }
            }
        }

        //draw grid lines
        g.setColor( Color.darkGray );
        //horizontal lines
        for (int r=0; r<=Board.fRows; r++) {
            g.drawLine( 0 + xOff, r*size + yOff, Board.fCols*size + xOff, r*size + yOff );
        }
        //vertical lines
        for (int c=0; c<=Board.fCols; c++) {
            g.drawLine( c*size + xOff, 0 + yOff, c*size + xOff, Board.fRows*size + yOff );
        }

        //draw images for pieces
        Graphics2D g2 = (Graphics2D)g;
        g.setColor( Color.lightGray );
        for (int r=0; r<Board.fRows; r++) {
            for (int c=0; c<Board.fCols; c++) {
                Piece v = b.getPiece( r, c );
                if (v == null)    continue;
                g2.drawImage( this.piece[v.ordinal()], c*size + xOff, r*size + yOff, size, size, this );
            }
        }

        //outline selected piece (if any)
        if (fromR != -1) {
            g.setColor( Color.yellow );
            g2.setStroke(new BasicStroke(3));
            g.drawRoundRect( size*fromC + xOff, size*fromR + yOff, size, size, 10, 10 );
        }

        //outline selected destinatio (if any)
        if (toR != -1) {
            g.setColor( Color.orange );
            g2.setStroke(new BasicStroke(3));
            g.drawRoundRect( size*toC + xOff, size*toR + yOff, size, size, 10, 10 );
        }
    }
    //-----------------------------------------------------------------------
    /// tricky part: adapt font size to fit varying window size!
    private Rectangle2D setFontSize ( Graphics g ) {
        int fSize = 18;  //starting size
        Font f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
        g.setFont( f );
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds( "XXXX", g );
        if (rect.getWidth() < this.size) {
            //increase until too big
            while (rect.getWidth() < this.size) {
                if (fSize >= 40)    break;  //set limits
                fSize += 2;
                f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
                g.setFont( f );
                fm = g.getFontMetrics();
                rect = fm.getStringBounds( "XXXX", g );
            }
            fSize -= 2;  //just right
        } else {
            //decrease until too small
            while (rect.getWidth() > this.size) {
                if (fSize <= 5)    break;  //set limits
                fSize -= 2;
                f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
                g.setFont( f );
                fm = g.getFontMetrics();
                rect = fm.getStringBounds( "XXXX", g );
            }
            fSize += 2;  //just right
        }

        //pick appropriate one
        f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
        g.setFont( f );
        fm = g.getFontMetrics();
        return fm.getStringBounds( "XXXX", g );
    }
    //-----------------------------------------------------------------------
    private void play ( Sound s ) {
        if (!soundOn)    return;
        try {
            File in;
            switch (s) {
                case badMove:
                    in = new File( "sounds/BananaImpact.wav" );
                    break;
                case capture:
                    in = new File( "sounds/croc_chomp_x.wav" );
                    break;
                case firstClick:
                    in = new File( "sounds/click_one.wav" );
                    break;
                case secondClick:
                    in = new File( "sounds/Mousclik.wav" );
                    break;
                case winner:
                    in = new File( "sounds/cheering.wav" );
                    break;
                case loser:
                    in = new File( "sounds/pacman_dies_y.wav" );
                    break;
                default:
                    System.err.println( "bad sound" );
                    return;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream( in );
            Clip clip = AudioSystem.getClip();
            clip.open( ais );
            clip.start();
        } catch (Exception e) {
            System.err.println( "play sound failed: " + s + "\n" + e );
        }
    }
    //-----------------------------------------------------------------------
    @Override
    public void mouseClicked ( MouseEvent e ) {
        //map click from screen coordinates to array coordinates
        int  r = (e.getY() - this.yOff) / size;
        int  c = (e.getX() - this.xOff) / size;

        //bounds check
        if (r < 0 || c < 0)    return;
        if (r >= Board.fRows || c >= Board.fCols)    return;

        System.out.println( "mouseClicked: r=" + r + ", c=" + c );
        if (fromR == -1) {  //are we are waiting for a click on the first (from) piece?
            fromR = r;
            fromC = c;
            play( Sound.firstClick );
            toR = toC = -1;
            repaint();
            return;
        }

        if (toR == -1) {  //are we are waiting for the second click (to)?
            toR = r;
            toC = c;
            //invoke move method
            b.doMove(fromR,fromC,toR,toC);

            play( Sound.secondClick );
            repaint();
            //i'd like to do this (the following) inline, but we can't.
            if (false) {
                //pause before resetting
                try { Thread.sleep( 300 ); } catch (Exception ignored) { }

                fromR = fromC = toR = toC = -1;
                repaint();
            } else {
                //"delay" until the ui catches up
                SwingUtilities.invokeLater(
                        new Runnable() {
                            public void run ( ) {
                                //pause before resetting
                                try { Thread.sleep(300); } catch (Exception ignored) { }

                                fromR = fromC = toR = toC = -1;
                                repaint();
                            }
                        }
                );
            }
            return;
        }
    }
    //.......................................................................
    @Override public void mousePressed  ( MouseEvent e ) { }
    @Override public void mouseReleased ( MouseEvent e ) { }
    @Override public void mouseEntered  ( MouseEvent e ) { }
    @Override public void mouseExited   ( MouseEvent e ) { }
    @Override public void mouseDragged  ( MouseEvent e ) { }
    @Override public void mouseMoved    ( MouseEvent e ) { }
    //-----------------------------------------------------------------------
    @Override
    public void keyTyped ( KeyEvent e ) {
        //System.out.println( "keyTyped (unused)" );
    }

    @Override
    public void keyPressed ( KeyEvent e ) {
        char  c = e.getKeyChar();
        System.out.println( "keyPressed: " + c );
        switch (c) {
            case 'h' :
            case 'H' :
            case '?' :
            case '/' :
                System.out.println( help );
                if (this.b.bluesTurn)    System.out.println( "blue's turn" );
                else                     System.out.println( "red's turn" );
                break;
            case 'n' :
            case 'N' :
            case 'r' :
            case 'R' :
                //reset/new
                this.b = new Board();
                repaint();
                break;
            case 'o' :
            case 'O' :
                this.rankOn  = !this.rankOn;
                this.namesOn = !this.namesOn;
                repaint();
                break;
            case 'q' :
            case 'Q' :
            case 'x' :
            case 'X' :
                System.exit( 0 );
                break;
            case 's' :
            case 'S' :
                this.soundOn = !this.soundOn;
                break;
            case '1' :    play( Sound.badMove );        break;
            case '2' :    play( Sound.capture );        break;
            case '3' :    play( Sound.firstClick );     break;
            case '4' :    play( Sound.loser );          break;
            case '5' :    play( Sound.secondClick );    break;
            case '6' :    play( Sound.winner );         break;
        }
    }

    private static final String help = "\n"
            + "commands: \n"
            + "    o toggle overlay on/off \n"
            + "    q or x quit/exit \n"
            + "    r reset \n"
            + "    s toggle sound on/off \n"
            + "    1 play bad-move sound \n"
            + "    2 play capture sound \n"
            + "    3 play first-click sound \n"
            + "    4 play loser sound \n"
            + "    5 play second-click sound \n"
            + "    6 play winner sound \n";

    @Override
    public void keyReleased ( KeyEvent e ) {
        //System.out.println( "keyReleased (unused)" );
    }

}
