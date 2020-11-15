package model.board;

import exception.InvalidBoardException;
import model.User;
import model.UserPosition;
import model.dice.Dice;
import model.ladder.Ladder;
import model.snake.Snake;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {


    private Long rows;
    private Long cols;
    private List<UserPosition> userPositionList;
    private Dice dice;


    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) throws Exception{
        if((rows == null) || (rows <= 0l)){
            throw new InvalidBoardException(String.format("Invalid %d rows for the board", rows));
        }
        this.rows = rows;
    }

    public Long getCols() {
        return cols;
    }

    public void setCols(Long cols) throws Exception{
        if((cols == null) && (cols <= 0l)){
            throw  new InvalidBoardException(String.format("Invalid %d cols for baoerd", cols));
        }

        this.cols = cols;
    }

    public Board(Long rows, Long cols, Dice dice) throws Exception {
        setRows(rows);
        setCols(cols);
        setDice(dice);
        userPositionList = new ArrayList<UserPosition>();
    }

    public List<UserPosition> getUserPositionList() {
        return userPositionList;
    }

    public void setUserPositionList(List<UserPosition> userPositionList) {
        this.userPositionList = userPositionList;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }


    public abstract void addSnakes(List<Snake> snake) throws Exception;

    public abstract void addLadders(List<Ladder> ladder) throws Exception;

    public abstract Boolean checkSnakeExist(Long tile) throws Exception;

    public abstract Boolean checkLadderExist(Long tile) throws Exception;

    public abstract Snake getSnakeWithCurrentMouth(Long mouthPosition) throws Exception;

    public abstract Ladder getLadderAtBottomPosition(Long bottomPosition) throws Exception;

}