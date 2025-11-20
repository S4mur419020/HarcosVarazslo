package Main;

import Controller.HarcosVarazsloControl;
import Model.HarcosVarazsloModel;
import View.HarcosVarazslo;

public class Indito {

    public static void main(String[] args) {
        HarcosVarazsloModel.GameModel model = new HarcosVarazsloModel.GameModel();
        HarcosVarazslo gui = new HarcosVarazslo();
        new HarcosVarazsloControl(gui, model);
    }
}
