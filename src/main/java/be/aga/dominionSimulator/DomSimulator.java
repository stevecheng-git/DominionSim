package be.aga.dominionSimulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DomSimulator {
    final static Map<String, DomPlayerStat> PLAYER_TOTALS = new HashMap<String, DomPlayerStat>();

    private static void updateTotals(DomPlayer player) {
        final String key = player.getName();
        DomPlayerStat playerStats = PLAYER_TOTALS.get(key); 
        if (playerStats == null) {
            playerStats = new DomPlayerStat(key);
            PLAYER_TOTALS.put(key, playerStats);
        }
        playerStats.updateWins(player);
    }
    
    public static void play1() {
        final DomEngine engine = new DomEngine();
        final boolean aShowLog = false;
        final int aNumber = 1000;
        final boolean keepOrder = false;
        final Map<String, DomPlayer> botMap =
                Arrays.asList(engine.getBotArray())
                .stream()
                .collect(Collectors.toMap(DomPlayer::getName, Function.identity()));

        HashSet<DomPlayer> uniquePlayers = new HashSet<DomPlayer>();
        List<DomPlayer> thePlayers;
        thePlayers = Arrays.asList(
            new DomPlayer[] {
                botMap.get("Chapel/Laboratory (Col)"),
 //               botMap.get("Beggar/Gardens"),
                botMap.get("ann game #1 - Mountebank/Warehouse")
            });
        engine.startSimulation(thePlayers, keepOrder, aNumber, aShowLog, PLAYER_TOTALS);
        uniquePlayers.addAll(thePlayers);
//        thePlayers.stream().forEach(p -> updateTotals(p, aNumber));

        thePlayers = Arrays.asList(
            new DomPlayer[] {
                botMap.get("Chapel/Laboratory (Col)"),
                botMap.get("Council Room/Goons")
            });
        engine.startSimulation(thePlayers, keepOrder, aNumber, aShowLog, PLAYER_TOTALS);
        uniquePlayers.addAll(thePlayers);
        uniquePlayers.stream().forEach(p -> updateTotals(p));

        PLAYER_TOTALS.forEach((a, b) -> { System.out.println(b); });
    }

    public static void main(String[] args) {
        play1();
    }
}
