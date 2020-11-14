package Lesson1.classwork1;

import Lesson1.classwork1.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);

    void addUser(User user);

    List<User> getUsers();
}
