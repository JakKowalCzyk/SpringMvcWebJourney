package com.kowal.dao;

import com.kowal.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JK on 2016-01-12.
 */
@Repository
public class CityDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<City> findAllCities(){
        return entityManager.createQuery("SELECT o from City o", City.class).getResultList();
    }

    public City findCity(Long id){
        return entityManager.find(City.class, id);
    }
}
