package com.uas.prakrplbo;

public class Evolusi extends Monster {
    Monster monster1;
    Monster monster2;

    public Evolusi(Monster monster1, Monster monster2) {
        super(monster1.getNama() + " " + monster2.getNama());
        this.monster1 = monster1;
        this.monster2 = monster2;
    }

    public String bersuara() {
        StringBuilder nama = new StringBuilder();
        String[] suara1;
        suara1 = monster1.bersuara().split("");
        String[] suara2;
        suara2 = monster2.bersuara().split("");
        int i = 0;
        if (i < 8) {
            do {
                switch (i % 2) {
                    case 0:
                        nama.append(suara2[i]);
                        break;
                    default:
                        nama.append(suara1[i]);
                        break;
                }
                i++;
            } while (i < 8);
        }
        return nama.toString();
    }

    @Override
    public String bergerak() {
        return monster2.bergerak();
    }
}
