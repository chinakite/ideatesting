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