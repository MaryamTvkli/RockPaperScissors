package com.rabo.assessment.rps.repository;

import com.rabo.assessment.rps.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
public interface GameRepository extends JpaRepository<Game,Long> {
}
