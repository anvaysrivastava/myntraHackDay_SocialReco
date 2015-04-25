package com.anprache.social.common.pojo.feed;

import com.anprache.social.common.pojo.compare.PersonDifference;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
public class PersonInRespectOfAnotherPerson {
    private Person person;
    private PersonDifference personDifference;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonDifference getPersonDifference() {
        return personDifference;
    }

    public void setPersonDifference(PersonDifference personDifference) {
        this.personDifference = personDifference;
    }
}
