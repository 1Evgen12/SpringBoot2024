package ru.shilov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shilov.MySecondTestAppSpringBoot.model.Positions;
@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate (Positions positions, double salary, double bonus, int workDays, boolean leapYear, boolean isManager){
        if(leapYear){
            return salary*bonus*366*positions.getPositionCoefficient()/workDays;
        }
        return salary*bonus*365*positions.getPositionCoefficient()/workDays;
    }
    @Override
    public double QuarterBonus (Positions positions, double salary, double bonus, int workDays, boolean isManager){
        if(isManager) {
            return salary * bonus * 91 * positions.getPositionCoefficient() / workDays;
        }
        return -1;
    }
}
