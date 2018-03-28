package presentation;

import business.Facade;
import data.models.Student;
import data.models.User;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class UserInfoUI extends JFrame {
    private Student student;
    private Facade facade;
    private User user;
    private JButton updateButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel cardLabel;
    private JLabel cnpLabel;
    private JLabel addressLabel;
    private JTextField cardField;
    private JTextField cnpField;
    private JTextField addressField;
    private JButton backButton;

    public UserInfoUI(Student student) {
        super("User Information");
        facade = new Facade();
        user = facade.userFindById(student.getUser_id());
        //construct components
        updateButton = new JButton ("Update");
        nameField = new JTextField (5);
        nameLabel = new JLabel ("Name");
        cardLabel = new JLabel ("Card Number");
        cnpLabel = new JLabel ("CNP");
        addressLabel = new JLabel ("Address");
        cardField = new JTextField (5);
        cnpField = new JTextField (5);
        addressField = new JTextField (5);
        backButton = new JButton ("Back");

        //adjust size and set layout
        setPreferredSize (new Dimension (319, 270));
        setLayout (null);

        //add components
        add (updateButton);
        add (nameField);
        add (nameLabel);
        add (cardLabel);
        add (cnpLabel);
        add (addressLabel);
        add (cardField);
        add (cnpField);
        add (addressField);
        add (backButton);

        //set component bounds (only needed by Absolute Positioning)
        updateButton.setBounds (185, 185, 100, 25);
        nameField.setBounds (20, 45, 100, 25);
        nameLabel.setBounds (20, 25, 100, 25);
        cardLabel.setBounds (185, 25, 100, 25);
        cnpLabel.setBounds (20, 110, 100, 25);
        addressLabel.setBounds (185, 110, 100, 25);
        cardField.setBounds (185, 45, 100, 25);
        cnpField.setBounds (20, 130, 100, 25);
        addressField.setBounds (185, 130, 100, 25);
        backButton.setBounds (20, 185, 100, 25);

        nameField.setText(user.getName());
        cardField.setText(user.getCard_no());
        addressField.setText(user.getAddress());
        cnpField.setText(user.getCnp());

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    User newUser = new User(user.getId(),user.getLogin_id(),cardField.getText(), nameField.getText(),addressField.getText(), cnpField.getText());
                    facade.updateUser(newUser);

                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
