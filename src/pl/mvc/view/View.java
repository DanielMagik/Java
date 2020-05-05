package pl.mvc.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * View class. GUI. Contains fields with input and output data.
 *
 * @author Daniel Tarnecki
 * @version 1.0.2, 03/10/20
 */
public class View extends javax.swing.JFrame 
{
    private boolean isHide;
    private boolean saveHistory;
    private DefaultTableModel tableModel;
    private ActionList actionList;
    
    /**
     * Constructor. Creates new form View.
     */
    public View() 
    {
        initComponents();
        isHide = false;
        saveHistory = true;
        tableModel = (DefaultTableModel) this.Table.getModel();
        actionList = new ActionList();
    }
    
    /**
     * Deleting all rows from table.
     */
    private void clearTable()
    {
        int rowCount = tableModel.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                tableModel.removeRow(i);
            }
    }

    /**
     * Getter that returns plain text.
     *
     * @return plain text
     */
    public String getPlainText() 
    {
        return plainText.getText();
    }

    /**
     * Getter that returns shift
     *
     * @return shift
     */
    public String getShift() 
    {
        return shift.getText();
    }

    /**
     * Getter that returns type of action (encryption or decryption).
     *
     * @return true(if encryption) or false (if decryption).
     */
    public boolean getAction() 
    {
        if (encryptionRadioButton.isSelected()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    /**
     * Getter that returns processed text.
     *
     * @param resultText processed text
     */
    public void setResult(String resultText) 
    {
        result.setText(resultText);
    }
    
    /**
     * Adding a row to table and element to list.
     * 
     * @param operationType operation type
     * @param shift shift
     * @param plainText plain text
     * @param outputText output text 
     */
    public void addRow(String operationType, String shift, String plainText, String outputText)
    {
        if (saveCheckBox.isSelected()) 
        {
            Action actionElement = new Action();
            actionElement.setPlainText(plainText);
            actionElement.setShift(shift);
            actionElement.setActionType(operationType);
            actionElement.setResult(outputText);
            actionList.AddElement(actionElement);
            if (isHide == false) 
            {
                tableModel.insertRow(0,
                        new Object[]{operationType, shift, plainText, outputText});
            }

        }
    }
    

    /**
     * Adding a listener, that checks if the "Perform" button has been pressed.
     *
     * @param listenForPerformmButton listener
     */
    public void addPerformListener(ActionListener listenForPerformmButton) 
    {
        performButton.addActionListener(listenForPerformmButton);
    }

    /**
     * Creating a popup, that displays error message.
     *
     * @param errorMessage error message
     */
    public void displayErrorMessage(String errorMessage) 
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plainText = new javax.swing.JTextField();
        shift = new javax.swing.JTextField();
        performButton = new javax.swing.JButton();
        result = new javax.swing.JTextField();
        encryptionRadioButton = new javax.swing.JRadioButton();
        decryptionRadioButton = new javax.swing.JRadioButton();
        plainTextLabel = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        HideButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        saveCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caesar Cipher");

        plainText.setText("Hello world!");

        shift.setText("13");

        performButton.setText("Perform");

        encryptionRadioButton.setSelected(true);
        encryptionRadioButton.setText("encryption");
        encryptionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionRadioButtonActionPerformed(evt);
            }
        });

        decryptionRadioButton.setText("decryption");
        decryptionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionRadioButtonActionPerformed(evt);
            }
        });

        plainTextLabel.setText("Plain Text:");

        shiftLabel.setText("Shift:");

        resultLabel.setText("Result:");

        HideButton.setText("Hide History");
        HideButton.setBorderPainted(false);
        HideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HideButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete history");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operation type", "Shift", "Input text", "Output text"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(1).setMinWidth(30);
            Table.getColumnModel().getColumn(1).setPreferredWidth(30);
            Table.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        saveCheckBox.setSelected(true);
        saveCheckBox.setText("Save history");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HideButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plainTextLabel)
                            .addComponent(plainText, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shiftLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(shift, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(performButton)
                                .addGap(18, 18, 18)
                                .addComponent(encryptionRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(decryptionRadioButton))
                            .addComponent(resultLabel))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plainTextLabel)
                .addGap(5, 5, 5)
                .addComponent(plainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(shiftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(performButton)
                    .addComponent(encryptionRadioButton)
                    .addComponent(decryptionRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultLabel)
                .addGap(2, 2, 2)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HideButton)
                    .addComponent(saveCheckBox)
                    .addComponent(DeleteButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Function supports radio buttons. Only 1 can be selected.
     *
     * @param evt action performed in encryption radio button
     */
    private void encryptionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionRadioButtonActionPerformed
        // TODO add your handling code here:

        if (encryptionRadioButton.isSelected() == false) 
        {
            encryptionRadioButton.setSelected(true);
        } 
        else 
        {
            decryptionRadioButton.setSelected(false);
        }
    }//GEN-LAST:event_encryptionRadioButtonActionPerformed

    /**
     * Function supports radio buttons. Only 1 can be selected.
     *
     * @param evt action performed in decryption radio button
     */
    private void decryptionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionRadioButtonActionPerformed
        // TODO add your handling code here:
        if (encryptionRadioButton.isSelected()) 
        {
            encryptionRadioButton.setSelected(false);
        } 
        else 
        {
            decryptionRadioButton.setSelected(true);
        }

    }//GEN-LAST:event_decryptionRadioButtonActionPerformed
    /**
     * Function supports hide or show history button. Changes the text on button
     * and hides or shows rows in table.
     *
     * @param evt action performed in button
     */
    private void HideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HideButtonActionPerformed
        // TODO add your handling code here:
        if (isHide == false) 
        {
            
            HideButton.setText("Show history");
            clearTable();
        }
        else
        {
            HideButton.setText("Hide history");
            List<Action> copyOfList =  new ArrayList<>();
            copyOfList = actionList.getList();
            for (Action actionElement : copyOfList)
            {
                tableModel.insertRow(0, 
                new Object [] {actionElement.getActionType(), actionElement.getShift(),
                actionElement.getPlainText(), actionElement.getResult()});
            }
            
        }
        isHide = !isHide;
    }//GEN-LAST:event_HideButtonActionPerformed
    /**
     * Function supports delete history button. Deletes all rows from table and
     * all elementf from list.
     *
     * @param evt action performed in button
     */
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        actionList.ClearList();
        clearTable();
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton HideButton;
    private javax.swing.JTable Table;
    private javax.swing.JRadioButton decryptionRadioButton;
    private javax.swing.JRadioButton encryptionRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton performButton;
    private javax.swing.JTextField plainText;
    private javax.swing.JLabel plainTextLabel;
    private javax.swing.JTextField result;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JCheckBox saveCheckBox;
    private javax.swing.JTextField shift;
    private javax.swing.JLabel shiftLabel;
    // End of variables declaration//GEN-END:variables
}
