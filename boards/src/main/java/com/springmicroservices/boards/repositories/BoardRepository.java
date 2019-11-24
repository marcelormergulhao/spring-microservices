package com.springmicroservices.boards.repositories;

import com.springmicroservices.boards.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
