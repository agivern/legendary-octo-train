package Problem3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine {
    final int ROWS = 3;
    final int COLUMNS = 5;

    int[][] symbols = new int[ROWS][COLUMNS];
    JPanel slotMachinePanel = new JPanel(null);

    public SlotMachine() {
        this.play();
    }

    /**
     * Generate random number between 0 and 7 for each slots of the machine
     */
    public void play() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                this.symbols[row][column] = (int)(Math.random() * 8);
            }
        }
    }

    /**
     * Search each winning combinations (with at least 3 consecutives same numbers) 
     * to return the list of winning values
     * 
     * @return list of winning value or empty list no winning combination
     */
    public List<Integer> calculateWinningValues()
    {
        List<Integer> winValues = new ArrayList<Integer>();

        // Top line combination
        if (this.symbols[0][0] == this.symbols[0][1] && this.symbols[0][1] == this.symbols[0][2] 
            || this.symbols[0][1] == this.symbols[0][2] && this.symbols[0][2] == this.symbols[0][3] 
            || this.symbols[0][2] == this.symbols[0][3] && this.symbols[0][3] == this.symbols[0][4]) {
            winValues.add(this.symbols[0][2]);
        }

        // Middle line combination
        if (this.symbols[1][0] == this.symbols[1][1] && this.symbols[1][1] == this.symbols[1][2] 
            || this.symbols[1][1] == this.symbols[1][2] && this.symbols[1][2] == this.symbols[1][3] 
            || this.symbols[1][2] == this.symbols[1][3] && this.symbols[1][3] == this.symbols[1][4]) {
            winValues.add(this.symbols[1][2]);
        }

        // Bottom line combination
        if (this.symbols[2][0] == this.symbols[2][1] && this.symbols[2][1] == this.symbols[2][2] 
            || this.symbols[2][1] == this.symbols[2][2] && this.symbols[2][2] == this.symbols[2][3] 
            || this.symbols[2][2] == this.symbols[2][3] && this.symbols[2][3] == this.symbols[2][4]) {
            winValues.add(this.symbols[2][2]);
        }

        // Combination in v
        if (this.symbols[0][0] == this.symbols[1][1] && this.symbols[1][1] == this.symbols[2][2]
            || this.symbols[1][1] == this.symbols[2][2] && this.symbols[2][2] == this.symbols[1][3]
            || this.symbols[2][2] == this.symbols[1][3] && this.symbols[1][3] == this.symbols[0][4]) {
            winValues.add(this.symbols[2][2]);
        }

        // Combination in ^
        if (this.symbols[2][0] == this.symbols[1][1] && this.symbols[1][1] == this.symbols[0][2]
            || this.symbols[1][1] == this.symbols[0][2] && this.symbols[0][2] == this.symbols[1][3]
            || this.symbols[0][2] == this.symbols[1][3] && this.symbols[1][3] == this.symbols[2][4]) {
            winValues.add(this.symbols[0][2]);
        }

        // Combination with line 1 and 2
        if (this.symbols[0][1] == this.symbols[0][2] && this.symbols[0][2] == this.symbols[1][3]
            || this.symbols[0][2] == this.symbols[1][3] && this.symbols[1][3] == this.symbols[1][4]) {
            winValues.add(this.symbols[0][2]);
        }

        // Combination with line 3 and 2
        if (this.symbols[2][1] == this.symbols[2][2] && this.symbols[2][2] == this.symbols[1][3]
            || this.symbols[2][2] == this.symbols[1][3] && this.symbols[1][3] == this.symbols[1][4]) {
            winValues.add(this.symbols[2][2]); 
        }

        return winValues;
    }

    /**
     * Update the slot machine panel with the new values on the machine
     * 
     * @param frame The main frame to add the slot machine panel
     */
    public void display(JFrame frame) {
        frame.remove(this.slotMachinePanel);
        this.slotMachinePanel.removeAll();
        slotMachinePanel.setBounds(0, 0, 300, 500);
        
        // Write each row and column current value
        for (int x = 0; x < 3; x++) {
            int postionX = 20 + 45 * x;
            for (int y = 0; y < 5; y++) {
                int postionY = 40 + 45 * y;

                JPanel panel = new JPanel();
                panel.setBackground(Color.white);

                JLabel label;
                label = new JLabel(Integer.toString(this.symbols[x][y]));
                label.setBounds(10, 0, 30, 30);
                panel.add(label);
                this.slotMachinePanel.add(panel);
                panel.setBounds(postionY, postionX, 30, 30);
            }
        }

        // Add the panel on the main frame and force the fram refresh
        frame.add(this.slotMachinePanel);
        frame.repaint();
        frame.validate();
    }
}
