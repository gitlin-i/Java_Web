package com.example.api01.service;


import com.example.api01.dto.PageRequestDTO;
import com.example.api01.dto.PageResponseDTO;
import com.example.api01.dto.TodoDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface TodoService {
    Long register(TodoDTO todoDTO);

    TodoDTO read(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);

}
