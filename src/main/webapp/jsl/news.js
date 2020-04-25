$(function () {
    var sid = UrlParam.paramValues("id");
    var cid = parseInt(sid);
    console.log(cid);
    $.ajax({
        url: "http://localhost:8080/News/selectNewsById",
        type: "post",
        dataType: "json",
        data:{
            id:cid
        },
        //调用成功，渲染数据
        success: function(resultData) {
            console.log(resultData);
            if (resultData.data != null) {
                    var pro = '\t\t<div id="center">\n' +
                        '<h4>'+resultData.data.title+'</h4>' +
                        '<h5>' + resultData.data.createTime+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5>' +
                        '<p>'+resultData.data.content+'</p>' +
                        '\t\t</div>';
                    $("#newsInfo").append(pro);
            }else{
                console.log("无数据加载！");
            }

        }
        ,error: function () {
            alert("接口请求失败！");
        }
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