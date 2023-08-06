import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class MyInternalFrame extends JInternalFrame {
    JTextArea textArea;
    JScrollPane scrollPane;
    static int count = 0;

    MyInternalFrame() {
        super("Document" + (++count), true, true, true, true);
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // setting size
        setSize(300, 300);
        setLocation(50, 50);
        setVisible(true);
    }
}

class MyFrame extends JFrame implements ActionListener {
    JDesktopPane jp;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem newDocument;

    MyFrame() {
        super("Internal Frame Demo");

        // Load background image
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("D:/Images/_26a510f6-deb6-4aaa-bf88-a0533cb7daf3.jpg"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            backgroundLabel.setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
            setContentPane(backgroundLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jp = new JDesktopPane();
        setContentPane(jp);

        menuBar = new JMenuBar();
        file = new JMenu("File");
        newDocument = new JMenuItem("New Document");

        file.add(newDocument);
        menuBar.add(file);
        setJMenuBar(menuBar);

        newDocument.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newDocument) {
            MyInternalFrame mi = new MyInternalFrame();
            jp.add(mi);
            mi.toFront(); // Bring the newly created internal frame to the front
        }
    }
}

public class NotepadInternalFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
