package be.aga.dominionSimulator;

public class DomPlayerStat {

    private String name;
    private int games = 0;
    private int wins = 0;
    private int ties = 0;
    private int cards = 0;
    private int maxCards = 0;
    private DomCost potentialCurrency = DomCost.ZERO;
    private DomCost availableCurrency = DomCost.ZERO;
    private int availableCoins = 0;
    private int moneyInDeck = 0;
    private double treasure = 0.0d;
    private int turns = 0;
    private int victoryPoints = 0;
    private int victoryTokens = 0;
    private int maxVictoryPoints = 0;
    private double maxOpponentsVictoryPoints = 0;
    
    public DomPlayerStat(String name) {
        this.name = name;
    }
    
    public String toString() {
//        return toString2();
        StringBuilder s = new StringBuilder();
        s.append(String.format("name=%s, ", name));
        s.append(String.format("totalWinPercentage=%2.2f, ", ((float) wins*100/games)));
        s.append(String.format("totalGames=%d, ", games));
        s.append(String.format("totalWins=%d, ", wins));
        s.append(String.format("totalTies=%d, ", ties));
//        s.append(String.format("totalTreasure=%f, ", treasure));
//        s.append("\r\n");
        s.append(String.format("totalAvailableCoins=%d, ", availableCoins));
        s.append(String.format("totalMoneyInDeck=%d, ", moneyInDeck));
        s.append(String.format("totalTurns=%d, ", turns));
        s.append(String.format("totalVictoryPoints=%d, ", victoryPoints));
        s.append(String.format("maxVictoryPoints=%d, ", maxVictoryPoints));
        s.append(String.format("maxOpponentsVictoryPoints=%f, ", maxOpponentsVictoryPoints));
        s.append(String.format("totalCards=%d, ", cards));
        s.append(String.format("maxCards=%d, ", maxCards));        
        return s.toString();
    }

    public String toString2() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%s, %2.2f, %d, %d, %d, %d, %d, %d, %d, %d, %f, %d, %d"
                , name, ((float) wins*100/games), games, wins, ties, availableCoins, moneyInDeck
                , turns, victoryPoints, maxVictoryPoints, maxOpponentsVictoryPoints, cards, maxCards));
        return s.toString();
    }

    public void updateWins(DomPlayer player) {
        wins += player.getWins();
        ties += player.getTies();
    }

    public void updateGameStats(DomPlayer player, int games) {
        this.games += games;
        potentialCurrency = potentialCurrency.add(player.getTotalPotentialCurrency());
        availableCurrency = availableCurrency.add(player.getTotalAvailableCurrency());
        availableCoins += player.getAvailableCoins();
        moneyInDeck += player.getTotalMoneyInDeck();
        treasure += player.getTotalTreasure();
        turns += player.getTurns();
        final int countAllCards = player.countAllCards();
        cards += countAllCards;
        victoryPoints += player.countVictoryPoints();
        victoryTokens += player.getVictoryTokens();
        maxVictoryPoints = Math.max(maxVictoryPoints, player.countVictoryPoints());
        maxOpponentsVictoryPoints = Math.max(maxOpponentsVictoryPoints, player.countMaxOpponentsVictoryPoints());
        maxCards = Math.max(maxCards, countAllCards);
    }
    
    public String getName() {
        return name;
    }
    public int getGames() {
        return games;
    }
    public int getWins() {
        return wins;
    }
    public int getTies() {
        return ties;
    }
    public DomCost getPotentialCurrency() {
        return potentialCurrency;
    }
    public DomCost getAvailableCurrency() {
        return availableCurrency;
    }
    public int getAvailableCoins() {
        return availableCoins;
    }
    public int getMoneyInDeck() {
        return moneyInDeck;
    }
    public double getTreasure() {
        return treasure;
    }
    public int getTurns() {
        return turns;
    }
    public int getVictoryTokens() {
        return victoryTokens;
    }
    public int getVictoryPoints() {
        return victoryPoints;
    }
    public int getMaxVictoryPoints() {
        return maxVictoryPoints;
    }
    public double getMaxOpponentsVictoryPoints() {
        return maxOpponentsVictoryPoints;
    }

    public int getCards() {
        return cards;
    }
    public int getMaxCards() {
        return maxCards;
    }
}
