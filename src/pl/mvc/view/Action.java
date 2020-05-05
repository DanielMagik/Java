package pl.mvc.view;

/**
 * Element of the list. Contains shift, action type, plain text and result.
 *
 * @author Daniel Tarnecki
 * @version 1.0.0, 03/10/20
 */
class Action 
{

    private String shift;
    private String actionType;
    private String plainText;
    private String result;
    
    /**
     * Setter that sets shift.
     * 
     * @param shift shift
     */
    void setShift(String shift) 
    {
        this.shift = shift;
    }
    
    /**
     * Setter that sets action type. 
     * 
     * @param actionType encryption or decryption
     */
    void setActionType(String actionType) 
    {
        this.actionType = actionType;
    }
    
    /**
     * Setter that sets plain text
     * 
     * @param plainText plain text
     */
    void setPlainText(String plainText) 
    {
        this.plainText = plainText;
    }
    
    /**
     * Setter that sets result.
     * 
     * @param result result
     */
    void setResult(String result)
    {
        this.result = result;
    }
    
    /**
     * Getter that returns shift.
     * 
     * @return shift
     */
    String getShift() 
    {
        return shift;
    }
    
    /**
     * Getter that returns action type.
     * 
     * @return action type
     */
    String getActionType() 
    {
        return actionType;
    }
    
    /**
     * Getter that returns plain text.
     * 
     * @return plain text
     */
    String getPlainText() 
    {
        return plainText;
    }
    
    /**
     * Gettet that returns result.
     * 
     * @return result
     */
    String getResult() 
    {
        return result;
    }
    
    
}
