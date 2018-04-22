$(function() {
	loadMenu();
});
function loadMenu() {
	$.post("admin/sysMenus/getSysMenusWithTreeStructure", null, function(r) {
		if (r.success) {
			if (r.data) {

				$("#menuContent").children().remove();

				console.log(r.data[0]);
				createMenuItem(r.data[0]);
			}
		} else {
			console.log(r.error);
			alert(r.message);
		}
	});
}

function createMenuItem(parent) {
	if (parent.children != null) {
		$.each(parent.children, function() {

			var firstLevelMenu = null;
			if (this.uri) {
				firstLevelMenu = '<ul class="nav nav-list"><a href="' + this.uri + '?title=' + this.title + '&pagePath=' + this.pagePath + '">' + this.name + '</a></ul>';
				$("#menuContent").append(firstLevelMenu);
			} else {
				firstLevelMenu = '<ul class="nav nav-list""><a href="javascript:void(0);">' + this.name + '</a></ul>'
				$("#menuContent").append(firstLevelMenu);
			}
			if (this.children != null && this.children.length > 0) {
				var subMenu = "<ul>";
				$.each(this.children, function() {
					subMenu += '<li><a href="' + this.uri + '/page?title=' + this.title + '&pagePath=' + this.pagePath + '">' + this.name + '</a></li>';
				});
				subMenu += "</ul>";
				$(subMenu).appendTo(firstLevelMenu);
			}
		});
	}
}
