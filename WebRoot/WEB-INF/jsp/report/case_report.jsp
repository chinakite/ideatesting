<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../include.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>测试报告</title>

    <link href='<idp:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
    <link href='<idp:url value="/css/nifty.min.css"/>' rel="stylesheet">

    <link href='<idp:url value="/plugins/nifty/css/nifty-demo-icons.min.css"/>' rel="stylesheet">

    <link id="theme" href='<idp:url value="/css/themes/type-a/theme-light.min.css"/>' rel="stylesheet">

    <link href='<idp:url value="/plugins/datatables/media/css/dataTables.bootstrap.css"/>' rel="stylesheet">
    <link href='<idp:url value="/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css"/>' rel="stylesheet">

    <link href='<idp:url value="/css/ideatesting.css"/>' rel="stylesheet">

    <script src='<idp:url value="/js/jquery-2.2.4.min.js"/>'></script>
    <script src='<idp:url value="/js/bootstrap.min.js"/>'></script>
    <script src='<idp:url value="/js/nifty.min.js"/>'></script>

    <!--DataTables [ OPTIONAL ]-->
    <script src='<idp:url value="/plugins/datatables/media/js/jquery.dataTables.js"/>'></script>
    <script src='<idp:url value="/plugins/datatables/media/js/dataTables.bootstrap.js"/>'></script>
    <script src='<idp:url value="/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"/>'></script>

    <script type="text/javascript">
        window.commonVars || (window.commonVars = {});
        window.reportPageVars || (window.reportPageVars = {});
        commonVars.ctx = '<idp:ctx/>';
        reportPageVars.projectId = '${project.id}';
	    reportPageVars.schemaExecutionId = '${schemaExecution.id}';
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
                <h1 class="page-header text-overflow">测试报告</h1>

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
                <li class="active"><a href="#">测试报告</a></li>
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
                        <table id="caseResultTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>用例名称</th>
                                <th>所属脚本</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>执行人</th>
                                <th>状态</th>
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
<div class="modal fade" id="commandResultModal" role="dialog" tabindex="-1" aria-labelledby="新建Hub" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <!--Modal header-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><i class="pci-cross pci-circle"></i></button>
                <h4 id="hubModalTitle" class="modal-title">用例详情</h4>
            </div>

            <!--Modal body-->
            <div class="modal-body">
                <table id="commandResultTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>Command</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>备注</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>

            <!--Modal footer-->
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--===================================================-->
<!--End Default Bootstrap Modal-->

<script type="text/javascript" src='<idp:url value="/js/report/ideatesting-report.js"/>'></script>
</body>
</html>