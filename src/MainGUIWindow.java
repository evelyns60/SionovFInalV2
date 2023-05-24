import javax.swing.*;
import java.awt.event.*;

public class MainGUIWindow extends JFrame implements ActionListener, ItemListener {
    private JPanel mainPanel;
    private JLabel label1;

    public MainGUIWindow() {
        init();
    }

    private void init() {
        //frame setup
        setContentPane(mainPanel);
        setTitle("My GUI!");
        setSize(1500,950);
        setLocation(300,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public void itemStateChanged(ItemEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
