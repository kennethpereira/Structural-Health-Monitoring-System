/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.FedGoverment;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public abstract class Role {
    
    public enum RoleType{
        MunicipalCommisioner("Municipal Commisioner"),
        ConstructionCompany("ConstructionCompany"),
        Citizen("Citizen");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            MunicipalCorporation municipalCorporation, 
            FedGoverment fedGovt);

    
    @Override
    public String toString(){
        return this.getClass().getName();
    }
    
}