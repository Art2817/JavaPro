package dz18;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Artem1", "Artem@gmail.com"));
        users.add(new User(2, "Artem2", "ACh@gmail.com"));
        users.add(new User(3, "Artem3", "Chere@gmail.com"));
        users.add(new User(4, "Artem4", "Art@gmail.com"));
    }

    // Метод findUserById(int id), який повертає Optional<User> з користувачем за вказаним id.
    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    /* Метод findUserByEmail(String email),
    який повертає Optional<User> з користувачем за вказаною електронною поштою. */
    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    // Метод findAllUsers(), який повертає список всіх користувачів у вигляді Optional<List<User>>.
    public Optional<List<User>> findAllUsers() {
        if (users.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(users);
        }
    }
}