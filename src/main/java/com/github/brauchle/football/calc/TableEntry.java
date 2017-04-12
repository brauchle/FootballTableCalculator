package com.github.brauchle.football.calc;

/**
 * Created by andreasbrauchle on 07.07.16.
 */
public class TableEntry {

    private int currentPosition;
    private String team;
    private int wins;
    private int draws;
    private int defeats;
    private int points;
    private int goalsShot;
    private int goalsConceeded;

    public TableEntry(String teamName) {
        this.team = teamName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public void setGoalsShot(int goalsShot) {
        this.goalsShot = goalsShot;
    }

    public int getGoalsConceeded() {
        return goalsConceeded;
    }

    public void setGoalsConceeded(int goalsConceeded) {
        this.goalsConceeded = goalsConceeded;
    }

    public void addWin(int goalsShot, int goalsConceeded) {
        setWins(getWins() + 1);
        setPoints(getPoints() + 3);
        addGoals(goalsShot, goalsConceeded);
    }

    public void addDefeat(int goalsShot, int goalsConceeded) {
        setDefeats(getDefeats() + 1);
        setPoints(getPoints() + 0);
        addGoals(goalsShot, goalsConceeded);
    }

    public void addDraw(int goalsShot, int goalsConceeded) {
        setDraws(getDraws() + 1);
        setPoints(getPoints() + 1);
        addGoals(goalsShot, goalsConceeded);
    }

    private void addGoals(int goalsShot, int goalsConceeded){
        setGoalsShot(getGoalsShot() + goalsShot);
        setGoalsConceeded(getGoalsConceeded() + goalsConceeded);
    }

    public int getGoalDifference(){
        return getGoalsShot() - getGoalsConceeded();
    }

    public int getMatchCount(){
        return wins + draws + defeats;
    }

    public TableEntry cloneObject(){
        TableEntry tr = new TableEntry(getTeam());
        tr.setCurrentPosition(getCurrentPosition());
        tr.setGoalsConceeded(getGoalsConceeded());
        tr.setGoalsShot(getGoalsShot());
        tr.setWins(getWins());
        tr.setDraws(getDraws());
        tr.setDefeats(getDefeats());
        tr.setPoints(getPoints());

        return tr;
    }

    public int compareTo(TableEntry o2){
        TableEntry o1 = this;
        int compare = new Integer(o1.getPoints()).compareTo(new Integer(o2.getPoints()));
        if (compare != 0) {
            return compare;
        } else {
            //check for the GoalDifference
            int compare1 = new Integer(o1.getGoalDifference()).compareTo(new Integer(o2.getGoalDifference()));
            if (compare1 != 0) {
                return compare1;
            } else {
                //check for #GoalsShot
                int compare2 = new Integer(o1.getGoalsShot()).compareTo(new Integer(o2.getGoalsShot()));
                if (compare2 != 0) {
                    return compare2;
                }

                //check for #GoalsConceeded
                int compare3 = new Integer(o1.getGoalsConceeded()).compareTo(new Integer(o2.getGoalsConceeded()));
                if (compare3 != 0) {
                    // because it's better to conceed less goals
                    return compare3 * -1;
                }

                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "TableEntry{" +
                "currentPosition=" + currentPosition +
                ", team='" + team + '\'' +
                ", wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", points=" + points +
                ", goalsShot=" + goalsShot +
                ", goalsConceeded=" + goalsConceeded +
                ", goalDifference=" + (goalsShot - goalsConceeded) +
                '}';
    }
}
