; window.IDEATESTING || (window.IDEATESTING = {});
IDEATESTING.runcase || (IDEATESTING.runcase = {});

$(document).ready(function(){
    $('#menu_runcase').siblings().removeClass('active');
    $('#menu_runcase').siblings().removeClass('active-link');
    $('#menu_runcase').addClass('active');
    $('#menu_runcase').addClass('active-link');

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    $('#caseTbl').dataTable( {
          "processing": true,
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": true,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + runcasePageVars.projectId + "/dtPageCases",
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
                      return full.scriptId;
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
              },
              {
                  "targets": [5],
                  "render": function(data, type, full) {
                      var role = '${sessionScope.__SESSION__USER__.role}';
                  
                      var html = '<a href=\'<idp:url value="/product/productDetail"/>?id=' + full.id + '\' target="_blank">查看依赖链</a> ';
                          html += '<span class="small">|</span> ';
                          html += '<a href="javascript:void(0);" onclick="IDEATESTING.scriptlib.parseScript(\'' + full.id + '\');">执行</a>';
                      
                      return html;
                  }
              }
          ]
      } );
      
      $('#caseGroupTbl').dataTable( {
          "processing": true,
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": true,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + runcasePageVars.projectId + "/dtPageCaseGroups",
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
                      return full.scriptId;
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
              },
              {
                  "targets": [5],
                  "render": function(data, type, full) {
                      var role = '${sessionScope.__SESSION__USER__.role}';
                  
                      var html = '<a href=\'<idp:url value="/product/productDetail"/>?id=' + full.id + '\' target="_blank">查看用例</a> ';
                          html += '<span class="small">|</span> ';
                          html += '<a href="javascript:void(0);" onclick="IDEATESTING.scriptlib.parseScript(\'' + full.id + '\');">执行</a>';
                      
                      return html;
                  }
              }
          ]
      } );
});