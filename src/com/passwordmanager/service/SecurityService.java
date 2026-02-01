package com.passwordmanager.service;

import com.passwordmanager.dao.SecurityQuestionDao;
import com.passwordmanager.model.SecurityQuestion;

import java.util.List;
import java.util.Scanner;

public class SecurityService {

    private SecurityQuestionDao dao = new SecurityQuestionDao();

    public void addSecurityQuestions(int userId) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter question: ");
        String q = sc.nextLine();

        System.out.print("Enter answer: ");
        String a = sc.nextLine();

        SecurityQuestion sq = new SecurityQuestion();
        sq.setUserId(userId);
        sq.setQuestion(q);
        sq.setAnswer(a);

        dao.addQuestion(sq);
    }

    public boolean verifyAnswers(int userId) {

        Scanner sc = new Scanner(System.in);
        List<SecurityQuestion> questions = dao.getQuestionsByUser(userId);

        for (SecurityQuestion sq : questions) {
            System.out.println(sq.getQuestion());
            System.out.print("Answer: ");
            String input = sc.nextLine();

            if (!input.equalsIgnoreCase(sq.getAnswer())) {
                return false;
            }
        }
        return true;
    }
}
