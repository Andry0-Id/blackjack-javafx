package com.blackjack.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rank {
    
    private String name;
    private String symbol;

    /**
     * Constructor
     * @param name
     * @param symbol
     */
    public Rank(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // ** Getters
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Rank [name=" + name + "]";
    }

    // ** Create Rank for Card
    public final static Rank As = new Rank("As", "a");
    public final static Rank Deux = new Rank("Deux", "2");
    public final static Rank Trois = new Rank("Trois", "3");
    public final static Rank Quatre = new Rank("Quatre", "4");
    public final static Rank Cinq = new Rank("Cinq", "5");
    public final static Rank Six = new Rank("Six", "6");
    public final static Rank Sept = new Rank("Sept", "7");
    public final static Rank Huit = new Rank("Huit", "8");
    public final static Rank Neuf = new Rank("Neuf", "10");
    public final static Rank Dix = new Rank( "Dix", "t" );
    public final static Rank JACK = new Rank( "Valet", "j" );
    public final static Rank QUEEN = new Rank( "Reine", "q" );
    public final static Rank KING = new Rank( "Roi", "k" );

    @SuppressWarnings("rawtypes")
    public final static List VALUES = Collections.unmodifiableList(Arrays.asList(new Rank[]{
        As,Deux,Trois,Quatre,Cinq,Six,Sept,Huit,Neuf,Dix,JACK,QUEEN,KING
    }));

}
