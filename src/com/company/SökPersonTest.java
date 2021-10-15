package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SökPersonTest {
    String svar = "Niklas Sahlberg";
    List<Person> personLista = new ArrayList<>();
    List<Person> medlemsLista = new ArrayList<>();
    Person p1 = new Person("9604031234", "Niklas Sahlberg", "2020-03-15");
    Person p2 = new Person("9203151234", "Joakim Andersson", "2020-04-03");
    Person p3 = new Person("7608021234", "Diamanda Djedi", "2021-01-30");

    @Test
   void register() {


        personLista.add(p1);
        personLista.add(p2);
        personLista.add(p3);

        boolean hittad = false;
        for (Person p:personLista
             ) {
            if (svar.equalsIgnoreCase(p.getNamn()) || svar.equals(p.getPersonnummer())) {
                hittad = true; //Hittad är sant och nu kan vi meddela att personen finns
               // return true;

            }

        }

        assertEquals(hittad, true);
        //Printa ut att personen finns
        assertNotEquals(hittad, false);
        //Printa ut att personen inte finns




    }

    @Test
    void medlem() {
        medlemsLista.add(p1);
        medlemsLista.add(p2);
        medlemsLista.add(p3);
        boolean hittad = false;
        for (Person p : medlemsLista
             ) {
            if(svar.equalsIgnoreCase(p.getNamn())|| svar.equals(p.getPersonnummer()))
            {
                hittad = true; //Hittad är sant så nu kan vi meddela att personen är medlem
                break;
            }
        }
        assertEquals(hittad, true);
        //Printa ut att personen är medlem
        assertNotEquals(hittad, false);
        //Printa ut att personen INTE är medlem
    }
}