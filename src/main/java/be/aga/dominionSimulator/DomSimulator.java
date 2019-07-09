package be.aga.dominionSimulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DomSimulator {
    final static Map<String, DomPlayer> PLAYER_TOTALS = new HashMap<String, DomPlayer>();

    private static void updateTotals(DomPlayer player) {
        final String key = "*" + player.getName();
        DomPlayer playerTotals = PLAYER_TOTALS.get(key);
        if (playerTotals == null) {
            playerTotals = player.getCopy(key);
            PLAYER_TOTALS.put(key, playerTotals);
        } else {
            playerTotals.addWins(player.getWins());
            playerTotals.addTie(player.getTies());
        }
    }
    
    public static void play1() {
        final DomEngine engine = new DomEngine();
        final boolean aShowLog = false;
        final int aNumber = 10000;
        final boolean keepOrder = false;
        final Map<String, DomPlayer> botMap =
                Arrays.asList(engine.getBotArray())
                .stream()
                .collect(Collectors.toMap(DomPlayer::getName, Function.identity()));

        List<DomPlayer> thePlayers = Arrays.asList(
            new DomPlayer[] {
                botMap.get("Beggar/Gardens"),
                botMap.get("ann game #1 - Mountebank/Warehouse")
            });

        
        engine.startSimulation(thePlayers, keepOrder, aNumber, aShowLog);
        
        thePlayers = Arrays.asList(
                new DomPlayer[] {
                    botMap.get("Chapel/Laboratory (Col)"),
                    botMap.get("Council Room/Goons")
                });
        engine.startSimulation(thePlayers, keepOrder, aNumber, aShowLog);
    }

    public static void main(String[] args) {
        play1();
    }
}
