package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public class SimpleMatchBean extends AbstractMatchBean {

    private String saison;
    private String teamNameHome;
    private String teamNameAway;
    private MATCH_RESULT_ENUM result;
    private Integer goalsShotHome;
    private Integer goalsShotAway;

    private TableDataBean dataHeim;
    private TableDataBean dataGast;


    public SimpleMatchBean() {
        dataHeim = new TableDataBean();
        dataGast = new TableDataBean();
    }

    @Override
    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    @Override
    public String getTeamNameHome() {
        return teamNameHome;
    }

    public void setTeamNameHome(String teamNameHome) {
        this.teamNameHome = teamNameHome;
    }

    @Override
    public String getTeamNameAway() {
        return teamNameAway;
    }

    public void setTeamNameAway(String teamNameAway) {
        this.teamNameAway = teamNameAway;
    }

    @Override
    public MATCH_RESULT_ENUM getResult() {
        return result;
    }

    public void setResult(MATCH_RESULT_ENUM result) {
        this.result = result;
    }

    @Override
    public Integer getGoalsShotHome() {
        return goalsShotHome;
    }

    public void setGoalsShotHome(Integer goalsShotHome) {
        this.goalsShotHome = goalsShotHome;
    }

    @Override
    public Integer getGoalsShotAway() {
        return goalsShotAway;
    }

    public void setGoalsShotAway(Integer goalsShotAway) {
        this.goalsShotAway = goalsShotAway;
    }

    @Override
    public TableDataBean getTableDataHome() {
        return dataHeim;
    }

    @Override
    public TableDataBean getTableDataAway() {
        return dataGast;
    }
}
