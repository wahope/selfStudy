var pageNum = 1,pageSize=10,loading = true;
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

//加载用户收藏的书籍
function initpro() {
    var cid=sessionStorage.getItem("userId");
    // console.log(cid);
    // console.log(pageNum);
    // console.log(pageSize);
    $.ajax({
        url: "http://localhost:8080/Col/selAllColByUserId",
        type: "post",
        dataType: "json",
        data:{
            pageNum:pageNum,
            limit:pageSize,
            userId:cid
        },
        //调用成功，渲染数据
        success: function(resultData) {
            $(".down").hide();
            $(".weui-pull-to-refresh__arrow").hide();
            // console.log(resultData);
            if (resultData.data != null) {
                for (var i = 0; i < resultData.data.size; i++) {
                    // console.log(resultData.data.list[i]);
                    var pro = '<p>' +
                        '<a href="../page/mybook.html?id='+resultData.data.list[i].bookId+'">书籍名称：' + resultData.data.list[i].bookName + '</a>' +
                        '<button id="btn" >删除</button>'+
                        '<i id="colId" style="display: none;">'+resultData.data.list[i].id+'</i>'+
                        '</p>';
                    $(".left-text").append(pro);
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

//删除收藏书籍
$(function () {
    $(".left-text").on('click','button[id="btn"]',function () {
        var bookid = $("#colId").html();
        console.log(bookid);
        $.ajax({
            url:"http://localhost:8080/Col/delColById",
            type:"post",
            dataType:"json",
            data:{
                id:bookid
            },
            success:function (resultData) {
                alert(resultData.msg);
                location.reload();
            },
            error:function () {
                alert("请求访问失败！");
            }
        })
    })


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

