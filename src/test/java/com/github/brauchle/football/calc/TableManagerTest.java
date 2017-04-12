package com.github.brauchle.football.calc;

import com.github.brauchle.football.calc.demoBeans.DemoMatchBean;
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
        List<List<List<DemoMatchBean>>> demoMatchBeans = generateDemoData();
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

    private List<List<List<DemoMatchBean>>> generateDemoData(){
        List<List<List<DemoMatchBean>>> allSeasons = new ArrayList<>();
        List<List<DemoMatchBean>> currentSeason = new ArrayList<>();
        for (int j = 0; j < 34; j++) {
            List<DemoMatchBean> currentMatchday = new ArrayList<>();

            DemoMatchBean demoMatchBean = new DemoMatchBean();
            demoMatchBean.setHeimName("Team1");
            demoMatchBean.setGastName("Team2");
            demoMatchBean.setSaison("2016");
            demoMatchBean.setErgebnis("1");
            demoMatchBean.setToreHeim(2);
            demoMatchBean.setToreGast(1);

            DemoMatchBean demoMatchBean2 = new DemoMatchBean();
            demoMatchBean2.setHeimName("Team3");
            demoMatchBean2.setGastName("Team4");
            demoMatchBean2.setSaison("2016");
            demoMatchBean2.setErgebnis("2");
            demoMatchBean2.setToreHeim(2);
            demoMatchBean2.setToreGast(3);

            currentMatchday.add(demoMatchBean);
            currentMatchday.add(demoMatchBean2);

            currentSeason.add(currentMatchday);
        }
        allSeasons.add(currentSeason);

        return allSeasons;
    }
}