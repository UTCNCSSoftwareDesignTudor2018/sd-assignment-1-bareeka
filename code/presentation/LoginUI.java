package presentation;

import business.Facade;
import data.models.Login;
import data.models.Student;
import data.models.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class LoginUI extends JFrame {

        private JButton loginButton;
        private JTextField usernameField;
        private JLabel usernameLabel;
        private JTextField passwordField;
        private JLabel passwordLabel;
        private JButton signupButton;
        private Facade facade;


        public LoginUI(String name) {

            super(name);
            this.facade = new Facade();
            //construct components
            loginButton = new JButton ("Log in");
            usernameField = new JTextField (5);
            usernameLabel = new JLabel ("username");
            passwordField = new JTextField (5);
            passwordLabel = new JLabel ("password");
            signupButton = new JButton ("Sign Up");

            //adjust size and set layout
            setPreferredSize (new Dimension (340, 260));
            setLayout (null);

            //add components
            add (loginButton);
            add (usernameField);
            add (usernameLabel);
            add (passwordField);
            add (passwordLabel);
            add (signupButton);

            //set component bounds (only needed by Absolute Positioning)
            loginButton.setBounds (80, 145, 140, 20);
            usernameField.setBounds (100, 35, 100, 25);
            usernameLabel.setBounds (120, 10, 100, 25);
            passwordField.setBounds (100, 90, 100, 25);
            passwordLabel.setBounds (120, 65, 100, 25);
            signupButton.setBounds (80, 170, 140, 20);

            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = passwordField.getText();

                    Login login = null;

                    try {
                        login = facade.loginFindByUsername(username);
                        if (login.getPassword().equals(password)) {
                            proceedLogin(login);
                        }else{
                            JOptionPane.showMessageDialog(null, "Incorrect Password", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }catch(Exception x){
                        JOptionPane.showMessageDialog(null, "No such username", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                        x.printStackTrace();
                    }

                }

            });


           // this.setContentPane(mainPanel);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);

        }

    public void proceedLogin(Login login){

        if(login.getRole() == 1){

            Student s = facade.studentFindById(login.getId());
            StudentUI studentUI = new StudentUI(s);
        }else{
            Teacher t = facade.teacherFindById(login.getId());
            TeacherUI teacherUI = new TeacherUI(t);
        }

        this.setVisible(false);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(JButton signupButton) {
        this.signupButton = signupButton;
    }


}
