package com.company;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p = new Person("199604031234", "Niklas Sahlberg", "2020-10-01");


    @Test
    public final void getPersonnummerTest(){
        assertEquals("199604031234", p.getPersonnummer());
        assertNotEquals("196805221234", p.getPersonnummer());
    }

    @Test
    public final void getNamnTest(){
        assertEquals("Niklas Sahlberg", p.getNamn());
        assertNotEquals("Picklas Dahlberg", p.getNamn());
    }

    @Test
    public final void getDatumTest(){
        assertEquals("2020-10-01", p.getDatum());
        assertNotEquals("2021-10-01", p.getDatum());
    }

}