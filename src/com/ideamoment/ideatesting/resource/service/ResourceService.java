/**
 * 
 */
package com.ideamoment.ideatesting.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideatesting.resource.dao.ResourceDao;

/**
 * @author Chinakite
 *
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    
}
