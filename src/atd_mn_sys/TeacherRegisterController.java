
package atd_mn_sys;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.sql.DriverManager;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TeacherRegisterController implements Initializable {
    @FXML
    private GridPane root;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private Button registerbutton;
    @FXML
    private Button backlogin;
    @FXML
    private Label status;
    @FXML
    private TextField PID;
    @FXML
    private TextField name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void userRegister(ActionEvent event) {
        String u = name.getText();
        String PPID = PID.getText();
        String p = password.getText();

        if(u.isEmpty()){
            status.setText("Username cannot be empty");
        }else if(p.isEmpty()){
            status.setText("Password cannot be empty");
        }else if(!p.equals(confirmpassword.getText())){
            status.setText("Passwords not same");
        }else{

            try {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attd_mng_sys?zeroDateTimeBehavior=convertToNull","root","");
                String query = "INSERT INTO teacher(`Name`, `Password`,`PID`)" +
                        "VALUES ('%s','%s','%s')";
                con.createStatement().executeUpdate(
                        String.format(query, u, p, PPID)
                );
                status.setText("Registration successful");
            } catch (SQLException e) {
                status.setText("Error occurred");
                e.printStackTrace();
            }

        } 
    }

    @FXML
    private void back2login(ActionEvent event) {
        try{
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();            
            currentStage.close();
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TeacherLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
