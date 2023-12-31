import atd_mn_sys.RegisterController;
import java.io.IOException;
import org.junit. Test;
import org.junit. Ignore;
import static org.junit.Assert.assertEquals;

public class RegisterControllerTest  {

    @Test
    public void testRegistrationSuccessful() {
        RegisterController controller = new RegisterController();

        controller.name.setText("John Doe");
        controller.PID.setText("12345");
        controller.password.setText("password");
        controller.confirmpassword.setText("password");

        // Trigger the registration action
        controller.userRegister(null);

        // Check if the status label shows "Registration successful"
        assertEquals("Registration successful", controller.status.getText());
    }

    @Test
    public void testEmptyName() {
        RegisterController controller = new RegisterController();

        controller.name.setText("");
        controller.PID.setText("12345");
        controller.password.setText("password");
        controller.confirmpassword.setText("password");

        // Trigger the registration action
        controller.userRegister(null);

        // Check if the status label shows "Name cannot be empty"
        assertEquals("Name cannot be empty", controller.status.getText());
    }

    @Test
    public void testEmptyPassword() {
        RegisterController controller = new RegisterController();

        controller.name.setText("John Doe");
        controller.PID.setText("12345");
        controller.password.setText("");
        controller.confirmpassword.setText("password");

        // Trigger the registration action
        controller.userRegister(null);

        // Check if the status label shows "Password cannot be empty"
        assertEquals("Password cannot be empty", controller.status.getText());
    }

    @Test
    public void testPasswordsNotSame() {
        RegisterController controller = new RegisterController();

        controller.name.setText("John Doe");
        controller.PID.setText("12345");
        controller.password.setText("password1");
        controller.confirmpassword.setText("password2");

        // Trigger the registration action
        controller.userRegister(null);

        // Check if the status label shows "Passwords not same"
        assertEquals("Passwords not same", controller.status.getText());
   
    }

    
    @Test
    public void testMain() throws IOException {
        System.out.println("main");

    }
    
    public static void main(String srgd[]){
        
    }
}
