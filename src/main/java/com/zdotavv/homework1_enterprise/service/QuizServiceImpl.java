package com.zdotavv.homework1_enterprise.service;

import com.zdotavv.homework1_enterprise.ResourceReader;
import com.zdotavv.homework1_enterprise.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class QuizServiceImpl implements QuizService {
    private ResourceReader resourceReader;
    @Autowired
    private User user;
    private int number;
    private int score;

    public void answer() {
        Scanner scanner = new Scanner(System.in);
        for (number = 0; number < resourceReader.getRecords().size(); number++){
            System.out.println("Питання №: "+Question());
            if (checkAnswer(scanner.nextLine())) {
                score++;
            }
        }
        System.out.println("\n" + user.getName() + " " + user.getSurname() + "\n"
                + "Вірних відповідей: " + score + " " + "з можливих " + resourceReader.getRecords().size());
    }

    public String Question() {
        List<String> record = resourceReader.getRecords().get(number);
        return record.get(0) +"\n" + String.join(
                ", ", record.get(1)+ "\n"+ record.get(2)+"\n"+ record.get(3)+"\n"+ record.get(4)+"."+"\n"+ "Введіть номер відповіді: ") ;
    }


    public boolean checkAnswer(String answer) {
        return resourceReader.getRecords().get(number).get(5).equals(answer);
    }

}



