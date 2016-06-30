<%@ page language="java" pageEncoding="utf-8"%>            
            <!--NAVBAR-->
            <!--===================================================-->
            <header id="navbar">
                <div id="navbar-container" class="boxed">
                    <!--Brand logo & name-->
                    <!--================================-->
                    <div class="navbar-header">
                        <a href="index.html" class="navbar-brand">
                            <img src='<idp:url value="/img/logo.png"/>' alt="IDEA Testing" class="brand-icon">
                            <div class="brand-title">
                                <span class="brand-text">IDEA TESTING</span>
                            </div>
                        </a>
                    </div>
                    <!--================================-->
                    <!--End brand logo & name-->
                    
                    <!--Navbar Dropdown-->
                    <!--================================-->
                    <div class="navbar-content clearfix">
                        <ul class="nav navbar-top-links pull-right">

                            <!--User dropdown-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <li id="dropdown-user" class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                                    <span class="pull-right">
                                        <!--<img class="img-circle img-user media-object" src="img/profile-photos/1.png" alt="Profile Picture">-->
                                        <i class="demo-pli-male ic-user"></i>
                                    </span>
                                    <div class="username hidden-xs">Aaron Chavez</div>
                                </a>
    
    
                                <div class="dropdown-menu dropdown-menu-md dropdown-menu-right panel-default">
    
                                    <!-- Dropdown heading  -->
                                    <div class="pad-all bord-btm">
                                        <p class="text-main mar-btm"><span class="text-bold">750GB</span> of 1,000GB Used</p>
                                        <div class="progress progress-sm">
                                            <div class="progress-bar" style="width: 70%;">
                                                <span class="sr-only">70%</span>
                                            </div>
                                        </div>
                                    </div>
    
    
                                    <!-- User dropdown menu -->
                                    <ul class="head-list">
                                        <li>
                                            <a href="#">
                                                <i class="demo-pli-male icon-lg icon-fw"></i> Profile
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="badge badge-danger pull-right">9</span>
                                                <i class="demo-pli-mail icon-lg icon-fw"></i> Messages
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="label label-success pull-right">New</span>
                                                <i class="demo-pli-gear icon-lg icon-fw"></i> Settings
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="demo-pli-information icon-lg icon-fw"></i> Help
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="demo-pli-computer-secure icon-lg icon-fw"></i> Lock screen
                                            </a>
                                        </li>
                                    </ul>
    
                                    <!-- Dropdown footer -->
                                    <div class="pad-all text-right">
                                        <a href="pages-login.html" class="btn btn-primary">
                                            <i class="demo-pli-unlock"></i> Logout
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End user dropdown-->
                        </ul>    
                    </div>
                </div>
            </header> 