package com.kowal.service;

import com.kowal.City;
import com.kowal.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JK on 2016-01-12.
 */
@Service
@Transactional
public class CityService {
    @Autowired
    private CityDao cityDao;

    public List<City> findAllCities() {
        return cityDao.findAllCities();
    }
    public String toString(){
        return findAllCities().toString();
    }
}
