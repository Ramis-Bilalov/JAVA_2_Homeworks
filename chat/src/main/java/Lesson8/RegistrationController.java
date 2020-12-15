package Lesson8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    public TextField login1;
    public TextField password1;

    public void enter(ActionEvent actionEvent) throws IOException {
        MockAuthServiceImpl.getInstance().addUser(login1.getText(), password1.getText());
        Parent chat = FXMLLoader.load(getClass().getResource("auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Вход");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login1.getScene().getWindow().hide();
    }
}
