package Business;

import Business.Architecture.Architecture;
import Business.Architecture.ArchitectureDirectory;
import Business.MunicipalCorporation.MunicipalCorporation;
import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.StateGoverment.StateGoverment;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static FedGoverment configure(){
        
        FedGoverment fedGovt = FedGoverment.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Person person = fedGovt.getPersonDirectory().createPerson("SysAdmin","shma7887@gmail.com");
        
        UserAccount ua = fedGovt.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        StateGoverment state=fedGovt.createAndAddStateGoverment();
        state.setName("MA");
        
        
        
        
        
        return fedGovt;
    }
    
}
