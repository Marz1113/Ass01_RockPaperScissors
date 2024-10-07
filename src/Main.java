import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playAgain;

        do {
            String player1 = "";
            while (true) {
                System.out.print("Player 1, enter your move (R, P, S): ");
                player1 = in.nextLine();
                if (player1.equalsIgnoreCase("R") ||
                        player1.equalsIgnoreCase("P") ||
                        player1.equalsIgnoreCase("S")) {
                    break;
                }
                System.out.println("Invalid move, please enter R, P, or S.");
            }

            String player2 = "";
            while (true) {
                System.out.print("Player 2, enter your move (R, P, S): ");
                player2 = in.nextLine();
                if (player2.equalsIgnoreCase("R") ||
                        player2.equalsIgnoreCase("P") ||
                        player2.equalsIgnoreCase("S")) {
                    break;
                }
                System.out.println("Invalid move, please enter R, P, or S.");
            }

            String result = determineWinner(player1, player2);
            System.out.println(result);

            System.out.print("Would you like to play again? (Y/N): ");
            playAgain = in.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        in.close();
    }

    public static String determineWinner(String playerOne, String playerTwo) {
        String moveA = playerOne.toUpperCase();
        String moveB = playerTwo.toUpperCase();

        if (moveA.equals(moveB)) {
            return moveA + " vs " + moveB + " - It's a draw!";
        }

        switch (moveA) {
            case "R":
                if (moveB.equals("S")) return "Rock crushes scissors, player 1 wins!";
                else return "Paper covers rock, player 2 wins!";
            case "P":
                if (moveB.equals("R")) return "Paper covers rock, player 1 wins!";
                else return "Scissors slashes paper, player 2 wins!";
            case "S":
                if (moveB.equals("P")) return "Scissors slashes paper, player 1 wins!";
                else return "Rock crushes scissors, player 2 wins!";
            default:
                return "Invalid move.";
        }
    }
}
