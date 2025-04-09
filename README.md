# NIM Game with AI (Minimax)

This is a Java console-based implementation of the classic game **NIM**, featuring both:
- Two human players
- OR one human player vs AI (Minimax algorithm)

---

## Game Rules

- The game starts with a set of piles containing a number of objects (e.g., 3, 4, 5).
- Players take turns removing **one or more** objects from a single pile.
- The player who removes the **last object wins** the game.

---

## Features

- Play against another human **or** the computer.
- AI uses the **Minimax algorithm** with a full game tree evaluation.
- Clear console prompts and game state display after each move.
- Input validation to avoid invalid pile selection or move sizes.

---

## File Structure

| File | Description |
|------|-------------|
| `NimGame.java` | Main game loop and console interface |
| `GameState.java` | Represents the state of the game (used for AI search tree) |
| `AIPlayer.java` | Minimax algorithm implementation for AI decision making |
| `README.md` | Project description and instructions |

---