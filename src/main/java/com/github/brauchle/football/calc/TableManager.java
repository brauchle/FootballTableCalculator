package com.github.brauchle.football.calc;

import com.github.brauchle.football.beans.AbstractMatchBean;
import com.github.brauchle.football.beans.TableDataBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by andreasbrauchle on 07.07.16.
 */
public class TableManager {
    private HashMap<String, TableEntry> lastTable = null;
    private HashMap<String, TableEntry> lastSeasonTable = null;

    public void createTable(List<? extends List<? extends List<? extends AbstractMatchBean>>> all) {
        Table table = new Table();

        for (List<? extends List<? extends AbstractMatchBean>> saison : all) {
            for (List<? extends AbstractMatchBean> matchday : saison) {
                for (AbstractMatchBean matchBean : matchday) {
                    if (matchBean.getErgebnis() != null) {
                        table.addEntry(matchBean, null);
                    }
                    if (lastTable != null) {
                        setLastPostion(lastTable, lastSeasonTable, matchBean.getHeimName(), matchBean.getTableDataHome());
                        setLastPostion(lastTable, lastSeasonTable, matchBean.getGastName(), matchBean.getTableDataAway());
                    }
                }

                lastTable = table.createTable(null);
            }
            table.clear();
            lastSeasonTable = lastTable;
        }
    }

    public List<TableEntry> getTable(){
        if (lastTable != null) {
            return new ArrayList<>(lastTable.values());
        }
        return null;
    }

    private void setLastPostion(HashMap<String, TableEntry> lastTable, HashMap<String, TableEntry> lastSeasonTable, String teamName, TableDataBean data) {
        TableEntry teamEntry = lastTable.get(teamName);
        if (teamEntry != null) {
            data.setTableEntry(teamEntry);
            data.setLastSeasonTableEntry(teamEntry);
        }

        if (lastSeasonTable != null) {
            TableEntry teamEntrySeason = lastSeasonTable.get(teamName);
            if (teamEntrySeason != null) {
                data.setLastSeasonTableEntry(teamEntrySeason);
            }
        }
    }
}
