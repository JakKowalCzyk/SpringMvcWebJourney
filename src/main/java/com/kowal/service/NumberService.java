package com.kowal.service;

import com.kowal.JouNumber;
import com.kowal.User;
import com.kowal.dao.NumberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

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

    public int WhatNumber(User user){
        this.user = user;
        int journeyNumber = numberDao.whatJourneyNumber(user.getId());
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
    }

    public void removeNumber(Long userId, Long journeyId){
        JouNumber jouNumber = numberDao.findOneNumber(userId, journeyId);
        numberDao.remove(jouNumber);
    }
    public ArrayList<Integer> getNumberList(User user){
        this.user = user;
        int whatJourneyNumber = this.WhatNumber(user);
        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        for (int i = 1; i <= whatJourneyNumber; i++) {
           numbersList.add(i);
        }
        return numbersList;
    }
}
