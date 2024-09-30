package ru.shilov.MySecondTestAppSpringBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2),
    BackEndDEV(2.0),
    FrontEndDEV(1.8),
    FullStackDEV(2.1),
    MiddleDEV(1.5),
    HR(1.2),
    TL(2.6);
    private final double  positionCoefficient;

    Positions(double positionCoefficient){
        this.positionCoefficient = positionCoefficient;
    }


}
