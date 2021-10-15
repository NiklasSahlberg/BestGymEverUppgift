package com.company;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiltigtMedlemskapTest {
    GiltigtMedlemskap gm = new GiltigtMedlemskap();
    LocalDate ld = LocalDate.now().minusMonths(3);
    LocalDate ld1 = LocalDate.now().minusYears(2);
    LocalDate ld2 = LocalDate.now().minusDays(364);

    Person p1 = new Person("199604031234", "Niklas Sahlberg", ld.toString() );
    Person p2 = new Person("199205231234", "Max Appelgren", ld1.toString());
    Person p3 = new Person("199303151234", "Joakim Andersson", ld2.toString());

    List<Person>giltigaPersoner = new ArrayList<>();
    List<Person>testPersoner = new ArrayList<>();

    @Test
    public final void giltigtMedlemskapsListaTest()
    {
        testPersoner = Arrays.asList(p1,p2,p3);
         giltigaPersoner = GiltigtMedlemskap.giltigtMedlemskapsLista(testPersoner);

         assertTrue(giltigaPersoner.size() == 2);
         assertFalse(giltigaPersoner.size()==1);

    }


}