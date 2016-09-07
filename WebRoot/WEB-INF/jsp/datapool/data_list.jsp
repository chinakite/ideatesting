<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../include.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>数据池</title>

    <link href='<idp:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
    <link href='<idp:url value="/css/nifty.min.css"/>' rel="stylesheet">

    <link href='<idp:url value="/plugins/nifty/css/nifty-demo-icons.min.css"/>' rel="stylesheet">

    <link id="theme" href='<idp:url value="/css/themes/type-a/theme-light.min.css"/>' rel="stylesheet">

    <link href='<idp:url value="/plugins/datatables/media/css/dataTables.bootstrap.css"/>' rel="stylesheet">
    <link href='<idp:url value="/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css"/>' rel="stylesheet">
    <link href='<idp:url value="/plugins/bootstrap-select/bootstrap-select.min.css"/>' rel="stylesheet">

    <link href='<idp:url value="/css/ideatesting.css"/>' rel="stylesheet">

    <script src='<idp:url value="/js/jquery-2.2.4.min.js"/>'></script>
    <script src='<idp:url value="/js/bootstrap.min.js"/>'></script>
    <script src='<idp:url value="/js/nifty.min.js"/>'></script>

    <!--DataTables [ OPTIONAL ]-->
    <script src='<idp:url value="/plugins/datatables/media/js/jquery.dataTables.js"/>'></script>
    <script src='<idp:url value="/plugins/datatables/media/js/dataTables.bootstrap.js"/>'></script>
    <script src='<idp:url value="/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"/>'></script>

    <!-- Bootstrap select -->
    <script src='<idp:url value="/plugins/bootstrap-select/bootstrap-select.min.js"/>'></script>

    <script src='<idp:url value="/plugins/fileupload/jquery.ui.widget.js"/>'></script>
    <script src='<idp:url value="/plugins/fileupload/jquery.fileupload.js"/>'></script>
    <script src='<idp:url value="/plugins/fileupload/jquery.iframe-transport.js"/>'></script>

    <script src='<idp:url value="/js/template.js"/>'></script>

    <script type="text/javascript">
        window.commonVars || (window.commonVars = {});
        window.dataPoolPageVars || (window.dataPoolPageVars = {});
        commonVars.ctx = '<idp:ctx/>';
        dataPoolPageVars.projectId = '${project.id}';

    </script>
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">
    <%@ include file="../header.jsp"%>

    <div class="boxed">
        <!--CONTENT CONTAINER-->
        <!--===================================================-->
        <div id="content-container">

            <!--Page Title-->
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <div id="page-title">
                <h1 class="page-header text-overflow">数据池</h1>

                <!--Searchbox-->
                <div class="searchbox">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search..">
                                <span class="input-group-btn">
                                    <button class="text-muted" type="button"><i class="demo-pli-magnifi-glass"></i></button>
                                </span>
                    </div>
                </div>
            </div>
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <!--End page title-->

            <!--Breadcrumb-->
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <ol class="breadcrumb">
                <li><a href="#">${project.name}</a></li>
                <li class="active"><a href="#">数据池</a></li>
            </ol>
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <!--End breadcrumb-->

            <!--Page content-->
            <!--===================================================-->
            <div id="page-content">

                <!-- Basic Data Tables -->
                <!--===================================================-->
                <div class="panel">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-6 table-toolbar-left">
                                <button class="btn btn-purple" onclick="IDEATESTING.datapool.popAddParamModal();"><i class="demo-pli-add icon-fw"></i>新建数据</button>
                                <button class="btn btn-default"><i class="demo-pli-printer"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default"><i class="demo-pli-information"></i></button>
                                    <button class="btn btn-default"><i class="demo-pli-recycling"></i></button>
                                </div>
                            </div>
                            <div class="col-sm-6 table-toolbar-right">
                                <div class="form-group">
                                    <input type="text" autocomplete="off" class="form-control" placeholder="Search" id="demo-input-search2">
                                </div>
                                <div class="btn-group">
                                    <button class="btn btn-default"><i class="demo-pli-download-from-cloud"></i></button>
                                    <div class="btn-group">
                                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <i class="demo-pli-gear"></i>
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <table id="dataTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th></th>
                                <th>数据名称</th>
                                <th>数据标识</th>
                                <th>类型</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--===================================================-->
                <!-- End Striped Table -->


            </div>
            <!--===================================================-->
            <!--End page content-->
        </div>
        <!--===================================================-->
        <!--END CONTENT CONTAINER-->

        <%@ include file="../project_side.jsp"%>
    </div>

    <%@ include file="../footer.jsp"%>

    <!--===================================================-->
    <!-- END FOOTER -->

    <%@ include file="../scrollTopBtn.jsp"%>
