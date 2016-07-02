/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Architecture;

import Business.StructuralHealthMonitor.StructuralHealthHistory;

/**
 *
 * @author User
 */
public class Architecture {
    
    
    private int RegID;
    private int yearConstructed;
    private String status;
    private int Age;
    private String comments;
    private String architectureName;
    private int repairDays;
    private String majorRepairsLocation;
    private String minorRepairLocations;
    private int ranking;
    
    private StructuralHealthHistory shh;
    
    public Architecture(){
        shh=new StructuralHealthHistory();
    }
    

    

    /**
     * @return the yearConstructed
     */
    public int getYearConstructed() {
        return yearConstructed;
    }

    /**
     * @param yearConstructed the yearConstructed to set
     */
    public void setYearConstructed(int yearConstructed) {
        this.yearConstructed = yearConstructed;
    }

    
    
    /**
     * @return the RegID
     */
    public int getRegID() {
        return RegID;
    }

    /**
     * @param RegID the RegID to set
     */
    public void setRegID(int RegID) {
        this.RegID = RegID;
    }

    /**
     * @return the architectureName
     */
    public String getArchitectureName() {
        return architectureName;
    }

    /**
     * @param architectureName the architectureName to set
     */
    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
    }
    
    @Override
    public String toString(){
        return architectureName;
    }

    /**
     * @return the shh
     */
    public StructuralHealthHistory getShh() {
        return shh;
    }

    /**
     * @param shh the shh to set
     */
    public void setShh(StructuralHealthHistory shh) {
        this.shh = shh;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the repairDays
     */
    public int getRepairDays() {
        return repairDays;
    }

    /**
     * @param repairDays the repairDays to set
     */
    public void setRepairDays(int repairDays) {
        this.repairDays = repairDays;
    }

    /**
     * @return the majorRepairsLocation
     */
    public String getMajorRepairsLocation() {
        return majorRepairsLocation;
    }

    /**
     * @param majorRepairsLocation the majorRepairsLocation to set
     */
    public void setMajorRepairsLocation(String majorRepairsLocation) {
        this.majorRepairsLocation = majorRepairsLocation;
    }

    /**
     * @return the minorRepairLocations
     */
    public String getMinorRepairLocations() {
        return minorRepairLocations;
    }

    /**
     * @param minorRepairLocations the minorRepairLocations to set
     */
    public void setMinorRepairLocations(String minorRepairLocations) {
        this.minorRepairLocations = minorRepairLocations;
    }

    /**
     * @return the ranking
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * @param ranking the ranking to set
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
