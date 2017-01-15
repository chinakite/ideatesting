<%@ page language="java" pageEncoding="utf-8"%>                
                <!--MAIN NAVIGATION-->
                <!--===================================================-->
                <nav id="mainnav-container">
                    <div id="mainnav">
    
                        <!--Menu-->
                        <!--================================-->
                        <div id="mainnav-menu-wrap">
                            <div class="nano">
                                <div class="nano-content">
    
                                    <!--Profile Widget-->
                                    <!--================================-->
                                    <div id="mainnav-profile" class="mainnav-profile">
                                        <div class="profile-wrap">
                                            <div class="pad-btm">
                                                <span class="label label-success pull-right">进行中</span>
                                                <img class="img-circle img-sm img-border" src='<idp:url value="/img/sina.jpg"/>' alt="Profile Picture">
                                            </div>
                                            <a href="#profile-nav" class="box-block" data-toggle="collapse" aria-expanded="false">
                                                <p class="mnp-name">${project.name}</p>
                                                <span class="mnp-desc">${project.desc}</span>
                                            </a>
                                        </div>
                                    </div>
    
    
                                    <!--Shortcut buttons-->
                                    <!--================================-->
                                    <div id="mainnav-shortcut">
                                        <ul class="list-unstyled">
                                            <li class="col-xs-3" data-content="成员">
                                                <a class="shortcut-grid" href="#">
                                                    <i class="demo-psi-male"></i>
                                                </a>
                                            </li>
                                            <li class="col-xs-3" data-content="留言板">
                                                <a class="shortcut-grid" href="#">
                                                    <i class="demo-psi-speech-bubble-3"></i>
                                                </a>
                                            </li>
                                            <li class="col-xs-3" data-content="动态">
                                                <a class="shortcut-grid" href="#">
                                                    <i class="demo-psi-thunder"></i>
                                                </a>
                                            </li>
                                            <li class="col-xs-3" data-content="设置">
                                                <a class="shortcut-grid" href="#">
                                                    <i class="demo-psi-gear-2"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <!--================================-->
                                    <!--End shortcut buttons-->
    
    
                                    <ul id="mainnav-menu" class="list-group">
                            
                                        <!--Category name-->
                                        <li class="list-header">Navigation</li>
                            
                                        <!--Menu list item-->
                                        <li class="active-link">
                                            <a href="index.html">
                                                <i class="demo-psi-home"></i>
                                                <span class="menu-title">
                                                    <strong>Dashboard</strong>
                                                </span>
                                            </a>
                                        </li>
                                        
                                        <!--Menu list item-->
                                        <li id="menu_schema">
                                            <a href="<idp:ctx/>/project/${project.id}/schemaPage">
                                                <i class="demo-psi-tactic"></i>
                                                <span class="menu-title">
                                                    <strong>测试方案</strong>
                                                </span>
                                            </a>
                                        </li>
                                        
                                        <!--Menu list item-->
                                        <li id="menu_runcase">
                                            <a href="<idp:ctx/>/project/${project.id}/casePage">
                                                <i class="demo-psi-boot-2"></i>
                                                <span class="menu-title">
                                                    <strong>用例</strong>
                                                </span>
                                            </a>
                                        </li>
                                        
                                        <!--Menu list item-->
                                        <li id="menu_scriptlib">
                                            <a href="<idp:ctx/>/project/${project.id}/scriptPage">
                                                <i class="demo-psi-file-html"></i>
                                                <span class="menu-title">
                                                    <strong>脚本库</strong>
                                                </span>
                                            </a>
                                        </li>
                                        
                                        <!--Menu list item-->
                                        <li id="menu_datapool">
                                            <a href="<idp:ctx/>/project/${project.id}/dataPoolPage">
                                                <i class="demo-psi-receipt-4"></i>
                                                <span class="menu-title">
                                                    <strong>数据池</strong>
                                                </span>
                                            </a>
                                        </li>
                                        
                                        <!--Menu list item-->
                                        <li id="menu_report">
                                            <a href="<idp:ctx/>/project/${project.id}/reportPage">
                                                <i class="demo-psi-bar-chart"></i>
                                                <span class="menu-title">
                                                    <strong>测试报告</strong>
                                                </span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--================================-->
                        <!--End menu-->
    
                    </div>
                </nav>