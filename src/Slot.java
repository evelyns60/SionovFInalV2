import javax.swing.*;

public class Slot extends JButton{
    private Player currentPlayer;

    public Slot(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Slot() {
        this.currentPlayer = null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
