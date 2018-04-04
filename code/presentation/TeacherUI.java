package presentation;

import business.Facade;
import data.models.Student;
import data.models.Teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TeacherUI extends JFrame {
    private JButton crudButton;
    private JButton reportButton;
    private Teacher teacher;
    private JPanel contentPane;
    private Facade facade;
    private JTabbedPane tabbedPane;
    private JScrollPane scrollPane;
    private JTable studentsTable;


    public TeacherUI(Teacher teacher) {
        super("Teacher Panel");
        this.teacher = teacher;
        this.facade = new Facade();
        //construct components
        crudButton = new JButton ("Student Data");
        reportButton = new JButton ("Generate Report");

        reportButton.setBounds(400,520,150,50);



        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(reportButton);

        //adjust size and set layout
        setPreferredSize (new Dimension (600, 1000));
        setLayout (null);


        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        this.scrollPane = new JScrollPane();
        tabbedPane.setBounds(50,10,500,500);
        contentPane.add(tabbedPane);


        // Table

        this.studentsTable = new JTable(facade.studentsToTable());
        scrollPane.add(studentsTable);
        scrollPane.setViewportView(studentsTable);
        tabbedPane.addTab("Students",null,scrollPane,null);

        //Button
        JButton updateButton = new JButton ("Update");
        JButton insertButton = new JButton ("Add new");

        updateButton.setBounds(75, 520, 100, 25);
        insertButton.setBounds(250, 520, 100, 25);

        contentPane.add(updateButton);
        contentPane.add(insertButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    int id = Integer.parseInt(studentsTable.getValueAt(studentsTable.getSelectedRow(), 0).toString());
                    String name = studentsTable.getValueAt(studentsTable.getSelectedRow(), 1).toString();

                    Student student = new Student(
                            id,
                            name,
                            Integer.parseInt(studentsTable.getValueAt(studentsTable.getSelectedRow(),3).toString()),
                            Integer.parseInt(studentsTable.getValueAt(studentsTable.getSelectedRow(), 2).toString()));

                    facade.updateStudent(student);

                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    NewStudentUI nsui = new NewStudentUI();


                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    


                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });




        //set component bounds (only needed by Absolute Positioning)
       // crudButton.setBounds (65, 35, 130, 45);
       // reportButton.setBounds (65, 105, 130, 50);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public void refreshTable(){
        this.studentsTable = new JTable(facade.studentsToTable());
        scrollPane.add(studentsTable);
        scrollPane.setViewportView(studentsTable);
        tabbedPane.addTab("Students",null,scrollPane,null);
    }

}
