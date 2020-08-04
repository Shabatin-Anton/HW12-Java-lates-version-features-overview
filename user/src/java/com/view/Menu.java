package java.com.view;

import java.com.model.User;
import java.com.service.UserService;
import java.com.service.impl.UserServiceImpl;
import java.util.Scanner;

public class Menu {
    private final UserService userService = UserServiceImpl.getInstance();
    Scanner scanner = new Scanner(System.in);
    private final String[] MENU = {"1. New User", "2. Edit User", "3. Delete User",
            "4. Find by All Users", "0. Exit"};

    public void run() {
        loop:
        while (true) {
            showMenu(MENU);
            int count = scanner.nextInt();
            switch (count) {
                case 1 -> newUser();
                case 2 -> editUser();
                case 3 -> deleteUser();
                case 4 -> findByAll();
                case 0 -> {
                    break loop;
                }
            }
        }
    }

    private void newUser() {
        User user = new User();
        System.out.println("Enter Name:");
        user.setName(scanner.nextLine());
        System.out.println("Enter Lastname:");
        user.setLastName(scanner.nextLine());
        System.out.println("Enter Age:");
        user.setAge(Integer.parseInt(scanner.nextLine()));
        userService.create(user);
        System.out.println("Success!");
    }

    private void editUser() {
        System.out.println("Enter Id");

        User user = userService.findById(scanner.nextInt());
        if (user != null) {
            System.out.println("Name: " + user.getName() + ", Enter new");
            user.setName(scanner.nextLine());
            System.out.println("Lastname: " + user.getLastName() + ", Enter new");
            user.setLastName(scanner.nextLine());
            System.out.println("Age: " + user.getAge() + ", Enter new");
            user.setAge(scanner.nextInt());
            userService.update(user);
            System.out.println("User:" + user.getName() + " " + user.getLastName() +
                    " " + user.getAge() + " update!");
        }
    }

    private void deleteUser() {
        System.out.println("Enter id:");
        User user = userService.findById(scanner.nextInt());
        if (user != null) {
            userService.delete(user);
            System.out.println("Deleted");
        } else {
            System.out.println("User does not exist");
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




