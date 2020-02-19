window.onload=function(){
	$(function() {
		console.log("Load Over")
		doInit();
		doInitSearch();
		//结果集
		var results = null;
		//当前页
		var page = null;
		//总页数
		var pageCount = null;
	})
	//异步获取数据方法
	function doGetData(url,params){
		$.getJSON(url, params, function(result) {
			results = result;
			page = results.data.pageCurrent;
			pageCount = result.data.pageCount;  
			doUpdatePage(result.data.records);
		});
	}
	
	
	function doInitSearch(){
		//重新生成输入框
		console.log($(".srh"));
		$("form").remove("#searchForm");
		
		var div = $(".srh");
		
		var btn = "<a class='c__search'>搜索</a>";
		
		var inp = "<input name='watchName' id='watchName' type='text' class='tIptTxt c999 f14' value=''" +
				" title='搜索 品牌/系列/型号' placeholder='搜索 品牌/系列/型号'/>";
		
		div.append(inp);
		div.append(btn);
		
		$(".c__search").on("click",function(){
			watchName = $(".tIptTxt").val();
			console.log(watchName);
			doSelectByName(watchName);
		});
		
		$(".c999").keydown(function(e){
			if(e.keyCode==13){
				var watchName=$(".c999").val();
				doSelectByName(watchName);
			}
		});
		
	}
	
	//跳转到指定位置,异步获取数据
	function doInit(pages) {
		console.log("Init");
		var url = "watch/findPage";
		if(pages>=1){
			page = pages;
		}else{
			page = 1;
		}
		var params = {"pageCurrent" : page};
		doGetData(url,params);
	}
	//根据名字查找
	function doSelectByName(watchName){
		console.log("getName");
		var url = "watch/findPage";
		var pageCurrent = results.data.pageCurrent;
		var params = {"pageCurrent" : pageCurrent,
				"watchName" : watchName};
		doGetData(url,params);
	}
	//页面切换
	function doChangePages(val,watchName){
		var url = "watch/findPage";
		var pageCurrent = val;
		watchName = $("#watchName").val();
		var params = {
				"pageCurrent" : pageCurrent,
				"watchName" : watchName};
		doGetData(url,params);
		$('html').animate({ scrollTop: 0 }, 100);//动画效果
	}
	

	//	库存不为0输出,如果watchLike为true,添加导师推荐
	
	//呈现页面方法
	function doUpdatePage(data) {
		//console.log(data);
		//页面容器
		var context = $(".context");
		context.empty();
		
		var newUl = "<ul class='infomation'></ul>";
		context.append(newUl);
		var tul = $(".infomation");
		//分页导航栏  上一页下一页第x页等
		var sPage =$("#page_nav");
		sPage.empty();
		//总记录数
		var rows = data.length;
		//console.log("切换页面栏clean over")
		//console.log("state==1");
		
		
		for (var i = 0; i < data.length; i++) {
			//console.log(data[i].id);
			//商品在数据表中的id
			var id = data[i].id;
			//商品的图片
			var watchImg = data[i].watchImg;
			//商品名称
			var watchName = data[i].watchName;
			//折扣价
			var watchSale = data[i].watchSale;
			//单价
			var watchPrice = data[i].watchPrice;
			//评论次数
			var watchComment = data[i].watchComment;
			//是否为导师推荐
			var watchLike = data[i].watchLike;
			/*	console.log(id);
				console.log(watchImg);
				console.log(watchName);
				console.log(watchSale);
				console.log(watchPrice);
				console.log(watchComment); 
				console.log(watchLike); */
			//判断,如果导师推荐为true(有推荐)时,输出不同的span class属性
			var likeTag = watchLike==true?"<span class='tips rec'></span>":"<span class></span>";
			
			//呈现页面
			//如果库存为0时,不执行呈现
			if(data[i].watchInventory<1){
				continue;
			}else{
				var lis = 
					"<li width='300px'> "+ likeTag +
					"<a href='xiangxiym?id=" + id + "' target='_blank' class='img'>"+
					"<img src='img_sb/" + watchImg + ".jpg' alt='"+watchName+"' width='300' height='300' />"+
					"</a>"+
					"<p> "+
					"<b>"+
					"<a href='xiangxiym?id=" + id + "'>"+
					watchName +
					"</a>"+
					"</b>"+
					"<br>"+
					"<u></u>"+
					"<ins>￥" + watchSale + "</ins>"+
					"<del>原价：￥" + watchPrice + "</del>"+
					"<br>"+
					"<span class='cmt'>已被评论<i>" + watchComment + "</i>次</span> "+
					"</p>"+
					"<a href='xiangxiym?id=" + id + "' class='btn'>立即抢购</a> "+
					"</li>";
				//添加到页面
				tul.append(lis);
			}
		}
		if(rows>=1){
			//总页数
			var pageNum = pageCount;
			//输出上一页按钮
			var pre = page==1?"<span class='pre'><span></span> 上一页</span>&nbsp;":"<a value = "+ (page-1<1?1:page-1) +" class='pre changePages'>上一页<span></span></a>&nbsp;";
			sPage.append(pre);
			//输出第一页按钮
//			var pageNum = 1;
//			var nums = page==pageNum?"<span class='cur'>"+pageNum+"</span>&nbsp;":"<a href='跳转"+pageNum+"'>"+ pageNum +"</a>&nbsp;";
//			sPage.append(nums);
			
			//判断
			var min = page-2>=1? min=page-2 : min=1;
//			var max = page +2 >= pageCount ? max=pageCount : max=page+2;
			var tj = min+5 >= pageCount ? pageCount : min+5;
			for(var i=min;i<tj;i++){
				var nums = page==i?"<span class='cur'>"+i+"</span>&nbsp;":"<a class='changePages' id ="+i+" value = "+ i +">"+ i +"</a>&nbsp;";
				sPage.append(nums);	
			}
			//输出最后一页按钮
			var nums = page==pageNum?"<span class='cur'>"+pageNum+"</span>&nbsp;":"<a class='changePages' value = "+ pageNum+">"+ pageNum +"</a>&nbsp;";
			sPage.append(nums);
			//输出下一页按钮
			var next = page==pageNum?"<span class='next'><span></span> 下一页</span>&nbsp;":"<a  value = "+ (page+1>pageNum?pageNum:page+1) +" class='next changePages'>下一页<span></span></a>&nbsp;";
			sPage.append(next);
		}else{
			var tips = "<li class='tips'width='100%' height='350px'>对不起,没有找到相关商品</li>";
			tul.append(tips);
		}

		$(".changePages").on("click",function(){
			var val=$(this).attr("value");
			//console.log(val);
			watchName = $("#watchName").val();
			//console.log(watchName);
			doChangePages(val,watchName);
			
            
		})
	}
}