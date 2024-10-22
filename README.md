# Connect Four Game

This is a Java-based implementation of the classic Connect Four game, with support for both human and AI players. The game uses the Minimax Monte Carlo Tree Search (MCTS) algorithm to control the AI opponent, making it challenging for players.

## Features

- **Two-player mode:** Play against another person.
- **AI mode:** Challenge the AI, which uses MCTS for decision-making.
- **Graphical user interface (GUI):** Visualize the game board and moves.
- **Winner detection:** Automatically identifies the winner or detects a draw.
- **Legal move checking:** Ensures moves are made within the rules.
- **MVC architecture:** Organized code structure following Model-View-Controller design pattern.


### Key Classes

1. **`AiPlayer.java`**
   - Represents the AI player using MCTS.
   - Implements the logic to decide the best column to place the piece.
   - Checks for legal moves and updates the game state accordingly.

2. **`Board.java`**
   - Handles the game board's state and operations.
   - Contains methods for checking the legality of moves, updating the board, and detecting winners.

3. **`HumanPlayer.java`**
   - Represents a human player in the game.

4. **`CreatePlayerController.java`**
   - Manages the player creation and selection of human vs. AI mode.

5. **`Launcher.java`**
   - Entry point for launching the application.

### How to Play

1. **Run the Application**
   - Use an IDE like IntelliJ or Eclipse to run the `Launcher.java` file.

2. **Select Mode**
   - Choose to play against another player or the AI.

3. **Make Moves**
   - Players take turns dropping pieces in one of the columns.
   - The first player to connect four pieces vertically, horizontally, or diagonally wins.

4. **Game End**
   - If no more legal moves are possible and no winner is found, the game ends in a draw.

## How to Build

1. **Prerequisites**
   - Java Development Kit (JDK) 8 or above.
   - An IDE or command-line tools for Java development.

2. **Steps**
   - Clone the repository.
   - Open the project in your favorite Java IDE.
   - Build the project to ensure all dependencies are met.

## Future Enhancements

- Add difficulty levels for the AI.
- Implement online multiplayer mode.
- Enhance the UI with animations.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
