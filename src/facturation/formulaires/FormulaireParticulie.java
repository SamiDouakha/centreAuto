/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturation.formulaires;

import facturation.entities.Particulie;
import java.util.Locale;

/**
 *
 * @author tayeb
 */
public class FormulaireParticulie extends Formulaire{
    protected ChampNom champNom;
    protected ChampPrenom champPrenom;
    protected ChampVille champVille;
    protected ChampLieu champLieu;
    protected ChampCodePostal  champCodePostal; 
                      
    
    protected Particulie particulie;
    
    public FormulaireParticulie() 
    {
           super();
          particulie = new Particulie();
                 
    }
     
    public FormulaireParticulie(String nom,String prenom,String lieu,String ville,String codePostal) 
    {
            champNom = new ChampNom(nom);
            champPrenom = new ChampPrenom(prenom);
            champVille = new ChampVille(ville);
            champLieu = new ChampLieu(lieu);
            champCodePostal= new ChampCodePostal(codePostal);
            
            
            this.champs.add(champNom);
            this.champs.add(champPrenom);
            this.champs.add(champVille);
            this.champs.add(champLieu);
            this.champs.add(champCodePostal);
            
            particulie = new Particulie();
                 
    }

    public String getNom() {
        return champNom.getValue();
    }
    
    public void setNom(String siret) {
        this.champNom.setValue(siret);
    }
    
    public String getPrenom() {
        return champPrenom.getValue();
    }
    
    public void setNomSociete(String nom) {
        this.champPrenom.setValue(nom);
    }

     public String getVille() {
        return champVille.getValue();
    }

    public void setVillee(String ville) {
        this.champVille.setValue(ville); 
    }

    public String getLieu() {
        return champLieu.getValue();
    }

    public void setLieu(String lieu) {
        this.champLieu.setValue(lieu);
    }

    public String getCodePostal() {
        return champCodePostal.getValue();
    }

    public void setCodePostalSociete(String codePostal) {
        this.champCodePostal.setValue(codePostal);
    }

    
    
    public String  hydrate()
    {
        String message= "";
        if(this.validate().isEmpty())
        {   
            this.particulie.setNom(this.getNom().toUpperCase(Locale.FRANCE));
            this.particulie.setPrenom(this.getPrenom().toUpperCase(Locale.FRANCE));
            this.particulie.setLieu(this.getLieu().toUpperCase(Locale.FRANCE));
            this.particulie.setVille(this.getVille().toUpperCase(Locale.FRANCE));
            this.particulie.setCodePostal(this.getCodePostal());
          
        }
        else
        {
           message= this.validate();
        }
        return message;
    }

    public Particulie getParticulie() {
        return particulie;
    }

    public void setParticulie(Particulie particulie) {
        this.particulie = particulie;
    }

   
}
