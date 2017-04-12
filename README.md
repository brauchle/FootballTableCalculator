### Usage:
#### SimpleMatchBean
contains all data representating a single match between two teams
```
  SimpleMatchBean demoMatchBean = new SimpleMatchBean();
  demoMatchBean.setTeamNameHome("Team1");
  demoMatchBean.setTeamNameAway("Team2");
  demoMatchBean.setSaison("2016");
  demoMatchBean.setResult(MATCH_RESULT_ENUM.RESULT_1);
  demoMatchBean.setGoalsShotHome(2);
  demoMatchBean.setGoalsShotAway(1);
```

#### TableManager
Takes a 3-dimensional List representing:
- inner list --> one Matchday
- middle list --> season as a list of a list of Matchdays
- outer list --> multiple seasons

Example:
```
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
```

#### Dependency via Gradle:
```
repositories {
 maven { url 'https://jitpack.io' }
}

[...]

compile 'com.github.brauchle:FootballTableCalculator'
```
