package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gym {

    public static List<Person> taInFrånFil(String inFrånfil)
    {
        String radEtt;
        String radTvå;

        Path inFil;
        List<Person> personLista = new ArrayList<>();

        String [] personDataRadEtt = new String[2];
        String [] personDataRadTvå = new String[1];

        inFil = Paths.get(inFrånfil);

        try(Scanner fileScanner = new Scanner(inFil))
        {
            while(fileScanner.hasNext()) {
                radEtt = fileScanner.nextLine();
                personDataRadEtt = radEtt.split(",");
                if(fileScanner.hasNext()) {
                    radTvå = fileScanner.nextLine();
                    personDataRadTvå = radTvå.split(",");
                }
                Person p = new Person(personDataRadEtt[0].trim(), personDataRadEtt[1].trim(), personDataRadTvå[0].trim()); //trim för onödiga space
                personLista.add(p);
            }

        }

        catch (IOException e) {
            System.out.println("Fil kan ej hittas");
            e.printStackTrace();

        }
        return personLista;
    }

    public static void filTillPT( List<Person> inträdesLista, String svar, String fil) throws IOException {



       try( BufferedWriter w = new BufferedWriter(new FileWriter(String.valueOf(fil), true)))
      {
        for ( Person p : inträdesLista){
            LocalDate ld = LocalDate.parse(p.getDatum());
            if (svar.equalsIgnoreCase(p.getNamn()) && ld.isAfter(LocalDate.now().minusYears(1))  || svar.equals(p.getPersonnummer()) && ld.isAfter(LocalDate.now().minusYears(1))) {
                w.write("Namn: " + p.getNamn() + ", " + " Personnummer: " + p.getPersonnummer()
                        + ", " + "Datum för inträde " + LocalDate.now() + "\n");
                System.out.println(p.getNamn() + " Läggs nu till i filen till PT");
            }
        }



    }
       catch (FileNotFoundException e){
        System.out.println("Kan inte skriva till fil för att filen inte kan hittas.");
        e.printStackTrace();
        System.exit(0);
    }
        catch (IOException e){
        System.out.println("Det gick inte att skriva till fil");
        e.printStackTrace();
        System.exit(0);
    }
        catch (Exception e){
        System.out.println("Något gick fel");
        e.printStackTrace();
        System.exit(0);
    }


}
}
