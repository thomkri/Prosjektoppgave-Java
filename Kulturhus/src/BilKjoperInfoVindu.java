import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class BilKjoperInfoVindu extends JFrame
{
    private JPanel vindu;
    private JTextPane info;
    private JScrollPane infoScroll;
    private JButton lukkKnapp, lagreKnapp;
    private JFileChooser filvelger;
    private int filvalgReturVerdi;
    
    private Arrangement arrangement;
    private Billett[] billettListe;
    
    private Kommandolytter knappelytter;
    
    public BilKjoperInfoVindu(Arrangement a)
    {
        super("Solgte biletter til " + a.getNavn());
        
        arrangement = a;
        billettListe = arrangement.getBilettListe();
        knappelytter = new Kommandolytter();
        
        vindu = new JPanel(new FlowLayout());
        
        info = new JTextPane();
        info.setBackground(vindu.getBackground());
        info.setEditable(false);
        
        lagInfoUtskrift(a.getNavn() +  " har blitt avlyst. Her er info om alle kjøpte billetter:", 20, true, false);
        
        if(billettListe == null)
            lagInfoUtskrift("\n\nArrangementet har ingen kjøpte billetter.", 16, false, false);
        else
        {
            for(int i = 0; i < billettListe.length; i++)
            {
                lagInfoUtskrift("\n\n" + billettListe[i].getEtternavn() + ", " + billettListe[i].getFornavn(), 16, false, false);
                lagInfoUtskrift("\nE-post: " + billettListe[i].getEpost(), 16, false, false);
                lagInfoUtskrift("\nTelefonnummer: " + billettListe[i].getTlf(), 16, false, false);
                lagInfoUtskrift("\nPenger betalt: " + billettListe[i].getPris(), 16, false, false);
            }
        }
        
        infoScroll = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoScroll.setPreferredSize(new Dimension(500, 500));
        infoScroll.setBorder(BorderFactory.createEmptyBorder( 0, 0, 0, 0 ));
        
        lukkKnapp = new JButton("Lukk");
        lukkKnapp.addActionListener(knappelytter);
        lagreKnapp = new JButton("Lagre fil");
        lagreKnapp.addActionListener(knappelytter);
        
        vindu.add(infoScroll);
        vindu.add(lukkKnapp);
        vindu.add(lagreKnapp);
        
        add(vindu);
        pack();
        setVisible(true);
    }
    
    private void kjorFilLagrer()
    {       
        filvelger = new JFileChooser();
        filvelger.setSelectedFile(new File(arrangement.getNavn().replace("\\s", "_") + "-billetter.txt"));
        filvalgReturVerdi = filvelger.showSaveDialog(this);
        
        if(filvalgReturVerdi == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                PrintWriter writer = new PrintWriter(filvelger.getSelectedFile(), "UTF-8");
                writer.append(info.getText());
                writer.close();
            }
            catch (FileNotFoundException fne)
            {
                visMelding("Du har valgt en ugyldig file-path.");
            }
            catch(UnsupportedEncodingException uee)
            {
                visMelding("Ukjent encoding type oppgitt");
            }
        }
    }
    
    private void lagInfoUtskrift(String tekst, int fontStr, boolean fetSkrift, boolean kursivSkrift)
    {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setFontSize(style, fontStr);
        StyleConstants.setBold(style, fetSkrift);
        StyleConstants.setItalic(style, kursivSkrift);
        
        StyledDocument infoDokument = info.getStyledDocument();
        try
        {
            infoDokument.insertString(infoDokument.getLength(), tekst, style);
        }
        catch(BadLocationException ble)
        {
            visMelding("Her har det skjedd en feil.");
        }
    }
    
    private void visMelding(String melding)
    {
        JOptionPane.showMessageDialog(this, melding);
    }
    
    private class Kommandolytter implements ActionListener //Kommandolytteren som bestemmer hvilken metode som blir utført utifra hvilken knapp det blir trykket på
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == lukkKnapp)
                return;
            else if(e.getSource() == lagreKnapp)
                kjorFilLagrer();
        }
    }
}
