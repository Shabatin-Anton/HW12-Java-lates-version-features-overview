package java.com.view;

import java.com.model.User;
import java.com.service.UserService;
import java.com.service.impl.UserServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    private UserService userService = UserServiceImpl.getInstance();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String[] MENU = {"1. New User", "2. Edit User", "3. Delete User",
            "4. Find by All Users", "0. Exit"};
    private String INCORRECT = "Please, Try again!";

    public void run() {
        loop:
        while (true) {
            try {
                showMenu(MENU);
                int count = Integer.parseInt(reader.readLine());
                switch (count) {
                    case 1 -> newUser();
                    case 2 -> editUser();
                    case 3 -> deleteUser();
                    case 4 -> findByAll();
                    case 0 -> {
                        break loop;
                    }
                }
            } catch (NullPointerException | NumberFormatException | IOException exception) {
                System.out.println(INCORRECT);
                run();
            }
        }
    }

    private void newUser() {
        User user = new User();
        try {
            System.out.println("Enter Name:");
            user.setName(reader.readLine());
            System.out.println("Enter Lastname:");
            user.setLastName(reader.readLine());
            System.out.println("Enter Age:");
            user.setAge(Integer.parseInt(reader.readLine()));
            userService.create(user);
            System.out.println("Success!");
        } catch (NullPointerException | NumberFormatException | IOException exception) {
            System.out.println(INCORRECT);
            newUser();
        }
    }

    private void editUser() {
        System.out.println("Enter Id");
        try {
            User user = userService.findById(Integer.parseInt(reader.readLine()));
            if (user != null) {
                System.out.println("Name: " + user.getName() + ", Enter new");
                user.setName(reader.readLine());
                System.out.println("Lastname: " + user.getLastName() + ", Enter new");
                user.setLastName(reader.readLine());
                System.out.println("Age: " + user.getAge() + ", Enter new");
                user.setAge(Integer.parseInt(reader.readLine()));
                userService.update(user);
                System.out.println("User:" + user.getName() + " " + user.getLastName() +
                        " " + user.getAge() + " update!");
            }
        } catch (NullPointerException | NumberFormatException | IOException exception) {
            System.out.println(INCORRECT);
            editUser();
        }
    }

    private void deleteUser() {
        System.out.println("Enter id:");
        try {
            User user = userService.findById(Integer.parseInt(reader.readLine()));
            if (user != null) {
                userService.delete(user);
                System.out.println("Deleted");
            } else {
                System.out.println("User does not exist");
            }
        } catch (NullPointerException | NumberFormatException | IOException exception) {
            System.out.println(INCORRECT);
            deleteUser();
        }
    }

    private void findByAll() {
        userService.findAll().forEach(System.out::println);
    }

    private void showMenu(String[] strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }
}




