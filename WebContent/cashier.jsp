<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收银</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/metro.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css_for_table.css" />
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>

<style type="text/css">
* {
	color: white;
	font-family: "微软雅黑";
}

.simple-text {
	margin: 0px;
	padding: 0px;
	width: 300px;
	height: 32px;
	margin-top: 2px;
	margin-bottom: 20px;
	font-size: 14px;
	letter-spacing: 1px;
	text-indent: 10px;
}

form {
	color: #009587;
	font-size: 16px;
	margin-top: 30px;
}

.container-fluid {
	background-color: black;
}

#header {
	height: 100px;
	border: 1px solid white;
}

#part1 {
	margin-left: 50px;
	height: 100%;
	width: 260px;
	float: left;
}

#part4 {
	height: 100%;
	width: 120px;
	float: left;
	margin-left: 20px;
}

#part2 {
	height: 100%;
	
	float: left;
	margin-left: 20px;
}

#part3 {
	height: 100%;
	
	float: left;
	margin-left: 20px;
}

#money-rest {
	display: block;
	float: left;
	clear: both;
	margin-top: 32px;
	margin-bottom: 15px;
}

#customer-level, #but-rest, #integration {
	display: block;
	float: left;
	clear: both;
	margin-top: 32px;
}

#trust_money, #get_money, #zl_money {
	color: black;
	display: block;
	float: left;
	clear: both;
	margin-top: 13px;
	margin-bottom: 15px;
}

#foot-part2-1, #foot-part3-1, #foot-part4-1 {
	display: block;
	float: left;
	clear: both;
	margin-top: 22px;
	margin-bottom: 15px;
}

#now-time {
	display: block;
	float: left;
	clear: both;
	margin-top: 32px;
}

#vip-no, #vip-type, #discount, #integration {
	display: block;
	float: left;
	clear: both;
}

#customer-level-son {
	display: block;
	float: right;
	width: 150px;
	margin-top: -2px;
}

#vip-no-son {
	display: block;
	float: right;
	width: 100px;
	margin-top: 20px;
	margin-left: 40px;
}

#but-rest-son {
	display: block;
	float: right;
	width: 145px;
}

#money-rest-son {
	display: block;
	float: right;
	width: 100px;
	border-bottom: 1px solid white;
}

#zl-rest-son {
	color: #777;;
	margin-top: 6px;
	display: block;
	font-size: xx-large;
	float: left;
	width: 200px;
	border-bottom: 1px solid white;
}

#change-rest-son {
	display: block;
	float: right;
	width: 100px;
	border-bottom: 1px solid black;
}

#vip-type-son, #integration-son, #discount-son {
	display: block;
	float: right;
	width: 100px;
	border-bottom: 1px solid white;
}

#content {
	height: 540px;
	/* border: 1px solid white; */
}

#footer {
	height: 100px;
	border: 1px solid white;
}

#situation {
	height: 100%;
	border: 1px solid white;
}

#customer-info {
	height: 100%;
	border: 1px solid white;
}

#main {
	height: 100%;
	border: 1px solid white;
}

#goods-info {
	height: 100%;
	border: 1px solid white;
}

#foot-part1 {
	margin: 0px auto;
	margin-top: 5px;
	padding: 5px;
	width: 340px;
	height: 40px;
	border: 1px solid #A6A6A6;
}

#foot-part2, #foot-part3, #foot-part4 {
	margin-left: 55px;
	display: block;
	float: left;
}

#foot-part2-2, #foot-part3-2, #foot-part4-2 {
	display: block;
	float: right;
	width: 80px;
	border-bottom: 1px solid white;
}

#company-info {
	height: 100%;
	border: 1px solid white;
}

#company-info1 {
	float: left;
	height: 42px;
	margin-left: 10px;
	margin-top: 40px;
}

#company-info2 {
	float: left;
	height: 42px;
	margin-left: 10px;
	margin-top: 40px;
}

#company-info3 {
	float: left;
	height: 42px;
	margin-left: 10px;
	margin-top: 40px;
}

#money-part1 {
	float: left;
	height: 42px;
	margin-left: 10px;
}

#money-part2 {
	float: left;
	height: 42px;
	margin-left: 10px;
	margin-top: 30px;
}

#money-part1-1 {
	display: block;
	float: left;
	clear: both;
	margin-top: 36px;
	margin-bottom: 15px;
}

#money-part1-2 {
	display: block;
	float: right;
	width: 100px;
	border-bottom: 1px solid white;
}

