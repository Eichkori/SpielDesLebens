package klassen;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class SpielDesLebens {
    private byte groesseRaster = 25;
    private byte[][] feld = new byte[groesseRaster][groesseRaster];
    private int maxAnzahlThreads= 1000;
    private ThreadPoolExecutor threadPool;
    private BlockingDeque<Runnable> blockingQueue;
    static ArrayList<Zelle> allezellen = new ArrayList<>();
    public Semaphore available = new Semaphore(1, true);


    public SpielDesLebens() {
        for (byte i = 0; i < feld.length; i++)
            for (byte j = 0; j< feld.length;j++)
                feld[j][i] = 0;

    }

    public void addZelle(Zelle z){
        allezellen.add(z);
        byte pos[] = z.getPosition();
        feld[pos[0]][pos[1]]= z.isAlivee()?(byte)1:(byte)0;
    }

    public void start(){
        for (Zelle x :allezellen) {
            x.start();
            //System.out.println(x+" gestartet");
        }
    }

    public synchronized boolean getCellAliveStatus(Zelle z){
        try {
            wait();
            //System.out.println(Thread.currentThread() + "legt los");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] zellposition = z.getPosition();

        byte[] pos1 = {(byte)(zellposition[0] - 1),(byte)(zellposition[1])};
        byte[] pos2 = {(byte)(zellposition[0] - 1),(byte)(zellposition[1] + 1)};
        byte[] pos3 = {(byte)(zellposition[0]),(byte)(zellposition[1] + 1)};
        byte[] pos4 = {(byte)(zellposition[0] + 1),(byte)(zellposition[1] + 1)};
        byte[] pos5 = {(byte)(zellposition[0] + 1),(byte)(zellposition[1])};
        byte[] pos6 = {(byte)(zellposition[0] + 1),(byte)(zellposition[1] - 1)};
        byte[] pos7 = {(byte)(zellposition[0]),(byte)(zellposition[1] - 1)};
        byte[] pos8 = {(byte)(zellposition[0] - 1),(byte)(zellposition[1] - 1)};


        if(z.isAlivee()){
            byte summeNachbarn=0;
            try { summeNachbarn+=feld[pos1[0]][pos1[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos2[0]][pos2[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos3[0]][pos3[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos4[0]][pos4[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos5[0]][pos5[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos6[0]][pos6[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos7[0]][pos7[1]]; } catch (Exception e){}
            try { summeNachbarn+=feld[pos8[0]][pos8[1]]; } catch (Exception e){}


            //System.out.println(Thread.currentThread()+" Summe:"+summeNachbarn);

            if(summeNachbarn < 2) {
                //System.out.println("Classes.Zelle " + zellposition[0] + "x" + zellposition[1] + " stirbt aus Einsahmkeit");
                feld[zellposition[0]][zellposition[1]]= 0;
                return false;
            }
            if(summeNachbarn == 2) {
                //System.out.println("Classes.Zelle " + zellposition[0] + "x" + zellposition[1] + " lebt");

                return true;
            }
            if(summeNachbarn == 3) {
                //System.out.println("Classes.Zelle " + zellposition[0] + "x" + zellposition[1] + " hat Sex");

                byte rand = getRandomNumber(1,8);
                try{if(feld[pos1[0]][pos1[1]]==0){feld[pos1[0]][pos1[1]]=1; new Zelle(pos1,this).start(); }}catch (Exception e){};
                try{if(feld[pos2[0]][pos2[1]]==0){feld[pos2[0]][pos2[1]]=1; new Zelle(pos2,this).start(); }}catch (Exception e){};
                try{if(feld[pos3[0]][pos3[1]]==0){feld[pos3[0]][pos3[1]]=1; new Zelle(pos3,this).start(); }}catch (Exception e){};
                try{if(feld[pos4[0]][pos4[1]]==0){feld[pos4[0]][pos4[1]]=1; new Zelle(pos4,this).start(); }}catch (Exception e){};
                try{if(feld[pos5[0]][pos5[1]]==0){feld[pos5[0]][pos5[1]]=1; new Zelle(pos5,this).start(); }}catch (Exception e){};
                try{if(feld[pos6[0]][pos6[1]]==0){feld[pos6[0]][pos6[1]]=1; new Zelle(pos6,this).start(); }}catch (Exception e){};
                try{if(feld[pos7[0]][pos7[1]]==0){feld[pos7[0]][pos7[1]]=1; new Zelle(pos7,this).start(); }}catch (Exception e){};
                try{if(feld[pos8[0]][pos8[1]]==0){feld[pos8[0]][pos8[1]]=1; new Zelle(pos8,this).start(); }}catch (Exception e){};
                return true;
            }
            if(summeNachbarn > 3) {
                //System.out.println("Classes.Zelle "+zellposition[0]+"x"+zellposition[1]+" stirbt aus Ueberbevoelerung");
                feld[zellposition[0]][zellposition[1]]= 0;
                return false;
            }

        }else{
            feld[zellposition[0]][zellposition[1]]=0;
            Thread.currentThread().interrupt();
        }

        return false;
    }
    public synchronized void nextGeneration(){
        notifyAll();
    }
    public void dump(){

        for (int i = 0; i < feld.length; i++)
        {
            for (int j = 0; j < feld[i].length; j++)
                System.out.print( feld[i][j]+"  ");
            System.out.println();
        }
        for (byte i = 0; i<groesseRaster*3;i++)
            System.out.print("-");
        System.out.println();
    }

    public synchronized byte getRandomNumber(int min, int max) {
        return (byte) ((Math.random() * (max - min)) + min);
    }



}
