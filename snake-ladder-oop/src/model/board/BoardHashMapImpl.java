package model.board;

import exception.InvalidBoardException;
import exception.InvalidLadderException;
import exception.InvalidSnakeException;
import model.UserPosition;
import model.dice.Dice;
import model.ladder.Ladder;
import model.snake.Snake;

import java.util.HashMap;
import java.util.List;

public class BoardHashMapImpl extends Board {

    private HashMap<Integer, Snake> snakePositionMap;
    private HashMap<Integer, Ladder> ladderPositionMap;

    public BoardHashMapImpl(Long rows, Long cols, Dice dice, List<UserPosition> userPositionList) throws Exception{
        super(rows, cols, dice);
        setUserPositionList(userPositionList);
        snakePositionMap = new HashMap<Integer, Snake>();
        ladderPositionMap = new HashMap<Integer, Ladder>();
    }

    private void addSnake(Snake snake) throws Exception {
        if(snakePositionMap.containsKey(snake.getMouth())){
            throw new InvalidBoardException(String.format("Two snakes at same %d position", snake.getMouth()));
        }else{
            snakePositionMap.put(snake.getMouth(), snake);
        }
    }

    private void addLadder(Ladder ladder) throws Exception {
        if(ladderPositionMap.containsKey(ladder.getBottom())){
            throw new InvalidLadderException(String.format("Two ladders at same %d position", ladder.getBottom()));
        }else{
            ladderPositionMap.put(ladder.getBottom(), ladder);
        }
    }

    @Override
    public  void addSnakes(List<Snake> snake) throws Exception {
        for(Snake curSnake : snake){
            addSnake(curSnake);
        }
    }

    @Override
    public void addLadders(List<Ladder> ladder) throws Exception{
        for(Ladder curLadder : ladder){
            addLadder(curLadder);
        }
    }

    @Override
    public Boolean checkSnakeExist(Long tile) {
        return snakePositionMap.containsKey(tile);
    }

    @Override
    public  Boolean checkLadderExist(Long tile) {
        return ladderPositionMap.containsKey(tile);
    }

    @Override
    public  Snake getSnakeWithCurrentMouth(Long mouthPosition) throws Exception {
        if(checkSnakeExist(mouthPosition) == false){
            throw new InvalidSnakeException("snake mouth do not exist");
        }
        return snakePositionMap.get(mouthPosition);
    }

    @Override
    public  Ladder getLadderAtBottomPosition(Long bottomPosition) throws Exception{
        if(checkLadderExist(bottomPosition) == false){
            throw new InvalidLadderException("Ladder bottom does not exist");
        }
        return ladderPositionMap.get(bottomPosition);
    }
}