public class Main {
    static final int PLACE_SIZE = 20;
    private static final int NEXT_CAR_TIME = 1000;
    static ParkingRunner runner = new ParkingRunner(NEXT_CAR_TIME);


    public static void main(String args[]) {
        runner.run();
    }

}
