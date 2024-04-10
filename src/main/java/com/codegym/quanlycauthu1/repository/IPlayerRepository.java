package com.codegym.quanlycauthu1.repository;

import com.codegym.quanlycauthu1.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
    boolean existsByName(String name);
}
