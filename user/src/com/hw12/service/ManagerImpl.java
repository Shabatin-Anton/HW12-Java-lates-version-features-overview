package com.hw12.service;

import com.hw12.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerImpl implements Manager{
    private final static String USER_NAME = "Please enter user name";
    private final static String USER_POSITION = "Please enter user position";
    private final static String CHANGES = "Changes have been made to the system";
    Scanner scanner = new Scanner(System.in);
    List<User> list = new ArrayList<>();

    @Override
    public void saveUser() {
        String name;
        String position;
        System.out.println(USER_NAME);
        name = scanner.next();
        System.out.println(USER_POSITION);
        position = scanner.next();
        System.out.println(CHANGES);
        list.add(new User(name, position));
    }

    @Override
    public void updateUser() {
        User user;
        getAllUsers();
        System.out.println("Choose user's number to update");
        var number = scanner.nextInt();
        user = list.get(number - 1);
        System.out.println("Please enter to change" + "\n1. User name" + "\n2. User position");
        var number2 = scanner.nextInt();
        if (number2 == 1) {
            updateUserName(user);
        } else if (number2 == 2) {
            updateUserPosition(user);
        }
    }

    @Override
    public void getAllUsers() {
        var i = 1;
        for (User user : list) {
            System.out.println(i + ": " + user);
            i++;
        }
    }

    private void updateUserName(User user) {
        System.out.println(USER_NAME);
        user.setName(scanner.next());
        System.out.println(CHANGES);
    }

    private void updateUserPosition(User user) {
        System.out.println(USER_POSITION);
        user.setPosition(scanner.next());
        System.out.println(CHANGES);
    }

    @Override
    public void deleteUser() {
        getAllUsers();
        System.out.println("Choose user's number to delete");
        int count = scanner.nextInt();
        for (var i = 0; i < list.size(); i++) {
            if (count == i + 1) {
                list.remove(i);
            }
        }
        System.out.println(CHANGES);
    }
}
