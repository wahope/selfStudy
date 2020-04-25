	$(function(){
		$.ajax({
			url:'http://localhost:8080/BackSpe/selectAllSpe',
			type:'post',
            dataType: 'JSON',
			success(e){
				let arr=e.data,options='';
				arr.map((item)=>{
					options+=`<option value="${item.id}">${item.specialtyName}</option>`;
				})
				$('#collage').html(options);
			}
		});
		$('#collage').change(function(){
			var collageid=$(this).val();
			$.ajax({
				url:'http://localhost:8080/BackStage/selStageBySpe?specialtyId='+collageid,
				type:'post',
                dataType: 'JSON',
				success(e){
					var arr=e.stage,stage='';
					arr.map((item)=>{
						if(item.id==collageid){
							item.stage.map((res)=>{
								stage+=`<option value="${res}">${res}</option>`
							})
							
						}
						$('#stage').html(stage);
						
					})
				
				}
			});
		});
	})
