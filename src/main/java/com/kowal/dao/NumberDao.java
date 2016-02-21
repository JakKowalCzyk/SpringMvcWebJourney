package com.kowal.dao;

import com.kowal.JouNumber;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static java.lang.Math.toIntExact;

/**
 * Created by JK on 2016-02-21.
 */
@Repository
public class NumberDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<JouNumber> findNumber(Long userId){
        TypedQuery<JouNumber> query = entityManager.createQuery("SELECT o from JouNumber  as o where o.userId = :userId", JouNumber.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public int whatJourneyNumber(Long userId){
        List<JouNumber> numbers = this.findNumber(userId);
        if(numbers.isEmpty()){
            return 1;
        }else{
            JouNumber lastNumber =  numbers.get(numbers.size()-1);
            int whatNumber = toIntExact(lastNumber.getJourneyId());
            System.out.println(whatNumber);
            return whatNumber+1;
        }
    }

    @Transactional
    public void persist(JouNumber jouNumber){
        this.entityManager.persist(jouNumber);
    }

    public void flush() {
        this.entityManager.flush();
    }
}
