
var prefix = "/user"
$(function() {
	load();
});
function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/personList", // 服务器数据的加载地址
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				singleSelect : false, // 设置为true将禁止多选
				pageSize : 20, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						title : $('#title').val()
					};
				},
				// 返回false将会终止请求
				columns : [
					{
						field : 'trueName',
						title : '姓名',
						align : 'center',
						width : '40%'
					},
					{
						field : 'hospital',
						title : '医院',
						align : 'center'
					},
					{
						field : 'insertTime',
						title : '上传时间',
						align : 'center'
					},
					{
						field : 'pptUrl',
						title : '下载连接',
						width : '15%',
						align : 'center'/*,
						formatter : function(value, row, index) {
							var v = '<input type="checkbox" onclick="typeFlag('+row.id+','+row.vedioShow+',\'vedioShow\')"';
							if (value == 1) {
								v = v.concat(" checked>");
							} else {
								v = v.concat(">");
							}
							return v;
						}*/
					}]
			});
}
function reLoad() {
	var opt = {
		query : {
		    title : $('#title').val()
		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}