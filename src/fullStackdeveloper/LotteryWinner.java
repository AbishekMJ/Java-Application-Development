package fullStackdeveloper;

import java.util.Scanner;

class LotteryTicket {
    private String ticketId;
    private int unluckyCode;

    public LotteryTicket(String ticketId, int unluckyCode) {
        this.ticketId = ticketId;
        this.unluckyCode = unluckyCode;
    }

    public String checkLuckiness() {
        int count = 0;
        for (char digit : ticketId.toCharArray()) {
            int num = Character.getNumericValue(digit);
            if (num == unluckyCode) {
                count++;
            }
        }

        if (count == 0) {
            return ticketId + " is lucky ticket";
        } else if (count < 3) {
            return ticketId + " is partially lucky";
        } else {
            return ticketId + " is unlucky ticket";
        }
    }
}

public class LotteryWinner{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ticket Id");
        String ticketId = scanner.nextLine();

        System.out.println("Enter the unlucky code");
        int unluckyCode = scanner.nextInt();

        LotteryTicket ticket = new LotteryTicket(ticketId, unluckyCode);
        String result = ticket.checkLuckiness();
        System.out.println(result);

        scanner.close();
    }
}


