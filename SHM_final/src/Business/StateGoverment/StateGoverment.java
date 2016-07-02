/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.StateGoverment;

import Business.MunicipalCorporation.MunicipalCorporationDirectory;

/**
 *
 * @author user
 */
public class StateGoverment {
    
    private String name;
    private MunicipalCorporationDirectory municipalCorporationDirectory;

    public StateGoverment() {
        municipalCorporationDirectory = new MunicipalCorporationDirectory();
    }

    public MunicipalCorporationDirectory getMunicipalCorporationDirectory() {
        return municipalCorporationDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
