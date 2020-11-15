package model.snake;

public interface Snake {

    Integer getMouth();

    Integer getTail();
    /*
    validates if paramaters for snake are valid or not
     */
    void validate() throws Exception;

    /*
    returns number of position to go down if current snake bites
     */
    Long snakeBite();
}