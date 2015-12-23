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

    <title>91健康商城后台管理系统 - JIUYI Admin <s:property value="verno"/></title>

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
<script type="text/javascript">
//订单编号搜索
	function selectno()
	{
		alter("ddd");
		var ordsta = document.getElementById("selectord").value;
		document.getElementById("selectord").href="ordermanager!selectOrderNoDeliv?orderStatus="+ordsta;
	}

//判断浏览器
	function selectBrowser()
	{
		if(navigator.appName=="Microsoft Internet Explorer"&&parseFloat(navigator.appVersion)>=1)
		{
			return 1;//IE
		}
		else if(navigator.appName=="Netscape"&&parseFloat(navigator.appVersion)>=5)
		{
			return 2;//火狐
		}
		else
		{
			return -1;
		}
	}
var i=1;
//显示图片
function showImage1(obj)
	{
		if(obj.name=="first"){
			var img1=document.getElementById("img1");
			switch(selectBrowser())
			{
				case 2:
					img1.src = window.URL.createObjectURL(obj.files[0]);
					break;
				case 1:
					img1.src = obj.value;
					break;
				default:
					alert("浏览器不兼容！");
			}
			img.style.display = "inline";
		}
		if(obj.name=="second"){
			var img2=document.getElementById("img2");
			switch(selectBrowser())
			{
				case 2:
					img2.src = window.URL.createObjectURL(obj.files[0]);
					break;
				case 1:
					img2.src = obj.value;
					break;
				default:
					alert("浏览器不兼容！");
			}
			img.style.display = "inline";
		}
		if(obj.name=="third"){
			var img3=document.getElementById("img3");
			switch(selectBrowser())
			{
				case 2:
					img3.src = window.URL.createObjectURL(obj.files[0]);
					break;
				case 1:
					img3.src = obj.value;
					break;
				default:
					alert("浏览器不兼容！");
			}
			img.style.display = "inline";
		}
		
		
		
	}
//删除图片
function deleteFile(obj)
	{
		//obj.parentNode.parentNode.removeChild(obj.parentNode);
		document.getElementById("img1").src=null;
		document.getElementById("img2").src=null;
		document.getElementById("img3").src=null;
	}
function returndeliveway(obj)
{
	var diliveway = getdelivalue();
	var uid = getUidvalue();
	
	window.location.href="enterdeok?delivway="+diliveway+"&orderid="+obj+"&uid="+uid;
}

function getdelivalue()
{
	var value = document.getElementById("delivway").value;
	return value;
}

function getUidvalue()
{
	var value = document.getElementById("uid").value;
	return value;
}

function go(obj)
{
	var num = getnum();
	//window.location.href="orders?upordown=go&way="+obj+"&num="+num;
	//window.location.href="enterdeok?delivway="+1+"&orderid="+1;
}

function getnum()
{
	var num = document.getElementById("pagenum").value;
	return num;
}

</script>
<script language="javascript" src="../js/sort.js"></script>
</head>


