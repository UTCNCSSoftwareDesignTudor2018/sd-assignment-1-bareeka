package presentation;

import business.Facade;
import data.models.Enrollment;
import data.models.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnrollmentUI extends JFrame {

    private Student student;
    private JPanel contentPane;
    private Facade facade;
    private JButton enrollButton;
    private int role;
    private JButton updateButton;

    public EnrollmentUI(Student student, int role) {
        super("Enrollment Panel");
        this.student = student;
        this.facade = new Facade();
        this.role = role;
        setPreferredSize (new Dimension (350, 420));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Button
        enrollButton = new JButton ("Enroll");
        contentPane.add(enrollButton);
        enrollButton.setBounds(125, 340, 100, 25);

        //Update
        if(role != 1) {
            this.updateButton = new JButton("Update");
            contentPane.add(updateButton);
            updateButton.setBounds(125, 360, 100, 25);
        }

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.setBounds(10,10,300,300);
        contentPane.add(tabbedPane);


        // Courses

        JTable coursesTable = new JTable(facade.coursesToTable());
        scrollPane.add(coursesTable);
        scrollPane.setViewportView(coursesTable);
        tabbedPane.addTab("Courses",null,scrollPane,null);


        // Grades

        JScrollPane mcPane = new JScrollPane();
        JTable mcoursesTable = new JTable(facade.studentEnrollmentsTable(student));
        mcPane.add(mcoursesTable);
        mcPane.setViewportView(mcoursesTable);
        tabbedPane.addTab("Grades",null,mcPane,null);

        //Enroll Action
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               int row = coursesTable.getSelectedRow();
               int id = Integer.parseInt(coursesTable.getValueAt(row,0).toString());
               facade.enrollStudent(student,facade.courseFindById(id));
                JOptionPane.showMessageDialog(null, "Enrolled!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Update Action - Only for Teachers
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int row = mcoursesTable.getSelectedRow();
                int id = Integer.parseInt(mcoursesTable.getValueAt(row,0).toString());
                int grade = Integer.parseInt(mcoursesTable.getValueAt(row,3).toString());
                Enrollment e = facade.enrollmentFindById(id);
                e.setGrade(grade);
                facade.updateEnrollment(e);
                JOptionPane.showMessageDialog(null, "Graded!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}
