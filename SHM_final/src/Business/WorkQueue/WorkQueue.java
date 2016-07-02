/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;
    private ArrayList<ContractRequest> contractList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
        contractList=new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    /**
     * @return the contractList
     */
    public ArrayList<ContractRequest> getContractList() {
        return contractList;
    }

    /**
     * @param contractList the contractList to set
     */
    public void setContractList(ArrayList<ContractRequest> contractList) {
        this.contractList = contractList;
    }
}