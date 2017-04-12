package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public abstract class AbstractMatchBean {
    abstract public String getSaison();

    abstract public MATCH_RESULT_ENUM getResult();

    abstract public String getTeamNameHome();

    abstract public String getTeamNameAway();

    abstract public Integer getGoalsShotHome();

    abstract public Integer getGoalsShotAway();

    abstract public TableDataBean getTableDataHome();
    abstract public TableDataBean getTableDataAway();
}
