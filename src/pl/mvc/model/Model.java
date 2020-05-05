package pl.mvc.model;

/**
 * Model class, validates input data, throws a possible exception and performs
 * encryption.
 *
 * @author Daniel Tarnecki
 * @version 1.0.1, 03/07/20
 */
public class Model 
{

    private String result;
    private int shift;
    private boolean action;

    /**
     * Function validates input data and calls the method that performs the
     * encryption.
     *
     * @param plainText plait next
     * @param shift shift
     * @param action encryption or decryption
     * @throws EncryptingException is thrown when a wrong shift or no text is
     * given
     */
    public void prepareEanryption(String plainText, String shift, boolean action) throws EncryptingException 
    {
        try 
        {
            this.action = action;
            this.shift = Integer.parseInt(shift);
            //bad shift
            if (this.shift <= 0) 
            {

                EncryptingException ex = new EncryptingException("Shift must be greather than 0!");
                throw ex;
            } 
            else if (this.shift >= 26) 
            {
                EncryptingException ex = new EncryptingException("Shift must be less than 26!");
                throw ex;
            } //no text
            else if (plainText.length() == 0) 
            {

                EncryptingException ex = new EncryptingException("Type some text!");
                throw ex;
            }
            //encryption
            if (action == true) 
            {
                performEncryption(plainText, this.shift);
            } //decryption
            else 
            {
                performEncryption(plainText, 26 - this.shift);
            }
        } //shift is not an integer
        catch (NumberFormatException e) 
        {
            EncryptingException ex = new EncryptingException("Shift must be an integer!");
            throw ex;
        }
    }

    /**
     * Method performs the encryption.
     *
     * @param plainText plain text
     * @param shift shift
     */
    private void performEncryption(String plainText, int shift) 
    {
        //buffer for encrypted text
        char x[] = plainText.toCharArray();
        //index of char in ASCII
        int charIndex;
        //loop to process each character of text
        for (int i = 0; i != x.length; i++) 
        {
            charIndex = x[i];
            if (charIndex >= 65 && charIndex <= 90)//big letters
            {
                //encryption don't exceeds the alphabet range (letter Z)
                if (charIndex + shift <= 90) {
                    charIndex += shift;
                } //encryption exceeds the alphabet range (letter Z)
                else 
                {
                    charIndex = charIndex + shift - 26;
                }
            } 
            else if (charIndex >= 97 && charIndex <= 122)//small letters
            {
                //encryption don't exceeds the alphabet range (letter z)
                if (charIndex + shift <= 122) 
                {
                    charIndex += shift;
                } //encryption exceeds the alphabet range (letter z)
                else 
                {
                    charIndex = charIndex + shift - 26;
                }
            }
            //setting a new letter in bufor
            x[i] = (char) charIndex;
        }
        //returning encrypted text
        this.result = new String(x);
    }

    /**
     * Getter that returns encrypted text.
     *
     * @return encrypted text
     */
    public String getResult() 
    {
        return this.result;
    }

}
