package com.kowal.service;

import com.kowal.JouNumber;
import com.kowal.User;
import com.kowal.dao.NumberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2016-02-21.
 */
@Service
public class NumberService {
    @Autowired
    private NumberDao numberDao;

    private User user;

    public int WhatJourneyNumber(User user){
        this.user = user;
        int journeyNumber = numberDao.whatJourneyNumber(user.getId());
        this.addOneJourneyNumber(user, journeyNumber);
        return journeyNumber;
    }

    public void addOneJourneyNumber(User user, int whatNumber){
        JouNumber jouNumber = new JouNumber();
        jouNumber.setUserId(user.getId());
        jouNumber.setJourneyId((long) whatNumber);
        this.saveJourneyNumber(jouNumber);
    }

    private void saveJourneyNumber(JouNumber jouNumber) {
        numberDao.persist(jouNumber);
        //numberDao.flush();
    }
}
