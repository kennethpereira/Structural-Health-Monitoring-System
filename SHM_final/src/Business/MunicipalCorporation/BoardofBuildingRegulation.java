/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MunicipalCorporation;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class BoardofBuildingRegulation extends MunicipalCorporation{

    public BoardofBuildingRegulation(String name) {
        super(name, DepartmentType.BBR);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
    
}
