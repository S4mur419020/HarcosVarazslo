package Controller;

import Model.HarcosVarazsloModel;
import View.HarcosVarazslo;
import java.io.*;

public class HarcosVarazsloControl {

    private HarcosVarazsloModel.GameModel model;
    private HarcosVarazslo gui;

    public HarcosVarazsloControl(HarcosVarazslo nezet, HarcosVarazsloModel.GameModel model1) {
        this.model = model1;   // ← HIBA JAVÍTVA
        this.gui = nezet;

        gui.addLepesAction(e -> leptet());
        gui.getJmMentes().addActionListener(e -> mentes());
        gui.getJmBetolt().addActionListener(e -> betoltes());

        gui.setVisible(true);
        frissitGUI();
    }

    private void leptet() {
        model.leptet();
        frissitGUI();
    }

    private void frissitGUI() {
        String[] mezok = {"-", "-", "-"};

        if (model.vanUtkozes()) {
            mezok[model.getHarcosPoz()] = "X";
        } else {
            mezok[model.getHarcosPoz()] = "H";
            mezok[model.getVarazsPoz()] = "V";
        }

        gui.setMezok(mezok);
    }

    private void mentes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mentes.dat"))) {
            oos.writeObject(model);
            System.out.println("Sikeres mentés!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void betoltes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mentes.dat"))) {
            model = (HarcosVarazsloModel.GameModel) ois.readObject();
            frissitGUI();
            System.out.println("Sikeres betöltés!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
