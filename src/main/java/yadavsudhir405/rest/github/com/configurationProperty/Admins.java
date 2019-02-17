package yadavsudhir405.rest.github.com.configurationProperty;

import yadavsudhir405.rest.github.com.configurationProperty.Person;

import java.util.List;

/**
 * Created by sudhiry on 2/17/19.
 */
public class Admins {
    List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
