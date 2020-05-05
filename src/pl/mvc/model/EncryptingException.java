package pl.mvc.model;

/**
 * Exception class, thrown in case of bad input data.
 *
 * @author Daniel Tarnecki
 * @version 1.0.0, 03/07/20
 */
public class EncryptingException extends Throwable 
{

    private String errorMessage;

    /**
     * Constructor, it sets error message.
     *
     * @param errorMessage error message
     */
    public EncryptingException(String errorMessage) 
    {
        this.errorMessage = errorMessage;
    }

    /**
     * Gettet that returns error message
     *
     * @return error message
     */
    public String getErrorMessage() 
    {
        return errorMessage;
    }

}
