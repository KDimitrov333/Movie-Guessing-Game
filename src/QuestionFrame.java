/**

 * File: QuestionFrame.java

 * Author: Kaloyan Dimitrov

 * Date: 11/28/2023

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class QuestionFrame extends JFrame {
        private JLabel shot;
        private JButton answer1;
        private JButton answer2;
        private JButton answer3;
        private JButton answer4;
        private int rightAns;
        private int wrongAns;
        private int numQuestions;
        private String correctName;

        public QuestionFrame(int numQuestions, int rightAns, int wrongAns) {
                // Initializing the frame with provided data
                this.numQuestions = numQuestions;
                this.rightAns = rightAns;
                this.wrongAns = wrongAns;

                // If more than 10 questions answered, display results and exit
                if (numQuestions > 10) {
                        new ResultsFrame(rightAns, wrongAns);
                        dispose();
                        return;
                }

                // Setting up the frame
                setTitle("Question " + numQuestions);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setExtendedState(Frame.MAXIMIZED_BOTH);
                setResizable(false);
                setLayout(new BorderLayout());
                setIconImage(new ImageIcon("img.png").getImage());

                getContentPane().setBackground(new Color(30, 30, 30));

                // Getting a list of random movies for the question
                List<MovieAnswer> selectedMovies;
                boolean correctAnswerAssigned = false;
                String correctAnswerTitle = "";

                // Loop to ensure a correct answer is selected
                do {
                        selectedMovies = MovieData.getRandomMovies();
                        for (MovieAnswer movie : selectedMovies) {
                                if (movie.isCorrect()) {
                                        correctAnswerTitle = movie.getTitle();
                                        correctAnswerAssigned = true;
                                        break;
                                }
                        }
                } while (!correctAnswerAssigned);

                // Displaying the movie shot related to the correct answer
                displayMovieShot(selectedMovies);

                // Creating buttons for answers and assigning correct answer text and action listeners
                createAnswerButtons(selectedMovies, correctAnswerTitle);

                // Adding buttons to the panel and displaying them
                JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
                setButtonColors();
                addButtonsToPanel(buttonsPanel);
                add(shot, BorderLayout.CENTER);
                add(buttonsPanel, BorderLayout.SOUTH);

                setVisible(true);
        }

        // Method to display the movie shot related to the correct answer
        private void displayMovieShot(List<MovieAnswer> selectedMovies) {
                for (MovieAnswer movie : selectedMovies) {
                        if (movie.isCorrect()) {
                                // Setting Movie correctName to the title of the correct movie
                                correctName = movie.getTitle();

                                // Resizing the movie shot for display
                                ImageIcon resizedIcon = resizeImageIcon(movie.getShotPath());

                                // Setting up shot properties
                                setShotProperties(resizedIcon);
                                break;
                        }
                }
        }

        // Method to resize the image icon for display
        private ImageIcon resizeImageIcon(String imagePath) {
                ImageIcon originalIcon = new ImageIcon(imagePath);
                Image originalImage = originalIcon.getImage();

                int originalWidth = originalIcon.getIconWidth();
                int originalHeight = originalIcon.getIconHeight();

                double widthScale = (double) 600 / originalWidth;
                double heightScale = (double) 300 / originalHeight;
                double scale = Math.min(widthScale, heightScale);

                int newWidth = (int) (originalWidth * scale);
                int newHeight = (int) (originalHeight * scale);

                Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                return new ImageIcon(resizedImage);
        }

        // Method to set up shot properties
        private void setShotProperties(ImageIcon resizedIcon) {
                shot = new JLabel();
                shot.setIcon(resizedIcon);
                shot.setHorizontalAlignment(SwingConstants.CENTER);
                shot.setVerticalAlignment(SwingConstants.CENTER);
        }

        private void setButtonColors() {
                answer1.setForeground(new Color(40,40,40));
                answer1.setBackground(Color.RED);

                answer2.setForeground(new Color(40,40,40));
                answer2.setBackground(Color.BLUE);

                answer3.setForeground(new Color(40,40,40));
                answer3.setBackground(Color.YELLOW);

                answer4.setForeground(new Color(40,40,40));
                answer4.setBackground(Color.GREEN);
        }

        // Method to create buttons for answers and assign correct answer text and action listeners
        private void createAnswerButtons(List<MovieAnswer> selectedMovies, String correctAnswerTitle) {
                answer1 = new JButton(selectedMovies.get(0).getTitle());
                answer2 = new JButton(selectedMovies.get(1).getTitle());
                answer3 = new JButton(selectedMovies.get(2).getTitle());
                answer4 = new JButton(selectedMovies.get(3).getTitle());

                int correctIndex = findCorrectIndex(selectedMovies);

                switch (correctIndex) {
                        case 0:
                                setButtonProperties(answer1, correctAnswerTitle, true);
                                setButtonProperties(answer2, correctAnswerTitle, false);
                                setButtonProperties(answer3, correctAnswerTitle, false);
                                setButtonProperties(answer4, correctAnswerTitle, false);
                                break;
                        case 1:
                                setButtonProperties(answer1, correctAnswerTitle, false);
                                setButtonProperties(answer2, correctAnswerTitle, true);
                                setButtonProperties(answer3, correctAnswerTitle, false);
                                setButtonProperties(answer4, correctAnswerTitle, false);
                                break;
                        case 2:
                                setButtonProperties(answer1, correctAnswerTitle, false);
                                setButtonProperties(answer2, correctAnswerTitle, false);
                                setButtonProperties(answer3, correctAnswerTitle, true);
                                setButtonProperties(answer4, correctAnswerTitle, false);
                                break;
                        case 3:
                                setButtonProperties(answer1, correctAnswerTitle, false);
                                setButtonProperties(answer2, correctAnswerTitle, false);
                                setButtonProperties(answer3, correctAnswerTitle, false);
                                setButtonProperties(answer4, correctAnswerTitle, true);
                                break;
                }
        }

        // Method to find the correct movie's index in the selectedMovies list
        private int findCorrectIndex(List<MovieAnswer> selectedMovies) {
                int correctIndex = -1;
                for (int i = 0; i < selectedMovies.size(); i++) {
                        if (selectedMovies.get(i).isCorrect()) {
                                correctIndex = i;
                                break;
                        }
                }
                return correctIndex;
        }

        // Method to set up button properties (text and action listener)
        private void setButtonProperties(JButton button, String correctAnswerTitle, boolean isCorrectAnswer) {
                button.setText(isCorrectAnswer ? correctAnswerTitle : button.getText());
                button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                handleAnswer(isCorrectAnswer);
                        }
                });
        }

        // Method to add buttons to the panel
        private void addButtonsToPanel(JPanel buttonsPanel) {
                buttonsPanel.add(answer1);
                buttonsPanel.add(answer2);
                buttonsPanel.add(answer3);
                buttonsPanel.add(answer4);
        }

        // Method to handle user's answer and proceed to the next question
        private void handleAnswer(boolean isCorrect) {
                numQuestions++;
                if (isCorrect) {
                        rightAns++;
                        new QuestionFrame(numQuestions, rightAns, wrongAns);
                } else {
                        wrongAns++;
                        new QuestionFrame(numQuestions, rightAns, wrongAns);
                        new WrongFrame(correctName);
                }
                dispose();
        }
}