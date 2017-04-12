package com.github.brauchle.football.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andreasbrauchle on 13.09.16.
 */
public class RelegatedTeams {

    public static List<String> getRelegatedTeams(String season){
        if (season.equals("2007")) {
            return new ArrayList<>(Arrays.asList("Mainz", "Aachen", "Gladbach"));
        }
        if (season.equals("2008")) {
            return new ArrayList<>(Arrays.asList("Nuernberg", "Rostock", "Duisburg"));
        }
        if (season.equals("2009")) {
            return new ArrayList<>(Arrays.asList("Cottbus", "Karlsruhe", "Bielefeld"));
        }
        if (season.equals("2010")) {
            return new ArrayList<>(Arrays.asList("Berlin", "Bochum"));
        }
        if (season.equals("2011")) {
            return new ArrayList<>(Arrays.asList("Frankfurt", "StPauli"));
        }
        if (season.equals("2012")) {
            return new ArrayList<>(Arrays.asList("Koeln", "Kaiserslauthern", "Berlin"));
        }
        if (season.equals("2013")) {
            return new ArrayList<>(Arrays.asList("Fuerth", "Duesseldorf"));
        }
        if (season.equals("2014")) {
            return new ArrayList<>(Arrays.asList("Nuernberg", "Braunschweig"));
        }
        if (season.equals("2015")) {
            return new ArrayList<>(Arrays.asList("Freiburg", "Paderborn"));
        }
        return new ArrayList<>();
    }
}
