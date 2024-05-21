/**

 * File: WrongFrame.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WrongFrame extends JFrame {
    public WrongFrame(String correctName) {
        setTitle("Wrong!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Disposes the frame instead of exiting the application
        setIconImage(new ImageIcon("img.png").getImage());

        JLabel messageLabel = new JLabel("The right answer was '" + correctName + "'");
        messageLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(new Color(220, 220, 220));

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton giveUpButton = new JButton("Give up");
        giveUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        getContentPane().setBackground(new Color(30, 30, 30));
        add(messageLabel);

        continueButton.setBackground(Color.GREEN);
        giveUpButton.setBackground(Color.RED);
        panel.add(continueButton);
        panel.add(giveUpButton);
        add(panel, BorderLayout.SOUTH);

        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}