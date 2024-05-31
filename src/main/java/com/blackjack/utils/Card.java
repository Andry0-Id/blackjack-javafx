package com.blackjack.utils;

import javafx.scene.image.Image;

public class Card {
    
    private Suit suitValues;
    private Rank rankValues;
    private Image cardImage;

    /**
     * @param suitValues
     * @param rankValues
     * @param cardImage
     */
    public Card(Suit suitValues, Rank rankValues, Image cardImage) {
        this.suitValues = suitValues;
        this.rankValues = rankValues;
        this.cardImage = cardImage;
    }

    public static String getFileName(Suit suit,Rank rank){
        return "file:src/main/resources/com/blackjack/cards/"+suit.getSymbol()+rank.getSymbol()+".gif";
    }

    public Suit getSuitValues() {
        return suitValues;
    }

    public Rank getRankValues() {
        return rankValues;
    }

    public Image getCardImage() {
        return cardImage;
    }
    
    public Integer getValue(){
        String rank = rankValues.getSymbol();
        try {
            return Integer.parseInt(rank);
        } catch (Exception e) {
            if (rank.equals("a")) {
                return 11;
            }
            else{
                return 10;
            }
        }
    }

    @Override
    public String toString() {
        return "Carte :" + suitValues + "," + rankValues+ "]";
    }


}
