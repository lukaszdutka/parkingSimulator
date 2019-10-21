import java.util.Random;

public class Parking {

    private static Car[] places = new Car[Main.PLACE_SIZE];

    private static int emptyPlaces = Main.PLACE_SIZE;

    private static void printParking() {
        for (int i = 0; i < Main.PLACE_SIZE; i++) {
            if (i % 10 == 0 && i != 0) System.out.println("|");

            if (places[i] != null) {
                System.out.print("| " + places[i].getId() + " ");
            } else {
                System.out.print("| X ");
            }
        }
        System.out.println("|\n\n");
    }

    synchronized boolean carIn(Car car) {
        if (emptyPlaces > 0) {
            for (int i = 0; i < places.length; i++) {
                if (places[i] == null) {
                    places[i] = car;
                    emptyPlaces--;
                    printParking();
                    return true;
                }
            }
        }
        return false;
    }


    public static class Car extends Thread {
        private int parkingPlace;
        private long startTime;
        private Random random = new Random();

        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            int timeToStay = (random.nextInt(9) + 1) * 1000;

            try {
                sleep(timeToStay);
                emptyPlaces++;
                places[parkingPlace] = null;
                if (Main.PRINT_PARKING) {
                    printParking();
                }
                this.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.run();
        }
    }
}
