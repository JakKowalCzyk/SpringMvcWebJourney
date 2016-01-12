package com.kowal.beans;

import com.kowal.City;
import com.kowal.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JK on 2016-01-11.
 */
@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private Map<City, Integer> contents = new HashMap<City, Integer>();

    public Map<City, Integer> getContents() {
        return contents;
    }

    @Override
    public String toString(){
        return contents.toString();
    }
}
