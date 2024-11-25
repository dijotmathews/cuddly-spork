import java.util.Scanner;

public class QuestionService {


    Question[] questions = new Question[4];
    private int score = 0;

    public QuestionService() {
        questions[0] = new Question(1, "Options", "a", "b", "c", "d", "a");
        questions[1] = new Question(1, "Options", "a", "b", "c", "d", "a");
        questions[2] = new Question(1, "Options", "a", "b", "c", "d", "a");
        questions[3] = new Question(1, "Options", "a", "b", "c", "d", "a");
    }


    public void quiz() {
        for (Question q : questions) {
            q.ask();
            Scanner s = new Scanner(System.in);

            String ans = s.nextLine();
            if(this.evaluate(q, ans)) {
                this.score++;
            }
        }
    }

    public void displayScore() {
        System.out.println("The score of quiz is # " + this.score);
    }

    public boolean evaluate(Question q, String usersAnswer) {
        String actualAnswer = q.getAnswer();

        if(actualAnswer.equals(usersAnswer)) {
            return  true;
        }
        return false;
    }
}
