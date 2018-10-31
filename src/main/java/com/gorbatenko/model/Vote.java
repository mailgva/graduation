package com.gorbatenko.model;

import com.gorbatenko.util.DateTimeUtil;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "voting")
public class Vote extends AbstractBaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne
    private DailyMenu dailyMenu;

    @Column(name = "date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDateTime dateTime;

    public Vote(User user, DailyMenu dailyMenu, @NotNull LocalDateTime dateTime) {
        this.user = user;
        this.dailyMenu = dailyMenu;
        this.dateTime = dateTime;
    }

    public Vote(Integer id, User user, DailyMenu dailyMenu, @NotNull LocalDateTime dateTime) {
        super(id);
        this.user = user;
        this.dailyMenu = dailyMenu;
        this.dateTime = dateTime;
    }

    public Vote() {
    }
}
