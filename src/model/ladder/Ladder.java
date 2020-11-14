package model.ladder;


public interface Ladder {

    Integer getTop();

    Integer getBottom();
    /*
    validates if ladder parameters are valid or not
     */
    void validate() throws Exception;

    /*
    will return number of positions to be added to reach to the top of current ladder
     */
    Long climbLadder() throws Exception;

}