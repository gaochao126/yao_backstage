// 下拉刷新
setInterval(function(){
    if ($(".dataList input[name='loading']").length == 0) {
        $(".dataList").append('<input type="hidden" name="loading" value="0">');
    }
    if ($(".dataList input[name='loading']").val() != 0) {
        return;
    }
    if ($(".dataList").find(".dataItem").length == 0) {
        return;
    }
    var w_top = $(window).scrollTop();
    var w_height = $(window).height();
    var b = (w_top >= ($(".dataList").find(".dataItem:last").offset().top + $(".dataList").find(".dataItem:last").outerHeight())) || ((w_top+w_height) <= $(".dataList").find(".dataItem:last").offset().top);
    if (!b) {
        if ($(".dataList form").length == 0) {
            return;
        }
        var currentPage = $(".dataList form").find("input[name='page.currentPage']").val();
        var totalPage = $(".dataList form").find("input[name='page.totalPage']").val();
        if (currentPage == '' || totalPage == '') {
            return;
        }
        if (parseInt(currentPage) >= parseInt(totalPage)) {
            return;
        } else {
            $("#page8").html("正在加载...");
            $("#page8").css({"text-align":"center"});
            $("#page8").show();
            $(".dataList form").find("input[name='page.currentPage']").val(parseInt(currentPage) + 1);
            $(".dataList input[name='loading']").val(1);
            $.ajax({
                type : "GET",
                url : $(".dataList form").attr("action"),
                data : $(".dataList form").serialize(),
                dataType : "text",
                success : function(data) {
                    $("#page8").hide();
                    $(".dataList form").remove();
                    if (data.indexOf("</form>") != -1) {
                        $(".dataList input[name='loading']").val(0);
                        $(".dataList").append(data);
                        $('.brief p').dotdotdot({
                            after:'a.readmore'
                        });
                        $('.doctorsC p').dotdotdot();
                    }
                }
            });
        }
    }
}, 200);



/** 上传文件. */
function uploadFile(type) {
    var options_info = {
        type:'post',
        url : "http://yao.51791.com:51105/yao_backstage/FileUploadServlet?type=" + type,
        //url : "http://localhost:8080/yao_backstage/FileUploadServlet?type="+type,
        dataType : null,
        async: false,
        success : function(data) {
        	console.log(data);
           // var result = $.parseJSON(data.replace(/<[^>]+>/g,""));
        	var result= data;
            if (result.resultCode != 0) {
                alert(result.resultDesc);
            }
            else{
                var file = result.detail.list[0];
                uploadCallBack(result);
            }
        },
        error : function() {
            alert("上传失败");
        }
    };
    if ($("#file") == undefined || $("#file").val() == "") {
        return;
    } else {
        var fileAllowExt = $("#file").val().split(".");
        if ($.inArray(
                fileAllowExt[fileAllowExt.length - 1].toLocaleLowerCase(), [
                        "jpg", "png", "jpeg" ]) == -1) {
            alert("上传文件只支持" + [ "jpg", "png", "jpeg" ].join("、") + "格式");
            return;
        }
    }
    $("form#upload").ajaxSubmit(options_info);
    return;
}

function setFocus() {
    if (this.createTextRange) {// IE浏览器
        var range = this.createTextRange();
        range.moveStart("character", this.value.length);
        rang.collapse(true);
        range.select();
    } else {// 非ID浏览器
        this.setSelectionRange(this.value.length, this.value.length);
        this.focus();
    }
}