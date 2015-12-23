
$(document).ready(function(){
	getType();
});

/**
 * 查询一级分类
 */
function getType(){
	var pro = $("#typeId"); 
	var html = "<option value='0'>-请选择分类-</option>";
	$.ajax({
		type:"post",
		url:"kind_typeList.html",
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				html+="<option value='"+data[i].type_id+"'>"+data[i].type_name+"</option>";
			}
			pro.html(html);
		}
	})
}

/**
 * 查询二级分类
 */
function getSecond(){
	var typeId = $("#typeId").val();
	var citty = $("#secondId");
	var html = "<option value='0'>-请选择分类-</option>";
	$.ajax({
		type:"post",
		url:"kind_SecondList.html?kindDto.type_id="+typeId,
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				html+="<option value='"+data[i].second_id+"'>"+data[i].second_name+"</option>";
			}
			citty.html(html);
		}
	})
}


/**
 * 查询三级分类
 */
function getThird(){
	var hos = $("#thirdId");
	var ccId = $("#secondId").val();
	var html = "<option value='0'>-请选择分类-</option>";
	$.ajax({
		type:"post",
		url:"kind_ThirdList.html?kindDto.second_id=" + ccId,
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				html+="<option value='"+data[i].third_id+"'>"+data[i].third_name+"</option>";
			}
			hos.html(html);
		}
	})
}



/////////////////////////////////////////////
$(document).ready(function(){
	 $("#del1").click(function(){
        $(this).hide();
        $("#img_path1").remove();
        $("#img1").attr("src","../icon/add_img.png");
        $("<input type=file  name='img' id='img_path1'  style='display: none;' onchange='add_pic(img1,this,del1); '>").appendTo("#div_img1");
    });
    $("#del2").click(function(){
        $(this).hide();
        $("#img_path2").remove();
        $("#img2").attr("src","../icon/add_img.png");
        $("<input type=file  name='img' id='img_path2'  style='display: none;' onchange='add_pic(img2,this,del2); '>").appendTo("#div_img2");
    });
    $("#del3").click(function(){
        $(this).hide();
        $("#img_path3").remove();
        $("#img3").attr("src","../icon/add_img.png");
        $("<input type=file  name='img' id='img_path3'  style='display: none;' onchange='add_pic(img3,this,del3); '>").appendTo("#div_img3");
    });
    $("#add_spe").click(function(){
        $("#div_price").hide();
        $("#div_price").children("input.input_size").val("");
        $("#div_stock").hide();
        $("#div_stock").children("input.input_size").val("");
        $("#div_num").hide();
        $("#div_num").children("input.input_size").val("");
        $("#div_discount").hide();
        $("#div_discount").children("input.input_size").val("");
        $("#div_spe").show();

    });
    $("#cancel_add").click(function(){
        $("#div_price").show();
        $("#div_stock").show();
        $("#div_num").show();
        $("#div_discount").show();
        $("#div_spe").hide();
        $("[name='spe_tr']").remove();
    });

    
})
function add_spetr(){
    var element=document.getElementById("tb_spe");
    var tr_spe=document.createElement("tr");
    tr_spe.setAttribute("name","spe_tr")
    tr_spe.innerHTML='<td><input type="text" class="tb_input" name="productDto.formats" value=""  placeholder="必填内容"></td><td><input type="text" class="tb_input" name="productDto.packs" value="" placeholder="选填内容"></td><td><input type="number" step="0.1" min="0" name="productDto.prices"  class="tb_input" value=""  placeholder="必填内容"></td><td><input type="number" min="0" step="1" class="tb_input"  name="productDto.sku" value=""  placeholder="必填内容"></td><td><a onclick="delete_spetr(this)">删除</a></td>';

    element.appendChild(tr_spe);

}
//alert($("[name='prodprice']").val());
function delete_spetr(obj){
    obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
}

