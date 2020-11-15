package service;

import exception.InvalidBoardException;
import model.DiceFactory;
import model.User;
import model.UserPosition;
import model.board.Board;
import model.board.BoardHashMapImpl;
import model.dice.Dice;
import model.ladder.Ladder;
import model.snake.Snake;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private Board board;
    private DiceFactory diceFactory;

    public BoardService(long rows, long cols, String diceInfo, List<User> userList,
                        List<Snake> snakeList, List<Ladder> ladderList) throws Exception{
        List<UserPosition> userPositionList = new ArrayList<UserPosition>();
        diceFactory = new DiceFactory();
        UserPosition userPosition = null;
        for(User curUser : userList){
            userPosition = new UserPosition(curUser, 0l);
            userPositionList.add(userPosition);
        }
        board = new BoardHashMapImpl(rows, cols, diceFactory.getInstance(diceInfo), userPositionList);
        board.addSnakes(snakeList);
        board.addLadders(ladderList);
    }

    public boolean isWinningPosition(Long curPosition){
        long rows = board.getRows();
        long cols  = board.getCols();
        if((rows*cols) == curPosition.longValue()){
            return true;
        }
        return false;
    }

    public boolean isNextPositionInvalid(long position){
        long rows = board.getRows();
        long cols  = board.getCols();
        if((rows*cols) < position){
            return true;
        }
        return false;
    }

    public void userMoveMsg(String userName, long start, long end){
        System.out.println(String.format("User named :- %s moved from %d to %d position", userName, start, end));
    }

    public void printUserWinMessage(String userName){
        System.out.println(String.format("User with name %s wins", userName));
    }

    public void playGame() throws Exception {
        if(board == null){
            throw new InvalidBoardException("Board not intialised");
        }
        int userIndex = 0;
        while (true){
            UserPosition curUserPosition = board.getUserPositionList().get(userIndex);
            long diceOutcome = board.getDice().getNextMove();
            long nextPosition = curUserPosition.getPostion() + diceOutcome;
            if(board.checkSnakeExist(nextPosition) == true){
                nextPosition += board.getSnakeWithCurrentMouth(nextPosition).snakeBite();
            }
            if(board.checkLadderExist(nextPosition)){
                nextPosition += board.getLadderAtBottomPosition(nextPosition).climbLadder();
            }
            userIndex = (userIndex + 1)%board.getUserPositionList().size();
            if(isNextPositionInvalid(nextPosition)){
                continue;
            }
            userMoveMsg(curUserPosition.getUser().getName(), curUserPosition.getPostion(), nextPosition);
            curUserPosition.setPostion(nextPosition);
            if(isWinningPosition(nextPosition)){
                printUserWinMessage(curUserPosition.getUser().getName());
                break;
            }
        }
    }



}