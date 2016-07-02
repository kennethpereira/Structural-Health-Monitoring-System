/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.StructuralHealthMonitor;

import Business.Architecture.Architecture;
import java.util.Date;

/**
 *
 * @author User
 */
public class SensorData {
    
    private int inputForce;
    private float outputVoltage;
    private String serialNumber;
    private String location;
    private String status;
    private String date;
    
    
    

    /**
     * @return the inputForce
     */
    public int getInputForce() {
        return inputForce;
    }

    /**
     * @param inputForce the inputForce to set
     */
    public void setInputForce(int inputForce) {
        this.inputForce = inputForce;
    }

    /**
     * @return the outputVoltage
     */
    public float getOutputVoltage() {
        return outputVoltage;
    }

    /**
     * @param outputVoltage the outputVoltage to set
     */
    public void setOutputVoltage(int inputForce) {
        
        float out =inputForce/20;
        this.outputVoltage = out;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
     * @return the date
     */
   
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the date
     */
    
    
}
