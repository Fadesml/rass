package ru.rass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rass.api.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
