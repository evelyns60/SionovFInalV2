import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener, ItemListener {
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel gamePanel;
    private JPanel bottomPanel;
    private Grid grid;
    private JButton startButton;
    private GridLayout gridLayout;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player playerTurn;
    private JLabel displayCurrentPlayer;
    private JLabel redPieceArea;
    private JLabel bluePieceArea;

    public GUI() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        currentPlayer = player1;
        createUIComponents();
    }

    private void createUIComponents() {
        //frame setup
        mainPanel = new JPanel();
        add(mainPanel);
        setTitle("My GUI!");
        setSize(1500,950);
        setLocation(300,50);
        mainPanel.setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //title panel setup
        titlePanel = new JPanel();
        JLabel gameTitle = new JLabel("Welcome to Connect 5!", SwingConstants.CENTER); //title
        gameTitle.setFont(new Font("Monospace", Font.BOLD, 75));

        JLabel gameDescription = new JLabel("<html>Be the first player to form a horizontal, vertical, or diagonal line of five with your tokens. Have fun!</html>", SwingConstants.CENTER); //game description
        gameDescription.setFont(new Font("Monospace", Font.ITALIC, 30));
        gameDescription.setBorder(BorderFactory.createEmptyBorder(40, 15, 15, 15));

        titlePanel.setBackground(Color.CYAN);

        startButton = new JButton("Start"); //start button
        startButton.setFont(new Font("Serif", Font.BOLD, 20));
        startButton.setBackground(Color.yellow);

        titlePanel.setLayout(new GridLayout(3, 1));
        titlePanel.add(gameTitle);
        titlePanel.add(gameDescription);
        titlePanel.add(startButton);

        //connect5 grid setup
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(titlePanel);

        gamePanel = new JPanel();
        gridLayout = new GridLayout(7, 8, 10, 10);
        gamePanel.setLayout(gridLayout);
        grid = new Grid();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                gamePanel.add(grid.getMatrix()[i][j]);
                grid.getMatrix()[i][j].addActionListener(this);
            }
        }
        mainPanel.add(gamePanel);

        //bottom panel setup
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 2));
        ImageIcon redPiece = new ImageIcon("src/redpiece.png");
        redPiece = new ImageIcon(redPiece.getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
        ImageIcon bluePiece = new ImageIcon("src/bluepiece.png");
        bluePiece = new ImageIcon(bluePiece.getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
        redPieceArea = new JLabel("Player 1 Score: " + player1.getNumWins(), redPiece, JLabel.CENTER);
        bluePieceArea = new JLabel("Player 2 Score: " + player2.getNumWins(), bluePiece, JLabel.CENTER);
        displayCurrentPlayer = new JLabel("Player 1's Turn!");
        displayCurrentPlayer.setFont(new Font("Serif", Font.BOLD, 30));
        displayCurrentPlayer.setForeground(Color.RED);

        bottomPanel.add(redPieceArea);
        bottomPanel.add(bluePieceArea);
        bottomPanel.add(displayCurrentPlayer);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(40, 15, 15, 15));
        mainPanel.add(bottomPanel);

        //pre-game setup
        gamePanel.setVisible(false);
        bottomPanel.setVisible(false);
        setVisible(true);

        //action listener setup
        setUpListeners();
    }

    public void startGame() {
        titlePanel.setVisible(false);
        gamePanel.setVisible(true);
        bottomPanel.setVisible(true);
    }

    public void setUpListeners() {
        startButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();     //include if statement for instance of JButton if you use other actionEvents
        JButton clickedButton = (JButton) source;
        String buttonText = clickedButton.getText();
        if (source instanceof Slot) {
            if (grid.isValidPlacement(((Slot) source))) {
                ((Slot) source).setPlayerOnSlot(currentPlayer);
                if (currentPlayer.getName().equals("Player 1")) {
                    ((Slot) source).setBackground(Color.red);
                    currentPlayer.setName("Player 2");
                    displayCurrentPlayer.setText("Player 2's Turn!");
                    displayCurrentPlayer.setForeground(Color.blue);
                } else {
                    ((Slot) source).setBackground(Color.blue);
                    currentPlayer.setName("Player 1");
                    displayCurrentPlayer.setText("Player 1's Turn!");
                    displayCurrentPlayer.setForeground(Color.red);
                }
                if (grid.playerHasWon(player1) || grid.playerHasWon(player2)) { //debug tmw: returns true when theres five pieces in a row regardless of their color
                    if (grid.playerHasWon(player1)) {
                        player1.addWin();
                        displayWins();
                    } else if (grid.playerHasWon(player2)) {
                        player2.addWin();
                        displayWins();
                    }
/*
                    grid.clearBoard();
*/
                }
                if (grid.isGridFilled()) { //restarts game if the board is filled; no points rewarded (NOTE: make bottom panel display text about this)
                    grid.clearBoard();
                }
            }
        } else {
            if (buttonText.equals("Start")) {
                startGame();
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {

    }

    private void displayWins() {
        redPieceArea.setText("Player 1 Score: " + player1.getNumWins());
        bluePieceArea.setText("Player 2 Score: " + player2.getNumWins());
    }
}
