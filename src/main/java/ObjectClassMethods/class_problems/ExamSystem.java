package ObjectClassMethods.class_problems;

abstract class Question {
    protected String question;
    protected int marks;

    public Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }

    public abstract int evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    public MultipleChoiceQuestion(String question, int marks, String correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    public int evaluate(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer))
            return marks;
        return 0;
    }
}

class TrueFalseQuestion extends Question {
    private String correctAnswer;

    public TrueFalseQuestion(String question, int marks, String correctAnswer) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    public int evaluate(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer))
            return marks;
        return 0;
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

class Attempt {
    Student student;
    Question[] questions;
    String[] answers;
    boolean submitted;

    public Attempt(Student student, Question[] questions) {
        this.student = student;
        this.questions = questions;
        answers = new String[questions.length];
        submitted = false;
    }

    public void answer(int number, String answer) {
        if (!submitted) {
            answers[number] = answer;
            System.out.println("Answer recorded for Question " + (number + 1) + ".");
        } else {
            System.out.println("Cannot change answers for a submitted examination.");
        }
    }

    public void submit() {
        submitted = true;

        int total = 0;
        int maximum = 0;

        System.out.println("Exam submitted by " + student.name + ".");

        for (int i = 0; i < questions.length; i++) {
            int score = questions[i].evaluate(answers[i]);
            total += score;
            maximum += questions[i].marks;

            if (score > 0)
                System.out.println("Question " + (i + 1) + ": Correct (" + score + " points)");
            else
                System.out.println("Question " + (i + 1) + ": Incorrect (0 points)");
        }

        System.out.println("Total score: " + total + "/" + maximum);
    }
}

public class ExamSystem {
    public static void main(String[] args) {

        Student s = new Student("Student 1");

        Question[] questions = {
                new MultipleChoiceQuestion("Question 1", 5, "C"),
                new TrueFalseQuestion("Question 2", 5, "False")
        };

        Attempt attempt = new Attempt(s, questions);

        System.out.println("Exam started by Student 1.");

        attempt.answer(0, "C");
        attempt.answer(1, "True");

        attempt.submit();

        attempt.answer(0, "B");
    }
}