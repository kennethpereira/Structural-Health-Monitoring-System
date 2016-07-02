/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MunicipalCorpAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MunicipalCorpAdmin extends Organization{

    public MunicipalCorpAdmin() {
        super(Type.MunicpalCorpAdmin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MunicipalCorpAdminRole());
        return roles;
    }
    
}
