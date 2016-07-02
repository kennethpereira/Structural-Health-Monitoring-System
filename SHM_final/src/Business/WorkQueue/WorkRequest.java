/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Architecture.Architecture;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private Architecture  building;
    private UserAccount sender;
    private UserAccount receiver;
    private String bidRequestID;
    private int lowestBidAmount;
    private String status;
    private String approval;
    
    private Date requestDate;
    private Date resolveDate;
    
    public WorkRequest(){
        requestDate = new Date();
        
    }

    

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    /**
     * @return the building
     */
    public Architecture getBuilding() {
        return building;
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(Architecture building) {
        this.building = building;
    }

    /**
     * @return the bidRequestID
     */
   
    /**
     * @return the lowestBidAmount
     */
    public int getLowestBidAmount() {
        return lowestBidAmount;
    }

    /**
     * @param lowestBidAmount the lowestBidAmount to set
     */
    public void setLowestBidAmount(int lowestBidAmount) {
        this.lowestBidAmount = lowestBidAmount;
    }

    /**
     * @return the approval
     */
    public String getApproval() {
        return approval;
    }

    /**
     * @param approval the approval to set
     */
    public void setApproval(String approval) {
        this.approval = approval;
    }
    
    
    @Override
    public String toString(){
        return getBidRequestID();
    }

    /**
     * @return the bidRequestID
     */
    public String getBidRequestID() {
        return bidRequestID;
    }

    /**
     * @param bidRequestID the bidRequestID to set
     */
    public void setBidRequestID(String bidRequestID) {
        this.bidRequestID = bidRequestID;
    }
    
        
    
}
