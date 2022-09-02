package com.zdotavv.homework1_enterprise;

import com.zdotavv.homework1_enterprise.Service.QuizService;
import com.zdotavv.homework1_enterprise.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserService userService = context.getBean(UserService.class);
        QuizService quizService = context.getBean(QuizService.class);

        userService.userNameAndSurname();

        quizService.answer();
    }
}
