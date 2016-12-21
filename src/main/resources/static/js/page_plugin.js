var ocpweb_page = function(options) {
	var defaults = {
		totalPage: 0,
		currentPage: 1,
		maxVisible: 10
	};
	
	var settings = $.extend({}, defaults, options);
	
	var pageShowTmp = "";
		
	var rangPage =  Math.ceil(settings.currentPage/settings.maxVisible);
	if (rangPage <= 0) {
		rangPage = 1;
	}
	
	var currentMaxPage = Math.min(settings.totalPage,  rangPage * settings.maxVisible);
	var currentMinPage = Math.min(settings.totalPage,  (rangPage - 1) * settings.maxVisible + 1);
	
	if (settings.totalPage == 0 || settings.currentPage == 1) {
		pageShowTmp = pageShowTmp + "<li class=\"disabled\"><a href=\"void(0)\">&laquo;</a></li>";
		pageShowTmp = pageShowTmp + "<li class=\"disabled\"><a href=\"void(0)\">&lt;</a></li>";
	} else if(settings.currentPage >= 1 && rangPage == 1) {
		pageShowTmp = pageShowTmp + "<li ><a ng-click=\"" + settings.func + "({pageNo:1})\">&laquo;</a></li>";
		pageShowTmp = pageShowTmp + "<li ><a ng-click=\"" + settings.func + "({pageNo:" + (settings.currentPage - 1)+"})\">&lt;</a></li>";
	} else {
		pageShowTmp = pageShowTmp + "<li ><a ng-click=\"" + settings.func + "({pageNo:1})\">&laquo;</a></li>";
		pageShowTmp = pageShowTmp + "<li ><a ng-click=\"" + settings.func + "({pageNo:" + (currentMinPage - 1) + "})\">&lt;</a></li>";
	}
	
	var pageNo = currentMinPage;
	for (; pageNo > 0 && pageNo <= currentMaxPage; pageNo++) { 
		if (settings.currentPage == pageNo) {
			pageShowTmp = pageShowTmp + "<li class=\"active\" ><a ng-click=\"" + settings.func + "({pageNo:" + (pageNo) + "})\">" +pageNo+ "</a></li>";
		} else {
			pageShowTmp = pageShowTmp + "<li ><a ng-click=\"" + settings.func + "({pageNo:" + (pageNo) + "})\">" +pageNo+ "</a></li>";
		}
	}

	if (settings.totalPage == 0 || settings.currentPage == settings.totalPage) {
		pageShowTmp = pageShowTmp + "<li class=\"disabled\"><a href=\"void(0)\">&gt;</a></li>";
		pageShowTmp = pageShowTmp + "<li class=\"disabled\"><a href=\"void(0)\">&raquo;</a></li>";
	} else if (rangPage >= 1 && (rangPage == Math.ceil(settings.totalPage/settings.maxVisible))){
		pageShowTmp = pageShowTmp + "<li><a ng-click=\"" + settings.func + "({pageNo:" + (settings.currentPage*1 + 1) + "})\">&gt;</a></li>";
		pageShowTmp = pageShowTmp + "<li><a ng-click=\"" + settings.func + "({pageNo:" + (settings.totalPage) + "})\">&raquo;</a></li>";
	} else {
		pageShowTmp = pageShowTmp + "<li><a ng-click=\"" + settings.func + "({pageNo:" + (currentMaxPage*1 + 1) + "})\">&gt;</a></li>";
		pageShowTmp = pageShowTmp + "<li><a ng-click=\"" + settings.func + "({pageNo:" + (settings.totalPage) + "})\">&raquo;</a></li>";
	}
	
	return pageShowTmp;
}