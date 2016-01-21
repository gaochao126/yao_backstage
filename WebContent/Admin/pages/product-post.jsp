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

    <title>91健康商城后台管理系统 - JIUYI Admin v2.0</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../dist/css/product_post.css" rel="stylesheet">
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
   <!--  HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries 
    WARNING: Respond.js doesn't work if you view the page via file://  -->
   <%--  [if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        
    [endif] --%>
<script type="text/javascript">

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
</script>
<script language="javascript" src="../js/classify.js"></script>
<script language="javascript" src="../js/product_post.js"></script>
 	
 	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../js/jquery-form.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script type="text/javascript" src="../js/laypage/laypage.js"></script>
    <script type="text/javascript" src="../js/pinyin.js"></script>
</head>


<body style="font-family:'微软雅黑';">

    <div id="wrapper">

        <!-- Navigation -->
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
                                <li class="active">
                                    <a href="prod_toInsert.html">发布产品</a>
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
                                <li>
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
                                    <a href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.html">Login Page</a>
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

	 <form id ="upProd" method="post" enctype="multipart/form-data">
        <!-- Page Content -->
       
      <div id="page-wrapper">
            <div class="container-fluid">
 		<div class="col-1g-6">
           <span id="upass1_mess" style="color:red;font-size:22px;">${message}</span>
        </div>
                <div class="row" style="margin:1px; font-size:16px;">
                    <h4 class="page-header head_weight">产品属性</h4>
                    <div class="col-lg-12">
                        <div  class="form-group">
                            <span class="col-lg-1">分类</span>
                       
                            <select name="productDto.type_id" id="typeId" onchange="getSecond()">
        						<option value="0">-请选择分类-</option>
        					</select>
       						<select name="productDto.second_id" id="secondId" onchange="getThird()">
            					<option value="0">-请选择分类-</option>
        					</select>
        					<select name="productDto.third_id" id="thirdId">
            					<option value="0">-请选择分类-</option>
        					</select>
                        </div>
                    </div>
                      <div class="col-lg-12">
                        <span class="col-lg-1">品牌</span>

                                        <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br1" value="ba" checked=""> 天圣
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br2" value="bb"> 亚宝
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br3" value="bc"> 长龙
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br4" value="bd"> 太极
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br5" value="bf"> 999
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br6" value="bj"> 白云山
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br7" value="bh"> 同仁堂
                                        </label>
										<label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br8" value="bg"> 修正制药
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br9" value="bi"> 云南白药
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br10" value="be"> 汤臣倍健
                                        </label>
										 <label class="radio-inline">
                                            <input type="radio" name="productDto.brand_id" id="br10" value="bk"> 其他
                                        </label>
                                   
                      </div>
                    <div class="col-lg-12">
                        <span class="col-lg-1">剂型</span>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sa" checked=""> 颗粒剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sb"> 注射剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sc"> 胶囊剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sd"> 片剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="se"> 溶液剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sf"> 软膏剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sg"> 栓剂
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="productDto.shape_id" value="sh">其他
                            </label>

                    </div>
                    <div class="col-lg-12 bottom_row">
                        <span class="col-lg-1">种类</span>
                        <label class="radio-inline">
                            <input type="radio" name="productDto.kind_id" value="ma" checked=""> 处方药
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="productDto.kind_id" value="mb"> 非处方药
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="productDto.kind_id" value="mc"> 非药品
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="productDto.kind_id" value="md"> 其他
                        </label>
                    </div>
                    <div class="col-lg-12" style="height: 20px;"></div>
                    <h4 class="page-header head_weight">基本信息</h4>
                   
                    <div class="col-lg-12 bottom_row">
                       <span class="col-lg-3" style="float: left;">图片（点击图片编辑）
                       </span>

                        <div class="col-lg-12">
                        <div id="imgUp" style="float: left; margin-right: 20px;">
	                    	<button type="button" id="upupload" style="background-image:url(../icon/add_img.png); width: 140px; height: 140px; border-color: #FFF" onclick="$('#file').click();"></button><!-- 添加图片 -->
	                    </div>
	                    <!-- 上传图片 -->
	                    <input type="hidden" id="prod_img" name="productDto.imgSrcs" value=""/>
	                        
                           <!--  <div id="div_img1"  style="float: left; margin-right: 20px;">
                                <input type=file  name="img"  id="img_path1" style="display: none;" onchange="add_pic(img1,this,del1); ">
                                <img src="../icon/add_img.png"  style="width: 137px; height: 137px;" id="img1" onclick=img_path1.click()><br>
                                <a style="display: none;" id="del1">删除</a>
                            </div> -->
                        </div>
                    </div>
                              
                    <div class="col-lg-12 row_name">
                    	<span class="col-lg-1">名称：</span>
                        <input type="text" class="input_size" name="productDto.prod_name" id="prod_name" placeholder="必填内容">
                    </div>
                    <div class="col-lg-12 row_name">
                    	<span class="col-lg-1">通用名称：</span>
                        <input type="text" class="input_size" name="productDto.prod_commonName" id="prod_commonName" placeholder="选填内容">
                    </div>
                    <div class="col-lg-12 row_name">
                    	<span class="col-lg-1">拼音：</span>
                        <input type="text" class="input_size" name="productDto.prod_pinyin" id="prod_pinyin" placeholder="必填内容" onfocus="getFile()">
                    </div>
                    <div class="col-lg-12 row_name">
                    	<span class="col-lg-1">拼音简写：</span>
                        <input type="text" class="input_size" name="productDto.prod_firstABC" id="prod_firstABC" placeholder="必填内容" onfocus="getFirst()">
                    </div>
                   <div class="col-lg-12 row_name">
                        <span class="col-lg-1">功能主治：</span>
                        <textarea rows="2"class="input_size" name="productDto.prod_function" id="prodfunction" placeholder="必填内容"></textarea>
                    </div>
                    <div class="col-lg-12 row_name">
                        <span class="col-lg-1">用法用量：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_usage"></textarea>
                    </div>
                    <div class="col-lg-12 row_name">
                        <span class="col-lg-1">主要成分：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_chengfen"></textarea>
                    </div>
                    <div class="col-lg-12 row_name">
                        <span class="col-lg-1">禁&nbsp;&nbsp;忌：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_taboo"></textarea>
                    </div>
                     <div class="col-lg-12 row_name">
                        <span class="col-lg-1">储藏方式：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_storage"></textarea>
                    </div>
 					<div class="col-lg-12 row_name">
                        <span class="col-lg-1">不良反应：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_bad"></textarea>
                    </div>
                    <div class="col-lg-12 row_name">
                        <span class="col-lg-1">有效期：</span>
                        <input type="text" class="input_size" id="prodkeepdate" name="productDto.prod_keepdate" placeholder="请输入年、月或天"  placeholder="必填内容">             
                    </div>
                    <div class="col-lg-12 row_name">
                    	<span class="col-lg-1">批准文号：</span>
                        <input type="text" class="input_size" name="productDto.prod_certno" placeholder="必填内容">
                    </div>
                    <div class="col-lg-12 row_name">
                        <span class="col-lg-1">产地：</span>
                        <textarea rows="2" class="input_size" name="productDto.prod_chandi" id="prodchandi"  placeholder="必填内容"></textarea>
                    </div>

                    <div class="col-lg-12 row_name" style="display: none" id="div_spe">
                        <table  class="table table-striped table-bordered " style="text-align: center;">
                            <thead >
                            <tr >
                                <th style="text-align: center;">规格</th>
                                <th style="text-align: center;">包装</th>
                                <th style="text-align: center;">价格</th>
                                <th style="text-align: center;">库存</th>
                                <th style="text-align: center;">操作</th>
                            </tr>
                            </thead>

                            <tbody id="tb_spe">
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-12 bottom_row">
                        <button id="add_spe" onclick="add_spetr()" type="button" class="btn btn-outline btn-default add_Specifications">+添加规格</button>
                        <button id="cancel_add" type="button" class="btn btn-outline btn-default add_Specifications">取消添加规格</button>
                    </div>
                    <div class="col-lg-3" style="padding-bottom: 80px;padding-top: 10px;">		
                                   <!--  <input type="submit" class="btn btn-1g btn-info" id="submit1"  style="padding-left: 30px;padding-right: 30px; margin-bottom: 30px; margin-top: 30px;font-size: 22"   value="确认提交" /> -->
                					<button class="btn btn-1g btn-info" onclick="insertProd()">确认提交</button>
                				</div>
                				<div class="col-1g-2">
                					<span id="upass1_mess" style="color:red">${message}</span>
                				</div>
                    <!-- /.col-lg-12 -->
                	</div>
            </div>
      </div><!--pagewraper-->
   </form>
   
   <form id="upload" method="post" enctype="multipart/form-data" style="display: none;"> 
	   <input id="file" type="file" name="file" style="display: none" onchange="uploadFile(1);"/>
   </form>
</div>
    <!-- /#wrapper -->

    <!-- jQuery -->
  <%--   <script src="../bower_components/jquery/dist/jquery.min.js"></script> --%>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
	<script src="http://cdn.bootcss.com/holder/2.4.1/holder.js"></script>
	
	<script type="text/javascript">

	    // 上传回调
        function uploadCallBack(result) {
	    	console.log("回调名字_______"+result.detail.list[0]);
            $("#prod_img").val(result.detail.list[0]);
         // $("#upupload").css("background-image", "url(http://222.180.171.34:51105/jiuyishop/images/smallimg/14322052524190016.jpg)");
        	$("#imgUp").html("");
        	var ipSrc = "http://222.180.171.34:51105/voice/medicine/"+result.detail.list[0];
        	$("#imgUp").html("<img src='"+ ipSrc +"' style='width: 137px; height: 137px;'>");
	    }
	    
	    //确认提交
	    function insertProd(){
	    	var thirdId = $("#thirdId").val();
	    	if(thirdId == 0){
	    		alert("请选择药品类别");
	    		return;
	    	}
	    	$.ajax({
				type : "post",
				url :  'prod_insertProd.html',
				data : $("#upProd").serialize(),
				dataType : "json",
				success : function(data) {
					if(data.resultCode == 0){
						alert("添加成功");
						window.location.href = "prod_toInsert.html";
					
					}else{
						alert("添加失败,"+data.resultDesc);
					}  
				}
			});
	    }
	    
	    //根据药品名字获得拼音
	    function getFile(){
	        var n = $("#prod_name").val();
	        var p = pinyin.getFullChars(n);
	        $("#prod_pinyin").val(p);
	    }

	    //根据药品名字获得首字母
	    function getFirst(){
	        var n = $("#prod_name").val();
	        var p = pinyin.getCamelChars(n);
	        $("#prod_firstABC").val(p);
	    }
	    
    </script>
</body>

</html>
