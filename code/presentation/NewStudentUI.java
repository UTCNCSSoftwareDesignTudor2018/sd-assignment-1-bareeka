package presentation;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import business.Facade;
import data.models.Login;
import data.models.Student;
import data.models.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class NewStudentUI extends JFrame {
    private JButton insertButton;
    private JLabel nameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JLabel groupLabel;
    private JTextField groupField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Login login;
    private User user;
    private Facade facade;

    public NewStudentUI() {
        super("Sign Up");
        this.facade = new Facade();
        insertButton = new JButton ("Done");
        nameLabel = new JLabel ("Name");
        usernameLabel = new JLabel ("Username");
        passwordLabel = new JLabel ("Password");
        groupLabel = new JLabel("Group");
        nameField = new JTextField (5);
        usernameField = new JTextField (5);
        passwordField = new JPasswordField (5);
        groupField = new JTextField(5);

        //adjust size and set layout
        setPreferredSize (new Dimension (241, 266));
        setLayout (null);

        //add components
        add (insertButton);
        add (nameLabel);
        add (usernameLabel);
        add (passwordLabel);
        add (nameField);
        add (usernameField);
        add (passwordField);
        add (groupLabel);
        add (groupField);

        //set component bounds (only needed by Absolute Positioning)
        insertButton.setBounds (65, 160, 100, 20);
        nameLabel.setBounds (25, 30, 100, 25);
        usernameLabel.setBounds (25, 60, 100, 25);
        passwordLabel.setBounds (25, 95, 100, 25);
        nameField.setBounds (95, 30, 100, 25);
        usernameField.setBounds (95, 60, 100, 25);
        passwordField.setBounds (95, 95, 100, 25);
        groupLabel.setBounds(25, 125, 100, 25);
        groupField.setBounds(95,125, 100, 25);

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String pass = String.valueOf(passwordField.getPassword());
                    String username = usernameField.getText();
                    String name = nameField.getText();
                    int group = Integer.parseInt(groupField.getText());
                    login = new Login(1,username,pass, 1);
                    facade.insertLogin(login);

                    Login newLogin = facade.loginFindByUsername(username);

                    user = new User(1,newLogin.getId());
                    facade.insertUser(user);

                    User newUser = facade.userFindByLoginId(newLogin.getId());

                    Student student = new Student(1,name,group,newUser.getId());
                    facade.insertStudent(student);

                    JOptionPane.showMessageDialog(null, "Student Added!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);


                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}

