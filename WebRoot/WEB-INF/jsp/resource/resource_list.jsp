<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>资源 - IDEA Testing</title>
        
        <link href='<idp:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
        <link href='<idp:url value="/css/nifty.min.css"/>' rel="stylesheet">
        
        <link href='<idp:url value="/plugins/nifty/css/nifty-demo-icons.min.css"/>' rel="stylesheet">
        
        <link href='<idp:url value="/plugins/datatables/media/css/dataTables.bootstrap.css"/>' rel="stylesheet">
        <link href='<idp:url value="/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css"/>' rel="stylesheet">
        
        <link id="theme" href='<idp:url value="/css/themes/type-a/theme-light.min.css"/>' rel="stylesheet">
        
        <script src='<idp:url value="/js/jquery-2.2.4.min.js"/>'></script>
        <script src='<idp:url value="/js/bootstrap.min.js"/>'></script>
        <script src='<idp:url value="/js/nifty.min.js"/>'></script>
    
        <!--DataTables [ OPTIONAL ]-->
        <script src='<idp:url value="/plugins/datatables/media/js/jquery.dataTables.js"/>'></script>
        <script src='<idp:url value="/plugins/datatables/media/js/dataTables.bootstrap.js"/>'></script>
        <script src='<idp:url value="/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"/>'></script>
    
        <script type="text/javascript">
            window.commonVars || (window.commonVars = {});
            commonVars.ctx = '<idp:ctx/>';
        </script>
    </head>    
    <body>
        
    
        <div id="container" class="effect aside-float aside-bright mainnav-lg">
            <%@ include file="../header.jsp"%> 
            
            <div class="boxed">
                <!--CONTENT CONTAINER-->
                <!--===================================================-->
                <div id="cls-content">
                    
                    <!--Page Title-->
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <div id="page-title">
                        <h1 class="page-header text-overflow">Dashboard</h1>
    
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
                    
                    <!--Page content-->
                    <!--===================================================-->
                    <div id="page-content">
                        
                        <div class="row">
                            <div class="tab-base">
                                <!--Nav Tabs-->
                                <ul class="nav nav-tabs">
                                    <li class="active">
                                        <a data-toggle="tab" href="#demo-lft-tab-1" aria-expanded="true">Hubs</a>
                                    </li>
                                    <li class="">
                                        <a data-toggle="tab" href="#demo-lft-tab-2" aria-expanded="false">Nodes</a>
                                    </li>
                                </ul>
                    
                                <!--Tabs Content-->
                                <div class="tab-content">
                                    <div id="demo-lft-tab-1" class="tab-pane fade active in">
                                        <div class="panel">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Hub列表</h3>
                                            </div>
                                
                                            <!--Data Table-->
                                            <!--===================================================-->
                                            <div class="panel-body">
                                                <div class="pad-btm form-inline">
                                                    <div class="row">
                                                        <div class="col-sm-6 table-toolbar-left">
                                                            <button class="btn btn-purple" onclick="IDEATESTING.resource.popAddHubModal();"><i class="demo-pli-add icon-fw"></i>新建Hub</button>
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
                                                </div>
                                                <div>
                                                    <table id="hubsTbl" class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th>名称</th>
                                                                <th>访问地址</th>
                                                                <th>端口</th>
                                                                <th>描述</th>
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
                                                <h3 class="panel-title">Order Status</h3>
                                            </div>
                                
                                            <!--Data Table-->
                                            <!--===================================================-->
                                            <div class="panel-body">
                                                <div class="pad-btm form-inline">
                                                    <div class="row">
                                                        <div class="col-sm-6 table-toolbar-left">
                                                            <button class="btn btn-purple" onclick="popAddForm"><i class="demo-pli-add icon-fw"></i>添加</button>
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
                                                </div>
                                                <div>
                                                    <table id="nodesTbl" class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th>名称</th>
                                                                <th>访问地址</th>
                                                                <th>端口</th>
                                                                <th>描述</th>
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
                    </div>
                    <!--===================================================-->
                    <!--End page content-->
                </div>  
                <!--===================================================-->
                <!--END CONTENT CONTAINER-->  
            </div>  
            
            <!-- FOOTER -->
            <!--===================================================-->
            <footer id="footer">
    
                <!-- Visible when footer positions are fixed -->
                <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
                <div class="show-fixed pull-right">
                    You have <a href="#" class="text-bold text-main"><span class="label label-danger">3</span> pending action.</a>
                </div>
    
    
    
                <!-- Visible when footer positions are static -->
                <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
                <div class="hide-fixed pull-right pad-rgt">
                    14GB of <strong>512GB</strong> Free.
                </div>
    
    
    
                <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
                <!-- Remove the class "show-fixed" and "hide-fixed" to make the content always appears. -->
                <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
    
                <p class="pad-lft">&#0169; 2016 Your Company</p>
    
    
    
            </footer>
            <!--===================================================-->
            <!-- END FOOTER -->
    
    
            <!-- SCROLL PAGE BUTTON -->
            <!--===================================================-->
            <button class="scroll-top btn">
                <i class="pci-chevron chevron-up"></i>
            </button>
            <!--===================================================--> 
        </div>
        
        <!--Default Bootstrap Modal-->
        <!--===================================================-->
        <div class="modal fade" id="hubModal" role="dialog" tabindex="-1" aria-labelledby="新建Hub" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
    
                    <!--Modal header-->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><i class="pci-cross pci-circle"></i></button>
                        <h4 id="hubModalTitle" class="modal-title">新建Hub</h4>
                    </div>
    
                    <!--Modal body-->
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="demo-is-inputsmall">名称</label>
                                <div class="col-sm-9">
                                    <input id="hubName" type="text" placeholder="Hub名称" class="form-control input-sm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="demo-is-inputsmall">访问地址</label>
                                <div class="col-sm-5">
                                    <input id="hubAddress" type="text" placeholder="网址或IP地址" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 control-label" for="demo-is-inputsmall">端口</label>
                                <div class="col-sm-2">
                                    <input id="hubPort" type="text" placeholder="端口" class="form-control input-sm">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="demo-is-inputsmall">描述</label>
                                <div class="col-sm-9">
                                    <textarea id="hubDesc" placeholder="这个Hub用途，方便查看" class="form-control" rows="4"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
    
                    <!--Modal footer-->
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                        <button class="btn btn-primary" onclick="IDEATESTING.resource.saveHub();">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!--===================================================-->
        <!--End Default Bootstrap Modal-->
        
        <script type="text/javascript" src='<idp:url value="/js/resource/ideatesting-datapool.js"/>'></script>
    </body>
</html>