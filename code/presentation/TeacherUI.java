package presentation;

import business.Facade;
import data.models.Student;
import data.models.Teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class TeacherUI extends JFrame {
    private JButton gradeButton;
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
        gradeButton = new JButton ("Student Data");
        reportButton = new JButton ("Generate Report");

        reportButton.setBounds(400,520,150,25);
        gradeButton.setBounds(400,570,150,25);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(reportButton);
        contentPane.add(gradeButton);


        //adjust size and set layout
        setPreferredSize (new Dimension (600, 700));
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

        gradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(studentsTable.getValueAt(studentsTable.getSelectedRow(), 0).toString());
                    Student student = facade.studentFindById(id);
                    EnrollmentUI eui = new EnrollmentUI(student, 2);


                }catch(Exception x){
                    x.printStackTrace();
                }

            }

        });

        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File f = null;
                try{
                    f = new File("report.txt");
                    int id = Integer.parseInt(studentsTable.getValueAt(studentsTable.getSelectedRow(), 0).toString());
                    Student student = facade.studentFindById(id);
                    JTable table = new JTable(facade.studentEnrollmentsTable(student));
                    toExcel(table,f);



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

    public void toExcel(JTable table, File file){
        try{
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for(int i = 0; i < model.getColumnCount(); i++){
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for(int i=0; i< model.getRowCount(); i++) {
                for(int j=0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i,j).toString()+"\t");
                }
                excel.write("\n");
            }

            excel.close();

        }catch(IOException e){ System.out.println(e); }
    }

}
