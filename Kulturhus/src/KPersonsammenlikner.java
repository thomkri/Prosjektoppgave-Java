/*Opprettet av: Thomas Kristiansen
Sist endret: 14.05.2015

Filen inneholder klassen KPersonsammenlikner.*/

import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

//Klassen implementerer interfacene Comparator<> og Serilizable, og brukes til sortering av Arrangement objekter
public class KPersonsammenlikner implements Comparator<Kontaktperson>, Serializable
{
    private String rekkefolge = "<\0<0<1<2<3<4<5<6<7<8<9<A,a<B,b<C,c<D,d<E,e<F,f<G,g<H,h<I,i<J,j<K,k<L,l<M,m<N,n<O,o<P,p<Q,q<R,r<S,s<T,t<U,u<V,v<W,w<X,x<Y,y<Z,z<Æ,æ<Ø,ø<Å=AA,å=aa;AA,aa";
    private RuleBasedCollator kollator;
    
    //Metoden er konstruktøren til klassen ArrangementDatoSammenlikner.
    public KPersonsammenlikner()
    {
        try
        {
            kollator = new RuleBasedCollator(rekkefolge);
        }
        catch(ParseException pe)
        {
            JOptionPane.showMessageDialog(null, "Feil i rekkefølge på kollatoren.");
        }
    }
    
    /*Metoden er implementert fra interfacet Comparator<>. Metoden tar to paramtere av typen Kontaktperson.
    Metoden tar så å sammenlikner disse to objektene, først etter alfabetisk etter etternavn og så etter fornavn.*/
    public int compare(Kontaktperson k1, Kontaktperson k2)
    {
        String eNavn1 = k1.getEtternavn();
        String eNavn2 = k2.getEtternavn();
        String fNavn1 = k1.getFornavn();
        String fNavn2 = k2.getFornavn();
        int d = kollator.compare(eNavn1, eNavn2);
        if(d != 0)
            return d;
        return kollator.compare(fNavn1, fNavn2);
    }
}
