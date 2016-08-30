package com.kowal.dao;

import com.kowal.JouNumber;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static java.lang.Math.tan;
import static java.lang.Math.toIntExact;

/**
 * Created by JK on 2016-02-21.
 */
@Repository
public class NumberDao {
    @PersistenceContext
    private EntityManager entityManager;

    private final String selectNumber = "SELECT o from JouNumber  as o where o.userId = :userId";
    private final String selectOneNumber = "SELECT o from JouNumber  as o where o.userId = :userId and o.journeyId = :journeyId";

    public List<JouNumber> findNumber(Long userId){
        TypedQuery<JouNumber> query = this.entityManager.createQuery(selectNumber, JouNumber.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public JouNumber findOneNumber(Long userId, Long journeyId){
        TypedQuery<JouNumber> query = this.entityManager.createQuery(selectOneNumber, JouNumber.class);
        query.setParameter("userId", userId);
        query.setParameter("journeyId", journeyId);
        return query.getSingleResult();
    }

    public int whatJourneyNumber(Long userId){
        List<JouNumber> numbers = this.findNumber(userId);
        if(numbers.isEmpty()){
            return 1;
        }else{
            JouNumber lastNumber =  numbers.get(numbers.size()-1);
            int whatNumber = toIntExact(lastNumber.getJourneyId());
            return whatNumber+1;
        }
    }

    @Transactional
    public void persist(JouNumber jouNumber){
        this.entityManager.persist(jouNumber);
    }

    @Transactional
    public void remove(JouNumber jouNumber){
        System.out.println(jouNumber.getJourneyId());
        jouNumber = this.entityManager.merge(jouNumber);
        this.entityManager.remove(jouNumber);
    }
    public void flush() {
        this.entityManager.flush();
    }
}
