package Lesson8;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

public class UsersSQLiteDao implements UserDao, Closeable {

    private Connection connection;
    private Statement statement;
    private String nickname;



    public UsersSQLiteDao() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:chatDB");
        statement = connection.createStatement();
    }

    @Override
    public boolean userExists(String login, String password) throws SQLException {
        String sql1 = String.format("SELECT NAME FROM USERS WHERE LOGIN = '%s'", login);
        ResultSet rs1 = statement.executeQuery(sql1);
        setNickname(rs1.getString("NAME"));
        if(rs1.next()) {
            String sql2 = String.format("SELECT LOGIN FROM USERS WHERE PASSWORD = '%s'", password);
            ResultSet rs2 = statement.executeQuery(sql2);

            return rs2.next();
        } return false;
    }

    @Override
    public String getNickname() {
        System.out.println("ниунейм" + nickname);
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    @Override
    public void updateUser(RegistrationController controller) throws SQLException {
        String sql;
        sql = String.format("INSERT INTO USERS(login, password, name, email) " +
                            "VALUES('%s', '%s', '%s', '%s')",
                    controller.getLogin1(),
                    controller.getPassword1(),
                    controller.getNickname(),
                    controller.getEmail());
        statement.execute(sql);
    }

    @Override
    public void close() throws IOException {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
