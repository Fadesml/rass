package ru.rass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rass.api.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
