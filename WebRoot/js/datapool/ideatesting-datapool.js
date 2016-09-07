; window.IDEATESTING || (window.IDEATESTING = {});
IDEATESTING.datapool || (IDEATESTING.datapool = {});

IDEATESTING.datapool.clearParamModal = function() {
    $('#paramModal #name').val('');
    $('#paramModal #desc').val('');
    $('#paramModal #varName').val('');
    IDEATESTING.datapool.toAddParamStep1();
    $('#addParamStep1').show();
};

IDEATESTING.datapool.popAddParamModal = function(id) {
    IDEATESTING.datapool.clearParamModal();
    $('#paramModal').modal('show');
};

IDEATESTING.datapool.addParamPrevStep = function() {
    var step2Shown = $('#addParamStep2').css('display') != 'none';

    if(step2Shown) {
        IDEATESTING.datapool.toAddParamStep1();
    }
};

IDEATESTING.datapool.addParamNextStep = function() {
    var step1Shown = $('#addParamStep1').css('display') != 'none';

    if(step1Shown) {
        IDEATESTING.datapool.toAddParamStep2();
    }
};

IDEATESTING.datapool.toAddParamStep1 = function() {
    $('#addParamStep1').siblings().hide();
    $('#addParamStep1').show();
    $('#addParamPrevStepBtn').prop('disabled', true);
    $('#addParamNextStepBtn').prop('disabled', false);
    $('#addParamSaveBtn').prop('disabled', true);
};

IDEATESTING.datapool.toAddParamStep2 = function() {
    $('#addParamStep2').siblings().hide();
    $('#addParamStep2').show();
    $('#addParamPrevStepBtn').prop('disabled', false);
    $('#addParamNextStepBtn').prop('disabled', true);
    $('#addParamSaveBtn').prop('disabled', false);
};

IDEATESTING.datapool.saveParam = function() {
    var name = $('#name').val();
    var desc = $('#desc').val();
    var varName = $('#varName').val();
    var type = $('#type').val();

    $.post(
        commonVars.ctx + '/project/' + dataPoolPageVars.projectId + '/param',
        {
            'name': name,
            'desc': desc,
            'varName': varName,
            'type': type
        },
        function(json) {
            alert('保存成功');
            $('#paramModal').modal('hide');
            IDEATESTING.datapool.paramTbl.api().ajax.reload();
        }
    );
};

IDEATESTING.datapool.paramTbl = null;

$(document).ready(function(){
    $('#menu_datapool').siblings().removeClass('active');
    $('#menu_datapool').siblings().removeClass('active-link');
    $('#menu_datapool').addClass('active');
    $('#menu_datapool').addClass('active-link');

    $('.selectPicker').selectpicker({});

    // Basic Data Tables with responsive plugin
    // -----------------------------------------------------------------
    IDEATESTING.datapool.paramTbl = $('#dataTbl').dataTable( {
        "processing": true,
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": false,
        "info": true,
        "autoWidth": false,
        "serverSide": true,
        "ajax": {url: commonVars.ctx + '/project/' + dataPoolPageVars.projectId + "/dtPageParams",
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
                    return full.name;
                }
            },
            {
                "targets": [2],
                "render": function(data, type, full) {
                    return full.varName;
                }
            },
            {
                "targets": [3],
                "render": function(data, type, full) {
                    return full.typeText;
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
            },
            {
                "targets": [6],
                "render": function(data, type, full) {
                    var role = '${sessionScope.__SESSION__USER__.role}';

                    var html = '<a href=\'<idp:url value="/product/productDetail"/>?id=' + full.id + '\' target="_blank">查看</a> ';
                    html += '<span class="small">|</span> ';
                    html += '<a onclick="IDEATESTING.scriptlib.parseScript(\'' + full.id + '\');">重新解析</a>';

                    return html;
                }
            }
        ]
    } );

    $('#importFile').fileupload({
        url: commonVars.ctx + '/uploadParam',
        dataType: 'json',
        done: function (e, data) {
            var fileUrl = data['result']['data'][0]['fileUrl'];
            var fileName = data['result']['data'][0]['fileName'];
            $('#importFileServerUrl').val(fileUrl);

            var fileType = $('#fileType').val();
            $.post(
                commonVars.ctx + '/project/' + dataPoolPageVars.projectId + '/previewFile',
                {
                    fileUrl: fileUrl,
                    fileType: fileType
                },
                function(json){
					var excelData = $.parseJSON(json);
					var data = excelData.data;
					var selectorHtml = template('sheetSelectorTmpl', data);
					$('#sheetNames').html(selectorHtml);
					$('#sheetNames').selectpicker('refresh');
					var sheets = data.sheets;
					if(sheets && sheets.length > 0) {
						var sheet = sheets[0];
						var rows = sheet.rows;
						if(rows && rows.length > 0) {
							var header = rows[0];
							var headerHtml = template('preivewFileHeaderTmpl', header);
							$('#dataPreviewTbl thead').html(headerHtml);

							$('#dataPreviewTbl tbody').empty();

							var topRows = [];
							if(rows.length > 5) {
								for(var i=1; i<3; i++) {
								    topRows.push(rows[i]);
								}
							    var topRowsHtml = template('preivewFileDataRowTmpl', {rows: topRows});
								$('#dataPreviewTbl tbody').append(topRowsHtml);
								
								var collapsedHtml = template('preivewFileCollapsedRowTmpl', {columnCount: header.cells.length});
								$('#dataPreviewTbl tbody').append(collapsedHtml);
								
								var bottomRows=[];
								for(var i=rows.length-2; i<rows.length; i++) {
								    bottomRows.push(rows[i]);
								}
							    var bottomRowsHtml = template('preivewFileDataRowTmpl', {rows: bottomRows});
								$('#dataPreviewTbl tbody').append(bottomRowsHtml);
							}else if(rows.length > 1){
								for(var i=1; i<rows.length; i++) {
								    topRows.push(rows[i]);
								}
							    var rowsHtml = template('preivewFileDataRowTmpl', {rows: topRows});
								$('#dataPreviewTbl tbody').html(rowsHtml);
							}
						}
					}
                }
            );
        }
    });
});