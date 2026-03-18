package tournament;

import robot.Robot;
import game.Game;
import java.util.List;
import java.util.ArrayList;

/**
 * Abstract class for tournaments.
 * Template Method pattern
 */
public abstract class Tournament {
    protected Game game;
    protected List<Robot> players;
    
    public Tournament(Game game) {
        this.game = game;
        this.players = new ArrayList<>();
    }
    
    // Runs the tournament
    
    public void checkEnd() {
        List<int[]> bracket = getBracket();
        
        for (int[] matchup : bracket) {
            Robot robot1 = players.get(matchup[0]);
            Robot robot2 = players.get(matchup[1]);
            
            System.out.println("\nMatch: " + robot1.getName() + " vs " + robot2.getName());
            int[] finalScores = game.run(robot1, robot2);
            System.out.println("Final Scores - " + robot1.getName() + ": " + 
                             finalScores[0] + ", " + robot2.getName() + ": " + finalScores[1]);
        }
        
        printFinalStandings();
    }
    
    /**
     * Abstract method that determines matchups for the tournament.
     * @return a list of matchups, each as [player1_Index, player2_Index]
     */
    protected abstract List<int[]> getBracket();
    
    // Adds a robot to the tournament.

    public void addPlayer(Robot robot) {
        players.add(robot);
    }
    
    // Prints final standings after tournament.

    protected void printFinalStandings() {
        System.out.println("\n ## Final Standings ##");
        List<Robot> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((r1, r2) -> r2.getScore() - r1.getScore());
        
        int rank = 1;
        for (Robot robot : sortedPlayers) {
            System.out.println(rank + ". " + robot.getName() + ": " + robot.getScore() + " points");
            rank++;
        }
    }
}