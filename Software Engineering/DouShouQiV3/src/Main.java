import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.JFrame;
/**
 * @brief this is there the magic begins!
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */
public class Main {

    public static void main ( String[] args ) {
        Board b = new Board();
        JFrame f = new JFrame( "Dou Shou Qi / Jungle Chess" );
        f.getContentPane().add( new BoardSketcher(f, b), BorderLayout.CENTER );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( BoardSketcher.initialSize*Board.fCols,
                BoardSketcher.initialSize*Board.fRows );
        f.setLocation( 500, 250 );

        //insets aren't available until visible so we need to resize again
        f.setVisible( true );
        Insets in = f.getInsets();
        f.setSize( BoardSketcher.initialSize*Board.fCols + in.left + in.right + 1,
                BoardSketcher.initialSize*Board.fRows + in.top  + in.bottom + 1 );
        System.out.println( "insets: " + in );
    }

}
