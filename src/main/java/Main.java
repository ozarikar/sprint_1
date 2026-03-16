
import robot.*;
import game.*;
import game.listener.*;
import tournament.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("## Strategy Interaction Tournament Simulator ##\n");
        
        // Creating the game (10 rounds of Prisoner's Dilemma)
        PrisonersDilemma game = new PrisonersDilemma(10);
        
        // Set up logging
        MoveListener moveLogger = new MoveListener("moves.log");
        ScoreListener scoreLogger = new ScoreListener("scores.log");
        game.addMoveListener(moveLogger);
        game.addScoreListener(scoreLogger);
        
        // Creating robots with different strategies
        Robot cooperator = new AlwaysCooperateBot("Cooperator");
        Robot defector = new AlwaysDefectBot("Defector");
        Robot titForTat = new TitForTatBot("TitForTat");
        
        // Creating Round Robin tournament
        Tournament tournament = new RoundRobinTournament(game);
        tournament.addPlayer(cooperator);
        tournament.addPlayer(defector);
        tournament.addPlayer(titForTat);
        
        // Run the tournament
        System.out.println("Starting Round Robin Tournament with 10 rounds per match\n");
        tournament.checkEnd();
        
        // Clean up
        moveLogger.close();
        scoreLogger.close();
        
        System.out.println("\nLogs saved to moves.log and scores.log");
    }
}