// 分类三级联动
// 2011-11-30 by http://www.cnblogs.com/zjfree
var addressInit = function(_cmbProvince, _cmbCity, _cmbArea, defaultProvince, defaultCity, defaultArea)
{
    var cmbProvince = document.getElementById(_cmbProvince);
    var cmbCity = document.getElementById(_cmbCity);
    var cmbArea = document.getElementById(_cmbArea);

    function cmbSelect(cmb, str)
    {
        for(var i=0; i<cmb.options.length; i++)
        {
            if(cmb.options[i].value == str)
            {
                cmb.selectedIndex = i;
                return;
            }
        }
    }
    function cmbAddOption(cmb, str,val, obj)
    {
        var option = document.createElement("OPTION");
        cmb.options.add(option);
        option.innerHTML = str;
        option.value = val;
        option.obj = obj;
    }
    function changeCity()
    {
        cmbArea.options.length = 0;
        if(cmbCity.selectedIndex == -1)return;
        var item = cmbCity.options[cmbCity.selectedIndex].obj;
        for(var i=0; i<item.areaList.length; i++)
        {
            console.log(item.areaList[i].name+item.areaList[i].id);
            cmbAddOption(cmbArea, item.areaList[i].name,item.areaList[i].id, null);
        }
        cmbSelect(cmbArea, defaultArea);
    }
    function changeProvince()
    {
        cmbCity.options.length = 0;
        cmbCity.onchange = null;
        if(cmbProvince.selectedIndex == -1)return;
        var item = cmbProvince.options[cmbProvince.selectedIndex].obj;
        for(var i=0; i<item.cityList.length; i++)
        {
//			cmbAddOption(cmbCity, item.cityList[i].name, item.cityList[i]);
            cmbAddOption(cmbCity, item.cityList[i].name,item.cityList[i].id, item.cityList[i]);
        }
        cmbSelect(cmbCity, defaultCity);
        changeCity();
        cmbCity.onchange = changeCity;
    }

    for(var i=0; i<provinceList.length; i++)
    {
        cmbAddOption(cmbProvince, provinceList[i].name,provinceList[i].id, provinceList[i]);
    }
    cmbSelect(cmbProvince, defaultProvince);
    changeProvince();
    cmbProvince.onchange = changeProvince;
}
var SERVER_URL = "http://192.168.19.113:8080/jiuyishop/";
function addPatient() {

    //一级分类ID（A）
    var typeid = $("#typeid").val();
    //二级分类ID(Ac,Ab...)
    var secondid = $("#secondid").val();
    //三级分类ID(Aa01,Ab02...)
    var thirdid = $("#thirdid").val();
    //剂型ID
    var shapeid=$("input[name='shapeid']:checked").val();
    //kindid
    var kindid=$("input[name='kindid']:checked").val();
    //prodname
    var prodname=$("#prodname").val();
    //功能主治
    var prodfunction=$("#prodfunction").val();
    //成分
    var prodchengfen=$("#prodchengfen").val();
    //保质期
    var prodkeepdate=$("#prodkeepdate").val();
    //produsage
    var produsage=$("#produsage").val();
    //规格
    var prodformat=new Array();
    //产地
    var prodchandi=$("#prodchandi").val();

    var guige=$("[name='prodformat']");
    create_data(prodformat,guige);
    //价格数组
    var prodprice=new Array();
    var price=$("[name='prodprice']");
    create_data(prodprice,price);
    //库存数组
    var prodsku=new Array();
    var kuncun=$("[name='prodsku']");
    create_data(prodsku,kuncun);
    //包装数组
    var prodpack=new Array();
    var banzhuang=$("[name='prodpack']");
    create_data(prodpack,banzhuang);

    //折扣
    var proddiscount=$("#proddiscount").val();
//    alert(img_arr[0]);
    $.post(SERVER_URL+"addprod_api", {
        typeid : typeid,
        secondid : secondid,
        thirdid : thirdid,
        shapeid : shapeid,
        kindid : kindid,
        prodname : prodname,
        prodfunction:prodfunction,
        prodchengfen:prodchengfen,
        prodkeepdate:prodkeepdate,
        produsage:produsage,
        prodformat:prodformat,
        prodprice:prodprice,
        prodsku:prodsku,
        prodpack:prodpack,
        prodchandi:prodchandi,
        proddiscount:proddiscount
    }, function(obj) {
        if(obj.code==0000){
            alert("添加成功")
        }
        if(obj.code==0003){
            alert("添加失败");
        }



    });


}
function create_data(arr,data){
    for(var i=0;i<data.length;i++){
        if(data.eq(i).val()!=""){
            arr[i]=data.eq(i).val();
        }
//        console.log(arr[i]);
    }
}