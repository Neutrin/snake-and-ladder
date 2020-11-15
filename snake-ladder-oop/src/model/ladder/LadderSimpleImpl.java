package model.ladder;

import exception.InvalidLadderException;
import exception.InvalidSnakeException;

public class LadderSimpleImpl implements Ladder {

    Integer top;
    Integer bottom;

    public LadderSimpleImpl(Integer top, Integer bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }



    @Override
    public void validate() throws Exception {
        if(top == null || bottom == null){
            throw  new InvalidSnakeException("Bottom or top  cannot be null");
        }
        if(bottom.longValue() > top.longValue()){
            throw new InvalidLadderException(String.format("bottom is at %d and top at %d are invalid",
                    bottom.longValue(), top.longValue()));
        }
    }

    @Override
    public Long climbLadder() throws Exception{
        if(top != null && bottom!= null){
            return (top.longValue() - bottom.longValue());
        }else{
            throw new InvalidLadderException("Ladder not intialised");
        }

    }
}