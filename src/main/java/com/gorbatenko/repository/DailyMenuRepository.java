package com.gorbatenko.repository;

import com.gorbatenko.model.DailyMenu;

import java.time.LocalDate;
import java.util.List;

public interface DailyMenuRepository {
    DailyMenu save(DailyMenu dailyMenu);

    // false if not found
    boolean delete(int id);

    // null if not found
    DailyMenu get(int id);

    // null if not found
    DailyMenu getByDate(LocalDate date);

    List<DailyMenu> getAll();
}
