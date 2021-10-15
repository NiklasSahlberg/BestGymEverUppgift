package com.company;

import java.util.List;


public class SökPerson {

    public static boolean register(String svar, List<Person>personLista){

     boolean hittad = false;
     try {
        for (Person p: personLista
             ) {
            if (svar.equalsIgnoreCase(p.getNamn()) || svar.equals(p.getPersonnummer())) {
                System.out.println(p.getNamn() + " finns med i registret");
                hittad = true;
                return true;
            }
        }


        }
     catch (NullPointerException e) {
         System.out.println("Du valde cancel, programmet stängs nu ner.");
         System.exit(0);
     }
         if (!hittad) {
             System.out.println("Personen finns inte med i registret");
         }
        return false;

    }
    public static void medlem(String svar, List<Person>medlemskapsLista){

           boolean hittad = false;
           for (Person p:medlemskapsLista
                ) {
               if (svar.equalsIgnoreCase(p.getNamn())|| svar.equals(p.getPersonnummer()))
               {
                   System.out.println(p.getNamn() + " har ett giltigt medlemskap");
                   hittad = true;

               }
           }
            if (!hittad)                                         
                System.out.println("Giltigt medlemskap saknas"); 


    }
}
