/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mvc.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for model.
 *
 * @author Daniel Tarnecki
 * @version 1.0.0, 02/05/20
 */
public class ModelTest 
{
    private Model instance;
    private String plainText;
    private String shift;
    private boolean action;
    private String expectedResult;
    public ModelTest() 
    {
        plainText = "";
        shift = "";
        action = true;
    }
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        instance = new Model();
    }
    
    @After
    public void tearDown() 
    {
    }

    /**
     * Test of prepareEanryption method, of class Model.
     * @throws pl.mvc.model.EncryptingException
     */
    @Test(expected=NullPointerException.class)
    public void testPrepareEncryptionNullModel() throws EncryptingException
    {
        instance = null;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=NullPointerException.class)
    public void testPrepareEncryptionNullPlainText() throws EncryptingException
    {
        plainText=null;
        shift = "12";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionNullShift() throws EncryptingException
    {
        plainText="Hello world!";
        shift = null;
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionNullAll() throws EncryptingException
    {
        plainText=null;
        shift = null;
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionEmptyText() throws EncryptingException
    {
        plainText="";
        shift = "12";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionBadShift() throws EncryptingException
    {
        plainText="Hello";
        shift = "1asd2";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionTooSmallShift() throws EncryptingException
    {
        plainText="Hello";
        shift = "0";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test(expected=EncryptingException.class)
    public void testPrepareEncryptionTooGreatShift() throws EncryptingException
    {
        plainText="Hello";
        shift = "100";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
    }
    @Test
    public void testPrepareEncryptionHelloWorld() throws EncryptingException
    {
        expectedResult = "Uryyb jbeyq!";
        plainText="Hello world!";
        shift = "13";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
        assertEquals(instance.getResult(),expectedResult);
    }
    @Test
    public void testPrepareEncryptionHello() throws EncryptingException
    {
        expectedResult = "Olssv dvysk!";
        plainText="Hello world!";
        shift = "7";
        action = true;
        instance.prepareEanryption(plainText, shift, action);
        assertEquals(instance.getResult(),expectedResult);
    }
    @Test
    public void testPrepareEncryptionHelloFalse() throws EncryptingException
    {
        expectedResult = "Olssv dvysk!";
        plainText="Hello world!";
        shift = "19";
        action = false;
        instance.prepareEanryption(plainText, shift, action);
        assertEquals(instance.getResult(),expectedResult);
    }
    
    
    
    
}
