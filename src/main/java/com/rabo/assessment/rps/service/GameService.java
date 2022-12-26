package com.rabo.assessment.rps.service;

import com.rabo.assessment.rps.enums.Choice;
import com.rabo.assessment.rps.exception.GameNotFoundException;
import com.rabo.assessment.rps.exception.GameOverException;
import com.rabo.assessment.rps.model.Game;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
public interface GameService {

    Game start(String playerOneName, String playerTwoName);

    Game getStatus(Long id) throws GameNotFoundException;

    Game play(Long id, Choice playerOneChoice, Choice playerTwoChoice) throws GameNotFoundException, GameOverException;
}
