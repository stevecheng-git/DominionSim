package be.aga.dominionSimulator;

import java.util.ArrayList;

import be.aga.dominionSimulator.gui.DomBarChart;
import be.aga.dominionSimulator.gui.DomLineChart;

public class HeadlessDom implements Dom {

    public HeadlessDom(DomEngine anEngine) {
    }
    
    @Override
    public void setVisible(boolean b) {
    }
    @Override
    public void setMoneyLineChart( DomLineChart aChart ) {
    }
    @Override
    public void setVPLineChart( DomLineChart aChart ) {
    }
    @Override
    public void setBarChart( DomBarChart aChart ) {
    }
    @Override
    public void validate() {
    }
    @Override
    public void showWinPercentage(DomPlayer thePlayer, int i) {
    }
    public void showTiePercentage(int i) {
    }
    @Override
    public void showAverageTurns(double aAverageTurns) {
    }
    @Override
    public void showTime(double aTime) {
    }
    @Override
    public void show3EmptyPilesEndings(double d) {
    }
    public void refreshBotSelectors(DomPlayer theNewPlayer) {
    }
    public ArrayList<DomPlayer> initPlayers() {
        return new ArrayList<DomPlayer>();
    }
    public void showSampleGame() {
    }
    public boolean getOrderBoxSelected() {
        throw new UnsupportedOperationException();
    }
}