#bigtitle {
	letter-spacing: 10px;
	display: block;
	margin: 0px auto;
	text-align: center;
	font-size: 50px;
	margin-top: 160px;
	font-weight: bold;
	color: white;
}

#money {
	height: 100%;
	border: 1px solid white;
}

#btn-back {
	display: block;
	margin-top: 28px;
	margin-left: 45px;
}

#money-back {
	display: block;
	margin-top: -2px;
	margin-left: 45px;
}

#true-back {
	margin: 0 10px;
	display: block;
	margin-top: -2px;
	width: 80px;
	float: right;
}

#btn-submit {
	display: block;
	margin-top: -4px;
}

#goods-info-text {
	color: black;
}

#member-info-text {
	color: black;
}
</style>
<script type="text/javascript">
	$(function() {
		var timer = setInterval(time, 1000);

		function time() {
			var time = new Date().toLocaleFormat();
			$("#time-info").html(time);
		}
		//ajax请求
		$("#btn-submit").click(
			function() {
				var m_phone = $("#member-info-text").val();
				$.ajax({
					method : "post",
					url : "${pageContext.request.contextPath }/Member/findMemberByphone1.action",
					data : {
						m_phone : m_phone
					}
					}).done(function(msg) {
						if (msg != null && msg != "") {
							$("#money-rest-son").html(msg.m_integral);
							$("#integration-son").html(0.9);
						} else {
							$("#money-rest-son").html("");
							$("#integration-son").html("");
						}});
					});
		});
