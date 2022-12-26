package com.rabo.assessment.rps.repository;

import com.rabo.assessment.rps.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Maryam Tavakoli on 22/12/2022
 */
public interface RoundRepository extends JpaRepository<Round,Long> {
}
