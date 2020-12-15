package Lesson8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea output;
    public TextField input;
    public TextField chatName;
    private String userName;
    private CharReader reader;


    public TextField getChatName() {
        return chatName;
    }

    public String getUserName() {
        return userName;
    }

    public void send(ActionEvent actionEvent) throws IOException {
        if(userName.endsWith("1")) {
            NetworkService.getInstance()
                    .write(Message.of(userName, input.getText()));
        } else {
            NetworkService.getInstance()
                    .write(Message.of(userName, input.getText()));
        }

        input.clear();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Вход");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        input.getScene().getWindow().hide();
        FileHistoryService.getInstance().save(
                Arrays.asList(output.getText().split("\n").clone()));
//        reader.setDaemon(true);
//        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName = NetworkService.getInstance().getUserName();
        reader = new CharReader(output, NetworkService.getInstance().getInputStream());
        output.setWrapText(true);
        reader.start();
    }
}