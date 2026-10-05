import javax.swing.*;
import java.awt.*;

public class TextEditorApplication extends JFrame {

    JTextArea textArea;

    TextEditorApplication() {

        setTitle("Simple Text Editor");
        setSize(700, 500);

        // Text area
        textArea = new JTextArea();

        JScrollPane scrollPane =
            new JScrollPane(textArea);

        add(scrollPane);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem =
            new JMenuItem("New");

        JMenuItem clearItem =
            new JMenuItem("Clear");

        JMenuItem exitItem =
            new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");

        JMenuItem cutItem =
            new JMenuItem("Cut");

        JMenuItem copyItem =
            new JMenuItem("Copy");

        JMenuItem pasteItem =
            new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // New
        newItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Clear
        clearItem.addActionListener(e -> {
            textArea.setText("");
        });

        // Exit
        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        // Cut
        cutItem.addActionListener(e -> {
            textArea.cut();
        });

        // Copy
        copyItem.addActionListener(e -> {
            textArea.copy();
        });

        // Paste
        pasteItem.addActionListener(e -> {
            textArea.paste();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditorApplication();
    }
}