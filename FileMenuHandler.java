import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.TreeMap;

public class FileMenuHandler implements ActionListener {
    WordGUI mygui;

    public FileMenuHandler(WordGUI mygui) {
        this.mygui = mygui;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open")) //need to invoke JFileChooser
            openFile();
        else if (menuName.equals("Quit"))
            System.exit(0);
    } //actionPerformed

    private void openFile() {
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile

    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getName();
        TextFileInput inFile = new TextFileInput(chosenFileName);
        String word;

        word = inFile.readLine();
        //must put in key or defaults to null
        TreeMap<Word, Word>  treeMap = new TreeMap();
        while (word != null) {
            try{
                Word tempWord = new Word(word);
                treeMap.put(tempWord, null);
            }catch(IllegalWordException iwe){
                iwe.printStackTrace();
            }finally {
                word = inFile.readLine();
            }
        }
         mygui.showGUI(treeMap);
    }

    public class ListFiles {

        public void main(String[] args) {
            JFileChooser fd = new JFileChooser();
//        mode - the type of files to be displayed:
          // JFileChooser.FILES_ONLY
                //    JFileChooser.DIRECTORIES_ONLY
                 //   JFileChooser.FILES_AND_DIRECTORIES
            fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fd.showOpenDialog(null);
            File f = fd.getSelectedFile();
            listFiles(f, "");
        }

        public void listFiles(File f, String indent) {
            File files[] = f.listFiles();

            for (int i = 0; i < files.length; i++) {
                File f2 = files[i];
                System.out.print(indent + f2.getName());
                System.out.print("...");
                System.out.print(f2.lastModified());
                System.out.print("...");
                System.out.print(f2.length());
                System.out.println();
                if (f2.isDirectory())
                    listFiles(f2, indent + "   ");
            }
        }
    }
}

