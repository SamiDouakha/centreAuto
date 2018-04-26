/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturation;


import facturation.entities.Piece;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tayeb
 */
public class PieceTableModel  extends AbstractTableModel{
    
    protected List<Piece> pieces = new ArrayList<>();
    
    protected  String[] entetes = {"N°","Référence", "Marque","Designation","Prix achat","Prix vente","Quantité"};

    public String[] getEntetes() {
        return entetes;
    }

    public void setEntetes(String[] entetes) {
        this.entetes = entetes;
    }

    public PieceTableModel() {
    
                     this.pieces = new ArrayList<>();
    }
    
    public PieceTableModel(List<Piece> pieces) {
            System.out.println(pieces.size());
            this.pieces = pieces;
    }
    
    
    @Override
    public int getRowCount() {
        return pieces.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return entetes[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return pieces.get(rowIndex).getId_piece();
            case 1:
                return pieces.get(rowIndex).getReference();
        
            case 2:
                 return pieces.get(rowIndex).getMarque();
            case 3:
                 return pieces.get(rowIndex).getDesignation();
            case 4:
                 return pieces.get(rowIndex).getPrixAchat();
            case 5:
                 return pieces.get(rowIndex).getPrixVente();
            case 6:
                 return pieces.get(rowIndex).getQuantite();
            
            default:
                 throw new IllegalArgumentException();
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        switch(columnIndex)
        {
        
            case 0:
            return Long.class;
        
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Double.class;
            case 5:
                return Double.class;
            case 6:
                return Integer.class;
            default:
                return Object.class;
        }
    }
    
    public void addPiece(Piece piece){
        pieces.add(piece);
        fireTableRowsInserted(pieces.size() -1, pieces.size() -1);
    }   
    
    public void removePiece(int rowIndex){
        pieces.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules éditables
        }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if(aValue != null)
            {
                Piece p = pieces.get(rowIndex);
                switch(columnIndex){
                
                case 0:
                    p.setId_piece((Long)aValue);
                break;
                
                case 1:
                    p.setReference((String)aValue);
                break;
                
                case 2:
                    p.setMarque((String)aValue);
                break;
                
                case 3:
                    p.setDesignation((String)aValue);
                break;
                
                case 4:
                     p.setPrixAchat((Double)aValue);
                break;
                
                case 5:
                    p.setPrixVente((Double)aValue);
                break;
                
                case 6:
                    p.setQuantite((Integer)aValue);
                break;
                
                
                
                
            }
            this.fireTableRowsUpdated(rowIndex,rowIndex);
            }
        }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    } 

    
    
}
