import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JPanel mainPanel;
    private Grid grid;

    public GUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        //frame setup
        mainPanel = new JPanel();
        add(mainPanel);
        setTitle("My GUI!");
        setSize(1500,950);
        setLocation(300,50);
        getContentPane().setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //title panel setup
        JPanel titlePanel = new JPanel();
        JLabel gameTitle = new JLabel("Welcome to Connect 4!");
        gameTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        titlePanel.add(gameTitle);

        //connect4 grid setup
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(titlePanel);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(6, 7, 10, 10));
        grid = new Grid();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                gamePanel.add(grid.getMatrix()[i][j]);
            }
        }
        mainPanel.add(gamePanel);


        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel(new ImageIcon("bluepiece.png")));
        bottomPanel.add(new JLabel(new ImageIcon("redpiece.png")));

        mainPanel.add(bottomPanel);



        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {

    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