<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <a class="navbar-brand" href="index.jsp">791大药房<s:property value="verno"/></a>

                <div style="width: 500px; margin-top: 15px;">
                <%
            	if(session.getAttribute("admin")!=null){
            	 %>
           		<b style="color: #F00;font-size:14px;"><s:property value="#session.admin.admin_name"/></b>&nbsp;&nbsp;
            	您好！欢迎来到791大药房后台管理！<a href="toadmin!logoutAdmin">[注销]</a>
            	<%
            		}else{
            	 %>
            	您好，欢迎来到791大药房后台管理！<a href="login.jsp">[登录]</a>&nbsp;<a href="register.jsp">[注册]</a>
           		<%
           			}
           		 %>
                </div>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li class="active">
                            <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> 商城状态</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-hand-o-right fa-fw"></i> 产品管理 <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="toaddprod!haveVerno">发布产品</a>
                                </li>
                                <li>
                                    <a href="product-modify.html">修改产品</a>
                                </li>
                                <li>
                                    <a href="product-showcase.html">橱窗推荐</a>
                                </li>
                                <li>
                                    <a href="product-picbank.html">图片银行</a>
                                </li>
                                <li>
                                    <a href="product-group">产品分组</a>
                                </li>
                                <li>
                                    <a href="product-bin">回收站</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-th-list fa-fw"></i> 交易管理 <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li class="active">
                                    <a href="toorders!haveVerno">所有订单</a>
                                </li>
                                <li>
                                    <a href="trade-refund.html">退款/纠纷</a>
                                </li>
                                <li>
                                    <a href="trade-output.html">批量导出</a>
                                </li>
                                <li>
                                    <a href="trade-comments.html">交易评价</a>
                                </li>
                                <li>
                                    <a href="trade-address.html">退货地址</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope-o fa-fw"></i> 站内信件 <span class="fa arrow"></span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bullhorn fa-fw"></i> 营销中心<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="promotion-mall.html">商城活动</a>
                                </li>
                                <li>
                                    <a href="promotion-group.html">营销分组</a>
                                </li>
                                <li>
                                    <a href="promotion-customers.html">历史客户</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 数据纵横<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="data-realtime.html">实时风暴</a>
                                </li>
                                <li>
                                    <a href="data-statistics.html">商城概况</a>
                                </li>
                                <li>
                                    <a href="data-search.html">搜索词分析</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blank.jsp">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.jsp">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
     
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <a href="altermess"><h1 class="page-header">订单更新</h1></a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->

                <div class="row">
				
                    <div class="col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="form-group"  style="margin-top:0px; margin-bottom:0px;">
                                    <div class="row">
                                        <%--<div class="col-lg-2">
                                            <p>特别关注：</p>
                                        </div>
                                        <div class="col-lg-10" style="color:#06C">
                                            <p>今日新订单(<span  style="color:#F00">8</span>)</p>
                                        </div>
                                    --%></div>
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <p>等待您操作的订单：</p>
                                        </div>
                                        <div class="col-lg-10" style="color:#06C">
                                           <a href="ordermanager" ><p>等待您发货(<span  style="color:#F00"><s:property value="nodelivnum"/></span>)</a> &nbsp &nbsp
                                              <%--<a href="#">  买家申请取消订单(<span  style="color:#F00">0</span>) </a>&nbsp &nbsp
                                               <a href="#"> 有纠纷的订单(<span  style="color:#F00">0</span>)</a> &nbsp &nbsp
                                              <a href="#">  未读留言(<span  style="color:#F00">0</span>)</a></p>
                                        --%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <p>等待买家操作的订单：</p>
                                        </div>
                                        <div class="col-lg-10" style="color:#06C">
                                          <a href="ordernopay">  <p>等待买家付款(<span  style="color:#F00"><s:property value="nopaynum"/></span>)</a> &nbsp &nbsp
                                            <a href="ordernoenter">     等待买家确认收货(<span  style="color:#F00"><s:property value="recivenum"/></span>)</a> </p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <p>已经发货订单：</p>
                                        </div>
                                        <div class="col-lg-10" style="color:#06C">
                                          <a href="alreadydeliv">  
                                          	已发货订单(<span  style="color:#F00"><s:property value="alreadyoknum"/></span>)</a> &nbsp &nbsp
                                           </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="margin-top:0px; margin-bottom:5px;">
                        	
                            <div class="row" style="margin-top:0px; margin-bottom:4px;"><%--

                                <label  class="col-sm-1 control-label">订单编号</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="orderNumber" name="ordno">
                                </div>
                                <div class="col-sm-1">
                                	<span class="input-group-btn">
                                        <a href="" class="btn btn-default" onclick="selectno()">确认 </a>
                                    </span>
                                </div>
                                
                                
                                <label  class="col-sm-1 control-label">运单号</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="shipNumber" name="delivno">
                                </div>
                                <div class="col-sm-1">
                                	<span class="input-group-btn">
                                       <a href="" class="btn btn-default" onclick="selectno()">确认 </a>      
                                    </span>
                                </div>
                                
                                --%><%--
                               
                                <label  class="col-sm-1 control-label">订单状态</label>
                                <div class="col-sm-2">
                                    <select class="form-control" id="selectord" name="orderStatus">
                                        <option value="allorder">全部订单</option>
                                        <option value="买家未付款">买家未付款</option>
                                        <option value="nodeliv">未发货订单</option>
                                        <option value="norecive">等待买家收货</option>
                                        <option value="end">已结束的订单</option>
                                    </select>
                                </div>
                                <div class="col-sm-1">
                                	<span class="input-group-btn">                  
                                    
                                       <button style="width:80px;" type="submit" class="btn btn-danger">提交</button>       
                                    </span>
                                </div>

                                --%><%--
                                <div class="col-sm-2">
                                    <input style="width:190px;" type="submit" class="btn btn-danger"  id="search" value="搜索" />
                                </div>
                                
                            --%>
                            </div>                                              
                        </div>

                        
                        
                        
                        <nav>
                            <ul class="pager">
                                <div class="col-lg-6">
                                </div>
                                <div class="col-lg-14">
                                    <nav>
                                        <ul class="pager">
                                        	<li>您当前正在操作：★<span style="color:red;"><s:property value="way"/></span>★</li>
                                        	<li>当前第【<span style="color:red;"><s:property value="pageindex"/></span>】页</li>
                                            <li><a href="orders?pageindex=<s:property value="pageindex"/>&way=<s:property value="way"/>&upordown=up"/>前一页</a></li>
                                            
                                            <li><a href="orders?pageindex=<s:property value="pageindex"/>&way=<s:property value="way"/>&upordown=down">后一页</a></li>
                                            <li>总页数：【<span style="color:red;"><s:property value="size"/></span>】</li>
                                            <%--<li>跳转到第<input type="text" name="num" id="pagenum" value="" onblur="getnum()" /> <input class="btn btn-default" type="button" onclick="go(<s:property value="way"/>)"  value="GO!"></li>
                                        --%></ul>
                                    </nav>
                                </div>
                            </ul>
                        </nav>
                        
						
		
                         <div class="form-group" style="margin-top:0px; margin-bottom:0px;">
                         <s:iterator value="orders" >
                         
                            <div class="panel panel-default">
                                <div class="panel-heading">
						                                    订单号：<s:property value="order_no"/> &nbsp &nbsp
						                                    下单时间：<s:property value="order_time"/> &nbsp &nbsp
						                                    买家：<s:property value="customer.user_tel"/> &nbsp &nbsp
						                                    送货地址：<span  style="color:#F00"><s:property value="address.addr_provence"/>--
						                                    			<s:property value="address.addr_city"/>--
						                                    			<s:property value="address.addr_country"/>--
						                                    			<s:property value="address.addr_stree"/>--
						                                    			邮编：<s:property value="address.addr_mail"/>--
						                                    			电话：<s:property value="address.phone"/>--
						                                    			<s:property value="address.person_name"/>(收)
						                                    			</span>
                                </div>
                                <div class="panel-body">
                                    <div class="col-lg-10" style="border-right:#CCC solid thin; margin-top:-15px; margin-bottom:-15px">
                                        <table class="table" style="margin-left:-7px; text-align:center; margin-top:10px;margin-bottom:10px; font-size:12px">
                                        	<tr style="background-color:#ECECEC; font-weight:bold; font-size:14px">
                                            	<td class="col-lg-2">图片</td>
                                            	<td class="col-lg-3">名称</td>
                                            	<td class="col-lg-1">数量</td>
                                            	<td class="col-lg-1">支付方式</td>
                                            	<td class="col-lg-1">是否需要发票</td>
                                                <td class="col-lg-1">送货时间</td>
                                                <td class="col-lg-2">发票抬头</td>
                                            	<td class="col-lg-1">发货状态</td>
                                            </tr>
                                            <tr>
                                            	<td class="col-lg-2"><img height="150px" width="150px" src="../../images/<s:property value="products.img.img1_src"/>"></td>
                                            	<td class="col-lg-3" style="padding-top:60px;"><s:property value="products.prod_name"/></td>
                                            	<td class="col-lg-1" style="padding-top:60px;"><s:property value="buy_count"/></td>
                                            	<td class="col-lg-1" style="padding-top:60px;color: red"><s:property value="pay_way"/></td>
                                            	<td class="col-lg-1" style="padding-top:60px;"><s:property value="invoice_no"/></td>
                                                <td class="col-lg-1" style="padding-top:60px;"><s:property value="song_day"/></td>
                                                <td class="col-lg-2" style="padding-top:60px;">无</td>
                                            	<td class="col-lg-1" style="padding-top:60px;color: red"><s:property value="order_status"/></td>
                                            </tr>
                                        </table>
                                    </div>
                                    
                                    
                                    <div class="col-lg-2" >
                                    	<label class="row" style="padding-left:10px">请选择快递方式</label>
                                    	<%--<form action="enterdeok" method="post" enctype="multipart/form-data">
                                        --%><div class="form-group input-group row" style="padding-left:10px;">
                                             <select class="form-control" id="delivway" onchange="getdelivalue()"  name="delivway">
                                                <option>--无--</option>
                                                <option>百世汇通</option>
                                                <option>顺丰速运</option>
                                                <option>申通快递</option>
                                                <option>圆通快递</option>
                                                <option>宅急送</option>
                                                <option>急急送</option>
                                                <option>邮政/EMS</option> 
                                            </select>
                                            <input type="hidden" id="uid" name="uid" value= '<s:property value="customer.user_id"/>'/>
                                            <span class="input-group-btn">
                                            	<%--<input type="hidden" name="orderid" value="<s:property value="order_id"/>">
                                                --%>
                                                <input class="btn btn-default" type="button" onclick="returndeliveway(<s:property value="order_id"/>)"  value="确认">
                                              
                                           
                                            	
                                            </span>
                                        </div><%--
                                        </from>
                                        --%><div class="row" style="padding-left:15px; padding-right:15px; padding-bottom:15px; padding-top:15px;border-top:#CCC solid thin; margin-right:-30px">
                                        	<textarea rows="4" style="width:100%"  readonly placeholder="<s:property value="orders.order_mess"/>" ></textarea>
                                        </div>
                                        
                                    </div>
                                  
                                </div>
                            </div>
                            
                         </s:iterator>
                        </div>
                      
                        
                        <nav>
                              <ul class="pager">
                                        	<li>您当前正在操作：★<span style="color:red;"><s:property value="way"/></span>★</li>
                                        	<li>当前第【<span style="color:red;"><s:property value="pageindex"/></span>】页</li>
                                            <li><a href="orders?pageindex=<s:property value="pageindex"/>&way=<s:property value="way"/>&upordown=up"/>前一页</a></li>
                                            
                                            <li><a href="orders?pageindex=<s:property value="pageindex"/>&way=<s:property value="way"/>&upordown=down">后一页</a></li>
                                             <li>总页数：【<span style="color:red;"><s:property value="size"/></span>】</li>
                                        </ul>
                        </nav>
                    </div>

                    <div class="col-lg-2">

                    </div>

                </div>
			
            </div>
            <!-- /.container-fluid -->


            <hr><br>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
	<script src="http://cdn.bootcss.com/holder/2.4.1/holder.js"></script>
<script language="javascript" defer>
new PCAS("province3","city3","area3");
</script>
</body>

</html>
