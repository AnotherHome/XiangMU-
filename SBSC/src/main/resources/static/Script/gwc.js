window.onload=function(){
	$(function(){
		console.log("PageLoad Over");
		var results = null;
		var id = getQueryVariable("id");
		console.log(id);
		var num = getQueryVariable("num");
		console.log(num);
		$("#goods_number_548546").val(num);
		initData(id);
	});

	function doGetData(url,params){
		$.getJSON(url, params, function(result) {
			results = result;
			console.log(result);
			//page = results.data.pageCurrent;
			//pageCount = result.data.pageCount;  
			//doUpdatePage(result.data.records);
			updatePage(result.data);
		});
	}

	function getQueryVariable(variable){
		var query = window.location.search.substring(1);
		var vars = query.split("&");
		for (var i=0;i<vars.length;i++) {
			var pair = vars[i].split("=");
			if(pair[0] == variable){return pair[1];}
		}
		return(false);
	}

	function initData(id){
		var url = "watch/findById";
		var params = {"id" : id};
		doGetData(url,params);
	}
	function updatePage(result){
		console.log("update");
		console.log(result);
		var data = result;
		var WatchImg = data.watchImg;
		var WatchName = data.watchName;
		var WatchPrice = data.watchPrice;
		//var z =	"<span class='w390 bold c333 fl h20 mt35'>"+WatchName+"</span>";
		//var m = "<span class='bold ccf0 f16'>￥"+WatchPrice+"</span>";
		//var i = "<img src='img_sb/"+WatchImg+".jpg' width='100px' height='100px' class='m_10_20_10_0' alt=''>";
		var dj = $(".danjia");
		var wName = $(".wName");
		var img = $(".m_10_20_10_0");
		img.prop("src","img_sb/"+WatchImg+".jpg");
		wName.html(WatchName);
		dj.html("￥"+WatchPrice);
		$("#goods_amount").html("￥"+WatchPrice);
		
	}

}