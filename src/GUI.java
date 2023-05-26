import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JPanel mainPanel;

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

        //creates title panel
        JPanel titlePanel = new JPanel();
        JLabel gameTitle = new JLabel("Welcome to Connect 4!");
        titlePanel.add(gameTitle);

        //creates connect4 grid
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(titlePanel);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(6, 7, 10, 10));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JButton newButton = new JButton();
                newButton.setBackground(Color.blue);
                gamePanel.add(newButton);
            }
        }

        mainPanel.add(gamePanel);



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
