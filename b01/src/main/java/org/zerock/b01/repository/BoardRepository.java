package org.zerock.b01.repository;
import jakarta.persistence.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.repository.search.BoardSearch;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from Board b where b.bno =:bno")
    Optional<Board> findByIdWithImages(Long bno);


    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}