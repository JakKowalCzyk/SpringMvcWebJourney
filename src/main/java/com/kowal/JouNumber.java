package com.kowal;

import javax.persistence.*;

/**
 * Created by JK on 2016-02-21.
 */
@Entity
@Table(name = "number")
public class JouNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "journeyId")
    private Long journeyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Long journeyId) {
        this.journeyId = journeyId;
    }
}
