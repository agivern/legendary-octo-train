package Problem3;

import javax.swing.JFrame;
import java.awt.*;    
import java.awt.event.*; 

public class App {
    public static void main(String[] args) throws Exception {
        SlotMachine slotMachine = new SlotMachine();

        // Start the frame
        JFrame frame = new JFrame("My ugly casino");
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add main button to play at the slot machine
        Button playButton = new Button("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                slotMachine.play();
                System.out.println("Winning values : " + slotMachine.calculateWinningValues() + "\n");
                slotMachine.display(frame);
            }
        });  
        playButton.setBounds(100,200,80,30);
        frame.add(playButton);

        // Display the slot machine
        slotMachine.display(frame);
    }

}
