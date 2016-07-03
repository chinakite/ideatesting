$(document).ready(function(){
    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    $('#demo-dt-basic').dataTable( {
          "processing": true,
          "paging": true,
          "lengthChange": false,
          "searching": false,
          "ordering": false,
          "info": true,
          "autoWidth": false,
          "serverSide": true,
          "ajax": {url: commonVars.ctx + '/project/' + scriptPageVars.projectId + "/dtPageScripts",
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
              },
              {
                  "targets": [5],
                  "render": function(data, type, full) {
                      var role = '${sessionScope.__SESSION__USER__.role}';
                  
                      var html = '<a href=\'<idp:url value="/product/productDetail"/>?id=' + full.id + '\' target="_blank">查看</a> ';
                          
                      if(full.state == '0' || full.state == '101') {
                          html += '<span class="small">|</span> ';
                          html += '<a onclick="popEditModal(\'' + full.id + '\');">编辑</a>';
                          html += ' <span class="small">|</span> <a onclick="deleteProduct(\'' + full.id + '\', \'' + full.name + '\');">删除</a>';
                      }
                      
                      return html;
                  }
              }
          ]
      } );
});