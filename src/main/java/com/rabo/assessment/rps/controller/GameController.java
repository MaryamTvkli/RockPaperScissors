package com.rabo.assessment.rps.controller;

import com.rabo.assessment.rps.config.Constants;
import com.rabo.assessment.rps.enums.Choice;
import com.rabo.assessment.rps.exception.GameNotFoundException;
import com.rabo.assessment.rps.exception.GameOverException;
import com.rabo.assessment.rps.model.Game;
import com.rabo.assessment.rps.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
@Api(tags = "Game")
@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game start(
            @RequestParam("playerOneName") String playerOneName) {
        return gameService.start(playerOneName, Constants.PLAYER_TWO_NAME);
    }

    @GetMapping("/{gameId}")
    public Game getStatus(
            @PathVariable("gameId") Long id) throws GameNotFoundException {
        return gameService.getStatus(id);
    }

    @PutMapping("/{gameId}")
    public Game play(
            @PathVariable("gameId") Long id,
            @RequestParam("choice") Choice playerOneChoice) throws GameOverException, GameNotFoundException {
        Choice playerTwoChoice = Choice.getRandom();
        return gameService.play(id, playerOneChoice, playerTwoChoice);
    }
}