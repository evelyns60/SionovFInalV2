import javax.swing.*;

public class Slot extends JButton{
    private String currentPlayer;

    public Slot(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Slot() {
        this.currentPlayer = "none";
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
