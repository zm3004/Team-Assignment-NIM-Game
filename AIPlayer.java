public class AIPlayer {

    public GameState getBestMove(GameState root) {
        minimax(root);
        // Return the child with the highest score (best move for AI)
        GameState bestMove = null;
        int bestScore = Integer.MIN_VALUE;

        for (GameState child : root.getChildren()) {
            if (child.getScore() > bestScore) {
                bestScore = child.getScore();
                bestMove = child;
            }
        }

        return bestMove != null ? bestMove : root; // Fallback to current state
    }

    private int minimax(GameState state) {
        if (state.isTerminal()) {
            int score = state.isPlayerTurn() ? 1 : -1; // If it's player's turn and game is over, AI won
            state.setScore(score);
            return score;
        }

        state.generateChildren();

        int bestScore;
        if (!state.isPlayerTurn()) {
            // AI's turn ¡ª maximize score
            bestScore = Integer.MIN_VALUE;
            for (GameState child : state.getChildren()) {
                int childScore = minimax(child);
                bestScore = Math.max(bestScore, childScore);
            }
        } else {
            // Player's turn ¡ª minimize score
            bestScore = Integer.MAX_VALUE;
            for (GameState child : state.getChildren()) {
                int childScore = minimax(child);
                bestScore = Math.min(bestScore, childScore);
            }
        }

        state.setScore(bestScore);
        return bestScore;
    }
}
