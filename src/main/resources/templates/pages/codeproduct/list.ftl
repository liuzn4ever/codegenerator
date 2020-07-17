<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <#assign base=request.contextPath>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title></title>
<link href="${base}/static/omui/css/elegant/om-all.css" rel="stylesheet" type="text/css" />
<link href="${base}/static/admin/css/admin.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${base}/static/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${base}/static/js/HForm.js"></script>
<script type="text/javascript" src="${base}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${base}/static/omui/js/operamasks-ui.min.js"></script>
<script type="text/javascript" src="${base}/static/omui/js/common.js"></script>
<script type="text/javascript" src="${base}/static/bui/js/common.js"></script>
<script type="text/javascript" src="${base}/static/admin/js/export.js"></script>

<script type="text/javascript">


	$().ready(function(){

		//初始化控件
		$("#search-panel").omPanel({
			title : "条件搜索",collapsible:false
		});

		//搜索
		$('#searchButton').bind('click', function(e) {
		     var data = $("#listForm").HForm('form2json');
		     $('#listGrid').omGrid({extraData:data});
		});

		$("#start-time").omCalendar();
		$("#time-end").omCalendar();

		 $('#searchButton').omButton({
		 	icons : {left : '${base}/static/omui/images/search.png'},width : 70
		 });

        $(".input-select").change(function(){
            $('#searchButton').click();
        });

		$('#buttonbar').omButtonbar({
			btns : [{label:"导出Excel",
						id:"addbutton" ,
						icons : {left : '${base}/static/omui/images/export.png'},
						onClick:function()
							{
								exportUtil({
									title : "列表导出",
									exportUrl : "${base}/admin/codeProduct/searchList",
									extraParam : $("#listForm").HForm('form2json')
								});
							}
						}
					]
		});


		//初始化列表
		var  height=$(document).height() -$('#search-panel').outerHeight()-$('#buttonbar').outerHeight()-40;
		$('#listGrid').omGrid({
			height:height,
			limit:20,
			method:'post',
			singleSelect:false,
			extraData:$("#listForm").HForm('form2json'),
			dataSource : '${base}/admin/codeProduct/searchList',
			colModel : [
			            {header : 'ID', name : 'id', width : 30, align : 'left',sort:'serverSide'},
						{header : '创建时间', name : 'createDate', width : 150, align : 'left',sort:'serverSide',renderer :dataFormat1},
						{header : '修改时间', name : 'modifyDate', width : 150, align : 'left',sort:'serverSide',renderer :dataFormat1},


			{header : '', name : 'id',width : 90, align : 'left',sort:'serverSide'},


			{header : '创建时间', name : 'createDate',width : 90, align : 'left',sort:'serverSide'},


			{header : '更新时间', name : 'modifyDate',width : 90, align : 'left',sort:'serverSide'},


			{header : '姓名', name : 'name',width : 90, align : 'left',sort:'serverSide'},


			{header : '手机号', name : 'mobile',width : 90, align : 'left',sort:'serverSide'},


			{header : '生成时间', name : 'bulidDate',width : 90, align : 'left',sort:'serverSide',renderer :dataFormat1 },


			{header : '公司名称', name : 'companyName',width : 90, align : 'left',sort:'serverSide'},


			{header : '主营商品', name : 'shopGoods',width : 90, align : 'left',sort:'serverSide'},


			{header : '备注信息', name : 'otherInfo',width : 90, align : 'left',sort:'serverSide'},


			{header : '状态', name : 'status',width : 90, align : 'left',sort:'serverSide'},


			{header : '处理人', name : 'operator',width : 90, align : 'left',sort:'serverSide'},
			],
			rowDetailsProvider:function(rowData){
			}
		});

		//初始化控件  end
		function getIds(datas) {
			var str = "";
			for (var i = 0; i < datas.length; i++) {
				str += datas[i].id + ",";
			}
			//去掉最后一个逗号(如果不需要去掉，就不用写)
			if (str.length > 0) {
				str = str.substr(0, str.length - 1);
			}
			return str;
		}

		$('#searchButton').click();
	});



</script>
</head>
<body >

<div id="search-panel">
    <form id="listForm">
	<div>
		<span class="label">状态:</span>
		<select class="js-example-basic-single input-select"  name="filter_EQS_status">
			<option value="0" selected>待处理</option>
			<option value="1">已处理</option>
			<option value="">全部</option>
		</select>
		<span class="label">手机号：</span>
		<input type="text" class="input-text" name="filter_LIKES_mobile" />
		<span class="label">联系人：</span>
		<input type="text" class="input-text" name="filter_LIKES_name" />
		<span class="label">创建时间：</span>
		<input id="start-time" style="width: 118px" name="filter_GTED_createDate"/>
		-
		<input id="time-end"  style="width: 118px" name="filter_LTED_createDate"/>
		<span id="searchButton">查询</span>
	</div>
	</form>
</div>

<div id="buttonbar"></div><!-- 工具栏位置 -->
<table id="listGrid"></table> <!-- 主列表位置 -->

</body>
</html>