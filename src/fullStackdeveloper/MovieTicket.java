package fullStackdeveloper;
// Demonstrate Program for Movie Ticket-static

	import java.util.Scanner;

	class Ticket {
	    private int ticketId;
	    private int price;
	    private static int availableTickets;

	    public Ticket(int ticketId, int price) {
	        this.ticketId = ticketId;
	        this.price = price;
	    }

	    public static int getAvailableTickets() {
	        return availableTickets;
	    }

	    public static void setAvailableTickets(int availableTickets) {
	        Ticket.availableTickets = availableTickets;
	    }

	    public int getTicketId() {
	        return ticketId;
	    }

	    public void setTicketId(int ticketId) {
	        this.ticketId = ticketId;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int calculateTicketCost(int noOfTickets) {
	        if (availableTickets >= noOfTickets) {
	            return noOfTickets * price;
	        } else {
	            return -1;
	        }
	    }
	}

	public class MovieTicket {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter movie name");
	        String movieName = scanner.nextLine();

	        System.out.println("Enter no of bookings");
	        int noOfBookings = scanner.nextInt();

	        System.out.println("Enter the available tickets");
	        int availableTickets = scanner.nextInt();

	        Ticket.setAvailableTickets(availableTickets);

	        for (int i = 0; i < noOfBookings; i++) {
	            System.out.println("Enter the ticketid");
	            int ticketId = scanner.nextInt();

	            System.out.println("Enter the price");
	            int price = scanner.nextInt();

	            System.out.println("Enter the no of tickets");
	            int noOfTickets = scanner.nextInt();

	            int totalAmount = Ticket.getAvailableTickets() >= noOfTickets ?
	                              new Ticket(ticketId, price).calculateTicketCost(noOfTickets) :
	                              -1;

	            if (totalAmount == -1) {
	                System.out.println("Tickets are not available");
	            } else {
	                System.out.println("Available tickets: " + Ticket.getAvailableTickets());
	                System.out.println("Total amount: " + totalAmount);
	                Ticket.setAvailableTickets(Ticket.getAvailableTickets() - noOfTickets);
	                System.out.println("Available ticket after booking: " + Ticket.getAvailableTickets());
	            }
	        }

	        if (Ticket.getAvailableTickets() == 0) {
	            System.out.println("House full");
	        }

	        scanner.close();
	    }
	}
