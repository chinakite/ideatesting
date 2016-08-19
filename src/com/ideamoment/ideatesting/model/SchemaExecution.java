package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;

import java.util.Date;

/**
 * Created by zhangzhonghua on 2016/8/19.
 */
@Entity(dataSet="T_SCHEMA_EXECUTION")
public class SchemaExecution extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type= DataItemType.VARCHAR, length=32)
    private String schemaId;

    @Property(dataItem="C_START_TIME", type= DataItemType.DATETIME)
    private Date startTime;

    @Property(dataItem="C_END_TIME", type= DataItemType.DATETIME)
    private Date endTime;


}
