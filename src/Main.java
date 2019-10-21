public class Main {
    static final int PLACE_SIZE = 20;
    static final boolean PRINT_PARKING = true;
    private static final int NEXT_CAR_TIME = 1000;
    private static ParkingRunner runner = new ParkingRunner(NEXT_CAR_TIME);

    public static void main(String[] args) {
        runner.run();
    }

}
