package ru.shilov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.shilov.MySecondTestAppSpringBoot.model.Positions;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest2 {

    @Test
    void quarterBonus() {
        Positions position = Positions.HR;
        double bonus = 1.3;
        int workDays = 80;
        double salary = 100000;
        boolean isManager = true;
        double result = new AnnualBonusServiceImpl().QuarterBonus(position,salary, bonus, workDays,isManager );
        double expected = 177450;
        assertThat(result).isEqualTo(expected);

    }
}