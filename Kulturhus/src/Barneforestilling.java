import java.time.*;
import javax.swing.*;

public class Barneforestilling extends UnderholdningsArrangement
{
    public Barneforestilling(String n, String p, int t, double bpB , double bpV, String[] dt, LocalDateTime d, ImageIcon aB, Kontaktperson kP, String sj)
    {
        super(n, p, t, bpB, bpV, dt, d, aB, kP, sj);
    }
    
    public String toString()
    {
        String tekst = super.toString();
        return tekst;
    }
} //End of class Barneforestilling