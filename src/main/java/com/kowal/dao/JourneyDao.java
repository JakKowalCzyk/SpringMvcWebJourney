package com.kowal.dao;

import com.kowal.Journey;
import com.kowal.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JK on 2016-01-13.
 */
@Repository
public class JourneyDao {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Journey> findJourney(Long userId, Long journeyId){
        TypedQuery<Journey> query = entityManager.createQuery("SELECT o from Journey as o where o.userId = :userId AND o.journeyId = :journeyId", Journey.class);
        query.setParameter("userId", userId);
        query.setParameter("journeyId", journeyId);
        return query.getResultList();
        
    }
    
    @Transactional
    public void persist(Journey journey){
        this.entityManager.persist(journey);
    }
    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

}
