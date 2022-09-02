package com.zdotavv.homework1_enterprise.Service;

import com.zdotavv.homework1_enterprise.ResourceReader;
import com.zdotavv.homework1_enterprise.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class QuizService {
    private ResourceReader resourceReader;
    private User user;
    private int number;
    private int score;

    public void answer() {
    int i=1;
        Scanner scanner = new Scanner(System.in);
        while (number < resourceReader.getRecords().size()) {
            System.out.println("Питання №: "+i+"."+Question());
//            System.out.println("Питання №: "+number+"."+Question());
            System.out.println("Введіть номер відповіді: ");

            if (checkAnswer(scanner.nextLine())) {
                score++;
            }
            i++;
            number++;
        }
        System.out.println("\n" + user.getName() + " " + user.getSurname() + "\n"
                + "Вірних відповідей: " + score + " " + "з можливих " + resourceReader.getRecords().size());
    }

    private String Question() {
        List<String> record = resourceReader.getRecords().get(number);
        return record.get(0) +"\n" + String.join(
                ", ", record.get(1)+ "\n"+ record.get(2)+"\n"+ record.get(3)+"\n"+ record.get(4)) ;
    }

    private boolean checkAnswer(String answer) {
        Pattern pattern = Pattern.compile("[^1234]");
        Matcher matcher = pattern.matcher(answer);
        if (answer.equals("") || matcher.lookingAt()) {
            throw new IllegalArgumentException("Ви ввели невірні данні. Спробуйте Ще!");
        }
            return resourceReader.getRecords().get(number).get(5).equals(answer);
        }
    }



