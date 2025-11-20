package Model;

import java.io.Serializable;

public class HarcosVarazsloModel {

    public class GameModel implements Serializable {

        private static final long serialVersionUID = 1L;

        private int harcosPoz = 0;
        private int varazsPoz = 2;
        private int meret = 3;

        public int getHarcosPoz() { return harcosPoz; }
        public int getVarazsPoz() { return varazsPoz; }

        public void leptet() {
            int kiLep = (int) (Math.random() * 2);
            int mennyit = 1 + (int) (Math.random() * 3);

            if (kiLep == 0) {
                harcosPoz = (harcosPoz + mennyit) % meret;
            } else {
                varazsPoz = (varazsPoz + mennyit) % meret;
            }
        }

        public boolean vanUtkozes() {
            return harcosPoz == varazsPoz;
        }
    }
}
