/**

 * File: ResultsFrame.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import javax.swing.*;
import java.awt.*;

public class ResultsFrame extends JFrame {
    public ResultsFrame(int rightAns, int wrongAns) {
        // Setting up the frame
        setTitle("Game Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        setLayout(new GridLayout(2, 1));
        setIconImage(new ImageIcon("img.png").getImage());

        // Creating labels for displaying the results
        JLabel rightLabel = new JLabel("Correct Answers: " + rightAns);
        JLabel wrongLabel = new JLabel("Wrong Answers: " + wrongAns);

        rightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wrongLabel.setHorizontalAlignment(SwingConstants.CENTER);

        rightLabel.setForeground(new Color(220, 220, 220));
        wrongLabel.setForeground(new Color(220, 220, 220));

        rightLabel.setFont(new Font("Impact", Font.PLAIN, 15));
        wrongLabel.setFont(new Font("Impact", Font.PLAIN, 15));

        getContentPane().setBackground(new Color(30, 30, 30));

        // Adding labels to the frame
        add(rightLabel);
        add(wrongLabel);

        setVisible(true);
    }
}