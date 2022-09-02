package com.zdotavv.homework1_enterprise.Service;

import com.zdotavv.homework1_enterprise.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Getter
@Setter
public class UserService {
    private User user;

    public void userNameAndSurname() {
        System.out.println("\n"+"***ВАС ВІТАЄ ФУТБОЛЬНА ВІКТОРИНА***");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вкажіть ваше ім'я:");
        user.setName(scanner.nextLine());
        checkIfCorrect(user.getName());

        System.out.println("Вкажіть ваше прізвище:");
        user.setSurname(scanner.nextLine());
        checkIfCorrect(user.getSurname());
    }

    private void checkIfCorrect(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        if (string.equals("") || matcher.lookingAt()) {
            throw new IllegalArgumentException("Невірні данні. Спробуй Ще!");
        }

    }
}
