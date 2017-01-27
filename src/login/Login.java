/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * @author greg.swank
 */
public class Login extends Application {
    String myUserName = "dog20aol";
    String myPassword = "Yamaha#1";
    
@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX Welcome");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(20);
    grid.setVgap(20);
    grid.setPadding(new Insets(25, 25, 25, 25));
    
    Text scenetitle = new Text("Welcome");
    scenetitle.setId("welcome-text");
    grid.add(scenetitle, 0, 0, 2, 1);
    
    Label userName = new Label("User Name:");
    grid.add(userName, 0, 1);
    
    TextField userTextField = new TextField();
    userTextField.setId("textField");
    grid.add(userTextField, 1, 1);
    
    Label pw = new Label("Password:");
    grid.add(pw, 0, 2);
    
    PasswordField pwBox = new PasswordField();
    pwBox.setId("textField");
    grid.add(pwBox, 1, 2);
    
    Button btn = new Button("Sign in");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 1, 4);
    
    final Text actiontarget = new Text();
    grid.add(actiontarget, 1, 6);
    actiontarget.setId("actiontarget");
    
    btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) { 
            String thisUserName = null;
            String thisPassword = null;
            if ((userTextField.getText() != null && !userTextField.getText().isEmpty())){
                thisUserName = userTextField.getText();
            } 
            if ((pwBox.getText() != null && !pwBox.getText().isEmpty())){
                thisPassword = pwBox.getText();
            }
            actiontarget.setText(setMessage(thisUserName,thisPassword));
        }
    });
    
    grid.setGridLinesVisible(false);
    
    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());

    primaryStage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    protected boolean checkCreds(String userName, String password){
        return checkName(userName) && checkPW(password);
    }
    
    protected boolean checkName(String userName){
        return userName.equals(myUserName);
    }
    
    protected boolean checkPW(String password){
        return password.equals(myPassword);
    }
    
    protected String setMessage(String userName, String password){
        if (userName==null){
            return "Please enter a username";
        } else if (password==null){
            return "Please enter a password";
        } else if (checkCreds(userName,password)){
            return "Welcome Greg!";
        } else {
            return "Bad Monkey!";
        }
    }
}
