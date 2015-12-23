<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<script>
	
		//初始化
		function init()
		{
			$("#uname").focus();
		}
		
		//密码验证
		function upassCheck(obj)
		{
			if(obj.value.length<6)
			{
				$("#upass_mess").innerHTML = "密码长度不能小于6！";
				$("#upass_mess").style.color = "#ff0000";
				$("#upass_mess").style.fontSize = "12px";
				return false;
			}
			else
			{
				$("#upass_mess").innerHTML = "√";
				$("#upass_mess").style.color = "#00ff00";
				$("#upass_mess").style.fontSize = "12px";
				return true;
			}
		}
		
		//确认密码
		function reupassCheck(obj)
		{
			var up = document.getElementById("upass").value;
			
			if(obj.value.length==0)
			{
				//obj.parentNode.innerHTML += "<span style='color:#ff0000'>111111111</span>";
				$("#uapss1_mess").innerHTML = "确认密码不能为空！";
				$("#uapss1_mess").style.color = "#ff0000";
				$("#uapss1_mess").style.fontSize = "12px";
				return false;
			}
			else if(obj.value!=up)
			{
				$("#uapss1_mess").innerHTML = "两次密码不一致";
				$("#uapss1_mess").style.color = "#ff0000";
				$("#upass1_mess").style.fontSize = "12px";
			}
			else
			{
				$("#uapss1_mess").innerHTML = "√";
				$("#uapss1_mess").style.color = "#00ff00";
				$("#upass1_mess").style.fontSize = "12px";	
			}
			
		}
		
		
		fuction checkpass()
		{
			var pass1 = document.getElementById("pass1").value;
			var pass2 = document.getElementById("pass2").value;
			if(pass1!=pass2)
			{
				alter("两次密码不相同！")
			}
		}
		
		var $ = function(id) {return document.getElementById(id.substring(1,id.length));};

	
	</script>
</head>

<body>
	

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">已有账号：<a style="color:red" href="login.jsp">去登录</a></h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="toadmin!registerAdmin" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="姓名（必填）" name="adminname" type="name" >
                                </div>
                                <div class="form-group">
                                    <span id="upass_mess"></span>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="pass1"  placeholder="密码（必填）" name="adminpass" type="password">
                                </div>
                                 <div class="form-group">
                                    <span id="upass_mess"></span>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="pass2" placeholder="确认密码（必填）" name="adminpass1" type="password">
                                </div>
                                 <div class="form-group">
                                    <span id="upass_mess"></span>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="pass1" placeholder="身份证号（必填）" name="idcard" type="text" value="" " >
                                </div>
                               
                                <div class="form-group">
                                    <input class="form-control" id="pass2" placeholder="确认身份证号（必填）" name="idcard1" type="text" value="" >
                                </div>
                                 <div class="form-group">
                                    <input class="form-control" id="pass2" placeholder="药房名称（选填）" name="whname" type="text" value=""  >
                                </div>
                                <div class="form-group">
                                   <span id="upass1_mess" style="color:red">${message}</span>
                                </div>
                              	<input type="submit" class="btn btn-lg btn-success btn-block" value="注册" /> 
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
