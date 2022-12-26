package com.rabo.assessment.rps.enums;

import lombok.Getter;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
@Getter
public enum GameStatus {

    STARTED(0),

    FINISHED(1);

    private final Integer value;

    GameStatus(Integer value) {
        this.value = value;
    }
}
