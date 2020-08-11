package main.java.com.hw12.executor;

import com.hw12.service.Manager;
import com.hw12.service.ManagerImpl;

import java.util.Scanner;

public class Executor {
    Scanner scanner = new Scanner(System.in);
    private Manager manager = new ManagerImpl();
    private final String[] MANAGER_MENU =
            {"1. Save user" + "\n2. Update user" + "\n3. Delete user"
                    + "\n4. Users list" + "\n5. Exit program"};

    private static final String INCORRECT_INPUT = "Incorrect input. Please try again";

    public void printManagerMenu() {
        int choise = 0;
        while (true) {
            printMenu(MANAGER_MENU);
            try {
                choise = scanner.nextInt();
            } catch (NumberFormatException u) {
                System.out.println(INCORRECT_INPUT);
                printManagerMenu();
            }
            switch (choise) {
                case 1:
                    manager.saveUser();
                    break;
                case 2:
                    manager.updateUser();
                    break;
                case 3:
                    manager.deleteUser();
                    break;
                case 4:
                    manager.getAllUsers();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private void printMenu(String[] manager_menu) {
        for (String menu : manager_menu) {
            System.out.println(menu);
        }
    }
}
