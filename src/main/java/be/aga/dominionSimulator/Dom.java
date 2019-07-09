package be.aga.dominionSimulator;

import java.util.ArrayList;

import be.aga.dominionSimulator.gui.DomBarChart;
import be.aga.dominionSimulator.gui.DomLineChart;

public interface Dom {
    public void setVisible(boolean b);
    public void setMoneyLineChart( DomLineChart aChart );
    public void setVPLineChart( DomLineChart aChart );
    public void setBarChart( DomBarChart aChart );
    public void validate();
    public void showWinPercentage(DomPlayer thePlayer, int i);
    public void showTiePercentage(int i);
    public void showAverageTurns(double aAverageTurns);
    public void showTime(double aTime);
    public void show3EmptyPilesEndings(double d);
    public void refreshBotSelectors(DomPlayer theNewPlayer);
    public ArrayList<DomPlayer> initPlayers();
    public void showSampleGame();
    public boolean getOrderBoxSelected();

}
