package com.github.brauchle.football.calc;

import com.github.brauchle.football.beans.AbstractMatchBean;
import com.github.brauchle.football.beans.TableDataBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by andreasbrauchle on 07.07.16.
 */
public class FormTableManager {

    private static Table[] tables = null;

    public static void createTable(int formLength, boolean saisonuebergreifend, List<? extends List<? extends List<? extends AbstractMatchBean>>> allMatches) {
        if (tables == null) {
            tables = new Table[formLength];
            for (int i = 0; i < formLength; i++) {
                tables[i] = new Table();
            }
        }

        HashMap<String, TableEntry> lastTable = null;

        String currentSeason = null;

        for (List<? extends List<? extends AbstractMatchBean>> saison : allMatches) {
            for (List<? extends AbstractMatchBean> matchDay : saison) {
                for (AbstractMatchBean matchBean : matchDay) {
                    if (currentSeason == null) {
                        currentSeason = matchBean.getSaison();
                    }
                    if (matchBean.getResult() != null) {
                        for (Table table : tables) {
                            table.addEntry(matchBean, null);
                        }
                    }

                    if (lastTable != null) {
                        setLastPostion(lastTable, matchBean.getTeamNameHome(), matchBean.getTableDataHome());
                        setLastPostion(lastTable, matchBean.getTeamNameAway(), matchBean.getTableDataAway());
                    }
                }
                lastTable = tables[0].createTable(currentSeason);

                moveTables(tables);
            }
            currentSeason = null;

            if (saisonuebergreifend == false) {
                //Reset am Saisonende
                for (Table table : tables) {
                    table.clear();
                }
                lastTable = null;
            }
        }
    }

    private static void moveTables(Table[] tables) {
        for (int i = 0; i < tables.length; i++) {
            if (i + 1 >= tables.length) {
                tables[i] = new Table();
                return;
            }else {
                tables[i] = tables[i + 1];
            }
        }
    }


    private static void setLastPostion(HashMap<String, TableEntry> lastTable, String teamName, TableDataBean data) {
        TableEntry teamEntry = lastTable.get(teamName);
        if (teamEntry != null) {
            data.setFormTableEntryLong(teamEntry);
        }
    }

    public static void clear() {
        tables = null;
    }
}
