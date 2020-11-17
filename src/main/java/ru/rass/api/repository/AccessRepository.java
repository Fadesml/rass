package ru.rass.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rass.api.models.Access;


@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
}
