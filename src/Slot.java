import javax.swing.*;

public class Slot extends JButton{
    private int row;
    private int col;
    private Player playerOnSlot;

    public Slot(int row, int col) {
        this.row = row;
        this.col = col;
        this.playerOnSlot = null;
    }

    public Player getPlayerOnSlot() {
        return playerOnSlot;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPlayerOnSlot(Player newPlayer) {
        this.playerOnSlot = newPlayer;
    }
}
