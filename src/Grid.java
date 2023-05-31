import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid {
    private Slot[][] matrix; //make this a matrix of circles

    public Grid() {
        matrix = new Slot[7][8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
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

    public boolean playerHasWon(Player player) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                Player slotPlayer = matrix[r][c].getCurrentPlayer();

                if (slotPlayer != null && slotPlayer.getName().equals(player.getName())) { //checks if no player is in a slot + checks if current slot equals the player parameter
                    //horizontal check
                    if (c + 4 < width &&
                            matrix[r][c + 1].getCurrentPlayer() == slotPlayer &&
                            matrix[r][c + 2].getCurrentPlayer() == slotPlayer &&
                            matrix[r][c + 3].getCurrentPlayer() == slotPlayer &&
                            matrix[r][c + 4].getCurrentPlayer() == slotPlayer
                    ) {
                        return true;
                    }

                    //vertical check
                    if (r + 4 < height &&
                            matrix[r + 1][c].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 2][c].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 3][c].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 4][c].getCurrentPlayer() == slotPlayer
                    ) {
                        return true;
                    }

                    //right diagonal check
                    if (r + 4 < height && c + 4 < width &&
                            matrix[r + 1][c + 1].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 2][c + 2].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 3][c + 3].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 4][c + 4].getCurrentPlayer() == slotPlayer
                    ) {
                        return true;
                    }

                    //left diagonal check
                    if (r + 4 < height && c - 4 >= 0 &&
                            matrix[r + 1][c - 1].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 2][c - 2].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 3][c - 3].getCurrentPlayer() == slotPlayer &&
                            matrix[r + 4][c - 4].getCurrentPlayer() == slotPlayer
                    ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //https://codereview.stackexchange.com/questions/127091/java-connect-four-four-in-a-row-detection-algorithms

}
