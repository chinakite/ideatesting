<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>测试方案</title>
        
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
            window.schemaPageVars || (window.schemaPageVars = {});
            commonVars.ctx = '<idp:ctx/>';
            schemaPageVars.projectId = '${project.id}';
            
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
                        <h1 class="page-header text-overflow">测试方案</h1>
    
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
                        <li class="active"><a href="#">测试方案</a></li>
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
                                        <button class="btn btn-purple" onclick="IDEATESTING.schema.popAddSchemaModal();"><i class="demo-pli-add icon-fw"></i>新建方案</button>
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

                                <table id="schemaTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>名称</th>
                                            <th>描述</th>
                                            <th>运行方式</th>
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
        <div class="modal fade" id="schemaModal" role="dialog" tabindex="-1" aria-labelledby="新建方案" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!--Modal header-->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><i class="pci-cross pci-circle"></i></button>
                        <h4 id="hubModalTitle" class="modal-title">新建方案</h4>
                    </div>

                    <!--Modal body-->
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div id="addSchemaStep1">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="demo-is-inputsmall">名称</label>
                                    <div class="col-sm-9">
                                        <input id="schemaName" type="text" placeholder="方案名称" class="form-control input-sm">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="demo-is-inputsmall">描述</label>
                                    <div class="col-sm-9">
                                        <textarea id="schemaDesc" placeholder="这个方案的简述，方便查看" class="form-control" rows="4"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div id="addSchemaStep2" style="display: none;">
                                <table id="scriptTbl" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>文件名</th>
                                        <th>版本</th>
                                        <th>上传人</th>
                                        <th>上传时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                            <div id="addSchemaStep3">
                                <table id="hubsTbl" class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>名称</th>
                                        <th>访问地址</th>
                                        <th>端口</th>
                                        <th>创建人</th>
                                        <th>创建时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                            <div id="addSchemaStep4">
                                <table id="nodesTbl" class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>名称</th>
                                        <th>访问地址</th>
                                        <th>端口</th>
                                        <th>创建人</th>
                                        <th>创建时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div id="addSchemaStep5">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="demo-is-inputsmall">执行方式</label>
                                    <div class="col-sm-9">
                                        <div class="radio">
                                            <input id="manualRunRadio" class="magic-radio" type="radio" name="runSchemaType" checked>
                                            <label for="manualRunRadio">手动执行</label>
                                        </div>
                                        <div class="radio">
                                            <input id="autoRunRadio" class="magic-radio" type="radio" name="runSchemaType" checked>
                                            <label for="autoRunRadio">自动执行</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                    <!--Modal footer-->
                    <div class="modal-footer">
                        <button id="addSchemaCancelBtn" data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                        <button id="addSchemaPrevStepBtn" class="btn btn-primary" onclick="IDEATESTING.schema.addSchemaPrevStep();" disabled>上一步</button>
                        <button id="addSchemaNextStepBtn" class="btn btn-primary" onclick="IDEATESTING.schema.addSchemaNextStep();">下一步</button>
                        <button id="addSchemaSaveBtn" class="btn btn-primary" onclick="IDEATESTING.schema.saveSchema();" disabled>保存</button>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src='<idp:url value="/js/schema/ideatesting-schema.js"/>'></script>
    </body>
</html>