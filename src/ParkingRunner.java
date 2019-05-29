import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ParkingRunner {
    private ArrayList<Parking.Car> carsInEnqueue = new ArrayList<>();
    private Parking parking = new Parking();
    private int nextCarTime;


    public ParkingRunner(int nextCarTime) {
        this.nextCarTime = nextCarTime;
    }

    public void run(){
        Timer timer1 = new Timer();
        MyTimerTask timer1_task = new MyTimerTask();
        timer1.schedule(timer1_task, 0, nextCarTime);
    }


     private class MyTimerTask extends TimerTask {
        public void run() {
            Parking.Car car = new Parking.Car();
            carsInEnqueue.add(car);
            if (parking.carIn(car)) {
                carsInEnqueue.remove(0);
                car.start();
            }
        }
    }
}
