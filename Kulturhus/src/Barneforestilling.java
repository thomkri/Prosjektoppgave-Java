

/*Opprettet av: Sara Torp Myhre
Sist endret: 15.05.2015

Filen inneholder klassen Barneforestilling.*/

import java.io.*;
import java.time.*;
import javax.swing.*;

//Klassen er en subklasse av klassen UnderholdningsArrangement og implementerer Serializable. Dette er en klasse for alle barneforestillinger
public class Barneforestilling extends UnderholdningsArrangement implements Serializable
{
    /*Metoden er konstruktøren til klassen Barneforestilling. Paramtrenes betydning:
    n = navn, p = program, lN = navnet på lokalet arrangementet holdes i, t = et heltatll som tilsier hvordan type arrangement det er(se Kulturhus.java),
    bpB = billettpris for barn, bpV = billettpris for voksne, dt = en array med navn over alle deltakere i arrangementet, d = Objekt med dato og tidspunkt for arrangementet,
    aB = ImageIcon som innneholder arrangemntets bilde(plakat), kP = Kontaktperson objekt av kontaktpersonen som er knyttet til arrangementet, sj = arrangementets sjanger*/
    public Barneforestilling(String n, String p, String lN, int t, double bpB , double bpV, String[] dt, LocalDateTime d, ImageIcon aB, Kontaktperson kP, String sj)
    {
        super(n, p, lN, t, bpB, bpV, dt, d, aB, kP, sj);
    }
    
    public String toString() //Metodens toString-metode. Skriver ut klassen som tekst
    {
        String tekst = super.toString();
        return tekst;
    }
} //End of class Barneforestilling