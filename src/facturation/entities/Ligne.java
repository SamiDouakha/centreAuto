/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturation.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author tayeb
 */
@Entity

public class Ligne implements Serializable {

   @Transient
   private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id_ligne;

    public Long getId_ligne() {
        return id_ligne;
    }

    public void setId_ligne(Long id) {
        this.id_ligne = id;
    }

    
   @OneToOne
   @JoinColumn(name  ="ID_PIECE")
   protected Piece piece;
   
   @Column(name ="PRIX_UHT",columnDefinition="Decimal(10,2) default '00.00'")
   protected  Double prixUHT;
   
   @OneToOne
   @JoinColumn(name  ="ID_FACTURE")
   protected Facture facture;
   
   @Column(name = "QUANTITE",columnDefinition="int default '0'" )
   protected int quantite;
   
   
   public Ligne(){
       
       piece = new Piece (); 
       this.quantite = 0;
       this.prixUHT = 0.0;
   }
   
    public Ligne( Piece p ,int quantite) {
        this.piece = p;
        this.quantite = quantite;
        this.prixUHT = this.piece.getPrixVente();
    }
    
    public Ligne( Piece p ,Double prix , int quantite) {
        this.piece = p;
        this.quantite = quantite;
        this.prixUHT = prix;
    }
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        double oldQuantite = this.quantite;
        this.quantite = quantite;
        changeSupport.firePropertyChange("quantite", oldQuantite, quantite);
    }

    public double getPrixUHT() {
        return prixUHT;
    }

    public void setPrixUHT(Double prixHT) {
        Double oldPrixHT = this.prixUHT;
        this.prixUHT = prixHT;
       changeSupport.firePropertyChange("prixUHT", oldPrixHT, prixHT);
    }
    
    

    @Override
    public String toString() {
        return "\n" + piece +"\n Quantite:"+ quantite +
                " TVA: "+this.getTVA()+"%"+
                " Montant HT: "+this.getMontantHT()+"€"+
                " Montant TVA: "+this.getMontantTVA()+"€"+
                " Montant TTC: "+this.getMontantTTC()+"€";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void setFacture(Facture facture) {
        Facture oldFacture = this.facture;
                this.facture = facture;
        changeSupport.firePropertyChange("facture", oldFacture, facture);
    }
    
    public Double getTVA()
    {
        //Double tva = this.getProduit().getCategorie().getTva();
        return (20.0/100.0);
    }
    public Double getMontantHT(){
        return this.getPrixUHT()*this.getQuantite() ;
    }
    public Double getMontantTVA(){
        return this.getMontantHT()*(20.0/100.0);
    }
    public Double getMontantTTC(){
     
    return this.getMontantHT()+this.getMontantTVA();
    }

    
    
}
