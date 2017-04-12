package com.github.brauchle.football.calc.demoBeans;

import com.github.brauchle.football.beans.AbstractMatchBean;
import com.github.brauchle.football.beans.TableDataBean;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public class DemoMatchBean extends AbstractMatchBean {

    private String saison;
    private String heimName;
    private String gastName;
    private String ergebnis;
    private Integer toreHeim;
    private Integer toreGast;

    private TableDataBean dataHeim;
    private TableDataBean dataGast;


    public DemoMatchBean() {
        dataHeim = new TableDataBean();
        dataGast = new TableDataBean();
    }

    @Override
    public String getSaison() {
        return saison;
    }

    @Override
    public String getErgebnis() {
        return ergebnis;
    }

    @Override
    public String getHeimName() {
        return heimName;
    }

    @Override
    public String getGastName() {
        return gastName;
    }

    @Override
    public Integer getToreHeim() {
        return toreHeim;
    }

    @Override
    public Integer getToreGast() {
        return toreGast;
    }

    @Override
    public TableDataBean getTableDataHome() {
        return dataHeim;
    }

    @Override
    public TableDataBean getTableDataAway() {
        return dataGast;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public void setHeimName(String heimName) {
        this.heimName = heimName;
    }

    public void setGastName(String gastName) {
        this.gastName = gastName;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    public void setToreHeim(Integer toreHeim) {
        this.toreHeim = toreHeim;
    }

    public void setToreGast(Integer toreGast) {
        this.toreGast = toreGast;
    }
}
