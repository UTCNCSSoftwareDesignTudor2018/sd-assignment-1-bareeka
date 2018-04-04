package presentation;

import data.models.Student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class StudentUI extends JFrame {
    private JButton userInfoButton;
    private JButton studentInfoButton;
    private JButton enrollButton;
    private JButton gradesButton;
    private Student student;

    public StudentUI(Student student) {
        super("Student Panel");
        this.student = student;
        userInfoButton = new JButton("User Information");
        studentInfoButton = new JButton("Student Information");
        enrollButton = new JButton("Enrollments");
        gradesButton = new JButton("Grades");

        //adjust size and set layout
        setPreferredSize(new Dimension(400, 350));
        setLayout(null);

        //add components
        add(userInfoButton);
        add(studentInfoButton);
        add(enrollButton);
        add(gradesButton);

        //set component bounds (only needed by Absolute Positioning)
        userInfoButton.setBounds(120, 35, 155, 50);
        studentInfoButton.setBounds(120, 95, 155, 50);
        enrollButton.setBounds(120, 155, 155, 50);
        gradesButton.setBounds(120, 215, 155, 50);

        studentInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //setVisible(false);
                    StudentInfoUI siu = new StudentInfoUI(student);

                }catch(Exception x){
                     x.printStackTrace();
                }

            }

        });

        userInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   // setVisible(false);
                    UserInfoUI ui = new UserInfoUI(student);

                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //setVisible(false);
                    EnrollmentUI ui = new EnrollmentUI(student, 1);

                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        gradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //setVisible(false);
                    EnrollmentUI ui = new EnrollmentUI(student, 1);

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
