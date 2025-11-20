package main;

import View.HarcosVarazslo;
import Model.HarcosVarazsloModel;
import Controller.HarcosVarazsloControl;

public class Indito {
    public static void main(String[] args) {
        HarcosVarazslo nezet=new HarcosVarazslo();
        HarcosVarazsloModel model=new HarcosVarazsloModel();
        new HarcosVarazsloControl(nezet,model);
        nezet.setVisible(true);
    }
}
