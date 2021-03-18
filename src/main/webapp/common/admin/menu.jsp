<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div id="sidebar" class="sidebar responsive">
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="ace-icon fa fa-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="ace-icon fa fa-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="ace-icon fa fa-users"></i>
				</button>

				<button class="btn btn-danger">
					<i class="ace-icon fa fa-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span>

				<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>
		<!-- /.sidebar-shortcuts -->


		<ul class="nav nav-list">

			<li class=""><a href="#" class="dropdown-toggle"> <i
					class="menu-icon fa fa-list"></i> <span class="menu-text">
						Quản lí  </span> <b class="arrow fa fa-angle-down"></b>
			</a> <b class="arrow"></b>

				<ul class="submenu">
					<li><a
						href='<c:url value="/admin/mon-an/danh-sach?page=1&limit=2"/>'>
							<i class="menu-icon fa fa-caret-right"></i> Danh sách món ăn
					</a> <b class="arrow"></b></li>
					<li><a
						href='<c:url value="/admin/the-loai/danh-sach?page=1&limit=2"/>'>
							<i class="menu-icon fa fa-caret-right"></i> Danh sách thể loại
					</a> <b class="arrow"></b></li>

				</ul></li>
		</ul>

		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left"
				data-icon1="ace-icon fa fa-angle-double-left"
				data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>

		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'collapsed')
			} catch (e) {
			}
		</script>
	</div>

</body>
</html>