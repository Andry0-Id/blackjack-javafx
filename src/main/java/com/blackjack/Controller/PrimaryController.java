package com.blackjack.Controller;

import java.io.IOException;

import com.blackjack.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }
}
