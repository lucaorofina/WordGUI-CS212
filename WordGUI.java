import javax.swing.*;
import java.awt.GridLayout;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WordGUI extends JFrame {
    private JTextArea A_TextArea;
    private JTextArea E_TextArea;
    private JTextArea I_TextArea;
    private JTextArea O_TextArea;
    private JTextArea U_TextArea;
    private JTextArea Other_TextArea;
    public WordGUI() {
        setTitle("Project 3");
        //Creating GUI with name = "Project 1" (Header: javax.swing.*)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Defining default close operation
        setSize(1900, 1000);
        createFileMenu();
        //Sets FrameSize
        setLocation(400, 400);
        //Sets Frame Locationgq
        setLayout(new GridLayout(2, 3));
        //Sets gridLayout with 2 row and 3 column (Header: java.awt.GridLayout)
        // checking for end of file
       A_TextArea = new JTextArea(10,10);
       E_TextArea = new JTextArea(10,10);
       I_TextArea = new JTextArea(10,10);
       O_TextArea = new JTextArea(10,10);
       U_TextArea = new JTextArea(10,10);
       Other_TextArea = new JTextArea(10,10);

       A_TextArea.setEditable(false);
       E_TextArea.setEditable(false);
       I_TextArea.setEditable(false);
       O_TextArea.setEditable(false);
       U_TextArea.setEditable(false);
       Other_TextArea.setEditable(false);

       JScrollPane scrollPaneA = new JScrollPane(A_TextArea);
       JScrollPane scrollPaneE = new JScrollPane(E_TextArea);
       JScrollPane scrollPaneI = new JScrollPane(I_TextArea);
       JScrollPane scrollPaneO = new JScrollPane(O_TextArea);
       JScrollPane scrollPaneU = new JScrollPane(U_TextArea);
       JScrollPane scrollPaneOther = new JScrollPane(Other_TextArea);

        getContentPane().add(scrollPaneA);
        getContentPane().add(scrollPaneE);
        getContentPane().add(scrollPaneI);
        getContentPane().add(scrollPaneO);
        getContentPane().add(scrollPaneU);
        getContentPane().add(scrollPaneOther);

        this.pack();
        setVisible(true);

    }

    public void createFileMenu() {
        //System.out.println("hi");
        JMenuItem item;
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open");    //Open...
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener(fmh);
        fileMenu.add(item);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    }

    public void showGUI(TreeMap treeMap) {

        A_TextArea.setText("");
        E_TextArea.setText("");
        I_TextArea.setText("");
        O_TextArea.setText("");
        U_TextArea.setText("");
        Other_TextArea.setText("");

       treeMap.keySet().forEach(key ->{ //key is word, tur checks first letter
           String word = key.toString();

           if (word.charAt(0) == 'a' || word.charAt(0) == 'A') A_TextArea.append(word + "\n");

           else if (word.charAt(0) == 'e' || word.charAt(0) == 'E') E_TextArea.append(word + "\n");

           else if (word.charAt(0) == 'i' || word.charAt(0) == 'I') I_TextArea.append(word + "\n");

           else if (word.charAt(0) == 'o' || word.charAt(0) == 'O') O_TextArea.append(word + "\n");

           else if (word.charAt(0) == 'u' || word.charAt(0) == 'U') U_TextArea.append(word + "\n");

           else
               Other_TextArea.append(word + "\n");
       });


    }

}

