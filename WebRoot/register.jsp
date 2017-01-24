<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册 | IDEATESTING</title>


    <!--STYLESHEET-->
    <!--=================================================-->

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
    <link href='<idp:url value="/css/bootstrap.min.css"/>' rel="stylesheet">


    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href='<idp:url value="/css/nifty.min.css"/>' rel="stylesheet">


    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
    <link href='<idp:url value="/plugins/nifty/css/nifty-demo-icons.min.css"/>' rel="stylesheet">


        
    <!--Demo [ DEMONSTRATION ]-->
    <link href='<idp:url value="/plugins/nifty/css/nifty-demo.min.css"/>' rel="stylesheet">


    <!--Magic Checkbox [ OPTIONAL ]-->
    <link href='<idp:url value="/plugins/magic-check/css/magic-check.min.css"/>' rel="stylesheet">





    
    <!--JAVASCRIPT-->
    <!--=================================================-->

    <!--Pace - Page Load Progress Par [OPTIONAL]-->
    <link href='<idp:url value="/plugins/pace/pace.min.css"/>' rel="stylesheet">
    <script src='<idp:url value="/plugins/pace/pace.min.js"/>'></script>


    <!--jQuery [ REQUIRED ]-->
    <script src='<idp:url value="/js/jquery-2.2.4.min.js"/>'></script>


    <!--BootstrapJS [ RECOMMENDED ]-->
    <script src='<idp:url value="/js/bootstrap.min.js"/>'></script>


    <!--NiftyJS [ RECOMMENDED ]-->
    <script src='<idp:url value="/js/nifty.min.js"/>'></script>






    <!--=================================================-->
    
    <!--Background Image [ DEMONSTRATION ]-->
    <script src='<idp:url value="/plugins/nifty/js/bg-images.js"/>'></script>

</head>

<!--TIPS-->
<!--You may remove all ID or Class names which contain "demo-", they are only used for demonstration. -->

<body>
	<div id="container" class="cls-container">
		
		
		<!-- BACKGROUND IMAGE -->
		<!--===================================================-->
		<div id="bg-overlay"></div>
		
		
		<!-- REGISTRATION FORM -->
		<!--===================================================-->
		<div class="cls-content">
		    <div class="cls-content-lg panel">
		        <div class="panel-body">
		            <div class="mar-ver pad-btm">
		                <h3 class="h4 mar-no">Create a New Account</h3>
		                <p class="text-muted">Come join the Nifty community! Let's set up your account.</p>
		            </div>
		            <form action="pages-login.html">
		                <div class="row">
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <input type="text" class="form-control" placeholder="Full name" name="name">
		                        </div>
		                        <div class="form-group">
		                            <input type="text" class="form-control" placeholder="邮箱" name="email">
		                        </div>
		                    </div>
		                    <div class="col-sm-6">
		                        <div class="form-group">
		                            <input type="text" class="form-control" placeholder="用户名" name="username">
		                        </div>
		                        <div class="form-group">
		                            <input type="password" class="form-control" placeholder="密码" name="password">
		                        </div>
		                    </div>
		                </div>
		                <div class="checkbox pad-btm text-left">
		                    <input id="demo-form-checkbox" class="magic-checkbox" type="checkbox">
		                    <label for="demo-form-checkbox">我同意遵守 <a href="#" class="btn-link">《用户协议》、《隐私政策》及《Cookie 政策》。</a></label>
		                </div>
		                <button class="btn btn-primary btn-block" type="submit">注&nbsp;&nbsp;册</button>
		            </form>
		        </div>
		        <div class="pad-all">
		            已有账号 ? <a href='<idp:url value="/login"/>' class="btn-link mar-rgt">前往登录</a>
		
		            <div class="media pad-top bord-top">
		                <div class="pull-right">
		                    <a href="#" class="pad-rgt"><i class="demo-psi-facebook icon-lg text-primary"></i></a>
		                    <a href="#" class="pad-rgt"><i class="demo-psi-twitter icon-lg text-info"></i></a>
		                    <a href="#" class="pad-rgt"><i class="demo-psi-google-plus icon-lg text-danger"></i></a>
		                </div>
		                <div class="media-body text-left text-muted">
		                    使用其他账号注册
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		<!--===================================================-->
		
		
		<!-- DEMO PURPOSE ONLY -->
		<!--===================================================-->
		<div class="demo-bg">
		    <div id="demo-bg-list">
		        <div class="demo-loading"><i class="psi-repeat-2"></i></div>
		        <img class="demo-chg-bg bg-trans active" src="img/bg-img/thumbs/bg-trns.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-1.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-2.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-3.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-4.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-5.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-6.jpg" alt="Background Image">
		        <img class="demo-chg-bg" src="img/bg-img/thumbs/bg-img-7.jpg" alt="Background Image">
		    </div>
		</div>
		<!--===================================================-->
		
		
		
	</div>
	<!--===================================================-->
	<!-- END OF CONTAINER -->


		</body>
</html>