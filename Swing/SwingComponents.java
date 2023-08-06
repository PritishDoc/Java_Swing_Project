import javax.swing.*;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    JLabel l;
    JButton b;
    int Count = 0;

    MyFrame() {
        super("Swing Demo");

        setLayout(new FlowLayout());
        l = new JLabel("Clicked " + Count + " Times");
        b = new JButton("Click");
        add(l);
        add(b);
        // add(new Button("Cancel"));
        b.addActionListener(this);
        getRootPane().setDefaultButton(b);
        // b.setIcon(new ImageIcon(
        // "C://Users//priti//Desktop//Images//360_F_303222627_wcPXTwFoDU4piZSWk9DGqM129H1vCcAy.jpg"));
        l.setToolTipText("Counter");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Count++;
        l.setText("Clicked " + Count + " Times");
    }
}

public class SwingComponents {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setSize(500, 500);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}