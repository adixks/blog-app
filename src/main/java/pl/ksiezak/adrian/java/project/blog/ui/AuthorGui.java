package pl.ksiezak.adrian.java.project.blog.ui;

import pl.ksiezak.adrian.java.project.blog.repository.DatabaseUniqueIdGenerator;
import pl.ksiezak.adrian.java.project.blog.web.AuthorController;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.AuthorBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorGui extends JFrame implements ActionListener  {
    static JTextField t;
    static JTextField t1;
    static JTextField t2;

    static JFrame f;

    static JButton b;

    static JLabel l;
    static JLabel l1;
    static JLabel l2;

    AuthorGui()
    {
    }

    public static void main(String[] args)
    {

        l = new JLabel("First name:");
        l1 = new JLabel("Last name:");
        l2 = new JLabel("Nick:");

        f = new JFrame("AuthorGui");

        b = new JButton("submit");

        AuthorGui te = new AuthorGui();

        b.addActionListener(te);

        t = new JTextField(16);
        t1 = new JTextField(16);
        t2 = new JTextField(16);

        JPanel p = new JPanel(new GridLayout(0, 1));

        p.add(l);
        p.add(t);
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b);


        f.add(p);

        f.setSize(400, 400);

        f.show();
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {

            String firstName = t.getText();
            String lastName = t1.getText();
            String nick = t2.getText();

            Author author = new AuthorBuilder().setId(DatabaseUniqueIdGenerator.generateId()).setFirstName(firstName).setLastName(lastName).setNickName(nick).createAuthor();
            AuthorController authorController = new AuthorController();
            authorController.create(author);

            t.setText("  ");
            t1.setText("  ");
            t2.setText("  ");
        }
    }
}