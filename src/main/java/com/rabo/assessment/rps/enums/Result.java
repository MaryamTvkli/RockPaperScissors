package com.rabo.assessment.rps.enums;

import lombok.Getter;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
@Getter
public enum Result {

    DRAW(0),

    LOOSE(2),

    WIN(1);

    private final Integer value;

    Result(Integer value) {
        this.value = value;
    }
}