</div>
<!--Default Bootstrap Modal-->
<!--===================================================-->
<div class="modal fade" id="paramModal" role="dialog" tabindex="-1" aria-labelledby="新建数据" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!--Modal header-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><i class="pci-cross pci-circle"></i></button>
                <h4 id="hubModalTitle" class="modal-title">新建数据</h4>
            </div>

            <!--Modal body-->
            <div class="modal-body">
                <form class="form-horizontal">
                    <div id="addParamStep1">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="name">名称</label>
                            <div class="col-sm-9">
                                <input id="name" type="text" placeholder="数据名称" class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="varName">变量名称</label>
                            <div class="col-sm-9">
                                <input id="varName" type="text" placeholder="变量名称，项目内唯一，脚本中使用" class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="type">数据类型</label>
                            <div class="col-sm-9 bootstrap-select">
                                <select id="type" name="type" class="selectPicker">
                                    <option value="0">固定值</option>
                                    <option value="1">数据列表（单列）</option>
                                    <option value="2">数据表格（多列）</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="desc">描述</label>
                            <div class="col-sm-9">
                                <textarea id="desc" placeholder="这个数据的简述，方便查看" class="form-control" rows="4"></textarea>
                            </div>
                        </div>
                    </div>
                    <div id="addParamStep2" style="display: none;">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="fileType">文件类型</label>
                            <div class="col-sm-9 bootstrap-select">
                                <select id="fileType" name="fileType" class="selectPicker">
                                    <option value="0">xlsx</option>
                                    <option value="1">xls</option>
                                    <option value="2">txt</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="importFile">数据文件</label>
                            <div class="col-sm-9">
                                <input id="importFile" name="importFile" type="file" class="form-control input-sm"/>
                                <input id="importFileServerUrl" type="hidden"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="importFile">数据预览</label>
                            <div class="col-sm-9">
                            	<div class="bootstrap-select">
	                                <select id="sheetNames" name="sheetNames" class="selectPicker">

	                                </select>
	                            </div>
	                            <table id="dataPreviewTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
									<thead>
										
									</thead>
									<tbody>
									
									</tbody>
		                        </table>
                            </div>
                        </div>
                    </div>
                 </form>
            </div>

            <!--Modal footer-->
            <div class="modal-footer">
                <button id="addParamCancelBtn" data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button id="addParamPrevStepBtn" class="btn btn-primary" onclick="IDEATESTING.datapool.addParamPrevStep();" disabled>上一步</button>
                <button id="addParamNextStepBtn" class="btn btn-primary" onclick="IDEATESTING.datapool.addParamNextStep();">下一步</button>
                <button id="addParamSaveBtn" class="btn btn-primary" onclick="IDEATESTING.datapool.saveParam();" disabled>保存</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src='<idp:url value="/js/datapool/ideatesting-datapool.js"/>'></script>

<script id="sheetSelectorTmpl" type="text/html">
    {{each sheets as sheet i}}
        <option value="{{i}}">{{sheet.name}}</option>
    {{/each}}
</script>

<script id="preivewFileHeaderTmpl" type="text/html">
    <tr>
        {{each cells as cell}}
            <th>{{cell.value}}</th>
        {{/each}}
    </tr>
</script>

<script id="preivewFileDataRowTmpl" type="text/html">
    {{each rows as row}}
        <tr>
            {{each row.cells as cell}}
                <td>{{cell.value}}</td>
            {{/each}}
        </tr>
    {{/each}}
</script>

<script id="preivewFileCollapsedRowTmpl" type="text/html">
    <tr>
        <td colspan="{{columnCount}}" align="center">. . .</td>
    </tr>
</script>

</body>
</html>