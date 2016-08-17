package com.ideamoment.ideatesting.model;

import com.ideamoment.ideadata.annotation.DataItemType;
import com.ideamoment.ideadata.annotation.Entity;
import com.ideamoment.ideadata.annotation.Property;

/**
 * Created by zhangzhonghua on 2016/8/16.
 */
@Entity(dataSet="T_SCHEMA_SCRIPT")
public class SchemaScript extends HistoriableEntity {
    @Property(dataItem="C_SCHEMA_ID", type= DataItemType.VARCHAR, length=32)
    private String schemaId;

    @Property(dataItem="C_SCRIPT_ID", type=DataItemType.VARCHAR, length=32)
    private String scriptId;

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }
}
