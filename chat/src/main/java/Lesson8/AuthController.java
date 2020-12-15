package Lesson8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AuthController {

    public TextField login;
    public TextField password;

    public void enter(ActionEvent actionEvent) throws IOException {
        boolean auth = MockAuthServiceImpl.getInstance()
                .auth(login.getText(), password.getText());
        if (auth) {
            System.out.println("правильный пароль");
            Parent chat = FXMLLoader.load(getClass().getResource("chat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Сетевой чат");
            stage.setScene(new Scene(chat));
            stage.setResizable(false);
            stage.show();
            login.getScene().getWindow().hide();
        } else {
            System.out.println("неправильный пароль");
            login.clear();
            login.setPromptText("WRONG LOGIN");
            password.clear();
            password.setPromptText("WRONG PASSWORD");
        }
    }

    public void reg(ActionEvent actionEvent) throws IOException {
        //MockAuthServiceImpl.getInstance().addUser(login.getText(), password.getText());
        Parent chat = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }
}
