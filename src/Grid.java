import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid {
    private JButton[][] matrix; //make this a matrix of circles
    private int blankCells;

    public Grid() {
        matrix = new JButton[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = new JButton();
                matrix[i][j].setBackground(Color.blue);
            }
        }
    }

    public JButton[][] getMatrix() {
        return matrix;
    }

}
