package uk.co.diggidydale.statsroller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

/**
 * @author DaleH
 */
@Component
public class D6Roller implements DieRoller {

    @Override
    public List<Integer> roll(int numberOfDice) {
        List<Integer> diceRolls  = new ArrayList<>();
        for(int i = 0; i < numberOfDice; i++){
            diceRolls.add(rollSingleD6());
        }

        return diceRolls;
    }

    private int rollSingleD6(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
