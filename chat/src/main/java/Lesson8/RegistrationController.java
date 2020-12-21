package Lesson8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController {

    public TextField login1;
    public TextField password1;
    public TextField email;
    public TextField nickname;


    public String getLogin1() {
        return login1.getText();
    }

    public void setLogin1(TextField login1) {
        this.login1 = login1;
    }

    public String getPassword1() {
        return password1.getText();
    }

    public void setPassword1(TextField password1) {
        this.password1 = password1;
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname.getText();
    }

    public void setNickname(TextField nickname) {
        this.nickname = nickname;
    }

    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        UsersSQLiteDao userDao = new UsersSQLiteDao();
        userDao.updateUser(this);
        Parent auth = FXMLLoader.load(getClass().getResource("auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Вход");
        stage.setScene(new Scene(auth));
        stage.setResizable(false);
        stage.show();
        login1.getScene().getWindow().hide();
    }
}
