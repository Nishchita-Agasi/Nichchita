package onlineQuizApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create quiz questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("What is the capital of India?", 
            new String[]{"1. Mumbai", "2. New Delhi", "3. Kolkata", "4. Chennai"}, 2));
        quiz.add(new Question("Which language is primarily used for Android development?", 
            new String[]{"1. Python", "2. Java", "3. C#", "4. Swift"}, 2));
        quiz.add(new Question("What is 5 + 7?", 
            new String[]{"1. 10", "2. 12", "3. 14", "4. 11"}, 2));

        int score = 0;

        System.out.println("=== Welcome to the Online Quiz App ===");

        // Loop through each question
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQuestion " + (i + 1) + ":");
            q.displayQuestion();

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is option " + q.getCorrectOption());
            }
        }

        System.out.println("\n=== Quiz Completed ===");
        System.out.println("Your Score: " + score + "/" + quiz.size());

        scanner.close();
    }
}
