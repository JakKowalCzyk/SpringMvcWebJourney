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
    public List<Journey> findJourney(Long userId, Long journeyId){
        return journeyDao.findJourney(userId, journeyId);
    }

    public void saveJourney(Journey journey){
        journeyDao.persist(journey);
        journeyDao.flush();
    }

    public void addOneJourney(String name, User user, int whatNumber) {
        this.user = user;
        Journey journey = new Journey();
        journey.setUserId(user.getId());
        journey.setCity(name);
        journey.setJourneyId((long) whatNumber);
        this.saveJourney(journey);
    }

    public void removeJourney(Long userId, Long journeyId){
        List<Journey> journeys = journeyDao.findJourney(userId, journeyId);
        for (Journey j: journeys) {
            journeyDao.remove(j);
        }
        journeyDao.flush();
    }

    public void removeOneJourney(Long id){
        journeyDao.remove(journeyDao.findOneJourney(id));
    }
}
