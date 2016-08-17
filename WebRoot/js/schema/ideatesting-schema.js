; window.IDEATESTING || (window.IDEATESTING = {});
IDEATESTING.schema || (IDEATESTING.schema = {});

IDEATESTING.schema.runSchema = function(id) {
    $.post(
        commonVars.ctx + '/project/' + schemaPageVars.projectId + "/schema/" + id + "/run",
        {},
        function(json){
            alert('执行成功');
        }
    );
};

IDEATESTING.schema.clearSchemaModal = function() {
    $('#schemaModal #schemaName').val('');
    $('#schemaModal #schemaDesc').val('');
    $('#schemaModal #scriptTbl tbody').empty();
    $('#addSchemaStep1').siblings().hide();
    $('#addSchemaStep1').show();
    $('#schemaModal').modal('show');
};

IDEATESTING.schema.popAddSchemaModal = function() {
    IDEATESTING.schema.clearSchemaModal();
    $('#schemaModal').modal('show');
};

IDEATESTING.schema.addSchemaPrevStep = function() {
    var step2Shown = $('#addSchemaStep2').css('display') != 'none';
    var step3Shown = $('#addSchemaStep3').css('display') != 'none';
    var step4Shown = $('#addSchemaStep4').css('display') != 'none';
    var step5Shown = $('#addSchemaStep5').css('display') != 'none';

    if(step2Shown) {
        IDEATESTING.schema.toAddSchemaStep1();
    }

    if(step3Shown) {
        IDEATESTING.schema.toAddSchemaStep2();
    }

    if(step4Shown) {
        IDEATESTING.schema.toAddSchemaStep3();
    }

    if(step5Shown) {
        IDEATESTING.schema.toAddSchemaStep4();
    }
};

IDEATESTING.schema.addSchemaNextStep = function() {
    var step1Shown = $('#addSchemaStep1').css('display') != 'none';
    var step2Shown = $('#addSchemaStep2').css('display') != 'none';
    var step3Shown = $('#addSchemaStep3').css('display') != 'none';
    var step4Shown = $('#addSchemaStep4').css('display') != 'none';

    if(step1Shown) {
        IDEATESTING.schema.toAddSchemaStep2();
    }

    if(step2Shown) {
        IDEATESTING.schema.toAddSchemaStep3();
    }

    if(step3Shown) {
        IDEATESTING.schema.toAddSchemaStep4();
    }

    if(step4Shown) {
        IDEATESTING.schema.toAddSchemaStep5();
    }
};

IDEATESTING.schema.scriptTbl = null;
IDEATESTING.schema.hubTbl = null;
IDEATESTING.schema.nodeTbl = null;

IDEATESTING.schema.toAddSchemaStep1 = function() {
    $('#addSchemaStep1').siblings().hide();
    $('#addSchemaStep1').show();
    $('#addSchemaPrevStepBtn').prop('disabled', true);
    $('#addSchemaNextStepBtn').prop('disabled', false);
}

IDEATESTING.schema.toAddSchemaStep2 = function() {
    $('#addSchemaStep2').siblings().hide();
    $('#addSchemaStep2').show();
    $('#addSchemaPrevStepBtn').prop('disabled', false);

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    if(!(IDEATESTING.schema.scriptTbl)) {
        IDEATESTING.schema.scriptTbl = $('#scriptTbl').dataTable( {
            "processing": true,
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": true,
            "autoWidth": false,
            "serverSide": true,
            "ajax": {url: commonVars.ctx + '/project/' + schemaPageVars.projectId + "/dtPageScripts",
                "data": function(d) {

                }
            },
            language: {
                "paginate": {
                    "first":      "首页",
                    "previous":   "上一页",
                    "next":       "下一页",
                    "last":       "尾页"
                },
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "emptyTable": "没有符合条件的数据",
                "infoEmpty": ""
            },
            "columns": [
                {width:'1px'},
                {},
                {},
                {},
                {},
            ],
            "columnDefs": [
                {
                    "targets": [0],
                    "render": function(data, type, full) {
                        return '<input type="checkbox" value="' + full.id + '" class="tblRowCheckbox"/>';
                    }
                },
                {
                    "targets": [1],
                    "render": function(data, type, full) {
                        return full.fileName;
                    }
                },
                {
                    "targets": [2],
                    "render": function(data, type, full) {
                        return full.version;
                    }
                },
                {
                    "targets": [3],
                    "render": function(data, type, full) {
                        return full.creatorId;
                    }
                },
                {
                    "targets": [4],
                    "render": function(data, type, full) {
                        return full.createTime;
                    }
                }
            ]
        } );
    }else{
        IDEATESTING.schema.scriptTbl.draw();
    }
};

