package presentation;

import business.Facade;
import data.models.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class EnrollmentUI extends JFrame {

    private Student student;
    private JPanel contentPane;
    private Facade facade;

    public EnrollmentUI(Student student) {
        super("Enrollment Panel");
        this.student = student;
        this.facade = new Facade();
        setPreferredSize (new Dimension (350, 380));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);



        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.setBounds(10,10,300,300);
        contentPane.add(tabbedPane);


        // Courses

        JTable coursesTable = facade.coursesToTable();
        scrollPane.add(coursesTable);
        scrollPane.setViewportView(coursesTable);
        tabbedPane.addTab("Courses",null,scrollPane,null);


        // Grades

        JScrollPane mcPane = new JScrollPane();
        JTable mcoursesTable = facade.studentEnrollmentsTable(student);
        mcPane.add(mcoursesTable);
        mcPane.setViewportView(mcoursesTable);
        tabbedPane.addTab("Grades",null,mcPane,null);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}
