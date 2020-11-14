package model.dice;

import exception.InvalidDiceException;

public class SingleDiceImpl implements Dice {

    Long max;
    Long min;

    public SingleDiceImpl(Long max) throws Exception{
        setMax(max);
    }

    public SingleDiceImpl(Long min, Long max) throws Exception{
        setMin(min);
        setMax(max);
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) throws Exception {
        if(min == null){
            min = 1l;
        }
        if(max.longValue() < min.longValue()){
            throw new InvalidDiceException("Min value should be less than max value");
        }
        this.max = max;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) throws Exception{
        if((max != null) && (max.longValue() < min.longValue())){
            throw  new InvalidDiceException("max value hsould be greater than min valuye");
        }
        this.min = min;
    }




    @Override
    public Long getNextMove() throws Exception {
        Long nextSteps = null;
        try {
            nextSteps =
                    (long)((double)getMin() + (Math.random())*(getMax() - getMin()));

        }catch (Exception e){
            throw e;
        }
        return nextSteps;
    }
}