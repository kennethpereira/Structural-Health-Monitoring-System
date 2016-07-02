/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MunicipalCorporation;

import Business.Architecture.ArchitectureDirectory;
import Business.Email.EmailManagementSystem;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.StructuralHealthMonitor.StructuralHealthHistory;


/**
 *
 * @author raunak
 */
public abstract class MunicipalCorporation extends Organization{

    private DepartmentType departmentType;
    private OrganizationDirectory organizationDirectory;
    private ArchitectureDirectory buildingDirectory;
   
    private EmailManagementSystem email;
    
    
    public MunicipalCorporation(String name, DepartmentType type) {
        super(name);
        this.departmentType = type;
        organizationDirectory = new OrganizationDirectory();
        buildingDirectory=new ArchitectureDirectory();
        email=new EmailManagementSystem();
        
        
    }

    /**
     * @return the buildingDirectory
     */
    public ArchitectureDirectory getBuildingDirectory() {
        return buildingDirectory;
    }

    /**
     * @param buildingDirectory the buildingDirectory to set
     */
    public void setBuildingDirectory(ArchitectureDirectory buildingDirectory) {
        this.buildingDirectory = buildingDirectory;
    }

    /**
     * @return the contract
     */
    

    
    
    /**
     * @return the email
     */
    public EmailManagementSystem getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(EmailManagementSystem email) {
        this.email = email;
    }

    
    
    public enum DepartmentType{
        BBR("Board of Building Regulation");
        
        private String value;

        private DepartmentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}
