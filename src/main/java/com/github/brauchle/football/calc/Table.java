package com.github.brauchle.football.calc;

import com.github.brauchle.football.beans.AbstractMatchBean;
import com.github.brauchle.football.beans.TableDataBean;

import java.util.*;

/**
 * Created by andreasbrauchle on 07.07.16.
 */
public class Table {
    public final HashMap<String, TableEntry> table = new HashMap<>();

    public void addEntry(AbstractMatchBean matchBean, Boolean home){
        if (home == null || home == true) {
            //Home-Fixure
            addResult(getEntryForTeam(matchBean.getHeimName()), matchBean.getErgebnis(), true, matchBean.getToreHeim(), matchBean.getToreGast(), matchBean.getTableDataHome());
        }

        if (home == null || home == false) {
            //Away-Fixure
            addResult(getEntryForTeam(matchBean.getGastName()), matchBean.getErgebnis(), false, matchBean.getToreGast(), matchBean.getToreHeim(), matchBean.getTableDataAway());
        }
    }

    private  void addResult(TableEntry tableEntryHome, String result, Boolean wasHome, int goalsShot, int goalsConceeded, TableDataBean dataHeim){
        boolean won = false;
        boolean lost = false;

        if (result.equals("X")) {
            //draw
        } else if (result.equals("1") && wasHome) {
            won = true;
        } else if (result.equals("2") && wasHome == false) {
            won = true;
        } else {
            lost = true;
        }

        if (won) {
            tableEntryHome.addWin(goalsShot, goalsConceeded);
        }else if (lost) {
            tableEntryHome.addDefeat(goalsShot, goalsConceeded);
        }else {
            tableEntryHome.addDraw(goalsShot, goalsConceeded);
        }
    }

    public void clear(){
        table.clear();
    }

    private TableEntry getEntryForTeam(String teamName){
        TableEntry tableEntry = table.get(teamName);
        if (tableEntry == null) {
            tableEntry = new TableEntry(teamName);
            table.put(teamName, tableEntry);
        }
        return tableEntry;
    }

    public class CustomComparator implements Comparator<TableEntry> {
        @Override
        public int compare(TableEntry o1, TableEntry o2) {
            return o1.compareTo(o2);
        }
    }

    public HashMap<String, TableEntry> createTable(String currentSeason){
        //remove relegated teams
        if (table.size() > 18 && currentSeason != null) {
            List<String> relegatedTeams = RelegatedTeams.getRelegatedTeams(currentSeason);
            for (String relegatedTeam : relegatedTeams) {
                table.remove(relegatedTeam);
            }
        }


        ArrayList<TableEntry> sortedTableList = new ArrayList<>(table.values());
        //sort the Table
        Collections.sort(sortedTableList, new CustomComparator());

        HashMap<String, TableEntry> returnMap = new HashMap<>();
        int pos = 1;
        TableEntry tableEntryBefore = null;
        int lastPosition = pos;
        for (int i = sortedTableList.size() - 1; i >= 0; i--) {
            TableEntry tableEntry = sortedTableList.get(i);

            //check if table-position is equal or not
            if (tableEntryBefore != null && tableEntry.compareTo(tableEntryBefore) == 0) {
                tableEntry.setCurrentPosition(lastPosition);
            }else {
                tableEntry.setCurrentPosition(pos);
                lastPosition = pos;
            }
            tableEntryBefore = tableEntry;
            returnMap.put(tableEntry.getTeam(), tableEntry);
            pos ++;
        }

        for (String s : returnMap.keySet()) {
            returnMap.put(s, returnMap.get(s).cloneObject());
        }

        return returnMap;
    }

}
