package com.kowal.service;

import com.kowal.Journey;
import com.kowal.User;
import com.kowal.dao.JourneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JK on 2016-01-14.
 */
@Service
public class JourneyService {
    @Autowired
    private JourneyDao journeyDao;

    private User user;
//    private JourneyNumber number;
    public List<Journey> findJourney(Long userId, Long journeyId){
        return journeyDao.findJourney(userId, journeyId);
    }

    public void saveJourney(Journey journey){
        journeyDao.persist(journey);
        journeyDao.flush();
    }

    public int whatJourneyNumber(User user){
        this.user = user;
        int journeyNumber;
        if(journeyDao.whatJourneyNumber(user.getId(), (long) 1) == 1){
            journeyNumber = 1;
        }else if(journeyDao.whatJourneyNumber(user.getId(), (long) 2) == 2){
            journeyNumber = 2;
        }else journeyNumber=3;
        return journeyNumber;
    }

    public void addOneJourney(String name, User user, int whatNumber) {
        this.user = user;
        System.out.println(user.getId());
        Journey journey = new Journey();
        journey.setUserId(user.getId());
        journey.setCity(name);
        journey.setJourneyId((long) whatNumber);
        this.saveJourney(journey);
    }
}
