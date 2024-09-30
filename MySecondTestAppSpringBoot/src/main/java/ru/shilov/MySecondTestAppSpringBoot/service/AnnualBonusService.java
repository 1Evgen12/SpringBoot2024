package ru.shilov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shilov.MySecondTestAppSpringBoot.model.Positions;
@Service
public interface AnnualBonusService {
    double calculate(Positions position, double salary, double bonus, int workDays, boolean leapYear, boolean isManager);
    double QuarterBonus(Positions position, double salary, double bonus, int workDays, boolean isManager);
}