</script>
<script type="text/javascript">
	function checkGoods() {
		var g_id = $("#goods-info-text").val();
		var g_num = 0;
		var objs = document.querySelectorAll('*[name="int2"]');
		var strsid = "";
		var objte = Number($("#span1").val());
		var flag = false;
		for (var i = 0; i < objs.length; i++) {
			var radio = objs[i].getAttribute("id");
			g_num = Number($("#" + radio).val());
			if (g_id == radio) {
				g_num = g_num + 1;
				flag = true;
				$("#" + radio).val(g_num);
				//购买相同的商品
				/* $("#number-info-text").val(g_num); */
				var price = Number(objs[i].parentNode.previousSibling.childNodes[0].value);
				var fPrice = objs[i].parentNode.nextSibling.childNodes[0].value;
				fPrice = price * g_num;
				
				objs[i].parentNode.nextSibling.childNodes[0].value = fPrice;
				/* $("#price2-info-text").val(fPrice.toFixed(2)); */
				//获取总金额
				var totalPrice = Number($("#money-part1-2").text());
				
				//alert($("#money-part1-2").val());
				
				if (g_id == radio.value) {
					//相同商品
					totalPrice = totalPrice + price;
					$("#money-part1-2").text(totalPrice.toFixed(2));
				} else {
					//不同商品
					totalPrice = totalPrice + price;
					$("#money-part1-2").text(totalPrice.toFixed(2));
				}
				//获取模态框中的应收金额
				var finalPrice = Number($("#span1").val());
				//获取会员积分
				var num = $("#money-rest-son").text();
				var num1 = $.trim(num);
				if (num1 != null && num1 != "") {
					//会员打折
					finalPrice = totalPrice * 0.9;
					$("#span1").val(finalPrice.toFixed(2));
				} else {
					//不是会员原价
					finalPrice = totalPrice;
					$("#span1").val(finalPrice.toFixed(2));
				}
				break;
			}
		}
		if (flag) {
			//购买相同的商品
			/* $("#number-info-text").val(g_num); */
			/* var price=Number($("#price1-info-text").val());
			var fPrice=$("#price2-info-text").val();
			fPrice=price*g_num;
			$("#price2-info-text").val(fPrice.toFixed(2)); */
			//获取总金额
			/* var totalPrice=Number($("#money-part1-2").text());
			if(g_id==radio.value){ */
			//相同商品
			/* 	totalPrice=totalPrice+price;
				$("#money-part1-2").text(totalPrice.toFixed(2));
			}else{ */
			//不同商品
			/* totalPrice=totalPrice+fPrice;
			$("#money-part1-2").text(totalPrice.toFixed(2));
			}  */
			//获取模态框中的应收金额
			/* var finalPrice = Number($("#span1").val()); */
			//获取模态框中的实收金额
			/* var num = $("#money-rest-son").text();
			var num1 = $.trim(num);
			if (num1 != null && num1 != "") {
				//会员打折
				finalPrice = totalPrice * 0.9;
				$("#span1").val(finalPrice.toFixed(2));
			} else {
				//不是会员原价
				finalPrice = totalPrice;
				$("#span1").val(finalPrice.toFixed(2));
			} */
		} else {
			//购买不同的商品
			$.ajax(
				{
					method : "post",
					url : "${pageContext.request.contextPath }/GoodsServlet",
					data : {
					g_id : g_id,
					type:"findGoods"
					}
				}).done(function(msg) {
					var jsonObj = $.parseJSON(msg);
					//alert("jjjjjjjjj"+jsonObj.g_name);
					var num = document.getElementsByName("t1");
					$("#showGoods").append("<tr name='trtr' class='trtr'><td name='t1' id='t1'>"
														+ (num.length + 1)
														+ "</td><td name='td2'>"
														+ jsonObj.g_name
														+ "</td><td name='td3'>"
														+ jsonObj.g_unit
														+ "</td><td name='td4'><input type='text' id='price1-info-text'  style='background-color:black;border-color:black;border-style:solid;color:white' readonly='readonly' value="
														+ jsonObj.g_purchasePrice+"></td><td name='td5' ><input type='text' name='int2' id='"
														+ jsonObj.g_id+"' style='background-color:black;border-color:black;border-style:solid;color:white' readonly='readonly' value='1'></td><td name='td6'><input type='text' id='price2-info-text'  style='background-color:black;border-color:black;border-style:solid;color:white' readonly='readonly' value="
														+ jsonObj.g_purchasePrice+"></td><td name='td7'>"
														+ jsonObj.g_shelfLife
														+ "</td><tr><input type='hidden' name='int1' value="+jsonObj.g_id+">");
								var sum = Number(jsonObj.g_purchasePrice);

								/* var totalsum=$("#price2-info-text").val();
								alert(totalsum); */

								//把NAN转成数字
								//获取总金额
								var price = Number($("#money-part1-2").text());
								//总金额和添加的新商品价钱相加
								price = price + sum;
								//js中数字保留两位小数
								//给总金额赋值
								$("#money-part1-2").text(price.toFixed(2));
								//获取模态框中的应收金额
								var finalPrice = Number($("#span1").val());
								//获取模态框中的实收金额
								var num = $("#money-rest-son").text();
								var num1 = $.trim(num);
								if (num1 != null && num1 != "") {
									//会员打折
									finalPrice = price * 0.9;
									$("#span1").val(finalPrice.toFixed(2));
								} else {
									//不是会员原价
									finalPrice = price;
									$("#span1").val(finalPrice.toFixed(2));
								}
							});
		}

		$("#goods-info-text").val("");
		$("#goods-info-text").select();
	}
	function findChange() {
		var realMoney = Number($("#text1").val());
		/* alert(realMoney); */
		var finalPrice = Number($("#span1").val());
		/* alert(finalPrice); */
		var change = realMoney - finalPrice;
		$("#zl-rest-son").html(change.toFixed(2));
	}
	function getMs() {
		//获取总金额
		var totalPrice = Number($("#money-part1-2").text());
		//获取模态框中的应收金额
		var finalPrice = Number($("#span1").val());
		//获取会员积分
		var num = $("#money-rest-son").text();
		var num1 = $.trim(num);
		if (num1 != null && num1 != "") {
			//会员打折
			finalPrice = totalPrice * 0.9;
			$("#span1").val(finalPrice.toFixed(2));
		} else {
			//不是会员原价
			finalPrice = totalPrice;
			$("#span1").val(finalPrice.toFixed(2));
		}
	}
