package ru.shilov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.shilov.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        Positions position = Positions.HR;
        double bonus = 2;
        int workDays = 243;
        double salary = 100000;
        boolean leapYear = false;
        boolean isManager = false;
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays, leapYear, isManager);

        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}