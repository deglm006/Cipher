package old;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller {

// definitions
    public Label guessedWord;
    public Rectangle rect1;
    public Rectangle rect2;
    public Rectangle rect3;
    public Rectangle rect4;
    public Rectangle rect5;
    public Rectangle rect6;
    public Rectangle rect7;
    public Text lives;
    public Text letterMes;
    public Text winMes;
    public String secretWord="";
    public int wrongGuesses=0;
    private String letters = "";


    public void setSecretWord(ActionEvent actionEvent){ // sets our secret to what is typed into the textField
        TextField textField= (TextField) actionEvent.getSource();
        secretWord = textField.getText();
        reset();
        String enteredText="";
        for (int i=0;i<secretWord.length();i++){
            enteredText+="_";
        }
        guessedWord.setText(enteredText);
        textField.setText("Enter a word to start a new game");
    }

    private void reset(){ // resets the game for another round
        lives.setText("lives");
        lives.setFill(Paint.valueOf("WHITE"));
        rect1.setVisible(true);
        rect2.setVisible(true);
        rect3.setVisible(true);
        rect4.setVisible(true);
        rect5.setVisible(true);
        rect6.setVisible(true);
        rect7.setVisible(true);
        wrongGuesses = 0;
    }

    public void guess(ActionEvent actionEvent) {//checks to make sure that the entered guess is correct and int eh right format
        TextField textField= (TextField) actionEvent.getSource();
        String g = textField.getText();
        if(secretWord==""){
            letterMes.setText("You need to set a word first.");

        }else if(g.length()!=1){
            letterMes.setText("Enter only a single charachter.");
        }else if (!"abcdefghijklmnopqrstuvwxyz".contains(g.toLowerCase())){
            letterMes.setText("Enter only letters.");
        }else if (letters.contains(g.toLowerCase())){
            letterMes.setText("You already guessed that letter.");
        }
        else {
            String theGuess = textField.getText();
            guessedWord.setText(checkGuess(theGuess.toLowerCase()));
            textField.setText("");
            letterMes.setText("");
        }

    }

    public String checkGuess(String theGuess){ // checks to make sure that the guessed letter is in the secret word and gives the user feed back [changes lives or prints geuss in the correct position of the word]
        String wordSoFar = guessedWord.getText();
        String thingToReturn = "";
        letters+=theGuess;
        if (secretWord.contains(theGuess)) {
            for (int i = 0; i<secretWord.length(); i++){
                if (secretWord.substring(i, i+1).toLowerCase().equals(theGuess)) {
                    thingToReturn += theGuess;
                } else {
                    thingToReturn += wordSoFar.substring(i, i+1);
                }
            }
            letterMes.setText("You guessed right.");
            if(secretWord.toLowerCase().equals(guessedWord.getText().toLowerCase())){
                winMes.setText("You Won");
            }else {
                winMes.setText("");
            }
            return thingToReturn;
        }else {
            wrongGuesses++;
            if(wrongGuesses==1) rect1.setVisible(false);
            if(wrongGuesses==2) rect2.setVisible(false);
            if(wrongGuesses==3) rect3.setVisible(false);
            if(wrongGuesses==4) rect4.setVisible(false);
            if(wrongGuesses==5) rect5.setVisible(false);
            if(wrongGuesses==6) rect6.setVisible(false);
            if(wrongGuesses==7) {
                rect7.setVisible(false);
                lives.setText("Game Over");
                lives.setFill(Paint.valueOf("BLACK"));


            }
            letterMes.setText("You guessed wrong.");
        }
        return wordSoFar;
    }


}
