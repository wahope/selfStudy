var pageNum = 1,pageSize=2,loading = true;
$(function () {
    initpro();
    //滚动加载
    $(document.body).infinite().on("infinite", function() {
        if(loading) {
            setTimeout(function() {
                pageNum+=1;
                pageSize=2;
                // console.log(pageNum);
                initpro();
            }, 1500);   //模拟延迟
        }
    });
});

$(function () {
    $("#collect").click(function () {
        var bookId =$("#collect").val();
        $.ajax({
            url: "http://localhost:8080/Book/selectBookById",
            type: "post",
            dataType: "json",
            data:{
                id:bookId
            },
            success:function (data) {
                console.log(data);
            },
            error:function () {
                alert("请求接口失败！");
            }
        });
    });

    var sid = UrlParam.paramValues("id");
    var cid = parseInt(sid);
    $.ajax({
        url: "http://localhost:8080/Book/selectSource",
        type: "post",
        dataType: "json",
        data:{
            stageId:cid
        },
        success:function (resultData) {
            if (resultData.data != null) {
                console.log(resultData);
                for (var i = 0; i < resultData.data.length; i++) {
                    var software ='<p>' + resultData.data[i].sourceName + '</p>' +
                        '<a href="'+resultData.data[i].sourceUrl+'">链接：' + resultData.data[i].sourceUrl.substring(0,20) + '</a>' +
                        '\t\t</div>';
                    $("#software").append(software);
                }
            }else{
                console.log("无数据加载！");
            }
        },
        error:function () {
            alert("接口请求失败！");
        }
    });
});

$(document.body).pullToRefresh({
    onRefresh: function () {
        $('#nav').pullToRefreshDone();
        location.reload();
    }
});

//加载学术动态
function initpro() {
    var sid = UrlParam.paramValues("id");
    var cid = parseInt(sid);
    // console.log(cid);
    // console.log(pageNum);
    // console.log(pageSize);
    $.ajax({
        url: "http://localhost:8080/Book/selectBookByStageId",
        type: "post",
        dataType: "json",
        data:{
            pageNum:pageNum,
            limit:pageSize,
            stageId:cid
        },

        //调用成功，渲染数据
        success: function(resultData) {
            $(".down").hide();
            $(".weui-pull-to-refresh__arrow").hide();
            // console.log(resultData);
            if (resultData.data != null) {
                for (var i = 0; i < resultData.data.size; i++) {
                    // console.log(resultData.data.list[i]);
                    var pro = '\t\t<div id="center">\n' +
                        '<h4>' + resultData.data.list[i].bookName + '&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkchild" value="' +
                        resultData.data.list[i].id + '">' + '收藏此书' + '</input>' +'</h4>' +
                        '<h5>作者：' + resultData.data.list[i].author+
                        '&nbsp;&nbsp;&nbsp;&nbsp;出版社：' + resultData.data.list[i].press +
                        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5>' +
                        '<p>' + resultData.data.list[i].bookIntro + '</p>' +
                        '<a href="'+resultData.data.list[i].bookUrl+'">购买链接：' + resultData.data.list[i].bookUrl.substring(0,50) + '</a>' +
                        '\t\t</div>';
                    $("#bookInfo").append(pro);
                }
                if((resultData.data.size<pageSize)||(pageNum==resultData.data.lastPage)){
                    $(".weui-loadmore").hide();
                    loading = false;
                    $(".weui-cells__title").css("display","block");
                    $(document.body).destroyInfinite();
                    console.log("所有数据加载完成！");
                }
            }else{
                $(".weui-loadmore").hide();
                loading = false;
                $(".weui-cells__title").css("display","block");
                $(document.body).destroyInfinite();
                console.log("无数据加载！");
            }

        }
        ,error: function () {
            alert("接口请求失败！");
        }
    });
}

$(function () {
    $("#shc").click(function () {
        var userId=sessionStorage.getItem("userId");
        var ids='';
        console.log(userId);
        $("input[name='checkchild']").each(function(){
            if($(this).is(":checked")){
                ids+=$(this).val()+','; // 将文本框的值添加到字符串中
            }
        });
        console.log(ids);
        $.ajax({
            url:'http://localhost:8080/Col/insert',
            type:"post",
            dataType:"json",
            data:{
                userId:userId,
                sourceIds:ids
            },
            success:function (result) {
                console.log(result);
                alert(result.msg);
            },error:function () {
                alert("请求接口失败！");
            }

        })
    });


});
//取网址上传过来的参数
UrlParam = function() { // url参数
    var data, index;
    (function init() {
        data = []; //值，如[["1","2"],["zhangsan"],["lisi"]]
        index = {}; //键:索引，如{a:0,b:1,c:2}
        var u = window.location.search.substr(1);
        if (u != '') {
            var params = decodeURIComponent(u).split('&');
            for (var i = 0, len = params.length; i < len; i++) {
                if (params[i] != '') {
                    var p = params[i].split("=");
                    if (p.length == 1 || (p.length == 2 && p[1] == '')) {// p | p= | =
                        data.push(['']);
                        index[p[0]] = data.length - 1;
                    } else if (typeof(p[0]) == 'undefined' || p[0] == '') { // =c 舍弃
                        continue;
                    } else if (typeof(index[p[0]]) == 'undefined') { // c=aaa
                        data.push([p[1]]);
                        index[p[0]] = data.length - 1;
                    } else {// c=aaa
                        data[index[p[0]]].push(p[1]);
                    }
                }
            }
        }
    })();
    return {
        // 获得参数,类似request.getParameter()
        param : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);
            } catch (e) {
            }
        },
        //获得参数组, 类似request.getParameterValues()
        paramValues : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o] : data[index[o]]);
            } catch (e) {}
        },
        //是否含有paramName参数
        hasParam : function(paramName) {
            return typeof(paramName) == 'string' ? typeof(index[paramName]) != 'undefined' : false;
        },
        // 获得参数Map ,类似request.getParameterMap()
        paramMap : function() {
            var map = {};
            try {
                for (var p in index) { map[p] = data[index[p]]; }
            } catch (e) {}
            return map;
        }
    }
}();