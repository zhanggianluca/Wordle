import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener {
    private JButton q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m, enter, delete;
    private JLabel title;
    private JPanel titlePanel, keyboard1, keyboard2, keyboard3,  r1, r2, r3, r4, r5, r6;
    private JTextField d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30, user;
    private String result, selectedWord;
    public String[] arr;
    private int attemptNum = 0, index = 0;
    private String attempt;
    private ArrayList<JPanel> panels;

    public GUI() {
        setTitle("WORDLE");
        setJLabel();
        setJTextField();
        setJPanel();
        setButton();
        panels = new ArrayList<JPanel>(Arrays.asList(r1, r2, r3, r4, r5, r6));
        addComponents();
        setActionCommands();
        addActionListeners();
        setLayout(new FlowLayout());
        add(titlePanel);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        add(r6);
        add(keyboard1);
        add(keyboard2);
        add(keyboard3);
        read();
        array();
        selectedWord();
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent click) {
//        ArrayList<JTextField> textfields = new ArrayList<JTextField>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30));
        String displayText = user.getText();
        boolean back = false;
        String actionCommand = click.getActionCommand();
        switch (actionCommand){
            case "q":
                displayText += "Q";
                break;
            case "w":
                displayText += "W";
                break;
            case "e":
                displayText += "E";
                break;
            case "r":
                displayText += "R";
                break;
            case "t":
                displayText += "T";
                break;
            case "y":
                displayText += "Y";
                break;
            case "u":
                displayText += "U";
                break;
            case "i":
                displayText += "I";
                break;
            case "o":
                displayText += "O";
                break;
            case "p":
                displayText += "P";
                break;
            case "a":
                displayText += "A";
                break;
            case "s":
                displayText += "S";
                break;
            case "d":
                displayText += "D";
                break;
            case "f":
                displayText += "F";
                break;
            case "g":
                displayText += "G";
                break;
            case "h":
                displayText += "H";
                break;
            case "j":
                displayText += "J";
                break;
            case "k":
                displayText += "K";
                break;
            case "l":
                displayText += "L";
                break;
            case "z":
                displayText += "Z";
                break;
            case "x":
                displayText += "X";
                break;
            case "c":
                displayText += "C";
                break;
            case "v":
                displayText += "V";
                break;
            case "b":
                displayText += "B";
                break;
            case "n":
                displayText += "N";
                break;
            case "m":
                displayText += "M";
                break;
            case "delete":
                back = true;
                break;
            case "enter":
                if (displayText.length() == 5) {
                    attempt = displayText;
                    if (validWord(attempt)) {
                        if (winCondition()) {
                            colorBoxes();
                            congratulations();
                        }
                        else {
                            colorBoxes();
                            attemptNum++;
                            displayText = "";
                        }
                    }
                    else {
                        System.out.println(attempt + " is not a valid word");
                    }
                }
                break;
        }
        if (displayText.length() > 5) {
            displayText = displayText.substring(0, 5);
        }
        if (back) {
            if (displayText.length() == 1) {
                displayText = "";
            }
            else {
                displayText = displayText.substring(0, displayText.length()-1);
            }
        }
        user.setText(displayText);
        Component[] comps = panels.get(attemptNum).getComponents();
        if (displayText.equals("")) {
            ((JTextField)comps[0]).setText(null);
        }
        for (int i = 0; i < displayText.length(); i++) {
            if (back) {
                ((JTextField)comps[displayText.length()]).setText(null);
            }
            ((JTextField)comps[i]).setText(displayText.substring(i, i+1));
        }
        repaint();
    }


    private void setJTextField() {
        d1 = new JTextField(5); d2 = new JTextField(1); d3 = new JTextField(1); d4 = new JTextField(1); d5 = new JTextField(1);
        d6 = new JTextField(5); d7 = new JTextField(1); d8 = new JTextField(1); d9 = new JTextField(1); d10 = new JTextField(1);
        d11 = new JTextField(5); d12 = new JTextField(1); d13 = new JTextField(1); d14 = new JTextField(1); d15 = new JTextField(1);
        d16 = new JTextField(5); d17 = new JTextField(1); d18 = new JTextField(1); d19 = new JTextField(1); d20 = new JTextField(1);
        d21 = new JTextField(5); d22 = new JTextField(1); d23 = new JTextField(1); d24 = new JTextField(1); d25 = new JTextField(1);
        d26 = new JTextField(5); d27 = new JTextField(1); d28 = new JTextField(1); d29 = new JTextField(1); d30 = new JTextField(1);

        d1.setPreferredSize(new Dimension(40, 55));
        d6.setPreferredSize(new Dimension(40, 55));
        d11.setPreferredSize(new Dimension(40, 55));
        d16.setPreferredSize(new Dimension(40, 55));
        d21.setPreferredSize(new Dimension(40, 55));
        d26.setPreferredSize(new Dimension(40, 55));

        ArrayList<JTextField> textFields = new ArrayList<JTextField>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30));
        for (JTextField textField: textFields) {
            textField.setEditable(false);
            textField.setBackground(Color.WHITE);
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
            textField.setBorder(border);
            textField.setFont(new Font("Helvetica", Font.BOLD, 14));
            textField.setHorizontalAlignment(JTextField.CENTER);
        }
        user = new JTextField(1);
    }

    private void setJLabel() {
        title = new JLabel("<html>W<font color = 61CD44>O</font>RDL<font color = FEEF00>E</font><html>", JLabel.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 54));
    }

    private void setButton() {
        q = new JButton("q");
        q.setPreferredSize(new Dimension(40, 40));
        w = new JButton("w");
        e = new JButton("e");
        r = new JButton("r");
        t = new JButton("t");
        y = new JButton("y");
        u = new JButton("u");
        i = new JButton("i");
        o = new JButton("o");
        p = new JButton("p");
        a = new JButton("a");
        a.setPreferredSize(new Dimension(40, 40));
        s = new JButton("s");
        d = new JButton("d");
        f = new JButton("f");
        g = new JButton("g");
        h = new JButton("h");
        j = new JButton("j");
        k = new JButton("k");
        l = new JButton("l");
        z = new JButton("z");
        z.setPreferredSize(new Dimension(40, 40));
        x = new JButton("x");
        c = new JButton("c");
        v = new JButton("v");
        b = new JButton("b");
        n = new JButton("n");
        m = new JButton("m");
        delete = new JButton("⌫");
        enter = new JButton("ENTER");
        enter.setFont(new Font("Helvetica", Font.BOLD, 7));

        ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m, enter, delete));
        for (JButton b: buttons) {
            b.setBackground(Color.LIGHT_GRAY);
            Border border = BorderFactory.createEmptyBorder();
            b.setBorder(border);
        }
    }

    private void setJPanel() {
        keyboard1 = new JPanel();
        keyboard1.setLayout(new GridLayout(1, 10, 2, 2));
        keyboard1.setBackground(Color.DARK_GRAY.brighter());
        keyboard2 = new JPanel();
        keyboard2.setLayout(new GridLayout(1, 9, 2, 2));
        keyboard2.setBackground(Color.DARK_GRAY.brighter());
        keyboard3 = new JPanel();
        keyboard3.setLayout(new GridLayout(1, 7, 2, 2));
        keyboard3.setBackground(Color.DARK_GRAY.brighter());
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.DARK_GRAY.brighter());
        r1 = new JPanel();
        r1.setLayout(new GridLayout(1, 5, 5, 5));
        r1.setBackground(Color.DARK_GRAY.brighter());
        r2 = new JPanel();
        r2.setLayout(new GridLayout(1, 5, 5, 5));
        r2.setBackground(Color.DARK_GRAY.brighter());
        r3 = new JPanel();
        r3.setLayout(new GridLayout(1, 5, 5, 5));
        r3.setBackground(Color.DARK_GRAY.brighter());
        r4 = new JPanel();
        r4.setLayout(new GridLayout(1, 5, 5, 5));
        r4.setBackground(Color.DARK_GRAY.brighter());
        r5 = new JPanel();
        r5.setLayout(new GridLayout(1, 5, 5, 5));
        r5.setBackground(Color.DARK_GRAY.brighter());
        r6 = new JPanel();
        r6.setLayout(new GridLayout(1, 5, 5, 5));
        r6.setBackground(Color.DARK_GRAY.brighter());
    }

    private void addComponents() {
        titlePanel.add(title);
        keyboard1.add(q); keyboard1.add(w); keyboard1.add(e); keyboard1.add(r); keyboard1.add(t); keyboard1.add(y); keyboard1.add(u); keyboard1.add(i); keyboard1.add(o); keyboard1.add(p);
        keyboard2.add(a); keyboard2.add(s); keyboard2.add(d); keyboard2.add(f); keyboard2.add(g); keyboard2.add(h); keyboard2.add(j); keyboard2.add(k); keyboard2.add(l);
        keyboard3.add(enter); keyboard3.add(z); keyboard3.add(x); keyboard3.add(c); keyboard3.add(v); keyboard3.add(b); keyboard3.add(n); keyboard3.add(m); keyboard3.add(delete);
        r1.add(d1); r1.add(d2); r1.add(d3); r1.add(d4); r1.add(d5);
        r2.add(d6); r2.add(d7); r2.add(d8); r2.add(d9); r2.add(d10);
        r3.add(d11); r3.add(d12); r3.add(d13); r3.add(d14); r3.add(d15);
        r4.add(d16); r4.add(d17); r4.add(d18); r4.add(d19); r4.add(d20);
        r5.add(d21); r5.add(d22); r5.add(d23); r5.add(d24); r5.add(d25);
        r6.add(d26); r6.add(d27); r6.add(d28); r6.add(d29); r6.add(d30);
    }

    private void setActionCommands() {
        q.setActionCommand("q");
        w.setActionCommand("w");
        e.setActionCommand("e");
        r.setActionCommand("r");
        t.setActionCommand("t");
        y.setActionCommand("y");
        u.setActionCommand("u");
        i.setActionCommand("i");
        o.setActionCommand("o");
        p.setActionCommand("p");
        a.setActionCommand("a");
        s.setActionCommand("s");
        d.setActionCommand("d");
        f.setActionCommand("f");
        g.setActionCommand("g");
        h.setActionCommand("h");
        j.setActionCommand("j");
        k.setActionCommand("k");
        l.setActionCommand("l");
        z.setActionCommand("z");
        x.setActionCommand("x");
        c.setActionCommand("c");
        v.setActionCommand("v");
        b.setActionCommand("b");
        n.setActionCommand("n");
        m.setActionCommand("m");
        enter.setActionCommand("enter");
        delete.setActionCommand("delete");
    }

    private void addActionListeners() {
        q.addActionListener(this);
        w.addActionListener(this);
        e.addActionListener(this);
        r.addActionListener(this);
        t.addActionListener(this);
        y.addActionListener(this);
        u.addActionListener(this);
        i.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        a.addActionListener(this);
        s.addActionListener(this);
        d.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        z.addActionListener(this);
        x.addActionListener(this);
        c.addActionListener(this);
        v.addActionListener(this);
        b.addActionListener(this);
        n.addActionListener(this);
        m.addActionListener(this);
        enter.addActionListener(this);
        delete.addActionListener(this);
    }

    private void read() {
        result = "";
        try {
            File myObj = new File("word_bank.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() <= 2) {
                    data = "";
                }
                result += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void array() {
        arr = result.split("\n");
    }

    private void selectedWord() {
        Random rn = new Random();
        int randInt = rn.nextInt(2315) + 1;
        selectedWord = arr[randInt];
    }

    private boolean validWord(String word) {
        for (String s: arr) {
            if (s.equals(word.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private void colorBoxes() {
        attempt = attempt.toLowerCase();
        for (int i = 0; i < attempt.length(); i++) {
            if (attempt.substring(i, i+1).equals(selectedWord.substring(i, i+1))) {
                ((JTextField)(panels.get(attemptNum).getComponents()[i])).setBackground(Color.GREEN);
            }
            else if (selectedWord.contains(attempt.substring(i, i+1))) {
                ((JTextField)(panels.get(attemptNum).getComponents()[i])).setBackground(Color.YELLOW);
            }
            else {
                ((JTextField)(panels.get(attemptNum).getComponents()[i])).setBackground(Color.GRAY.darker());
            }
        }
    }

    private boolean winCondition() {
        if (attempt.toLowerCase().equals(selectedWord)) {
            return true;
        }
        else {
            return false;
        }
    }

    private void congratulations() {
        System.out.println("Congrats, you guessed the correct word: " + selectedWord);
        System.out.println("You got guessed it in " + (attemptNum+1) + " tries.");
    }
}
