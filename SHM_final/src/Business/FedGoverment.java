package Business;

import Business.StateGoverment.StateGoverment;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class FedGoverment extends Organization {

    private static FedGoverment fedGoverment;
    private ArrayList<StateGoverment> stateGovtList;

    public static FedGoverment getInstance() {
        if (fedGoverment == null) {
            fedGoverment = new FedGoverment();
        }
        return fedGoverment;
    }

    private FedGoverment() {
        super(null);
        stateGovtList = new ArrayList<>();
    }

    public ArrayList<StateGoverment> getStateGovermentList() {
        return stateGovtList;
    }

    public StateGoverment createAndAddStateGoverment() {
        StateGoverment stateGovt = new StateGoverment();
        stateGovtList.add(stateGovt);
        return stateGovt;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        for (StateGoverment stateGovt : stateGovtList) {
        }

        return true;
    }
}