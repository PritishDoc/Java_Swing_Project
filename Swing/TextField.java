import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

class Swing extends JFrame  {
    Swing() {
        JTextField textField = new JTextField(15);
        DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
        JFormattedTextField formattedTextField = new JFormattedTextField(df);

        formattedTextField.setColumns(15);
        formattedTextField.setValue(0);
        setLayout(new FlowLayout());

        NumberFormat nf=NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormatter nft=new NumberFormatter(nf);
        JFormattedTextField jf=new JFormattedTextField(nft);
        jf.setColumns(15);
        setLayout(new FlowLayout());
        //nums are allowed but num are not allowed
        nft.setAllowsInvalid(false);
        nft.setMaximum(1000);
       jf.setValue(0);

        add(textField);
        add(formattedTextField);
        add(jf);


    }
}

public class TextField {
    public static void main(String[] args) {
        Swing frame = new Swing();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void setEditable(boolean b) {
    }

    public void setFont(Font buttonFont) {
    }
}
