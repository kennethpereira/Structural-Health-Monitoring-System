/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.FedGoverment;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Organization.MunicipalCommsionerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.MunicipalCommisionerWorkArea.MunicipalCommisionerWorkAreaJPanel;

/**
 *
 * @author User
 */
public class MunicipalCommisionerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, MunicipalCorporation municipalCorporation, FedGoverment fedGovt) {
        return new MunicipalCommisionerWorkAreaJPanel(userProcessContainer,account,(MunicipalCommsionerOrganization)organization,municipalCorporation);
    }

    @Override
    public String toString() {
        return "MunicipalCommisionerRole";
    }
    
    
}
