import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener, ItemListener {
    private JPanel mainPanel = new JPanel();

    public GUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        //frame setup
        setContentPane(mainPanel);
        setTitle("My GUI!");
        setSize(1500,950);
        setLocation(300,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 7, 3, 3));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                add(new Button());
            }
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public void itemStateChanged(ItemEvent e) {

    }
}
