/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;


public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getEmployeeList() {
        return personList;
    }
    
    public Person createPerson(String name,String email){
        Person person = new Person();
        person.setName(name);
        person.setEmailID(email);
        personList.add(person);
        return person;
    }
}