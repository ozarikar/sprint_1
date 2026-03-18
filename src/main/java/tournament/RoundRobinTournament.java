package tournament;

import game.Game;
import java.util.ArrayList;
import java.util.List;

/**
 * Round Robin tournament format.
 * Every player plays against every other player exactly once.
 */
public class RoundRobinTournament extends Tournament {
    
    public RoundRobinTournament(Game game) {
        super(game);
    }
    
    @Override
    protected List<int[]> getBracket() {
        List<int[]> matchups = new ArrayList<>();
        
        // Generate all unique pairs
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                matchups.add(new int[] { i, j });
            }
        }
        
        return matchups;
    }
}