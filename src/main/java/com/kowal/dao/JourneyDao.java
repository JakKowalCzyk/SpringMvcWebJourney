package com.kowal.dao;

import com.kowal.Journey;
import com.kowal.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JK on 2016-01-13.
 */
@Repository
public class JourneyDao {
    @PersistenceContext
    private EntityManager entityManager;
    private final String selectJourney = "SELECT o from Journey as o where o.userId = :userId AND o.journeyId = :journeyId";

    public List<Journey> findJourney(Long userId, Long journeyId){
        TypedQuery<Journey> query = entityManager.createQuery(selectJourney, Journey.class);
        query.setParameter("userId", userId);
        query.setParameter("journeyId", journeyId);
        return query.getResultList();
    }

    @Transactional
    public void persist(Journey journey){
        this.entityManager.persist(journey);
    }
    @Transactional
    public Journey findOneJourney(Long id){
        return this.entityManager.find(Journey.class, id);
    }
    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public void remove(Journey journey){
        journey = entityManager.merge(journey);
        entityManager.remove(journey);
    }


}
