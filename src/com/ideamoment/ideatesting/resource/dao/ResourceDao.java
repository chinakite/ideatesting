/**
 * 
 */
package com.ideamoment.ideatesting.resource.dao;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.RunNode;
import com.ideamoment.ideatesting.model.dict.TestNodeTypeDict;

/**
 * @author Chinakite
 *
 */
@Component
public class ResourceDao {

    public Page<RunNode> pageQueryHubsByOwner(int curPage,
                                               int pageSize,
                                               String ownerId)
    {
        String sql = "SELECT * FROM T_NODE WHERE C_OWNER_ID = :ownerId and C_TYPE = :type";
        return IdeaJdbc.query(sql)
                        .setParameter("ownerId", ownerId)
                        .setParameter("type", TestNodeTypeDict.HUB)
                        .pageTo(RunNode.class, curPage, pageSize);
    }

    public Page<RunNode> pageQueryNodesByOwner(int curPage,
                                                int pageSize,
                                                String ownerId)
    {
        String sql = "SELECT * FROM T_NODE WHERE C_OWNER_ID = :ownerId and C_TYPE = :type";
        return IdeaJdbc.query(sql)
                        .setParameter("ownerId", ownerId)
                        .setParameter("type", TestNodeTypeDict.NODE)
                        .pageTo(RunNode.class, curPage, pageSize);
    }

}
