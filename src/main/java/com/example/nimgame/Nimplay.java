package com.example.nimgame;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Nimplay {
    @FXML private GridPane page;
    @FXML private Button submitButton;
    @FXML private TextArea log;
    @FXML private Circle G1;
    @FXML private Circle G2;
    @FXML private Circle G3;
    @FXML private Circle Y1;
    @FXML private Circle Y2;
    @FXML private Circle Y3;
    @FXML private Circle Y4;
    @FXML private Circle Y5;
    @FXML private Circle Y6;
    @FXML private Circle Y7;
    @FXML private Circle R1;
    @FXML private Circle R2;
    @FXML private Circle R3;
    @FXML private Circle R4;
    @FXML private Circle R5;

    @FXML private Button nextGameButton;

    private ArrayList<Circle> greenList = new ArrayList<>();
    private ArrayList<Circle> yellowList = new ArrayList<>();
    private ArrayList<Circle> redList = new ArrayList<>();

    private ArrayList<Circle> playerClickedList = new ArrayList<>();
    private ArrayList<Circle> computerClickedList = new ArrayList<>();

    private int playerCount = 0;
    private String playerColor = "";
    private int computerCount = 0;
    private String computerColor = "";

    boolean compGoesFirst = false;

    int gameCounter;

    //------------------------------------------------------------------------------------
    //Fields for HomePage
    @FXML private GridPane homePane;
    @FXML private ComboBox<Integer> gameNum;
    @FXML private Button startButton;
    @FXML private TextArea gameLog;
    @FXML
    private ComboBox<String> gameNum1; 

    List<Integer> list = new ArrayList<>();
    //------------------------------------------------------------------------------------

    @FXML
    public void initialize(){
        //Initialize for HomePage
        if(gameCounter == 0) {
            homePane.toFront();
            homePane.setDisable(false);
            homePane.setVisible(true);
        }

        for(int n = 0; n < 4; n++) {
            list.add(2*n+1);
        }

        gameNum.setItems(FXCollections.observableList(list));
        gameCounter = 0;
       
        List<String> difficultyLevels = new ArrayList<>();
        difficultyLevels.add("easy");
        difficultyLevels.add("medium");
        difficultyLevels.add("hard");

        gameNum1.setItems(FXCollections.observableList(difficultyLevels));

        //------------------------------------------------------------------------------------

        //Initialize for Game
        initLists();

        submitButton.setDisable(true);

        randomGame();

        nextGameButton.setDisable(true);
        nextGameButton.setVisible(false);
    }

    public void initLists() {
        greenList.add(G1);greenList.add(G2);greenList.add(G3);
        yellowList.add(Y1);yellowList.add(Y2);yellowList.add(Y3);yellowList.add(Y4);yellowList.add(Y5);yellowList.add(Y6);yellowList.add(Y7);
        redList.add(R1);redList.add(R2);redList.add(R3);redList.add(R4);redList.add(R5);

        playerClickedList.clear();
        computerClickedList.clear();

        int gameTracker = gameCounter+1;
        log.setText("Start Game " + gameTracker +"\n\n");
    }

    public void randomGame() {
        Random rand = new Random();
        if(rand.nextDouble() > 0.5) {
            log.appendText("Computer Goes First\n\n");
            compGoesFirst = true;
            if ("easy".equals(gameNum1.getValue())) {
                playGameEasy();
            } else if ("hard".equals(gameNum1.getValue())) {
            	
                playGame()
               ;
                           } 
            else {
                playGameMedium();
            }
        } else{
            log.appendText("Player Goes First\n\n");
        }
    }

    public void circleClickGreen() {
        for(Circle y:yellowList) {
            y.setDisable(true);
            y.setFill(Paint.valueOf("#b9b90a"));
        }
        for(Circle r:redList) {
            r.setDisable(true);
            r.setFill(Paint.valueOf("#ac1717"));
        }
        submitButton.setDisable(false);

        playerColor = "Green";
        playerCount++;
    }

    @FXML
    public void clickG1() {
        G1.setDisable(true);
        G1.setFill(Paint.valueOf("#118e11"));
        playerClickedList.add(G1);
        greenList.remove(G1);
        circleClickGreen();
    }
    @FXML
    public void clickG2() {
        G2.setDisable(true);
        G2.setFill(Paint.valueOf("#118e11"));
        playerClickedList.add(G2);
        greenList.remove(G2);
        circleClickGreen();
    }
    @FXML
    public void clickG3() {
        G3.setDisable(true);
        G3.setFill(Paint.valueOf("#118e11"));
        playerClickedList.add(G3);
        greenList.remove(G3);
        circleClickGreen();
    }

    public void circleClickYellow() {
        for(Circle g:greenList) {
            g.setDisable(true);
            g.setFill(Paint.valueOf("#118e11"));
        }
        for(Circle r:redList) {
            r.setDisable(true);
            r.setFill(Paint.valueOf("#ac1717"));
        }
        submitButton.setDisable(false);

        playerColor = "Yellow";
        playerCount++;
    }

    @FXML
    public void clickY1() {
        Y1.setDisable(true);
        Y1.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y1);
        yellowList.remove(Y1);
        circleClickYellow();
    }
    @FXML
    public void clickY2() {
        Y2.setDisable(true);
        Y2.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y2);
        yellowList.remove(Y2);
        circleClickYellow();
    }
    @FXML
    public void clickY3() {
        Y3.setDisable(true);
        Y3.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y3);
        yellowList.remove(Y3);
        circleClickYellow();
    }
    @FXML
    public void clickY4() {
        Y4.setDisable(true);
        Y4.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y4);
        yellowList.remove(Y4);
        circleClickYellow();
    }
    @FXML
    public void clickY5() {
        Y5.setDisable(true);
        Y5.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y5);
        yellowList.remove(Y5);
        circleClickYellow();
    }
    @FXML
    public void clickY6() {
        Y6.setDisable(true);
        Y6.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y6);
        yellowList.remove(Y6);
        circleClickYellow();
    }
    @FXML
    public void clickY7() {
        Y7.setDisable(true);
        Y7.setFill(Paint.valueOf("#b9b90a"));
        playerClickedList.add(Y7);
        yellowList.remove(Y7);
        circleClickYellow();
    }

    public void circleClickRed() {
        for(Circle g:greenList) {
            g.setDisable(true);
            g.setFill(Paint.valueOf("#118e11"));
        }
        for(Circle y:yellowList) {
            y.setDisable(true);
            y.setFill(Paint.valueOf("#b9b90a"));
        }
        submitButton.setDisable(false);

        playerColor = "Red";
        playerCount++;
    }

    @FXML
    public void clickR1() {
        R1.setDisable(true);
        R1.setFill(Paint.valueOf("#ac1717"));
        playerClickedList.add(R1);
        redList.remove(R1);
        circleClickRed();
    }
    @FXML
    public void clickR2() {
        R2.setDisable(true);
        R2.setFill(Paint.valueOf("#ac1717"));
        playerClickedList.add(R2);
        redList.remove(R2);
        circleClickRed();
    }
    @FXML
    public void clickR3() {
        R3.setDisable(true);
        R3.setFill(Paint.valueOf("#ac1717"));
        playerClickedList.add(R3);
        redList.remove(R3);
        circleClickRed();
    }
    @FXML
    public void clickR4() {
        R4.setDisable(true);
        R4.setFill(Paint.valueOf("#ac1717"));
        playerClickedList.add(R4);
        redList.remove(R4);
        circleClickRed();
    }
    @FXML
    public void clickR5() {
        R5.setDisable(true);
        R5.setFill(Paint.valueOf("#ac1717"));
        playerClickedList.add(R5);
        redList.remove(R5);
        circleClickRed();
    }

    @FXML
    public void submit() {
        log.appendText("> Player removed " + playerCount + " balls of " + playerColor + ".\n");
        resetGameColors();
        if ("easy".equals(gameNum1.getValue())) {
            playGameEasy();
        } else if ("hard".equals(gameNum1.getValue())) {

        	// log.appendText("\n hard mode.");
            playGame();
        } 
        else {
            playGameMedium();
        }

        if(greenList.size() == 0 && yellowList.size() == 0 && redList.size() == 0){
            if (compGoesFirst&& !("easy".equals(gameNum1.getValue()))) {
                log.appendText("\n Computer Wins. Better luck next time.");

            }                
           {nextGameButton.setDisable(false);
            nextGameButton.setVisible(true);
                gameCounter++;
                if (gameNum.getValue() == gameCounter) {
                    homePane.toFront();
                    homePane.setDisable(false);
                    homePane.setVisible(true);

                 //   gameLog.setText("The computer won " + gameNum.getValue() + " games.\n");
                    gameLog.appendText("thank you to playing our game.\n\n");
                    gameLog.appendText("Better Luck Next Time");
                }
            }
        }
    }
        
    


    public void resetGameColors() {
        for(Circle g:greenList) {
            g.setDisable(false);
            g.setFill(Paint.valueOf("#14dc14"));
        }for(Circle y:yellowList) {
            y.setDisable(false);
            y.setFill(Paint.valueOf("YELLOW"));
        }for(Circle r:redList) {
            r.setDisable(false);
            r.setFill(Paint.valueOf("RED"));
        }for(Circle p: playerClickedList) {
            p.setDisable(true);
            p.setFill(Paint.valueOf("BLACK"));
        }for (Circle c : computerClickedList) {
            c.setDisable(true);
            c.setFill(Paint.valueOf("GREY"));
        }

        submitButton.setDisable(true);

        playerColor = "";
        playerCount = 0;
        computerColor = "";
        computerCount = 0;
    }

    @FXML
    public void nextGame() {
        initLists();
        resetGameColors();

        randomGame();

        nextGameButton.setDisable(true);
        nextGameButton.setVisible(false);
    }
    public void playGameEasy() {
        if (compGoesFirst) {
            removeOneBall(greenList);
        } else {
            // Default strategy for easy mode - remove one ball each time without technique
            String[] colors = {"Green", "Yellow", "Red"};
            Random random = new Random();
            computerColor = colors[random.nextInt(colors.length)];

            removeOneBall(greenList); 
        }

        compGoesFirst = false;

        for (Circle c : computerClickedList) {
            c.setDisable(true);
            c.setFill(Paint.valueOf("GREY"));
        }  	
    }

    public void playGame() {//hard method

        if(compGoesFirst) {
            computerClickedList.add(greenList.get(0));
            greenList.remove(0);
            log.appendText("> Computer removed 1 balls of Green.\n");
        } else if((greenList.size()^yellowList.size()^redList.size()) != 0) {
            if(greenList.size() > (yellowList.size() ^ redList.size())) {
                computerColor = "Green";
                while (greenList.size() > (yellowList.size() ^ redList.size())) {
                    computerClickedList.add(greenList.get(0));
                    greenList.remove(0);
                    computerCount++;
                }
            } else if (yellowList.size() > (greenList.size() ^ redList.size())) {
                computerColor = "Yellow";
                while (yellowList.size() > (greenList.size() ^ redList.size())) {
                    computerClickedList.add(yellowList.get(0));
                    yellowList.remove(0);
                    computerCount++;
                }
            } else if(redList.size() > (yellowList.size() ^ greenList.size())) {
                computerColor = "Red";
                while (redList.size() > (yellowList.size() ^ greenList.size())) {
                    computerClickedList.add(redList.get(0));
	                    redList.remove(0);
	                    computerCount++;
                }
            }
            log.appendText("> Computer removed " + computerCount + " balls of " + computerColor +".\n");
        } else {
            if(greenList.size()>yellowList.size() && greenList.size()>redList.size()) {
                computerColor = "Green";
                computerClickedList.add(greenList.get(0));
                greenList.remove(0);
                computerCount++;
            } else if(yellowList.size()>greenList.size() && yellowList.size()>redList.size()) {
                computerColor = "Yellow";
                computerClickedList.add(yellowList.get(0));
                yellowList.remove(0);
                computerCount++;
            } else if(redList.size()>greenList.size() && redList.size()>yellowList.size()) {
                computerColor = "Red";
                computerClickedList.add(redList.get(0));
                redList.remove(0);
                computerCount++;
            }
            else if(greenList.size()==0)
            {
            	removeOneBall(greenList);
            }
            
            log.appendText("> Computer removed " + /*computerCount + " balls of " +*/ computerColor +".\n");
        }

        for (Circle c : computerClickedList) {
            c.setDisable(true);
            c.setFill(Paint.valueOf("GREY"));
        }

        compGoesFirst = false;
    }

    public void playGameMedium() {
        int[] result = minimax(5, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        int index = result[1];
        int ballsToRemove = result[2];
        int bestval = result[0];

        if (ballsToRemove > 0) {
            List<Circle> currentColorList = getCurrentColorList();

            List<Circle> removedCircles = new ArrayList<>(currentColorList.subList(index, index + ballsToRemove));
            currentColorList.removeAll(removedCircles);

            if (bestval == -1) {
                for (int i = 0; i < ballsToRemove; i++) {
                    computerClickedList.add(greenList.get(0));
                    greenList.remove(0);
                    computerCount++;
                }
                updateColorListAndLog(currentColorList, removedCircles, "> Computer removed " + ballsToRemove + " balls of Green.\n");
            } else if (bestval == -2) {
                for (int i = 0; i < ballsToRemove; i++) {
                    computerClickedList.add(yellowList.get(0));
                    yellowList.remove(0);
                    computerCount++;
                }
                updateColorListAndLog(currentColorList, removedCircles, "> Computer removed " + ballsToRemove + " balls of Yellow.\n");
            } else if (bestval == -3) {
                for (int i = 0; i < ballsToRemove; i++) {
                    computerClickedList.add(redList.get(0));
                    redList.remove(0);
                    computerCount++;
                }
                updateColorListAndLog(currentColorList, removedCircles, "> Computer removed " + ballsToRemove + " balls of Red.\n");
            }

   
             computerColor = getColorFromCircle(removedCircles.get(0));
        }

        updateUIAfterComputerMove();
    }



    private void updateColorListAndLog(List<Circle> currentColorList, List<Circle> removedCircles, String logMessage) {
        if (greenList.size() > 0) {
            greenList.clear();
            greenList.addAll(currentColorList);
            greenList.removeAll(removedCircles);
        } else if (yellowList.size() > 0) {
            yellowList.clear();
            yellowList.addAll(currentColorList);
            yellowList.removeAll(removedCircles);
        } else {
            redList.clear();
            redList.addAll(currentColorList);
            redList.removeAll(removedCircles);
        }

        log.appendText(logMessage);
    }

    private void updateUIAfterComputerMove() {
        for (Circle c : computerClickedList) {
            c.setDisable(true);
            c.setFill(Paint.valueOf("GREY"));
        }

        compGoesFirst = false;
    }


    private List<Circle> getCurrentColorList() {
        return (greenList.size() > 0) ? new ArrayList<>(greenList) :
               (yellowList.size() > 0) ? new ArrayList<>(yellowList) :
               new ArrayList<>(redList);
    }



    private int[] minimax(int depth, int alpha, int beta, boolean isMaximizing) {
        if (depth == 0 || (greenList.isEmpty() && yellowList.isEmpty() && redList.isEmpty())) {
            int evaluation = evaluate();
            return new int[]{evaluation, -1, -1};
        }

        int bestValue, bestIndex, ballsToRemove;
        List<Circle> currentColorList = getCurrentColorList();

        if (isMaximizing) {
            bestValue = Integer.MIN_VALUE;//maximizing -inf
            bestIndex = -1;
            ballsToRemove = -1;

            for (int i = 0; i < currentColorList.size(); i++) {
                for (int j = 1; j <= currentColorList.size() - i; j++) {
                    List<Circle> removedCircles = new ArrayList<>(currentColorList.subList(i, i + j));
                    currentColorList.removeAll(removedCircles);

                    int[] result = minimax(depth - 1, alpha, beta, false);//evaluate the board after the potential move
                    int score = result[0];

                    if (score > bestValue) {
                        bestValue = score;
                        bestIndex = i;
                        ballsToRemove = j;
                    }

                    alpha = Math.max(alpha, bestValue);
                    if (beta <= alpha) {
                        // Undo the move
                        currentColorList.addAll(i, removedCircles);
                        break;
                    }
                }
            }
        } else {
            bestValue = Integer.MAX_VALUE;
            bestIndex = -1;
            ballsToRemove = -1;

            for (int i = 0; i < currentColorList.size(); i++) {
                for (int j = 1; j <= currentColorList.size() - i; j++) {
                    List<Circle> removedCircles = new ArrayList<>(currentColorList.subList(i, i + j));
                    currentColorList.removeAll(removedCircles);

                    int[] result = minimax(depth - 1, alpha, beta, true);
                    int score = result[0];

                    if (score < bestValue) {
                        bestValue = score;
                        bestIndex = i;
                        ballsToRemove = j;
                    }

                    beta = Math.min(beta, bestValue);
                    if (beta <= alpha) {
                        // Undo the move
                        currentColorList.addAll(i, removedCircles);
                        break;
                    }
                }
            }
        }

        return new int[]{bestValue, bestIndex, ballsToRemove};
    }

    private int evaluate() {
        int xor = greenList.size() ^ yellowList.size() ^ redList.size();
        int bestval = 1;
        int maxGreenSize = greenList.size();
        int maxYellowSize = yellowList.size();
        int maxRedSize = redList.size();
        if (xor != 0) {
            

            if (maxGreenSize > (maxYellowSize ^ maxRedSize)) {
                    computerCount++;
                bestval = -1;

            } else if (maxYellowSize > (maxGreenSize ^ maxRedSize)) {
            
                bestval = -2;
        } else if (maxRedSize > (maxGreenSize ^ maxYellowSize)) {
                bestval = -3;
            }
        } else {

            if (maxGreenSize > maxYellowSize && maxGreenSize > maxRedSize && maxGreenSize > 0) {
                bestval = -1;
            } else if (maxYellowSize > maxGreenSize && maxYellowSize > maxRedSize && maxYellowSize > 0) {
                log.appendText("> the computer should remove yellow \n");
                bestval = -2;
            } else if (maxRedSize > maxGreenSize && maxRedSize > maxYellowSize && maxRedSize > 0) {
                bestval = -3;
            }
        }

        return bestval;
    }




 

    private void removeOneBall(List<Circle> ballList) {
        if (!ballList.isEmpty()) {
            Circle removedBall = ballList.get(0);
            computerClickedList.add(removedBall);
            ballList.remove(removedBall);
            log.appendText("> Computer removed 1 ball of " + computerColor + ".\n");
          
} else {
            
            for (List<Circle> otherList : Arrays.asList(greenList, yellowList, redList)) {
                if (!otherList.isEmpty()) {
                    Circle removedBall = otherList.get(0);
                    computerColor = getColorFromCircle(removedBall);
                    computerClickedList.add(removedBall);
                    otherList.remove(removedBall);
                 //   log.appendText("> Computer removed 1 ball of " + computerColor );
                    return;
                }
            }

            
                  if (greenList.size() == 0 && yellowList.size() == 0 && redList.size() ==0 && !compGoesFirst )
                	  
            
                	  log.appendText("> The player Wins.\n");
                  else if (greenList.size() == 0 && yellowList.size() == 0 && redList.size() ==0 && compGoesFirst ) 
                  log.appendText("> The pc wins.\n"); 
            
      

        }
       // compGoesFirst = false;
    }


	


    private String getColorFromCircle(Circle ball) {
        if (greenList.contains(ball)) {
            return "Green";
        } else if (yellowList.contains(ball)) {
            return "Yellow";
        } else if (redList.contains(ball)) {
            return "Red";
        }
        return "green"; // Handle the case where the color is unknown
    }




    //------------------------------------------------------------------------------------
    //Methods for HomePage

    @FXML
    public void editStartButton() {
        startButton.setDisable(false);
    }

    @FXML
    public void start(){
        homePane.setDisable(true);
        homePane.setVisible(false);
        homePane.toBack();

        if(gameCounter != 0) {
            gameCounter = 0;
            nextGame();
        }
    }
    //------------------------------------------------------------------------------------
}