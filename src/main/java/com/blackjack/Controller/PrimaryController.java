package com.blackjack.Controller;

import java.io.IOException;

import com.blackjack.App;
import com.blackjack.utils.Card;
import com.blackjack.utils.Deck;
import com.blackjack.utils.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    // * Generation de carte
    Deck deck = new Deck(1);
    Player player = new Player("test");
    Player dealer = new Player("croupier");

    @FXML
    private Button play;

    @FXML
    private HBox cardDealer;
    @FXML
    private HBox cardPlayer;
    @FXML
    private HBox panePlayer;
    @FXML
    private HBox paneDealer;

    @FXML
    private HBox state;

    /**
     * * Function to show Card
     * @param player
     * @param hBox
     */
    @FXML
    public void showCard(Player player, HBox hBox) {
        try {
            Card card = deck.dealCard();
            player.addCard(card);
            ImageView imageView = new ImageView(card.getCardImage());
            hBox.getChildren().add(imageView);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * * Show score player
     * @param player
     * @param h
     */
    @FXML
    public void showScore(Player player,HBox h){
        try {
            Integer score = player.getScore();
            Label scoreLabel = new Label(score.toString());

            // !! Don't remove Label
            // ?? Why
            h.getChildren().clear();

            h.getChildren().add(scoreLabel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * * Show the state if you lose | bust | win
     * @param stateMessage
     */
    @FXML
    public void showState(String stateMessage){
        Label l = new Label(stateMessage);
        state.getChildren().add(l);
    }

    /**
     * * Controller to return the principal window
     * @throws IOException
     */
    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }

    /**
     * * Function to start the game
     */
    @FXML
    private void play() {
        Platform.runLater(() -> {
            System.out.println("Play");
            player.reStart();
            dealer.reStart();
            cardDealer.getChildren().removeAll(cardDealer.getChildren());
            cardPlayer.getChildren().removeAll(cardPlayer.getChildren());
            showCard(player, cardPlayer);
            showCard(dealer, cardDealer);
            showCard(player, cardPlayer);

            // * Score player
            showScore(player, panePlayer);

            // * Score dealer
            showScore(dealer, paneDealer);

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
                showCard(player, cardPlayer);
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
            showCard(dealer, cardDealer);
            while (dealer.getScore() < 17) {
                showCard(dealer, cardDealer);
            }
            if (player.getScore() <= 21) {
                if (player.getScore() < dealer.getScore()) {
                    showState("You WIN ;)");
                }else if ( player.getScore() < dealer.getScore() ){
                    showState("You LOSE |)");
                }else{
                    showState("PUSH");
                }
            }else{
                showState("You bust");
            }
            showScore(dealer, paneDealer);
            showScore(player, panePlayer);
        });
    }

}
