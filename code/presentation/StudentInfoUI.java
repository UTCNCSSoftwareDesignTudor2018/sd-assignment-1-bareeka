package presentation;

import business.Facade;
import data.models.Student;
import data.models.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Created by Mortimer on 3/28/2018.
 */
public class StudentInfoUI extends JFrame {

    private Student student;
    private JButton updateButton;
    private JLabel idLabel;
    private JLabel groupLabel;
    private JTextField groupField;
    private JButton backButton;
    private JButton gradesButton;
    private JButton enrollmentButton;
    private JLabel jcomp8;
    private JTextField idField;
    private Facade facade;

    public StudentInfoUI(Student student) {
        super("Hello" + student.getName());
        System.out.println("student info panel");
        this.facade = new Facade();
        this.student = student;
        updateButton = new JButton("Update");
        idLabel = new JLabel("ID");
        groupLabel = new JLabel("Group");
        groupField = new JTextField(5);
        backButton = new JButton("Back");
        gradesButton = new JButton("Grades");
        enrollmentButton = new JButton("Enrollments");
        jcomp8 = new JLabel("");
        idField = new JTextField(5);

        //adjust size and set layout
        setPreferredSize(new Dimension(319, 275));
        setLayout(null);

        //add components
        add(updateButton);
        add(idLabel);
        add(groupLabel);
        add(groupField);
        add(backButton);
        add(gradesButton);
        add(enrollmentButton);
        add(jcomp8);
        add(idField);

        //set component bounds (only needed by Absolute Positioning)
        updateButton.setBounds(180, 185, 110, 30);
        idLabel.setBounds(20, 25, 100, 25);
        groupLabel.setBounds(185, 25, 100, 25);
        groupField.setBounds(185, 45, 100, 25);
        backButton.setBounds(20, 185, 115, 30);
        gradesButton.setBounds(20, 140, 115, 30);
        enrollmentButton.setBounds(180, 140, 110, 30);
        jcomp8.setBounds(50, 45, 100, 25);
        idField.setBounds(20, 45, 100, 25);

        idField.setText(Integer.toString(student.getId()));
        groupField.setText(Integer.toString(student.getGroup()));

        enrollmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    EnrollmentUI eui = new EnrollmentUI(student);

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

