/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.StructuralHealthMonitor;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StructuralHealthHistory {
    
    private ArrayList<SensorData> buildingHealthData;
    
    public StructuralHealthHistory(){
        buildingHealthData=new ArrayList<>();
    }

    /**
     * @return the buildingHealthData
     */
    public ArrayList<SensorData> getBuildingHealthData() {
        return buildingHealthData;
    }

    /**
     * @param buildingHealthData the buildingHealthData to set
     */
    public void setBuildingHealthData(ArrayList<SensorData> buildingHealthData) {
        this.buildingHealthData = buildingHealthData;
    }
    
    public SensorData addValue(){
        SensorData shv=new SensorData();
        buildingHealthData.add(shv);
        return shv;
    }
    
    
    
}
