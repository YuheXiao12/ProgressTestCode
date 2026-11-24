import javax.swing.*;

import java.awt.*;

import java.util.List;

public class GUI extends JFrame {

    public GUI(List<Student> students) {
        setTitle("AI-Aware Software Engineering Assessment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(

                new GridLayout(students.size() + 1, 1, 0, 4)

        );
        JPanel header = new JPanel(new GridLayout(1, 7));
        header.setBackground(Color.LIGHT_GRAY);



        for (Student student : students) {

            JPanel row = new JPanel(new GridLayout(1, 7));


            if (student.aiDifferences()) {

                row.setBackground(Color.RED);

            } else {

                row.setBackground(Color.WHITE);

            }


        }

        add(new JScrollPane(mainPanel));

        setSize(1100, 350);

        setLocationRelativeTo(null);

        setVisible(true);

    }

}