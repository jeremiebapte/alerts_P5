package com.safetynet.alerts.dto;


import java.util.Collection;

public class  PersonPerAge {

    private final Collection<PersonForFireStation> personForFireStation;
    private long major;
    private long minor;



    public PersonPerAge(Collection<PersonForFireStation> personForFireStation) {
        this.personForFireStation = personForFireStation;

        this.major = personForFireStation.stream().filter(personForFireStation1 ->
                personForFireStation1.getAge() >= 18 ).count();

        this.minor = personForFireStation.size() - this.major;
    }

    public Collection<PersonForFireStation> getPersonForFireStation() {
        return personForFireStation;
    }

    public long getMajor() {
        return major;
    }

    public long getMinor() {
        return minor;
    }
}
