package com.company;

public class Person {
    String personnummer;
    String namn;
    String datum;

    @Override
    public String toString() {
        return "Person{" +
                "personnummer='" + personnummer + '\'' +
                ", namn='" + namn + '\'' +
                ", datum='" + datum + '\'' +
                '}';
    }

    public Person(String personnummer, String namn, String datum) {
        this.personnummer = personnummer;
        this.namn = namn;
        this.datum = datum;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public String getNamn() {
        return namn;
    }

    public String getDatum() {
        return datum;
    }


}
