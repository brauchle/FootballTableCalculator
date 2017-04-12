package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public abstract class AbstractMatchBean {
    abstract public String getSaison();
    abstract public String getErgebnis();
    abstract public String getHeimName();
    abstract public String getGastName();
    abstract public Integer getToreHeim();
    abstract public Integer getToreGast();
    abstract public TableDataBean getTableDataHome();
    abstract public TableDataBean getTableDataAway();
}
