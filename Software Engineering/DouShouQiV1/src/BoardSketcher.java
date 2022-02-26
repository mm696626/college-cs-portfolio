import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @brief BoardSketcher (View in M-V-C)
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */
public class BoardSketcher extends JPanel {

    public static final int initialSize = 50;

    private int size = initialSize;
    private JFrame f = null;
    private Board  b = null;
    //-----------------------------------------------------------------------
    BoardSketcher ( JFrame f, Board b ) {
        this.f = f;
        this.b = b;
    }
    //-----------------------------------------------------------------------
    public void paint ( Graphics g ) {
        if (b == null)    return;
        System.out.println( "board: \n" + this.b + "\n" );

        //change individual cell size as size of window varies
        Dimension frameSize = this.f.getSize();
        Insets in = this.f.getInsets();
        double w = (frameSize.getWidth()  - in.left - in.right  - 1) / Board.fCols;
        double h = (frameSize.getHeight() - in.top  - in.bottom - 1) / Board.fRows;
        this.size = (int) Math.min( h, w );  //updated cell size

        //offsets to center board in window
        int xOff = ((int)(frameSize.getWidth()  - in.left - in.right  - 1) - Board.fCols*size) / 2;
        int yOff = ((int)(frameSize.getHeight() - in.top  - in.bottom - 1) - Board.fRows*size) / 2;

        //draw individual board squares
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
                    int dx = (int)(size-rect.getWidth()) / 2;
                    g.drawString( p, x+dx, y+size/2 );
                    int  rank = b.getRank( r, c );
                    g.drawString( ""+rank, x+size/4, y+size/2+size/3 );
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
    }
    //-----------------------------------------------------------------------
    /// tricky part: adapt font size varying window size!
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
                rect = fm.getStringBounds("XXXX", g);
            }
            fSize -= 2;
        } else {
            //decrease until too small
            while (rect.getWidth() > this.size) {
                if (fSize <= 5)    break;  //set limits
                fSize -= 2;
                f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
                g.setFont( f );
                fm = g.getFontMetrics();
                rect = fm.getStringBounds("XXXX", g);
            }
            fSize += 2;
        }
        f = new Font( Font.MONOSPACED, Font.BOLD, fSize );
        g.setFont( f );
        fm = g.getFontMetrics();
        return fm.getStringBounds("XXXX", g);
    }

}
