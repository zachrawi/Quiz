package com.zachrawi.quiz;

public class Question {
    private int question;
    private boolean answerTrue;

    public Question(int question, boolean answerTrue) {
        this.question = question;
        this.answerTrue = answerTrue;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
