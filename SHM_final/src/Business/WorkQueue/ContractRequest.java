/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Architecture.Architecture;
import Business.UserAccount.UserAccount;

/**
 *
 * @author User
 */
public class ContractRequest {
    
    private String contractID;
    private Architecture architecture;
    private UserAccount company;
    private UserAccount sender;

    public ContractRequest() {
        architecture = new Architecture();
    }

    
    
    /**
     * @return the contractID
     */
    public String getContractID() {
        return contractID;
    }

    /**
     * @param contractID the contractID to set
     */
    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    /**
     * @return the architecture
     */
    public Architecture getArchitecture() {
        return architecture;
    }

    /**
     * @param architecture the architecture to set
     */
    public void setArchitecture(Architecture architecture) {
        this.architecture = architecture;
    }

    /**
     * @return the company
     */
    public UserAccount getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(UserAccount company) {
        this.company = company;
    }
    
    @Override
    public String toString(){
        return getContractID();
    }

    /**
     * @return the sender
     */
    public UserAccount getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(UserAccount sender) {
        this.sender = sender;
    }
     
    
}
