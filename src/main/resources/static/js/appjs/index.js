
var prefix = "/addressbook"
$(function() {
	load();
	$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
	$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
});
function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/getaddressbook", // 服务器数据的加载地址
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : false, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				singleSelect : false, // 设置为true将禁止多选
				pageSize : 50, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				pageList: [],        //可供选择的每页的行数（*）
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						option : $('#option').val(),
						name : $('#name').val(),
						offic : $('#offic').val()
					};
				},
				// 返回false将会终止请求
				columns : [
					{
						field: 'no',
		                title: '序号',
		                sortable: true,
		                align: "center",
		                width: '5%',
		                formatter: function (value, row, index) {
		                    return index+1;
		                }
					},
					{
						field : 'cheZhan',
						title : '车站',
						align : 'center',
						width : '10%'
					},
					{
						field : 'cheKongShi',
						title : '车控室',
						align : 'center',
						width : '10%'
					},
					{
						field : 'name',
						title : '姓名',
						align : 'center',
						width : '10%'
					},
					{
						field : 'job',
						title : '职务',
						align : 'center',
						width : '15%'
					},
					{
						field : 'office',
						title : '办公室',
						align : 'center',
						width : '17%'
					},
					{
						field : 'mobile',
						title : '联系电话',
						align : 'center',
						width : '10%'
					},
					{
						field : 'shortMobile',
						title : '集团短号',
						align : 'center',
						width : '10%'
					},
					{
						field : 'landline',
						title : '办公电话',
						align : 'center',
						width : '15%' 
					},
					{
						field : 'shortLandline',
						title : '内线号码',
						align : 'center',
						width : '10%'
					},
					{
						field : 'qq',
						title : 'QQ',
						align : 'center',
						width : '10%'
					}]
			});
}
function reLoad() {
	var opt = {
		query : {
			option : $('#option').val(),
			name : $('#name').val(),
			offic : $('#offic').val()
		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}

function cilckoffic(val) {
	if('sy' == val) {
		document.getElementById("text").innerHTML = "徐州地铁运营公司通讯录";
		document.getElementById("printTital").innerHTML = "徐州地铁运营公司通讯录";
		$("#offic").val("sy");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('bgs' == val) {
		document.getElementById("text").innerHTML = "办公室通讯录";
		document.getElementById("printTital").innerHTML = "办公室通讯录";
		$("#offic").val("bgs");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('rlzy' == val) {
		document.getElementById("text").innerHTML = "人力资源通讯录";
		document.getElementById("printTital").innerHTML = "人力资源通讯录";
		$("#offic").val("rlzy");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('dqgz' == val) {
		document.getElementById("text").innerHTML = "党群工作部通讯录";
		document.getElementById("printTital").innerHTML = "党群工作部通讯录";
		$("#offic").val("dqgz");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('aqjs' == val) {
		document.getElementById("text").innerHTML = "安全技术部通讯录";
		document.getElementById("printTital").innerHTML = "安全技术部通讯录";
		$("#offic").val("aqjs");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('qh' == val) {
		document.getElementById("text").innerHTML = "企划部通讯录";
		document.getElementById("printTital").innerHTML = "企划部通讯录";
		$("#offic").val("qh");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('wz' == val) {
		document.getElementById("text").innerHTML = "物资部通讯录";
		document.getElementById("printTital").innerHTML = "物资部通讯录";
		$("#offic").val("wz");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('ddpw' == val) {
		document.getElementById("text").innerHTML = "调度票务部通讯录";
		document.getElementById("printTital").innerHTML = "调度票务部通讯录";
		$("#offic").val("ddpw");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('zd' == val) {
		document.getElementById("text").innerHTML = "调度票务部--总调室通讯录";
		document.getElementById("printTital").innerHTML = "调度票务部--总调室通讯录";
		$("#offic").val("zd");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('pw' == val) {
		document.getElementById("text").innerHTML = "调度票务部--票务室通讯录";
		document.getElementById("printTital").innerHTML = "调度票务部--票务室通讯录";
		$("#offic").val("pw");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('ky' == val) {
		document.getElementById("text").innerHTML = "客运部通讯录";
		document.getElementById("printTital").innerHTML = "客运部通讯录";
		$("#offic").val("ky");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('zw' == val) {
		document.getElementById("text").innerHTML = "客运部--站务室通讯录";
		document.getElementById("printTital").innerHTML = "客运部--站务室通讯录";
		$("#offic").val("zw");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('cw' == val) {
		document.getElementById("text").innerHTML = "客运部--乘务室通讯录";
		document.getElementById("printTital").innerHTML = "客运部--乘务室通讯录";
		$("#offic").val("cw");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('cz' == val) {
		document.getElementById("text").innerHTML = "客运部--车站通讯录";
		document.getElementById("printTital").innerHTML = "客运部--车站通讯录";
		$("#offic").val("cz");
		reLoad();
		$('#exampleTable').bootstrapTable('showColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('showColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('hideColumn', 'office');
	} else if ('cl' == val) {
		document.getElementById("text").innerHTML = "车辆部通讯录";
		document.getElementById("printTital").innerHTML = "车辆部通讯录";
		$("#offic").val("cl");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('jx' == val) {
		document.getElementById("text").innerHTML = "车辆部--检修室通讯录";
		document.getElementById("printTital").innerHTML = "车辆部--检修室通讯录";
		$("#offic").val("jx");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('sb' == val) {
		document.getElementById("text").innerHTML = "车辆部--设备室通讯录";
		document.getElementById("printTital").innerHTML = "车辆部--设备室通讯录";
		$("#offic").val("sb");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('jdss' == val) {
		document.getElementById("text").innerHTML = "机电设施部通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部通讯录";
		$("#offic").val("jdss");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('gds' == val) {
		document.getElementById("text").innerHTML = "机电设施部--供电室通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部--供电室通讯录";
		$("#offic").val("gds");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('gjs' == val) {
		document.getElementById("text").innerHTML = "机电设施部--工建室通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部--工建室通讯录";
		$("#offic").val("gjs");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('jds' == val) {
		document.getElementById("text").innerHTML = "机电设施部--机电室通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部--机电室通讯录";
		$("#offic").val("jds");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('zdh' == val) {
		document.getElementById("text").innerHTML = "机电设施部--自动化室通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部--自动化室通讯录";
		$("#offic").val("zdh");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} else if ('th' == val) {
		document.getElementById("text").innerHTML = "机电设施部--通号室通讯录";
		document.getElementById("printTital").innerHTML = "机电设施部--通号室通讯录";
		$("#offic").val("th");
		reLoad();
		$('#exampleTable').bootstrapTable('hideColumn', 'cheZhan');
		$('#exampleTable').bootstrapTable('hideColumn', 'cheKongShi');
		$('#exampleTable').bootstrapTable('showColumn', 'office');
	} 
}