import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener, ItemListener{

    public GUI() {
        super("Frame title");
        init();
    }

    private void init() {
        //frame setup

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocation(300,50);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public void itemStateChanged(ItemEvent e) {

    }

}