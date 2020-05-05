package pl.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import pl.mvc.model.Model;
import pl.mvc.model.EncryptingException;
import pl.mvc.view.View;

/**
 * The Controller. Coordinates interactions between the View and Model.
 *
 * @author Daniel Tarnecki
 * @version 1.0.0, 03/07/20
 */
public class Controller 
{

    private View theView;
    private Model theModel;

    /**
     * Constructor of Controller class.
     *
     * @param theView view
     * @param theModel model
     */
    public Controller(View theView, Model theModel) 
    {
        this.theView = theView;
        this.theModel = theModel;

        // Tell the View that when ever the perform button
        // is clicked to execute the actionPerformed method
        // in the PerformListener inner class
        this.theView.addPerformListener(new PerformListener());
    }

    /**
     * Class contains the method in case listener detects the action.
     *
     * @author Daniel Tarnecki
     * @version 1, 03/07/20
     */
    class PerformListener implements ActionListener 
    {

        /**
         * Method in case listener detects the action
         *
         * @param e event
         */
        public void actionPerformed(ActionEvent e) 
        {
            String plainText;
            String shift;
            boolean action;

            // Surround interactions with the view with
            // a try block in case of bad input data.
            plainText = theView.getPlainText();
            shift = theView.getShift();
            action = theView.getAction();
            try 
            {
                theModel.prepareEanryption(plainText, shift, action);
                theView.setResult(theModel.getResult());
                theView.addRow(action ? "Encryption" : "Decryption", 
                        shift, plainText,theModel.getResult() );
                
            } 
            catch (EncryptingException ex) 
            {
                System.out.println(ex);
                theView.displayErrorMessage(ex.getErrorMessage());
            }
        }
    }
}
