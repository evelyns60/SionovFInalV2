import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid {
    private Slot[][] matrix; //make this a matrix of circles

    public Grid() {
        matrix = new Slot[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = new Slot();
                matrix[i][j].setBackground(Color.yellow);
            }
        }
    }

    public Slot[][] getMatrix() {
        return matrix;
    }

    public int getNumBlankCells() {
        int count = 0;
        for (Slot[] row: matrix) {
            for (Slot slot: row) {
                if (slot.getCurrentPlayer() != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void clearBoard() {
        for (Slot[] row: matrix) {
            for (Slot slot: row) {
                slot.setCurrentPlayer(null);
            }
        }
    }

}
