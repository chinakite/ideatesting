; window.IDEATESTING || (window.IDEATESTING = {});
IDEATESTING.report || (IDEATESTING.report = {});

IDEATESTING.report.commandResultTbl;

IDEATESTING.report.showCommandResults = function(caseResultId) {
    $('#commandResultModal').modal('show');
    
    if(IDEATESTING.report.commandResultTbl) {
        IDEATESTING.report.commandResultTbl.draw();
    }else{
	    IDEATESTING.report.commandResultTbl = $('#commandResultTbl').dataTable( {
	          "processing": true,
	          "paging": false,
	          "lengthChange": false,
	          "searching": false,
	          "ordering": false,
	          "info": false,
	          "autoWidth": false,
	          "serverSide": true,
	          "ajax": {url: commonVars.ctx + '/project/' + reportPageVars.projectId + "/schemaExecution/" + reportPageVars.schemaExecutionId + "/caseResult/" + caseResultId + "/commandReports",
	              "data": function(d) {
	                  
	              }
	          },
	          language: {
	            "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
	            "emptyTable": "没有符合条件的数据",
	            "infoEmpty": ""  
	          },
	          "columnDefs": [
	              {
	                  "targets": [0],
	                  "render": function(data, type, full) {
	                      return full.commandText;
	                  }
	              },
	              {
	                  "targets": [1],
	                  "render": function(data, type, full) {
	                      return full.startTime;
	                  }
	              },
	              {
	                  "targets": [2],
	                  "render": function(data, type, full) {
	                      return full.endTime;
	                  }
	              },
	              {
	                  "targets": [3],
	                  "render": function(data, type, full) {
	                      if(full.message) {
	                      	  return full.message;
	                      }else{
	                          return "";
	                      }
	                  }
	              },
	              {
	                  "targets": [4],
	                  "render": function(data, type, full) {
	                      return full.resultText;
	                  }
	              }
	          ]
	      } );
    }
};

$(document).ready(function(){
    $('#menu_report').siblings().removeClass('active');
    $('#menu_report').siblings().removeClass('active-link');
    $('#menu_report').addClass('active');
    $('#menu_report').addClass('active-link');

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    $('#reportTbl').dataTable( {
          "processing": true,
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": true,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + reportPageVars.projectId + "/dtPageReports",
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
                      return full.startTime;
                  }
              },
              {
                  "targets": [2],
                  "render": function(data, type, full) {
                      return full.endTime;
                  }
              },
              {
                  "targets": [3],
                  "render": function(data, type, full) {
                      return full.schema.name;
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
                      return full.stateText;
                  }
              },
              {
                  "targets": [6],
                  "render": function(data, type, full) {
                      var html = '<a href="' + commonVars.ctx + '/project/'+ reportPageVars.projectId + '/schemaExecution/' + full.id + '/caseReportPage">查看详情</a> ';
                      return html;
                  }
              }
          ]
      } );
      
      
      $('#caseResultTbl').dataTable( {
          "processing": true,
          "paging": false,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": false,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + reportPageVars.projectId + "/schemaExecution/" + reportPageVars.schemaExecutionId + "/caseReports",
              "data": function(d) {
                  
              }
          },
          language: {
            "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "emptyTable": "没有符合条件的数据",
            "infoEmpty": ""  
          },
          "columnDefs": [
              {
                  "targets": [0],
                  "render": function(data, type, full) {
                      return full.caseName;
                  }
              },
              {
                  "targets": [1],
                  "render": function(data, type, full) {
                      return full.script.fileName;
                  }
              },
              {
                  "targets": [2],
                  "render": function(data, type, full) {
                      return full.startTime;
                  }
              },
              {
                  "targets": [3],
                  "render": function(data, type, full) {
                      return full.endTime;
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
                      return full.resultText;
                  }
              },
              {
                  "targets": [6],
                  "render": function(data, type, full) {
                      var html = '<a href="javascript:void(0);" onclick="IDEATESTING.report.showCommandResults(\'' + full.id + '\');">查看详情</a> ';
                      return html;
                  }
              }
          ]
      } );
});