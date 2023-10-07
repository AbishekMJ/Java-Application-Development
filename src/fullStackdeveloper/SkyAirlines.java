package fullStackdeveloper;

import java.util.Scanner;

class SkyAir {
    private String name;
    private String source;
    private String destination;

    public SkyAir(String name, String source, String destination) {
        this.name = name;
        this.source = source;
        this.destination = destination;
    }

    public void printWelcomeMessage() {
        System.out.println("Dear " + name + ", welcome onboard with service from " + source + " to " + destination + ". Thank you for choosing Sky Airlines. Enjoy your flight.");
    }
}

public class SkyAirlines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter source");
        String source = scanner.nextLine();

        System.out.println("Enter destination");
        String destination = scanner.nextLine();

        SkyAir skyAir = new SkyAir(name, source, destination);
        skyAir.printWelcomeMessage();

        scanner.close();
    }
}
