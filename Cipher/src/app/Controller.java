package app;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public Label helloWorld;
    public Label guessedWord;
    public String secretWord = "Mississippi";

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello, World!");
    }

    public void guess(ActionEvent actionEvent) {
        Button theButtonPressed = (Button) actionEvent.getSource();
        String theGuess = theButtonPressed.getText();
        theButtonPressed.setDisable(true);
        guessedWord.setText(checkGuess(theGuess));

    }

    public String checkGuess(String theGuess){
        String wordSoFar = guessedWord.getText();
        String thingToReturn = "";
        if (secretWord.contains(theGuess)) {
            for (int i = 0; i<secretWord.length(); i++){
                if (secretWord.substring(i, i+1).equals(theGuess)) {
                    thingToReturn += theGuess;
                } else {
                    thingToReturn += wordSoFar.substring(i, i+1);
                }

            }
            return thingToReturn;
        }
        return wordSoFar;
    }


}
