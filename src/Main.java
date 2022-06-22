package src;

import src.Zelle;
import src.SpielDesLebens;

public class Main {
    public static void main(String[] args) {
        //Main Class
        SpielDesLebens spiel = new SpielDesLebens();
        spiel.dump();
        spiel.addZell(new Zelle(new byte[]{5, 5}, spiel));
        spiel.addZell(new Zelle(new byte[]{5, 6}, spiel));
        spiel.addZell(new Zelle(new byte[]{5, 4}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 5}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 6}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 4}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 7}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 8}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 9}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 4}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 5}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 6}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 7}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 8}, spiel));
        spiel.addZell(new Zelle(new byte[]{7, 9}, spiel));
        spiel.addZell(new Zelle(new byte[]{6, 10}, spiel));

        spiel.start();
        while(true){
            spiel.dump();
            spiel.nextGeneration();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
