package uk.co.diggidydale.statsroller.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.diggidydale.statsroller.model.Stat;

/**
 * @author DaleH
 */
@Component
public class RollerService {

    DieRoller d6Roller;

    @Autowired
    public RollerService(DieRoller d6Roller) {
        this.d6Roller = d6Roller;
    }

    public List<Stat> rollForStatsOver(int value){
        boolean check = false;
        List<Stat> stats = Collections.emptyList();
        while(!check){
            stats = rollForStats();

            List<Integer> currentStats = stats
                    .stream()
                    .map(Stat::getRoll)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            check = currentStats.get(0) >= value;

        }
        return stats;
    }

    public List<Stat> rollForStats(){
        List<Stat> fullStatsRolls = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            fullStatsRolls.add(rollForSingleStat());
        }
        return fullStatsRolls;
    }

    private Stat rollForSingleStat(){
        return new Stat(statRoll());
    }

    private int statRoll(){
        return d6Roller.roll(4)
                .stream()
                .sorted(Comparator.naturalOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
