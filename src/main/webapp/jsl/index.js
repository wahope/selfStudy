
$(function () {
    initpro();
});


//加载
function initpro() {
    $.ajax({
        url: 'http://localhost:8080/BackSpe/selectAllSpe',
        type: 'get',
        dataType: 'JSON',
        //调用成功，渲染数据
        success: function(resultData) {
            // console.log(resultData);
            if (resultData!= null) {

                $.each(resultData,function (key,data) {
                    // console.log(data.id);
                    var pro ='<li><a target="_blank" href="../page/It.html?id='+data.id+'">'+data.specialtyName+'</a>';
                        $("#nav").append(pro);
                })
                // for(var i=0;i<resultData.length;i++){
                //     console.log(i.id);
                //     var pro ='<li><a target="_blank" href="../page/It.html?"'+i.id+'>'+i.specialtyName+'</a>';
                //     $("#nav").append(pro);
                // }
            }else{
                console.log("追加失败！");
            }
        }
        ,error: function () {
            alert("接口请求失败！");
        }
    });
}

