/**
 * 
 */
package com.ideamoment.ideatesting.schema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideatesting.schema.dao.SchemaDao;

/**
 * @author Chinakite
 *
 */
@Service
public class SchemaService {
    @Autowired
    private SchemaDao schemaDao;
}
