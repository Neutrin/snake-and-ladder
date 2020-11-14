import model.User;
import model.UserPosition;
import model.ladder.Ladder;
import model.ladder.LadderSimpleImpl;
import model.snake.Snake;
import model.snake.SnakeSimpleImpl;
import service.BoardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String []args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BoardService boardService = null;

        User curUser = null;
        List<Snake> snakeList = new ArrayList<Snake>();
        List<Ladder> ladderList = new ArrayList<Ladder>();
        Snake curSnake = null;
        Ladder curLadder = null;
        String diceImpl = new String();
        List<User> userList = new ArrayList<>();

        long rows = 0l;
        long cols = 0l;
        System.out.println("\n enter number of rows in board");
        rows = sc.nextLong();
        System.out.println("enter number of cols in board");
        cols = sc.nextLong();

        int users = 0;
        System.out.println("enter number of users");
        users = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter names of each user");
        while (users > 0){
            users--;
            curUser = new User(sc.nextLine());
           userList.add(curUser);
        }
        System.out.println("Enter dice implementation");
        diceImpl = sc.nextLine();
        int snakeCount = 0;
        int start = 0, end = 0;
        System.out.println("enter number of snakes");
        snakeCount = sc.nextInt();
        System.out.println("Please enter starting and ending position of snakes");
        while(snakeCount > 0){
            start = sc.nextInt();
            end = sc.nextInt();

            curSnake = new SnakeSimpleImpl(start, end);
            snakeList.add(curSnake);
            snakeCount--;
        }
        System.out.println("enter number of ladders");
        int ladderCount = 0;
        ladderCount = sc.nextInt();
        System.out.println("Please enter starting and ending position of each ladder");
        while(ladderCount > 0){
            start = sc.nextInt();
            end = sc.nextInt();
            curLadder = new LadderSimpleImpl(start, end);
            ladderList.add(curLadder);
            ladderCount--;
        }
        boardService = new BoardService(rows,cols, diceImpl, userList,snakeList, ladderList);
        boardService.playGame();
    }
}