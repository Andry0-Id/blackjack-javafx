package com.blackjack.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Suit {
    private String name;
    private String symbol;

    /**
     * @param name
     * @param symbol
     */
    public Suit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public final static Suit Trefle = new Suit("Trefle", "c");
    public final static Suit Carreaux = new Suit("Carreaux", "d");
    public final static Suit Coeur = new Suit("Coeur", "h");
    public final static Suit Pique = new Suit("Pique", "s");

    @SuppressWarnings("rawtypes")
    public final static List VALUES = Collections.unmodifiableList(
        Arrays.asList(new Suit[]{ Trefle, Carreaux, Coeur, Pique})
    );


    // ** Getters
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    // ** String
    @Override
    public String toString() {
        return "Suit [name=" + name + "]";
    }

}
