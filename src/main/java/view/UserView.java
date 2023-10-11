package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) {
                System.out.println("Работа приложения завершена");
                return;
            }
            switch (com) {
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Идентификатор пользователя: ");
                    if (userId.isEmpty()) {
                        throw new RuntimeException("Идентификатор не может быть пустым");
                    } else {
                        userController.updateUser(userId, createUser());
                    }
                    break;
                case DELETE:
                    String del = prompt("Идентификатор пользователя: ");
                    if (del.isEmpty()) {
                        throw new RuntimeException("Идентификатор не может быть пустым");
                    } else {
                        userController.deleteUser(del);
                    }
                    break;
                case LIST:
                    System.out.println(userController.getAllUsers());
                    break;
            }


        }
    }


    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private User createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }


}