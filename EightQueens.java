//Sinan Karabocuoglu & Oktay Comu
//13 February 2018
//8 Queens

import javax.swing.*;

public class EightQueens
{
    public static void main(String [] args)
    {
        for(int i = 0; i<=7;i++)
        {
            System.out.println("Round: "+(i+1));
            TableComponents components =  new TableComponents();
            components.queenDraw(i,0);
        }

        // Create a frame from my StopwatchFrame class
        JFrame frame = new ViewerFrame();
        // Set the frame size according to the defined constants
        frame.setSize(640, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the frame title
        frame.setTitle("8 Queens");

        // Set the frame to be visible
        frame.setVisible(true);
        // Set the frame so that it is not resizable
        frame.setResizable(false);
        // Center the frame
        frame.setLocationRelativeTo(null);
    }
}