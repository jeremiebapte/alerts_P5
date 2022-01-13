package com.safetynet.alerts.dto;

import java.util.Collection;
import java.util.stream.Collectors;

public class ChildPerHouse {


    private  Collection<ChildForAdress> children;
    private  Collection<ChildForAdress> others;


    public ChildPerHouse(Collection<ChildForAdress> persons) {

        this.children = persons.stream().filter(childForAdress ->
                childForAdress.getAge() < 18).collect(Collectors.toList());

        this.others = persons.stream().filter(childForAdress ->
                childForAdress.getAge() >= 18).collect(Collectors.toList());
    }

    public Collection<ChildForAdress> getChildren() {
        return children;
    }

    public Collection<ChildForAdress> getOthers() {
        return others;
    }
}
