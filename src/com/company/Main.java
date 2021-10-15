package com.company;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String fil = "/Users/niklassahlberg/Desktop/BestGymEver/Uppgifter.txt";
        String filTillPt = "/Users/niklassahlberg/Desktop/BestGymEver/filTillPt.txt";
        List<Person> personLista = Gym.taInFrånFil(fil);
        List<Person> medlemSkapsLista = GiltigtMedlemskap.giltigtMedlemskapsLista(personLista);
        String s = JOptionPane.showInputDialog("Vänligen ange namn eller personnummer för personen");
        if(SökPerson.register(s, personLista))
            SökPerson.medlem(s, medlemSkapsLista);
        Gym.filTillPT(medlemSkapsLista, s, filTillPt);
    }
}
