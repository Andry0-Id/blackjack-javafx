package com.blackjack.Controller;

import java.io.IOException;

import com.blackjack.App;
import com.blackjack.utils.Card;
import com.blackjack.utils.Deck;
import com.blackjack.utils.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    // * Generation de carte
    Deck deck = new Deck(1);
    Player player = new Player("test");
    Player dealer = new Player("croupier");

    @FXML
    private HBox cardDealer;
    @FXML
    private HBox cardPlayer;
    @FXML
    private HBox panePlayer;
    @FXML
    private HBox paneDealer;

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }

    @SuppressWarnings("static-access")
    @FXML
    private void play() {
        Platform.runLater(() -> {
            System.out.println("Play");
            // * Distribute two card */
            for (int i = 0; i < 2; i++) {
                Card card1 = deck.dealCard();
                Card card2 = deck.dealCard();
                if (card1 != null && card2 != null) {
                    player.addCard(card2);
                    dealer.addCard(card1);

                    ImageView imageViewDealer = new ImageView(card1.getCardImage());
                    ImageView imageViewPlayer = new ImageView(card2.getCardImage());
                    cardDealer.getChildren().add(imageViewDealer);
                    cardPlayer.getChildren().add(imageViewPlayer);
                }
            }
            // * Score player
            Integer s = player.getScore();
            Label scorep = new Label(s.toString());
            panePlayer.getChildren().add(scorep);

            // * Score dealer
            Integer d = dealer.getScore();
            Label scored = new Label(d.toString());
            paneDealer.getChildren().add(scored);
        });

    }

    /**
     * * Function : hit()
     * * Ajouter une carte
     */
    @FXML
    protected void hit() {
        Platform.runLater(() -> {
            Platform.runLater(() -> {
                System.out.println("Hit Activer");
            });
        });
    }

    /**
     * * Function : stand()
     * * Rester sur la main
     */
    @FXML
    protected void stand() {
        Platform.runLater(() -> {
            System.out.println("Stand Activer");
        });
    }

}
