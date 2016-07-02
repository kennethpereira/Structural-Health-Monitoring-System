/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Architecture;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ArchitectureDirectory {
    
    private ArrayList<Architecture> buildingList;
    
    public ArchitectureDirectory(){
        buildingList=new ArrayList<>();
    }

    /**
     * @return the buildingList
     */
    public ArrayList<Architecture> getBuildingList() {
        return buildingList;
    }

    /**
     * @param buildingList the buildingList to set
     */
    public void setBuildingList(ArrayList<Architecture> buildingList) {
        this.buildingList = buildingList;
    }
    
    public Architecture createBuilding(){
        Architecture building =new Architecture();
        /*building.setRegID(regID);
        building.setBuildingYear(year);
        building.setBuildingName(street);*/
        buildingList.add(building);
        return building;
    }
    
    
    
    
    
}
