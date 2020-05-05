import pl.mvc.controller.Controller;
import pl.mvc.model.Model;
import pl.mvc.view.View;

/**
 * Class contains model, view, controller and main function.
 * 
 * @author Daniel Tarnecki
 * @version 1.0.0, 03/07/20
 */
public class MVC 
{
    /**
     * Main function. Creates model, view and controller.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {
    	View theView = new View();
    	Model theModel = new Model();
        Controller theController = new Controller(theView,theModel);
        theView.setVisible(true);
        
    }
}