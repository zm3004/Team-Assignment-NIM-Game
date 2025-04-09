import java.util.*;

public class GameState {
    private List<Integer> piles;
    private boolean isPlayerTurn; // true = human, false = AI
    private int score; // Evaluation score for Minimax
    private List<GameState> children;

    public GameState(List<Integer> piles, boolean isPlayerTurn) {
        // Deep copy of piles to avoid shared references
        this.piles = new ArrayList<>(piles);
        this.isPlayerTurn = isPlayerTurn;
        this.children = new ArrayList<>();
    }

    public List<Integer> getPiles() {
        return piles;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public int getScore() {
        return score;
    }

    public List<GameState> getChildren() {
        return children;
    }

    public boolean isTerminal() {
        for (int pile : piles) {
            if (pile > 0) return false;
        }
        return true;
    }

    public void generateChildren() {
        // Generate all possible moves for the current player
        for (int i = 0; i < piles.size(); i++) {
            int pileCount = piles.get(i);
            for (int remove = 1; remove <= pileCount; remove++) {
                List<Integer> newPiles = new ArrayList<>(piles);
                newPiles.set(i, pileCount - remove);
                children.add(new GameState(newPiles, !isPlayerTurn));
            }
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
}
