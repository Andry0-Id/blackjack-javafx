package com.blackjack.utils;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private String nom;
    private List<Card> main = new ArrayList<>();
    private int score;
    public int soft;


    public Player(String nom, List<Card> main, int score) {
        this.nom = nom;
        this.main = main;
        this.score = score;
    }

    public Player(String nom) {
        this.nom =nom;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getMain() {
        return main;
    }

    public void reStart(){
        main.clear();
        score = 0;
    }

    public void addCard(Card card) {
        score += card.getValue();
        if (card.getRankValues() == Rank.As) {
            soft += 1;
        }
        if (soft > 0) {
            if (score > 21) {
                score -= 10;
                soft -= 1;
            }
        }
        main.add(card);
    }
    
}
