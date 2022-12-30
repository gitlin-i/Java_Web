package com.example.api01.repository;

import com.example.api01.domain.Todo;
import com.example.api01.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
