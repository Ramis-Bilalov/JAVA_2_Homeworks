package Lesson8;

import java.sql.SQLException;

public interface UserDao {

    boolean userExists(String login, String password) throws SQLException;

    String getNickname();

    void setNickname(String nickname);

    void updateUser(RegistrationController controller) throws SQLException;
}
