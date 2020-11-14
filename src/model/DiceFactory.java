package model;

import exception.InvalidDiceException;
import model.dice.Dice;
import model.dice.SingleDiceImpl;

public class DiceFactory {

    public Dice getInstance(String input) throws Exception {
        String []inputSplit = input.split("\\-");
        Dice dice = null;
        if(inputSplit.length > 0){
            switch (inputSplit[0]){
                case "Single" :
                    if(inputSplit.length < 1){
                        throw new InvalidDiceException(String.format("Invalid format for dice %s", input));
                    }
                    try {
                    dice = new SingleDiceImpl(Long.parseLong(inputSplit[1]));
                    } catch (Exception e){
                        throw e;
                    } break;

                default:
                    throw new InvalidDiceException("Not a valid format");

            }
        }else{
            throw new InvalidDiceException(String.format("Invalid input for string %s", input));
        }
        return dice;
    }
}