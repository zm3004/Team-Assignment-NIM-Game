import java.util.*;

public class NimGame {
    private List<Integer> piles;
    private Scanner scanner;
    private boolean isPlayerOneTurn;
    private boolean againstAI;

    public NimGame(List<Integer> initialPiles, boolean againstAI) {
        this.piles = new ArrayList<>(initialPiles);
        this.scanner = new Scanner(System.in);
        this.isPlayerOneTurn = true; // Player 1 starts
        this.againstAI = againstAI;
    }

    // Display the current state of the piles
    public void displayBoard() {
        System.out.println("\nCurrent Piles:");
        for (int i = 0; i < piles.size(); i++) {
            System.out.println("Pile " + i + ": " + piles.get(i));
        }
    }

    // Check if all piles are empty (game over)
    public boolean isGameOver() {
        for (int pile : piles) {
            if (pile > 0) return false;
        }
        return true;
    }

    // Handle move from a human player
    public void playerMove(int playerNumber) {
        while (true) {
            System.out.println("Player " + playerNumber + "'s turn:");
            System.out.print("Enter pile index: ");
            int index = scanner.nextInt();
            System.out.print("Enter number of objects to remove: ");
            int count = scanner.nextInt();

            if (index < 0 || index >= piles.size() || count <= 0 || count > piles.get(index)) {
                System.out.println("Invalid move. Try again.");
            } else {
                piles.set(index, piles.get(index) - count);
                break;
            }
        }
    }

    // Handle move from AI
    public void aiMove() {
        System.out.println("AI is thinking...");
        AIPlayer ai = new AIPlayer();
        GameState bestMove = ai.getBestMove(new GameState(piles, false));
        this.piles = bestMove.getPiles();
        System.out.println("AI has made its move.");
    }

    // Main game loop
    public void play() {
        while (!isGameOver()) {
            displayBoard();

            if (isPlayerOneTurn) {
                playerMove(1);
            } else {
                if (againstAI) {
                    aiMove();
                } else {
                    playerMove(2);
                }
            }

            isPlayerOneTurn = !isPlayerOneTurn;
        }

        displayBoard();
        if (isPlayerOneTurn) {
            System.out.println("\nGame Over. " + (againstAI ? "AI" : "Player 2") + " wins!");
        } else {
            System.out.println("\nGame Over. Player 1 wins!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NIM!");
        System.out.print("Play against AI? (yes/no): ");
        String mode = sc.nextLine().trim().toLowerCase();
        boolean againstAI = mode.equals("yes");

        //Change the initial setup here
        List<Integer> initialPiles = Arrays.asList(3, 4, 5);
        NimGame game = new NimGame(initialPiles, againstAI);
        game.play();
    }
}
