var pageNum = 1,pageSize=10,loading = true;
$(function () {
    initpro();
    //滚动加载
    $(document.body).infinite().on("infinite", function() {
        if(loading) {
            setTimeout(function() {
                pageNum+=1;
                pageSize=10;
                // console.log(pageNum);
                initpro();
            }, 1500);   //模拟延迟
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
        url: "http://localhost:8080/News/selectNewsInfo",
        type: "get",
        dataType: "json",
        data:{
            pageNum:pageNum,
            limit:pageSize,
            sid:cid
        },

        //调用成功，渲染数据
        success: function(resultData) {
            // console.log(resultData);
            $(".down").hide();
            $(".weui-pull-to-refresh__arrow").hide();
            if (resultData.data.data != null) {
                for(var i=0;i<resultData.data.data.size;i++){
                    var pro = '\t\t<div id="center">\n' +
                        '<a id="xq" href="../page/news.html?id='+resultData.data.data.list[i].id +'" +>\n' +
                        '<table class="center_2">\n' +
                        '<tr><td>'+resultData.data.data.list[i].title+'</td>' +
                        '<td>'+resultData.data.data.list[i].content.substring(0,40)+'...'+'</td>' +
                        '<td>' + resultData.data.data.list[i].createTime + '</td></tr></table>\n' +
                        '</a>\n' +
                        '\t\t</div>';
                    $("#newsLists").append(pro);
                }
                if(resultData.data.data.size<pageSize){
                    $(".weui-loadmore").hide();
                    loading = false;
                    $("#noStudy").append('<div class=\\"weui-cells__title\\" style=\'text-align: center\'>已无更多数据</div>');
                    $(document.body).destroyInfinite();
                    console.log("所有数据加载完成！");
                }
            }else{
                console.log("数据加载完成！");
            }
        }
        ,error: function () {
            alert("接口请求失败！");
        }
    });
}

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