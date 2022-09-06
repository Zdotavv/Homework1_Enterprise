package com.zdotavv.homework1_enterprise.Service;

import com.zdotavv.homework1_enterprise.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class UserServiceImpl implements UserService {
    private User user;

    public void userNameAndSurname() {
        System.out.println("\n"+"***ВАС ВІТАЄ ФУТБОЛЬНА ВІКТОРИНА***");
        Scanner scanner = new Scanner(System.in);
        boolean isFilled = false;
        while (!isFilled) {
            System.out.println("Введіть ваше ім'я: ");
            user.setName(scanner.nextLine());
            System.out.println("Введіть ваше прізвище: ");
            user.setSurname(scanner.nextLine());
            if (isInputNotEmpty()) {
                isFilled = true;
            } else {
                System.out.println("Поля Ім'я та Фамілія не можуть бти пустими!");
            }
        }
    }

    public boolean isInputNotEmpty() {
        return !user.getName().isEmpty() && !user.getSurname().isEmpty();
    }

}
