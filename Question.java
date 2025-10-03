package onlineQuizApp;

//Represents a single quiz question
public class Question {
 private String questionText;
 private String[] options;
 private int correctOption;

 // Constructor
 public Question(String questionText, String[] options, int correctOption) {
     this.questionText = questionText;
     this.options = options;
     this.correctOption = correctOption;
 }

 // Display the question and options
 public void displayQuestion() {
     System.out.println(questionText);
     for (String option : options) {
         System.out.println(option);
     }
 }

 // Check if user's answer is correct
 public boolean checkAnswer(int userAnswer) {
     return userAnswer == correctOption;
 }

 public int getCorrectOption() {
     return correctOption;
 }
}
