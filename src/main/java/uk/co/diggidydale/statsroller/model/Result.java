package uk.co.diggidydale.statsroller.model;

import java.util.List;

/**
 * @author DaleH
 */
public class Result {

    private List<Stat> stats;

    private int totalRolls;

    private int totalBonus;

    public Result(List<Stat> stats) {
        this.stats = stats;
        initTotalRolls();
        initTotalBonus();
    }

    private void initTotalRolls(){
        this.totalRolls = stats.stream().mapToInt(Stat::getRoll).sum();
    }

    private void initTotalBonus(){
        this.totalBonus = stats.stream().mapToInt(Stat::getBonus).sum();
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public int getTotalRolls() {
        return totalRolls;
    }

    public void setTotalRolls(int totalRolls) {
        this.totalRolls = totalRolls;
    }

    public int getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(int totalBonus) {
        this.totalBonus = totalBonus;
    }
}
