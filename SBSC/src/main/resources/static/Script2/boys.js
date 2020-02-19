	window.onload=function(){
		$(function(){
			console.log("xxx")
			
			curPage=1
			$("#pg1").data("cur", curPage)
			
			$("#btnJtp2").click(function(){
				toPage = $("#jtp2").val()
				console.log("toPage " + toPage)
				load_page(toPage)
			})
			
			//footerBindClick()
			
			load_page(curPage);
			//alert("girl.html")
						
			//debugger;					
		})

		//图片点击跳转单页
		function tospym(id){
			var myurl="xiangxiym.html"+"?"+"id="+id;   
	        window.location.assign(encodeURI(myurl));  
		console.log(id);
		//alert("图片点击"+id);
		}

		
		function getSpan(i){
			
			//return "<span id='pg"+i+"' class='cur'>"+i+"</span>&nbsp;"
			return "<span id='pg"+i+"' class='cur'>"+i+"</span>"
		}
		
		function getA(i){
			//return "<a id='pg"+i+"' class='changePages'>"+i+"</a>&nbsp;";
			return "<a id='pg"+i+"' class='changePages'>"+i+"</a>";
		}
		
		function load_page(curPage){
			
			params = {"cur":curPage}
			
			$.getJSON("boysxxx", params, function(result){
				
				//debugger;
				
				$(".st_bot .red").html(result.page.totalNum)
				console.log(result.page.totalNum)
				console.log(result.page.pageNum)
				//debugger;
				
				pageNum = result.page.pageNum
				$("#record #pageNum").html(pageNum)
				//$("#page_nav a").last(1).html(result.page.pageNum)
				load_footer(pageNum)

				load_items_info(result)
				//load_items_image(result)								
			})			
		}
		
		function load_footer(pageNum){
			
			//debugger;
			//$("#pgLast").html(pageNum)
				//$("#page_nav").load("page_nav")
				for(i=pageNum+1;i<=5;i++){
					//id = "#pg"+id; 
					$("#pg"+i).remove()
				}				
		}
		
		function load_items_info(result){
						
			console.log("load_items_info")
			//debugger;

			//elems = $("#goods_list li") 
			elems = $("#goods_list li")
			//n = $("#goods_list li").size()
			n = result.page.watches.length;
			for(i=0;i<n;i++){
				watch = result.page.watches[i]
				
				$("#goods_list li").eq(i).find("a").prop("href", "")
				$("#goods_list li").eq(i).find("a").on("click", function(){
					//id = watch.id
					tospym(watch.id)
				})
				
				nameHolder = $("#goods_list li").eq(i).find(".tNm")
				nameHolder.html(watch.watchName)
								
				priceHolder = $("#goods_list li").eq(i).find(".tPrc span")
				//console.log(price)
				//$("#goods_list li").eq(i).find(".tPrc span").html(watch)
				priceHolder.html(watch.watchPrice)
				
				volumeHolder =  $("#goods_list li").eq(i).find(".tInfo b")
				volumeHolder.html(watch.watchSell)
				
				//saleAmountHolder =  $("#goods_list li").eq(i).find(".tInfo b")
				//saleAmountHolder.html(watch.)
				baseDir = "img_sb/"
				url = baseDir + watch.watchImg + ".jpg"
				console.log(url)
				
				imgHolder = $("#goods_list li").eq(i).find(".tImg img")
				imgHolder.prop("src", url)
				
				//debugger;
			}
			
			clear_non_exist(n)
			//for(i=n;i<24;i++){}
			
		}
		
		function clear_non_exist(n){
			
//			n1=n
//			n2=n
//			debugger;
//						
//			list = $("#goods_list li")
//			//debugger;
//			//for(i=n;i<24;i++){}
//			for(i=n1;i<24;i++){							
//				priceHolder = $("#goods_list li").eq(i).find(".tPrc span")
//				priceHolder.html(9999)
//				//debugger;
//			}
			for(i=n;i<24;i++){
				//$("#goods_list li").eq(i).remove()
				$("#goods_list li").last().remove()
			}
						
		}
				
		function load_items_image(result){
			
			
		}
		
 
		function footerBindClick(){
			
			$(".changePages").on("click", function(){

				pre = $("#page_nav .cur").html()
				
//				pre = $("#pg1").data("cur")
//				console.log("pre" + pre)
								
				$("#page_nav .cur").next().before(getA(pre))
				footerBindClick()//bind click
				
				//$("#pg1").prop("id","pg"+pre)
				//$("pg"+pre).html(pre)
				
				$("#page_nav .cur").remove()
				
				curPage = $(this).html()
				console.log(curPage)
				
				//$("#pg1").data("cur", curPage)
								
//				<span id="pg1" class="cur">1</span>&nbsp;
				//$("#pg"+curPage).next().before("<span id='pg2x' class='cur'>2</span>&nbsp;")
				$("#pg"+curPage).next().before(getSpan(curPage))				
				$("#page_nav .cur").html(curPage)
				$("#pg"+curPage).remove()
				
				load_footer(4) //4 pages														
			})	
		}
		
		
	}
	

