package com.springmicroservices.boards.repositories;

import com.springmicroservices.boards.models.Board;
import com.springmicroservices.boards.models.LabelGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface LabelGroupRepository extends JpaRepository<LabelGroup, Integer> {

    List<LabelGroup> findByBoardId(Integer boardId);
}
