/**
 * 
 */

package com.ideamoment.ideatesting.resource.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideadp.usercontext.UserContext;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.RunNode;
import com.ideamoment.ideatesting.model.dict.TestNodeStateDict;
import com.ideamoment.ideatesting.model.dict.TestNodeTypeDict;
import com.ideamoment.ideatesting.resource.dao.ResourceDao;

/**
 * @author Chinakite
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @IdeaJdbcTx
    public Page<RunNode> pageHubs(int curPage, int pageSize, String ownerId) {
        return resourceDao.pageQueryHubsByOwner(curPage, pageSize, ownerId);
    }

    @IdeaJdbcTx
    public Page<RunNode> pageNodes(int curPage, int pageSize, String ownerId) {
        return resourceDao.pageQueryNodesByOwner(curPage, pageSize, ownerId);
    }

    @IdeaJdbcTx
    public void addHub(RunNode node) {
        UserContext uc = UserContext.getCurrentContext();
        // User curUser =
        // (User)uc.getContextAttribute(UserContext.SESSION_USER);
        String userId = "1";
        Date curTime = new Date();
        node.setModifierId(userId);
        node.setModifyTime(curTime);
        node.setCreateTime(curTime);
        node.setCreatorId(userId);
        node.setOwnerId(userId);
        node.setState(TestNodeStateDict.USING);
        node.setType(TestNodeTypeDict.HUB);

        IdeaJdbc.save(node);
    }

    @IdeaJdbcTx
    public void editHub(RunNode node) {
        UserContext uc = UserContext.getCurrentContext();
        // User curUser =
        // (User)uc.getContextAttribute(UserContext.SESSION_USER);
        String userId = "1";
        Date curTime = new Date();
        node.setModifierId(userId);
        node.setModifyTime(curTime);

        IdeaJdbc.update(node);
    }

    @IdeaJdbcTx
    public RunNode findHub(String id) {
        return IdeaJdbc.find(RunNode.class, id);
    }

}