</script>
<script type="text/javascript">
	var no;
	function getMoney() {
		var content = document.getElementsByName("trtr");
		var objs = [];
		objs.length = 0;
		var objs1 = [];
		objs1.length = 0;
		//货物ID
		objs = document.querySelectorAll('*[name="int1"]');
		//数量
		objs1 = document.querySelectorAll('*[name="int2"]');
		var strsid = "";
		var strnum = "";
		var objte = Number($("#span1").val()); //总金额	
		var uid = document.getElementById("operate").value;
		for (var i = 0; i < objs.length; i++) {
			strsid = strsid + objs[i].value + ",";
		}
		for (var i = 0; i < objs1.length; i++) {
			strnum = strnum + objs1[i].value + ",";
		}

		$
				.ajax(
						{
							method : "POST",
							url : "${pageContext.request.contextPath }/sale/addSaleOrder.action",
							data : {
								objte : objte,
								strsid : strsid,
								strnum : strnum
							}
						}).done(function(msg) {
					var jsonObj = JSON.parse(msg);
					if (jsonObj == true) {
						$(".trtr").html("");
						$("#zl-rest-son").html("");
						$("#text1").val("");
						$("#money-part1-2").html("");
						$("#member-info-text").val("");
						$("#money-rest-son").html("");
						$("#integration-son").html("");
					} else {
						alert("失败！");
					}
				});
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid" id="header">
			<div class="col-md-2" id="situation">
				<span id="now-time">时间：<span id="time-info"></span></span>
			</div>
			<div class="col-md-8" id="customer-info">
				<div id="part1">
					<span id="customer-level"> 会员手机号： <span
						id="customer-level-son"> <input type="text"
							name="member-info-text" id="member-info-text" value="" />
					</span>
					</span> <span id="vip-no"><span id="vip-no-son"></span></span>
				</div>
				<div id="part4">
					<span id="but-rest"> <input type="submit" id="btn-submit"
						class="btn-submit" value="查询" onclick="checkMember()" /> <span
						id="but-rest-son"> </span>
					</span>
				</div>
				<div id="part2">
					<span id="money-rest"> 会员积分： <span id="money-rest-son">

					</span>
					</span>
				</div>
				<div id="part3">
					<span id="integration"> 享受折扣： <span id="integration-son">

					</span>
					</span>
				</div>
			</div>
			<div class="col-md-2" id="div-back">
				<div id="div-btn-back">
					<a href="${pageContext.request.contextPath }/jsp/index.jsp"><input
						type="button" name="btn-back" id="btn-back" value="退出POS前端销售" /></a>
				</div>
			</div>
		</div>

		<div class="row-fluid" id="content">
			<div class="col-md-12" id="main">
				<div id="content" class="simple-table">
					<table border="0" cellspacing="0" cellpadding="0" id="showGoods">
						<tr>
							<th>序号</th>
							<th>商品名称</th>
							<th>单位</th>
							<th>原价</th>
							<th>数量</th>
							<th>金额</th>
							<th>有效日期</th>
						</tr>
					</table>
					<span id="bigtitle"> 已购商品展示区 </span>
				</div>
			</div>
		</div>
		<div class="row-fluid" id="footer">
			<div class="col-md-4" id="goods-info">
				<div id="foot-part1">
					输入品名或者扫描条形码：<input type="text" name="goods-info-text"
						id="goods-info-text" onchange="checkGoods()" />
				</div>
				<div id="foot-part2">
					<span id="foot-part2-1"> 收银员编号： <span id="foot-part2-2">
							${user.u_id } </span> <input type="hidden" name="operate" id='operate'
						value=${user.u_id }>

					</span>
				</div>
				<div id="foot-part3">
					<span id="foot-part3-1"> 收银员姓名： <span id="foot-part3-2">
							${user.u_name }</span>
					</span>
				</div>
			</div>
			<div class="col-md-5" id="company-info">
				<div id="company-info1">
					<span id="company-info1-1">企业名称： <span id="foot-part1-2">
							${enterprise.e_enterprisename }</span>
					</span>
				</div>
				<div id="company-info2">
					<span id="company-info1-1">联系方式： <span id="foot-part1-2">
							${enterprise.e_phone }</span>
					</span>
				</div>
				<div id="company-info3">
					<span id="company-info1-1">公司地址： <span id="foot-part1-2">
							${enterprise.e_address }</span>
					</span>
				</div>
			</div>
			<div class="col-md-3" id="money">
				<div id="money-part1">
					<span id="money-part1-1"> 总金额： <span id="money-part1-2">
					</span>
					</span>
				</div>
				<div id="money-part2">
					<input type="button" data-target="#AddMedicineModal"
						data-toggle="modal" name="money-back" id="money-back" value="结算"
						onclick="getMs()" />
				</div>
			</div>
			<!--   弹框     -->
			<div class="modal fade" id="AddMedicineModal" data-backdrop="static"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<form id="addMedicine" method="post">
							<div class="modal-body">
								<table border="0" cellspacing="0" cellpadding="0">
									<span id="get_money">应收金额：</span>
									<input type="text" name="" id="span1" style="color: black"
										class="simple-text" readonly="readonly" />
									<br />
									<span id="trust_money">实收金额：</span>
									<input type="text" value="" name="" id="text1"
										style="color: black" class="simple-text" placeholder="请输入收入金额"
										onblur="findChange()" />
									<br />
									<span id="zl_money">找&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;零：</span>
									<span id="zl-rest-son"></span>
								</table>
							</div>
							<div class="modal-footer">
								<input data-dismiss="modal" onclick="getMoney()" type="button"
									name="true-back" id="true-back" value="确定" /></a> <input
									data-dismiss="modal" type="button" value="关闭" id="true-back" />

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>