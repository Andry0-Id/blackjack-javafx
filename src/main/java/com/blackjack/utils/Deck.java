    package com.blackjack.utils;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Iterator;
    import java.util.List;

    import javafx.scene.image.Image;

    public class Deck {
        @SuppressWarnings("rawtypes")
        private List deck;
        private Integer index;

        public Deck() {
            this(1);
        }

        /**
         * @param numDeck
         */
        @SuppressWarnings("rawtypes")
        public Deck(int numDeck) {
            deck = new ArrayList<>();
            index = 0;

            try {
                for (int i = 0; i < numDeck; i++) {
                    Iterator suitIterator = Suit.VALUES.iterator();
                    while (suitIterator.hasNext()) {
                        Suit suit = (Suit) suitIterator.next();
                        Iterator rankIterator = Rank.VALUES.iterator();
                        while (rankIterator.hasNext()) {
                            Rank rank = (Rank) rankIterator.next();
                            Card card = new Card(suit, rank, new Image(Card.getFileName(suit, rank)));
                            addCard(card);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * @param card
         */
        @SuppressWarnings("unchecked")
        public void addCard(Card card) {
            deck.add(card);
        }

        public int getSizeOfDeck() {
            return deck.size();
        }

        public int getNumberOfCardsRemaining() {
            return deck.size() - index;
        }

        public Card dealCard() {
            if (index >= deck.size())
                return null;
            else
                return (Card) deck.get(index++);
        }

        public void shuffle() {
            Collections.shuffle(deck);
        }

        public boolean isEmpty() {
            if (index >= deck.size())
                return true;
            else
                return false;
        }

        public void restoreDeck() {
            index = 0;
        }

    }
