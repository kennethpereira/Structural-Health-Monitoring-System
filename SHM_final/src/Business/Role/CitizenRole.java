/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.FedGoverment;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.CitizenWorkArea.CitizenWorkAreaJPanel;

/**
 *
 * @author User
 */
public class CitizenRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, MunicipalCorporation municipalCorporation, FedGoverment fedGovt) {
        return new CitizenWorkAreaJPanel(userProcessContainer, account, (CitizenOrganization)organization, municipalCorporation,fedGovt);
    }

    @Override
    public String toString() {
        return "CitizenRole";
    }
    
}
