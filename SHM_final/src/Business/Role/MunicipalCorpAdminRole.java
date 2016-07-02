/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.MunicipalCorporation.MunicipalCorporation;
import Business.FedGoverment;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.MunicipalCorpAdminWorkArea.MunicipalCorpAdminWorkAreaJPanel;

/**
 *
 * @author User
 */
public class MunicipalCorpAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, MunicipalCorporation municipalCorp, FedGoverment fedGovt) {
        return new MunicipalCorpAdminWorkAreaJPanel(userProcessContainer,municipalCorp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
