package ru.rass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rass.api.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
