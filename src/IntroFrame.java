/**

 * File: IntroFrame.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroFrame extends JFrame {
    private JLabel title;
    private JButton start;

    public IntroFrame() {
        setTitle("Guess the Movie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("img.png").getImage());

        initializeComponents();
        setupLayout();
        setupStartButtonListener();

        getContentPane().setBackground(new Color(30, 30, 30));
        setVisible(true);
    }

    // Method to initialize components
    private void initializeComponents() {
        title = new JLabel("Guess the Movie!");
        title.setForeground(new Color(220, 220, 220));
        title.setFont(new Font("Impact", Font.PLAIN, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        start = new JButton("Start");
        start.setFont(new Font("Segoe UI", Font.BOLD, 15));
    }

    // Method to set up layout
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(title, BorderLayout.CENTER);
        add(start, BorderLayout.SOUTH);
    }

    // Method to set up action listener for the start button
    private void setupStartButtonListener() {
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    // Method to start the game
    private void startGame() {
        new QuestionFrame(1, 0, 0);
        dispose(); // Close the intro window
    }
}
