
package atd_mn_sys;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onTeacher(ActionEvent event) {
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
    //WINDOW CLOSE HORAHI HAI NA yES BRO OK
    @FXML
    private void onStudent(ActionEvent event) {
        try{

            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();            
            currentStage.close();
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
