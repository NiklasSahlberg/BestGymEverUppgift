package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GiltigtMedlemskap {
    public static List<Person> giltigtMedlemskapsLista(List<Person> allaPersoner){


        List<Person>giltigtMedlemskapsLista = new ArrayList<>();
        for (Person p: allaPersoner
             ) {
            LocalDate ld = LocalDate.parse(p.getDatum());
            if(ld.isAfter(LocalDate.now().minusYears(1)))
                giltigtMedlemskapsLista.add(p);

        }
        return giltigtMedlemskapsLista;
    }

}
