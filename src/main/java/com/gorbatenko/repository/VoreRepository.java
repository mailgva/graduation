package com.gorbatenko.repository;

import com.gorbatenko.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoreRepository {
    Vote save(Vote vote);

    // false if not found
    boolean delete(int id);

    // null if not found
    Vote get(int id);

    // null if not found
    Vote getByDate(LocalDate date);

    List<Vote> getAll();
}
