/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MunicipalCorporation;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class MunicipalCorporationDirectory {
    
    private ArrayList<MunicipalCorporation> municipalCorporationList;

    public MunicipalCorporationDirectory() {
        municipalCorporationList = new ArrayList<>();
    }

    public ArrayList<MunicipalCorporation> getMunicipalCorporationList() {
        return municipalCorporationList;
    }
    
    public MunicipalCorporation createAndAddDepaartment(String name, MunicipalCorporation.DepartmentType type){
        MunicipalCorporation mc = null;
        if (type == MunicipalCorporation.DepartmentType.BBR){
            mc = new BoardofBuildingRegulation(name);
            municipalCorporationList.add(mc);
        }
        return mc;
    }
    
}
