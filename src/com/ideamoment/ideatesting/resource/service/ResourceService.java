/**
 * 
 */
package com.ideamoment.ideatesting.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.TestNode;
import com.ideamoment.ideatesting.resource.dao.ResourceDao;

/**
 * @author Chinakite
 *
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    @IdeaJdbcTx
    public Page<TestNode> pageHubs(int curPage, int pageSize, String ownerId) {
        return resourceDao.pageQueryHubsByOwner(curPage, pageSize, ownerId);
    }

    @IdeaJdbcTx
    public Page<TestNode> pageNodes(int curPage, int pageSize, String ownerId) {
        return resourceDao.pageQueryNodesByOwner(curPage, pageSize, ownerId);
    }
    
}
