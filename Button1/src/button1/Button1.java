package button1;

import javax.swing.*;
import java.awt.*;

public class Button1 {

    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }
    
    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton east = new JButton("Push Push");
        JButton west = new JButton("Shove over!");
        JButton north = new JButton("Fatty BUM");
        Font bigFont = new Font("serif",Font.BOLD, 28);
        north.setFont(bigFont);
        JButton south = new JButton("Stretch!");
        south.setFont(bigFont);
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300,300);
        frame.setVisible(true);
        
    }
}
