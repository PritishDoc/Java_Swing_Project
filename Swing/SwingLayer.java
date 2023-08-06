import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class MyFrame extends JFrame implements ActionListener{
    JLayeredPane layeredPane;
    JRadioButton r1,r2,r3;
    JLabel l1,l2,l3,l4;

    MyFrame(){
        super("Layered Demo");
        r1=new JRadioButton("Magenta");
        r2=new JRadioButton("Orange");
        r3=new JRadioButton("Cyen");
        ButtonGroup bGroup=new ButtonGroup();
        bGroup.add(r1);
        bGroup.add(r2);
        bGroup.add(r3);

        r1.addActionListener((ActionListener) this);
        r3.addActionListener((ActionListener) this);
        r2.addActionListener((ActionListener) this);

        JPanel p1=new JPanel();
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        
        l1=new JLabel("Magenta");
         l1.setBounds(10, 10, 800, 800);
         l1.setBackground(Color.MAGENTA);
         l1.setOpaque(true);//To visible

         l2=new JLabel("Orange");
         l2.setBounds(10, 10, 250, 250);
         l2.setBackground(Color.ORANGE);
         l2.setOpaque(true);

         l3=new JLabel("Green");
         l3.setBounds(10, 10, 300, 300);
         l3.setBackground(Color.green);
         l3.setOpaque(true);

         l4=new JLabel("Cyan");
         l4.setBounds(10, 10, 150, 150);
         l4.setBackground(Color.cyan);
         l4.setOpaque(true);
         
         layeredPane=new JLayeredPane();
         layeredPane.add(l1,new Integer(0));
         layeredPane.add(l2,new Integer(1));
         layeredPane.add(l3,new Integer(2));

         layeredPane.add(l4,new Integer(3));
         add(p1,BorderLayout.NORTH);
         add(layeredPane,BorderLayout.CENTER);

         addMouseListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me){
                l4.setLocation(me.getX(),me.getY());
            }
         });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(r1.isSelected())
    layeredPane.setLayer(l4, 1);

    if(r2.isSelected())
    layeredPane.setLayer(l4, 2);
    if(r3.isSelected())
    layeredPane.setLayer(l4,3);
      
    }
}
public class SwingLayer {
    public static void main(String[] args) {
        MyFrame frame=new MyFrame();
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
