import klassen.SpielDesLebens;
import klassen.Zelle;

public class Main {
    public static void main(String[] args) {
        SpielDesLebens spiel = new SpielDesLebens();
        spiel.dump();
        spiel.addZelle(new Zelle(new byte[]{5, 5}, spiel));
        spiel.addZelle(new Zelle(new byte[]{5, 6}, spiel));
        spiel.addZelle(new Zelle(new byte[]{5, 4}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 5}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 6}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 4}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 7}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 8}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 9}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 4}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 5}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 6}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 7}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 8}, spiel));
        spiel.addZelle(new Zelle(new byte[]{7, 9}, spiel));
        spiel.addZelle(new Zelle(new byte[]{6, 10}, spiel));

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
