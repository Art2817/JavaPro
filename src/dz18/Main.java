package dz18;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

        // a. Пошук користувача за id.
        Optional<User> userById = repository.findUserById(1);
        userById.ifPresentOrElse(
                user -> System.out.println("Found by ID: " + user),
                () -> System.out.println("User not found by ID")
        );

        // b. Пошук користувача за email.
        Optional<User> userByEmail = repository.findUserByEmail("Art@gmail.com");
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Found by Email: " + user),
                () -> System.out.println("User not found by Email")
        );

        // c. Отримання списку всіх користувачів
        Optional<List<User>> allUsers = repository.findAllUsers();
        allUsers.ifPresentOrElse(
                list -> System.out.println("Total users: " + list.size()),
                () -> System.out.println("No users found")
        );
    }
}
