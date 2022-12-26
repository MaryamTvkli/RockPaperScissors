package com.rabo.assessment.rps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabo.assessment.rps.enums.Choice;
import com.rabo.assessment.rps.enums.Result;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
@Data
@NoArgsConstructor
@Entity
public class Round {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private Choice playerOneChoice;

    private Choice playerTwoChoice;

    private Result playerOneResult;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Game game;

    public Round(
            Choice playerOneChoice,
            Choice playerTwoChoice,
            Result result,
            Game game) {
        this.playerOneChoice = playerOneChoice;
        this.playerTwoChoice = playerTwoChoice;
        this.playerOneResult = result;
        this.game = game;
    }
}
