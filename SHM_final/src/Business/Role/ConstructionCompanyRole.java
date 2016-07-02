/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.FedGoverment;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.ConstructionCompanyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.ConstructionCompanyWorkArea.ConstructionCompanyWorkAreaJPanel;

/**
 *
 * @author User
 */
public class ConstructionCompanyRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, MunicipalCorporation municipalCorporation, FedGoverment fedGovt) {
        return new ConstructionCompanyWorkAreaJPanel(userProcessContainer, account, (ConstructionCompanyOrganization)organization, municipalCorporation);
    }

    @Override
    public String toString() {
        return "ConstructionCompanyRole";
    }
    
}
