import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid {
    private Slot[][] matrix; //make this a matrix of circles

    public Grid() {
        matrix = new Slot[7][8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = new Slot(i, j);
                matrix[i][j].setBackground(Color.yellow);
            }
        }
    }

    public Slot[][] getMatrix() {
        return matrix;
    }

    public boolean isGridFilled() { //tmw: put this into actionlistener to check when the board is filled and restart game
        int count = 0;
        for (Slot[] row: matrix) {
            for (Slot slot: row) {
                if (slot.getPlayerOnSlot() != null) {
                    count++;
                }
            }
        }
        if (count == 56) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidPlacement(Slot slot) {
        if (slot.getPlayerOnSlot() != null) { //checks if slot already has player in it
            return false;
        }

        if (slot.getRow() == 6) { //checks if slot is in the bottom row
            return true;
        }
        Slot slotBelow = matrix[slot.getRow() + 1][slot.getCol()]; //checks if slot below is filled up
        if (slotBelow.getPlayerOnSlot() == null) {
            return false;
        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j].setPlayerOnSlot(null);
                matrix[i][j].setBackground(Color.yellow);
            }
        }
    }

    public boolean playerHasWon(Player player) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                Player slotPlayer = matrix[r][c].getPlayerOnSlot();
                setPlayersTemporarily();

                if (slotPlayer != null && slotPlayer.getName().equals(player.getName())) { //checks if no player is in a slot + checks if current slot equals the player parameter
                    //horizontal check
                    if (c + 4 < width &&
                            matrix[r][c + 1].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r][c + 2].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r][c + 3].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r][c + 4].getPlayerOnSlot().getName().equals(slotPlayer.getName())
                    ) {
                        reversePlayerSet();
                        return true;
                    }

                    //vertical check
                    if (r + 4 < height &&
                            matrix[r + 1][c].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 2][c].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 3][c].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 4][c].getPlayerOnSlot().getName().equals(slotPlayer.getName())
                    ) {
                        reversePlayerSet();
                        return true;
                    }

                    //right diagonal check
                    if (r + 4 < height && c + 4 < width &&
                            matrix[r + 1][c + 1].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 2][c + 2].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 3][c + 3].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 4][c + 4].getPlayerOnSlot().getName().equals(slotPlayer.getName())
                    ) {
                        reversePlayerSet();
                        return true;
                    }

                    //left diagonal check
                    if (r + 4 < height && c - 4 >= 0 &&
                            matrix[r + 1][c - 1].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 2][c - 2].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 3][c - 3].getPlayerOnSlot().getName().equals(slotPlayer.getName()) &&
                            matrix[r + 4][c - 4].getPlayerOnSlot().getName().equals(slotPlayer.getName())
                    ) {
                        reversePlayerSet();
                        return true;
                    }
                }
            }
        }
        reversePlayerSet();
        return false;
    }

    private void setPlayersTemporarily() { //used to avoid null error
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].getPlayerOnSlot() == null) {
                    matrix[i][j].setPlayerOnSlot(new Player("No Player"));
                }
            }
        }
    }

    private void reversePlayerSet() { //reverses setPlayersTemporarily method to set the blank slots back to null values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].getPlayerOnSlot().getName().equals("No Player")) {
                    matrix[i][j].setPlayerOnSlot(null);
                }
            }
        }
    }

    //https://codereview.stackexchange.com/questions/127091/java-connect-four-four-in-a-row-detection-algorithms

}
