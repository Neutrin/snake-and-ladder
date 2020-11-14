package model.snake;

import exception.InvalidSnakeException;

public class SnakeSimpleImpl implements Snake {

    Integer mouth;
    Integer tail;

    public Integer getMouth() {
        return mouth;
    }

    public void setMouth(Integer mouth) {
        this.mouth = mouth;
    }

    public Integer getTail() {
        return tail;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }

    public SnakeSimpleImpl(Integer mouth, Integer tail) {
        this.mouth = mouth;
        this.tail = tail;
    }

    @Override
    public void validate() throws Exception {
        if(mouth == null || tail == null){
            throw  new InvalidSnakeException("Mouth and tail cannot be null");
        }
        if(mouth.longValue() < tail.longValue()){
            throw new InvalidSnakeException(String.format("Mouth is at %d and tail at %d are invalid",
                    mouth.longValue(), tail.longValue()));
        }
    }

    @Override
    public Long snakeBite() {
        return (tail.longValue() - mouth.longValue());
    }




}