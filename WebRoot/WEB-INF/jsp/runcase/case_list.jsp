<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        
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
            window.runcasePageVars || (window.runcasePageVars = {});
            commonVars.ctx = '<idp:ctx/>';
            runcasePageVars.projectId = '${project.id}';
            
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
                        <h1 class="page-header text-overflow">用例</h1>
    
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
                        <li class="active"><a href="#">用例</a></li>
                    </ol>
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <!--End breadcrumb-->
                    
                    <!--Page content-->
                    <!--===================================================-->
                    <div id="page-content">
                        <div class="tab-base">
                            <!--Nav Tabs-->
                            <ul class="nav nav-tabs">
                                <li class="active">
                                    <a data-toggle="tab" href="#demo-lft-tab-1" aria-expanded="true">用例</a>
                                </li>
                                <li class="">
                                    <a data-toggle="tab" href="#demo-lft-tab-2" aria-expanded="false">用例组</a>
                                </li>
                            </ul>
                
                            <!--Tabs Content-->
                            <div class="tab-content">
                                <div id="demo-lft-tab-1" class="tab-pane fade active in">
                                    <div class="panel">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">用例列表</h3>
                                        </div>
                            
                                        <!--Data Table-->
                                        <!--===================================================-->
                                        <div class="panel-body">
                                            <div>
                                                <table id="caseTbl" class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th></th>
                                                            <th>名称</th>
                                                            <th>所属脚本</th>
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
                                        <!--End Data Table-->
                            
                                    </div>
                                </div>
                                <div id="demo-lft-tab-2" class="tab-pane fade">
                                    <div class="panel">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">用例组列表</h3>
                                        </div>
                            
                                        <!--Data Table-->
                                        <!--===================================================-->
                                        <div class="panel-body">
                                            <div>
                                                <table id="caseGroupTbl" class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th></th>
                                                            <th>名称</th>
                                                            <th>所属脚本</th>
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
                                        <!--End Data Table-->
                            
                                    </div>
                                </div>
                            </div>
                        </div>
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
        
        <script type="text/javascript" src='<idp:url value="/js/runcase/ideatesting-runcase.js"/>'></script>
    </body>
</html>