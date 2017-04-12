package com.github.brauchle.football.beans;

/**
 * Created by andreasbrauchle on 12.04.17.
 */
public enum MATCH_RESULT_ENUM {
    RESULT_1, RESULT_X, RESULT_2;

    public static MATCH_RESULT_ENUM fromShort(String s) {
        switch (s) {
            case "1":
                return RESULT_1;
            case "X":
                return RESULT_X;
            case "2":
                return RESULT_2;
        }
        return null;
    }
}
