


function delCat(categoryId){
    var data ={'id':categoryId}
	$.get("mt/mtSecondLevelCategory/remove",data,function(r){
		if(r.success){
			 window.location.reload();
		}
	})
}

function editCat(){
	var $myPopups = $('#my-popups');
	$myPopups.modal();
}