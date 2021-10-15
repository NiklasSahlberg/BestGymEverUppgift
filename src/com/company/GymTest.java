package com.company;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {
    String inFil = "/Users/niklassahlberg/Desktop/BestGymEver/UppgifterTest.txt";
    Gym gym = new Gym();
    String filTillPt = "/Users/niklassahlberg/Desktop/BestGymEver/filTillPtTest.txt";


    @Test
    public final void taInFrånFil() {
        List<Person> personLista = gym.taInFrånFil(inFil);
        assertTrue(personLista.size() == 14);
        assertFalse(personLista.size() == 15);


    }
    public final int antalRaderiFil(String radRäknare){
        int rader = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(radRäknare));) {
            while (reader.readLine() != null) rader++;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rader;
    }
    public final String sistaRaden() throws IOException {
        String sistaRaden = "";
        try {
            String sCurrentLine;

           BufferedReader br = new BufferedReader(new FileReader(filTillPt));



            while ((sCurrentLine = br.readLine()) != null)
            {

                sistaRaden = sCurrentLine;
            }

            br.close();

        }
          catch (Exception e)
          {
              e.printStackTrace();

          }
        return sistaRaden;



    }


    @Test
    void filTillPT() throws IOException { //Kolla metod
        String sök = "Niklas Sahlberg";

        Person p1 = new Person("9604031234", "Niklas Sahlberg", "2021-03-15");
        Person p2 = new Person("9203151234", "Joakim Andersson", "2022-04-03");
        Person p3 = new Person("7608021234", "Diamanda Djedi", "2021-01-30");
        List<Person> testPersonLista = Arrays.asList(p1,p2,p3);


        //Test för att se till att raderna skrivs till fil.
       gym.filTillPT(testPersonLista, sök, filTillPt);
        for (int i = 0; i<antalRaderiFil(filTillPt); i++) {
           i = antalRaderiFil(filTillPt);
            assertTrue(antalRaderiFil(filTillPt) == i);
            assertFalse(antalRaderiFil(filTillPt) == i+1);
            System.out.println(i);
        }

        //Test för att se vad se att rätt meddelande skrevs till filen
        for (Person p:testPersonLista
             ) {
            if (sök.equalsIgnoreCase(p.getNamn())) {
                assertTrue(sistaRaden().equals("Namn: " + p.getNamn() + ", " + " Personnummer: " + p.getPersonnummer()
                        + ", " + "Datum för inträde " + LocalDate.now()));
                assertFalse(sistaRaden().equals("Hej jag är sista raden"));
            }


        }




    }
}