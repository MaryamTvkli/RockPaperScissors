package com.rabo.assessment.rps.service;

import com.rabo.assessment.rps.enums.Choice;
import com.rabo.assessment.rps.enums.GameStatus;
import com.rabo.assessment.rps.exception.GameNotFoundException;
import com.rabo.assessment.rps.exception.GameOverException;
import com.rabo.assessment.rps.model.Game;
import com.rabo.assessment.rps.repository.GameRepository;
import com.rabo.assessment.rps.repository.RoundRepository;
import com.rabo.assessment.rps.service.impl.GameServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Maryam Tavakoli on 26/12/2022
 */
public class GameServiceImplTest {

    private GameRepository gameRepository;

    private RoundRepository roundRepository;

    private GameService classUnderTest;

    @Before
    public void setup() {
        gameRepository = mock(GameRepository.class);
        roundRepository = mock(RoundRepository.class);
        classUnderTest = new GameServiceImpl(gameRepository, roundRepository);
    }


    @Test(expected = GameNotFoundException.class)
    public void shouldThrowBadGameNotFoundException() throws GameNotFoundException {

        // given
        when(gameRepository.findById(any())).thenReturn(Optional.empty());

        // when
        classUnderTest.getStatus(1L);
    }

    @Test(expected = GameOverException.class)
    public void shouldThrowBadGameOverException() throws GameOverException, GameNotFoundException {

        // given
        Game givenGame = new Game();
        givenGame.setGameStatus(GameStatus.FINISHED);
        Long givenId = new Long(1L);
        when(gameRepository.findById(any())).thenReturn(Optional.ofNullable(givenGame));

        // when
        classUnderTest.play(givenId, Choice.getRandom(), Choice.getRandom());

    }

}
