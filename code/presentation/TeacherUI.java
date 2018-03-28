package presentation;

import data.models.Teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeacherUI extends JFrame {
    private JButton crudButton;
    private JButton reportButton;
    private Teacher teacher;

    public TeacherUI(Teacher teacher) {
        super("Teacher Panel");
        this.teacher = teacher;
        //construct components
        crudButton = new JButton ("Student Data");
        reportButton = new JButton ("Generate Report");

        //adjust size and set layout
        setPreferredSize (new Dimension (268, 220));
        setLayout (null);

        //add components
        add (crudButton);
        add (reportButton);

        //set component bounds (only needed by Absolute Positioning)
        crudButton.setBounds (65, 35, 130, 45);
        reportButton.setBounds (65, 105, 130, 50);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}
