package com.zdotavv.homework1_enterprise;

import com.zdotavv.homework1_enterprise.Service.QuizServiceImpl;
import com.zdotavv.homework1_enterprise.Service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        QuizServiceImpl quizService = context.getBean(QuizServiceImpl.class);

        userService.userNameAndSurname();
        quizService.answer();
    }
}
