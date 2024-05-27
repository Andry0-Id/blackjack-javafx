package com.blackjack.Controller;

import java.io.IOException;

import com.blackjack.App;

import javafx.fxml.FXML;

public class StartController {
    
    @FXML
    private void switchToApp() throws IOException{
        App.setRoot("primary");
    }
}
