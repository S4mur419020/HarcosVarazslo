package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Karakter implements Serializable {

    private static final long serialVersionUID = 3L;
    private transient int pontok;

    private UUID id;
    private String nev;
    private String kaszt;
    private int szint;
    private List<Targy> felszereles;

    public Karakter(String nev, String kaszt, int szint) {
        this.pontok=78;
        this.id = UUID.randomUUID();
        this.nev = nev;
        this.kaszt = kaszt;
        this.szint = szint;
        felszereles = new ArrayList<>();
        felszereles.add(new Targy("kard"));
        felszereles.add(new Targy("pajzs"));
        setId();
    }

    public void setId(){
        this.id = UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }
    
    

    public void felvesz(Targy targy) {
        felszereles.add(targy);
    }

    @Override
    public String toString() {
        String f = "\nFelszerelés:\n";
        for (Targy targy : felszereles) {
            f += targy.getLeiras() + "\n";
        }
        String str = "Karakter{ id=" + id + ","
                + " nev=" + nev + ", "
                + "kaszt=" + kaszt + ", "
                + "szint=" + szint + ", "
                + "pontok=" + pontok 
                + f + '}';

        return str;
    }

}
