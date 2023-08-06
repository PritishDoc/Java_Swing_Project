import javax.swing.*;
//import javax.swing.border.Border;
import javax.swing.border.BevelBorder;

import java.awt.*;

class MyFrame extends JFrame{
    JLabel label;
    JTextField textField;
    JButton button;
    JPanel panel;
    MyFrame(){
        label=new JLabel("Name");
        textField=new JTextField(20);
        button=new JButton("OK");
        panel=new JPanel();

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        
       //Here border method is called
        javax.swing.border.Border br=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN),"Login");
        panel.setBorder(br);

        setLayout(new FlowLayout());
        add(panel);
    }
}
public class Border{
    public static void main(String[] args) {
        MyFrame f=new MyFrame();
        f.setSize(800, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}