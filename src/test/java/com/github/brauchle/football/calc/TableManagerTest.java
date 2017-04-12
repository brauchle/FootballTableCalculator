package com.github.brauchle.football.calc;

import com.github.brauchle.football.beans.MATCH_RESULT_ENUM;
import com.github.brauchle.football.beans.SimpleMatchBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public class TableManagerTest {

    @Test
    public void createTable() throws Exception {
        List<List<List<SimpleMatchBean>>> demoMatchBeans = generateDemoData();

        TableManager tableManager = new TableManager();
        tableManager.createTable(demoMatchBeans);

        List<TableEntry> table = tableManager.getTable();

        //sort by currentPosition in TableEntry
        Collections.sort(table, new Comparator<TableEntry>() {
            @Override
            public int compare(TableEntry o1, TableEntry o2) {
                return ((Integer)o1.getCurrentPosition()).compareTo(o2.getCurrentPosition());
            }
        });

        for (TableEntry tableEntry : table) {
            System.out.println(tableEntry.toString());
        }
    }

    private List<List<List<SimpleMatchBean>>> generateDemoData() {
        List<List<List<SimpleMatchBean>>> allSeasons = new ArrayList<>();
        List<List<SimpleMatchBean>> currentSeason = new ArrayList<>();
        for (int j = 0; j < 34; j++) {
            List<SimpleMatchBean> currentMatchday = new ArrayList<>();

            SimpleMatchBean demoMatchBean = new SimpleMatchBean();
            demoMatchBean.setTeamNameHome("Team1");
            demoMatchBean.setTeamNameAway("Team2");
            demoMatchBean.setSaison("2016");
            demoMatchBean.setResult(MATCH_RESULT_ENUM.RESULT_1);
            demoMatchBean.setGoalsShotHome(2);
            demoMatchBean.setGoalsShotAway(1);

            SimpleMatchBean demoMatchBean2 = new SimpleMatchBean();
            demoMatchBean2.setTeamNameHome("Team3");
            demoMatchBean2.setTeamNameAway("Team4");
            demoMatchBean2.setSaison("2016");
            demoMatchBean2.setResult(MATCH_RESULT_ENUM.RESULT_2);
            demoMatchBean2.setGoalsShotHome(2);
            demoMatchBean2.setGoalsShotAway(3);

            currentMatchday.add(demoMatchBean);
            currentMatchday.add(demoMatchBean2);

            currentSeason.add(currentMatchday);
        }
        allSeasons.add(currentSeason);

        return allSeasons;
    }
}