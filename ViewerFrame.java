import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ViewerFrame extends JFrame {

    public int counter;

    public ViewerFrame() {
        counter = 91;

        class DrawComponent extends JComponent {
            public void paintComponent(Graphics g2) {
                Graphics2D g = (Graphics2D) g2;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        g.setColor(((i + j) % 2 == 0) ? Color.BLACK : Color.WHITE);
                        if(TableComponents.combinations.get(counter).get(j).get(i) == 1) g.setColor(Color.BLUE);
                        g.fillRect(60 + 60 * j, 60 + 60 * i, 60, 60);
                    }
                }
            }
        }

        // add the component to the frame
        add(new DrawComponent());
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        class StartListener implements ActionListener {
            StartListener() { }

            public void actionPerformed(ActionEvent e) {
                counter = (counter-1) % 92;
                repaint();
            }
        }

        prevButton.addActionListener(new StartListener());
        class StopListener implements ActionListener {
            StopListener() { }

            public void actionPerformed(ActionEvent e) {
                counter = (counter+1) % 92;
                repaint();
            }
        }

        nextButton.addActionListener(new StopListener());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton, "West");
        buttonPanel.add(nextButton, "East");
        add(buttonPanel, "South");
    }
}

