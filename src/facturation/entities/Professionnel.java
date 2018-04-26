/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturation.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author tayeb
 */
@Entity
@DiscriminatorValue("PRO")
public class Professionnel extends Client implements Serializable {

    
    
    protected String siret;
    protected String nomSociete;

    public Professionnel() {
    }
    public Professionnel(String siret, String nomSociete) {
        this.siret = siret;
        this.nomSociete = nomSociete;
    }
   

    public Professionnel(Long id, String siret, String nomSociete, Adresse adresse) {
        super(id,adresse);
        this.siret = siret;
        this.nomSociete = nomSociete;
    }
    
    
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

   

    @Override
    public String toString() {
        return "Professionnel{" + "siret=" + siret + ", nomSociete=" + nomSociete + " " +this.adresse.toString()+ '}';
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.siret);
        hash = 53 * hash + Objects.hashCode(this.nomSociete);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professionnel other = (Professionnel) obj;
        if (!Objects.equals(this.siret, other.siret)) {
            return false;
        }
        if (!Objects.equals(this.nomSociete, other.nomSociete)) {
            return false;
        }
        return true;
    }
    
}
