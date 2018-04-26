/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturation;

import facturation.entities.Ligne;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author tayeb
 */
public class QantiteCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
   protected JTextField quantiteJTF;
   protected Border bordure;
   
   protected Integer quantite;
   protected Integer quantiteStock;
   
    public QantiteCellEditor() {
        super();
        this.bordure = BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 128) ));
        quantite = 0;
        quantiteJTF = new JTextField();
        quantiteJTF.addActionListener(this);
        quantiteJTF.setBorder(bordure);
    }
@Override
public void actionPerformed(ActionEvent e) {
        
            try{
                 quantite = Integer.parseInt(quantiteJTF.getText());
                 if(quantiteStock >= quantite)
                 {
                     fireEditingStopped();
                 }
                 else
                 {
                     //JDialog.setDefaultLookAndFeelDecorated(true);
                     String erreur = "quantite insufisante "+quantiteStock ;
                     System.out.println("erreur :" + erreur);
                     quantite=2; 
                     fireEditingStopped();
                  
                 }
            }
            catch(NumberFormatException ex)
            {
               quantiteJTF.setBackground(Color.red);
               quantiteJTF.setForeground(Color.white);
            }
                        


}
@Override
public Object getCellEditorValue() {
return quantite;
}
@Override
public Component getTableCellEditorComponent(JTable table, Object value, boolean
isSelected, int row, int column) {
    
    LigneTableModel model = (LigneTableModel) table.getModel();
    
    List<Ligne> lignes = model.getLignes();
    
    for(Ligne l : lignes)
    {
        
       if(l.getPiece().getId_piece().equals(model.getValueAt(row,0)))
           this.quantiteStock = l.getPiece().getQuantite();
    
    }
    
    System.out.println(" row "+row );
    System.out.println(" column "+column );
    System.out.println("value"+ value );
    return quantiteJTF;
}

    
}
