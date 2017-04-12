package com.github.brauchle.football.beans;

import com.github.brauchle.football.calc.TableEntry;

/**
 * Created by andreasbrauchle on 26.02.17.
 */
public class TableDataBean {
    /**
     * the table-managers copy the TableEntries to this bean
     * --> always contains the table reflecting the current status before the current Match displayed by the MatchBean
     */

    private TableEntry tableEntry;
    private TableEntry lastSeasonTableEntry;
    private TableEntry formTableEntryLong;

    public TableEntry getTableEntry() {
        if (tableEntry == null) {
            TableEntry tableEntry = new TableEntry("");
            tableEntry.setCurrentPosition(14);
            return tableEntry;
        }
        return tableEntry;
    }

    public void setTableEntry(TableEntry tableEntry) {
        this.tableEntry = tableEntry;
    }

    public TableEntry getLastSeasonTableEntry() {
        return lastSeasonTableEntry;
    }

    public void setLastSeasonTableEntry(TableEntry lastSeasonTableEntry) {
        this.lastSeasonTableEntry = lastSeasonTableEntry;
    }

    public TableEntry getFormTableEntryLong() {
        return formTableEntryLong;
    }

    public void setFormTableEntryLong(TableEntry formTableEntryLong) {
        this.formTableEntryLong = formTableEntryLong;
    }
}
