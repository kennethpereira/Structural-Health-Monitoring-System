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
import userInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, MunicipalCorporation enterprise, FedGoverment fedGovt) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, fedGovt);
    }
    
}
