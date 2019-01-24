/**
 * 常量参数
 */
var CONST_PARAM = {
	SPLIT_CHAR : ":", // 构造各种key的连接字符
	PX_UNIT : 50, // 像素单位
	PX_FACTOR_ARR_W : [ 100, 150, 200, 250, 300, 350, 400, 450, 500 ],
	PX_FACTOR_ARR_H :  [ 300, 300, 300, 300, 300, 300, 300, 300, 300],
	SCREEN_W : $(window).width(),
	PX_WIDTH : Math.floor( $(window).width()/50 ) * 50,
	PX_WIDTH_MIN : 500,
	POWER_W : Math.floor( $(window).width()/50 )
}
//var panel_map = new Map(); // FreePanel map，key是panel的长宽，value是FreePanel数组
//var free_panel_arr = fun_simulate_panel(100);
//var free_panel_matrix = fun_convert_matrix(free_panel_arr); // FreePanel 矩阵
//var cardStyle = new Array(100);
//
//console.log("=========自由panel模拟数据==========");
//console.log(free_panel_arr);
//console.log("=========自由panel的缓冲map==========");
//console.log(panel_map);
//console.log("=========自由panel的矩阵==========");
//console.log(free_panel_matrix);
//console.log("=========自由panel的矩阵格式化输出==========");
//for(var i=0; i<free_panel_matrix.length; i++){
//	var str = "";
//	for(var j=0; j<free_panel_matrix[i].length; j++){
//		str = str + (i +2) + "," + (j + 2) + "(" + free_panel_matrix[i][j].length + ") ";
//	}
//	console.log(str);
//}
//fun_sinulate_panel_html();
/**
 * 模拟生成FreePanel
 * 
 * @param num
 * @returns
 */
function fun_simulate_panel(num) {
	var retArr = new Array(num);
	for (var i = 0; i < num; i++) {
		var w_index = Math.round(Math.random()
				* (CONST_PARAM.PX_FACTOR_ARR_W.length - 1));
		var h_index = Math.round(Math.random()
				* (CONST_PARAM.PX_FACTOR_ARR_H.length - 1));
		var aFreePanel = new FreePanelObj(CONST_PARAM.PX_FACTOR_ARR_W[w_index],
				CONST_PARAM.PX_FACTOR_ARR_H[h_index]);
		retArr[i] = aFreePanel;
		var key = aFreePanel.width + CONST_PARAM.SPLIT_CHAR + aFreePanel.height;
		if (panel_map.has(key)) {
			var tempArr = panel_map.get(key);
			tempArr.push(aFreePanel);
			panel_map.set(key, tempArr);
		} else {
			var tempArr = new Array();
			tempArr.push(aFreePanel);
			panel_map.set(key, tempArr);
		}
	}
	return retArr;
}
function fun_sinulate_panel_html(){
	var html = "";
	var index = 0;
	for(var i=0; i<free_panel_matrix.length ; i++){
		for(var j=0; j<free_panel_matrix[i].length; j++){
			var panelArr = free_panel_matrix[i][j];
			if(panelArr.length > 0){
				for(var k=0; k<panelArr.length; k++){
					cardStyle[index] = fun_get_panel_style(panelArr[k].width, panelArr[k].height);
					var htmlLine = "<el-card shadow=\"hover\" v-bind:style=\"cardStyle[" + index + "]\">"
						//+"<img v-bind:style=\"imageStyle[" + i + "]\" src=\"" + imageUrl + "\" title=\"第【" + i + " 】张图片\" />"
						+ "<div style=\"padding-top:4px;\"><i class=\"el-icon-time\">2014-09-21 12:45:24</i></div>"
						+ "<div  style=\"padding-top:4px;\"><i class=\"el-icon-location\">中国 北京</i></div> "
						+ "<div  style=\"padding-top:4px;\"><el-rate v-model=\"4.5\"></el-rate></div>"
						+ "</el-card>";
					html = html + htmlLine;
					index ++;
				}
			}
		}
	}
	return html;
}
function fun_sinulate_panel_html2(){
	var html = "";
	for(var i=0; i<free_panel_arr.length ; i++){
		cardStyle[i] = fun_get_panel_style(free_panel_arr[i].width, free_panel_arr[i].height);
		var htmlLine = "<el-card shadow=\"hover\" v-bind:style=\"cardStyle[" + i + "]\">"
			//+"<img v-bind:style=\"imageStyle[" + i + "]\" src=\"" + imageUrl + "\" title=\"第【" + i + " 】张图片\" />"
			+ "<div style=\"padding-top:4px;\"><i class=\"el-icon-time\">2014-09-21 12:45:24</i></div>"
			+ "<div  style=\"padding-top:4px;\"><i class=\"el-icon-location\">中国 北京</i></div> "
			+ "<div  style=\"padding-top:4px;\"><el-rate v-model=\"4.5\"></el-rate></div>"
			+ "</el-card>";
		html = html + htmlLine;
	}
	return html;
}
/**
 * 自由panel数组转化为矩阵
 * @param panel_arr
 * @returns
 */
function fun_convert_matrix(panel_arr){
	var one_dim_arr = new Array(CONST_PARAM.PX_FACTOR_ARR_W.length);
	for(var i=0; i<one_dim_arr.length; i++){
		var two_dim_arr = new Array(CONST_PARAM.PX_FACTOR_ARR_W.length);
		for(var j=0; j<two_dim_arr.length; j++){
			var three_dim_arr = new Array();
			var key = (j+2)*CONST_PARAM.PX_UNIT + CONST_PARAM.SPLIT_CHAR + (i+2)*CONST_PARAM.PX_UNIT;
			if(panel_map.has(key)){
				three_dim_arr = three_dim_arr.concat(panel_map.get(key));
			}
			two_dim_arr[j] = three_dim_arr;
		}
		one_dim_arr[i] = two_dim_arr;
	}
	return one_dim_arr;
}
/**
 * FreePanel 对象定义
 * 
 * @param width
 *            panel的宽度
 * @param height
 *            panel的高度
 * @param x_axis
 *            panel的x坐标
 * @param y_axis
 *            panel的y坐标
 * @param top
 *            panel的top offset
 * @param bottom
 *            panel的bottom offset
 * @param left
 *            panel的left offset
 * @param right
 *            panel的right offset
 * @returns
 */
function FreePanelObj(width, height, x_axis, y_axis, top, bottom, left, right) {
	this.width = width;
	this.height = height;
	this.x_axis = x_axis;
	this.y_axis = y_axis;
	this.top = top;
	this.bottom = bottom;
	this.left = left;
	this.right = right;
}
/**
 * 坐标定义
 * @param x
 * @param y
 * @returns
 */
function CoordinateObj(x, y) {
	this.x_axis = x;
	this.y_axis = y;
}
/**
 * key的哈希函数
 * @param map_key
 * @returns
 */
function fun_key_hash(map_key) {
	var key_arr = map_key.split(CONST_PARAM.SPLIT_CHAR);
	if (key_arr && key_arr.length == 2) {
		var x_axis = key_arr[0] / CONST_PARAM.PX_UNIT;
		var y_axis = key_arr[1] / CONST_PARAM.PX_UNIT;
		var retAxis = new TwoDimArrAxis(x_axis, y_axis);
		return retAxis;
	} else {
		return null;
	}
}
function fun_get_panel_style(w, h, padding, float, margin) {
	var panel_style = {
			width : w + "px",
			height : h + "px",
			padding : "0px",
			float : 'left',
			margin : '2px'
	}
	return panel_style;
}