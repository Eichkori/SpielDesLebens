package klassen;

public class Zelle extends Thread {

    private SpielDesLebens spiel;
    private byte[] position;
    private boolean isAlive;
    public Zelle(byte[] position, SpielDesLebens spiel) {

        this.position = position;
        isAlive = true;
        this.spiel=spiel;

    }

    public byte[] getPosition() {
        return position;
    }

    public void setPosition(byte[] position) {
        this.position = position;
    }

    public boolean isAlivee() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void run() {

        //System.out.println(Thread.currentThread()+" gestartet");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!isInterrupted()){
                isAlive=spiel.getCellAliveStatus(this);

        }
    }

}
