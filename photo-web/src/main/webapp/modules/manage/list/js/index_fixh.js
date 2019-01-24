var CONST_PARAM = {
	PX_FACTOR_ARR_W : [ 100, 150, 200, 250, 300, 350, 400, 450, 500],
	PX_FACTOR_H : 300
}

function fun_get_image_style2 (width, height, panel_width, panle_height){
	var img_resize_w = panel_width;
	var img_resize_h = panel_height;
	if(height/width>=1){
		if(panel_height/panel_width >= height/width){
			img_resize_w = panel_width;
			img_resize_h = Math.round(img_resize_w/width * height);
		}else{
			img_resize_h = CONST_PARAM.PX_FACTOR_H;
	 		img_resize_w = Math.round(width * img_resize_h/height);
		}
	}else{
		if(panel_height/panel_width >= height/width){
	 		img_resize_h = CONST_PARAM.PX_FACTOR_H;
	 		img_resize_w = Math.round(width * img_resize_h/height);
		}else{
			img_resize_w = panel_width;
			img_resize_h = Math.round(img_resize_w/width * height);
		}
	}
	var style = {
			width : panel_width,
			height : panel_height,
			img_w : img_resize_w,
			img_h : img_resize_h
	}
	return style;
}

function fun_get_image_style (width, height){
	var a_style = fun_get_panel_style(width, height);
	var panel_width = a_style.width;
	var panel_height = a_style.height;
	var img_resize_w = panel_width;
	var img_resize_h = panel_height;
	if(height/width>=1){
		if(panel_height/panel_width >= height/width){
			img_resize_w = panel_width;
			img_resize_h = Math.round(img_resize_w/width * height);
		}else{
			img_resize_h = CONST_PARAM.PX_FACTOR_H;
	 		img_resize_w = Math.round(width * img_resize_h/height);
		}
	}else{
		if(panel_height/panel_width >= height/width){
	 		img_resize_h = CONST_PARAM.PX_FACTOR_H;
	 		img_resize_w = Math.round(width * img_resize_h/height);
		}else{
			img_resize_w = panel_width;
			img_resize_h = Math.round(img_resize_w/width * height);
		}
	}
	var style = {
			width : panel_width,
			height : panel_height,
			img_w : img_resize_w,
			img_h : img_resize_h
	}
	return style;
}
function fun_get_panel_style (width, height){
	var min_value = 100;
	var ratio = width/height;
	var ratio_index = 0;
	for(var i=0; i<CONST_PARAM.PX_FACTOR_ARR_W.length; i++){
		var ratio_temp = CONST_PARAM.PX_FACTOR_ARR_W[i]/CONST_PARAM.PX_FACTOR_H;
		var a_min = ratio - ratio_temp;
		if(a_min < min_value){
			ratio_index = i;
			min_value = a_min;
		}
	}
	var style = {
		width : CONST_PARAM.PX_FACTOR_ARR_W[ratio_index],
		height : 300
	}
	return style;
}