IDEATESTING.schema.toAddSchemaStep3 = function() {
    $('#addSchemaStep3').siblings().hide();
    $('#addSchemaStep3').show();
    $('#addSchemaPrevStepBtn').prop('disabled', false);

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    if(!(IDEATESTING.schema.hubTbl)) {
        IDEATESTING.schema.hubTbl = $('#hubsTbl').dataTable( {
            "processing": true,
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": true,
            "autoWidth": false,
            "serverSide": true,
            "ajax": {url: commonVars.ctx + '/resource/dtPageHubs',
                "data": function(d) {

                }
            },
            language: {
                "paginate": {
                    "first":      "首页",
                    "previous":   "上一页",
                    "next":       "下一页",
                    "last":       "尾页"
                },
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "emptyTable": "没有符合条件的数据",
                "infoEmpty": ""
            },
            "columns": [
                {width:'1px'},
                {},
                {},
                {},
                {},
                {}
            ],
            "columnDefs": [
                {
                    "targets": [0],
                    "render": function(data, type, full) {
                        return '<input type="checkbox" value="' + full.id + '" class="tblRowCheckbox"/>';
                    }
                },
                {
                    "targets": [1],
                    "render": function(data, type, full) {
                        return full.name;
                    }
                },
                {
                    "targets": [2],
                    "render": function(data, type, full) {
                        return full.address;
                    }
                },
                {
                    "targets": [3],
                    "render": function(data, type, full) {
                        return full.port;
                    }
                },
                {
                    "targets": [4],
                    "render": function(data, type, full) {
                        return full.creatorId;
                    }
                },
                {
                    "targets": [5],
                    "render": function(data, type, full) {
                        return full.createTime;
                    }
                }
            ]
        } );
    }else{
        IDEATESTING.schema.hubTbl.draw();
    }
};

IDEATESTING.schema.toAddSchemaStep4 = function() {
    $('#addSchemaStep4').siblings().hide();
    $('#addSchemaStep4').show();
    $('#addSchemaPrevStepBtn').prop('disabled', false);

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    if(!(IDEATESTING.schema.nodeTbl)) {
        IDEATESTING.schema.nodeTbl = $('#nodesTbl').dataTable( {
            "processing": true,
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": false,
            "info": true,
            "autoWidth": false,
            "serverSide": true,
            "ajax": {url: commonVars.ctx + '/resource/dtPageNodes',
                "data": function(d) {

                }
            },
            language: {
                "paginate": {
                    "first":      "首页",
                    "previous":   "上一页",
                    "next":       "下一页",
                    "last":       "尾页"
                },
                "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "emptyTable": "没有符合条件的数据",
                "infoEmpty": ""
            },
            "columns": [
                {width:'1px'},
                {},
                {},
                {},
                {},
                {}
            ],
            "columnDefs": [
                {
                    "targets": [0],
                    "render": function(data, type, full) {
                        return '<input type="checkbox" value="' + full.id + '" class="tblRowCheckbox"/>';
                    }
                },
                {
                    "targets": [1],
                    "render": function(data, type, full) {
                        return full.name;
                    }
                },
                {
                    "targets": [2],
                    "render": function(data, type, full) {
                        return full.address;
                    }
                },
                {
                    "targets": [3],
                    "render": function(data, type, full) {
                        return full.port;
                    }
                },
                {
                    "targets": [4],
                    "render": function(data, type, full) {
                        return full.creatorId;
                    }
                },
                {
                    "targets": [5],
                    "render": function(data, type, full) {
                        return full.createTime;
                    }
                }
            ]
        } );
    }else{
        IDEATESTING.schema.nodeTbl.draw();
    }
};

IDEATESTING.schema.toAddSchemaStep5 = function() {
    $('#addSchemaStep5').siblings().hide();
    $('#addSchemaStep5').show();
    $('#addSchemaPrevStepBtn').prop('disabled', false);
    $('#addSchemaNextStepBtn').prop('disabled', true);
};

IDEATESTING.schema.saveSchema = function() {

};

$(document).ready(function(){
    $('#menu_schema').siblings().removeClass('active');
    $('#menu_schema').siblings().removeClass('active-link');
    $('#menu_schema').addClass('active');
    $('#menu_schema').addClass('active-link');

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    $('#schemaTbl').dataTable( {
          "processing": true,
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": true,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + schemaPageVars.projectId + "/dtPageSchemas",
              "data": function(d) {
                  
              }
          },
          language: {
            "paginate": {
              "first":      "首页",
              "previous":   "上一页",
              "next":       "下一页",
              "last":       "尾页"
            },
            "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "emptyTable": "没有符合条件的数据",
            "infoEmpty": ""  
          },
          "columns": [
            {width:'1px'},
            {},
            {},
            {},
            {}
          ],
          "columnDefs": [
              {
                  "targets": [0],
                  "render": function(data, type, full) {
                    return '<input type="checkbox" value="' + full.id + '" class="tblRowCheckbox"/>';
                  }
              },
              {
                  "targets": [1],
                  "render": function(data, type, full) {
                      return full.name;
                  }
              },
              {
                  "targets": [2],
                  "render": function(data, type, full) {
                      return full.desc;
                  }
              },
              {
                  "targets": [3],
                  "render": function(data, type, full) {
                      return full.runType;
                  }
              },
              {
                  "targets": [4],
                  "render": function(data, type, full) {
                      var role = '${sessionScope.__SESSION__USER__.role}';
                  
                      var html = '<a href=\'<idp:url value="/product/productDetail"/>?id=' + full.id + '\' target="_blank">查看</a> ';
                          html += '<span class="small">|</span> ';
                          html += '<a href="javascript:void(0);" onclick="IDEATESTING.schema.runSchema(\'' + full.id + '\');">立即执行</a>';
                      
                      return html;
                  }
              }
          ]
      } );
});