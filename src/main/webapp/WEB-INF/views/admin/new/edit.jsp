<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/mon-an" />
<c:url var="NewURL" value="/admin/mon-an/chinh-sua" />
<c:url var="NewURL1" value="/admin/mon-an/danh-sach" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>

			<div class="page-content">

				<div class="row">
					<div class="col-xs-12">

						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>

						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<c:if test="${empty dish.categoryCode}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty dish.categoryCode}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if test="${item.code == dish.categoryCode}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${dish.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình
									đại diện</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="thumbnail"
										name="thumbnail" value="${dish.thumbnail}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortdescription"
										name="shortdescription" value="${dish.shortdescription}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội
									dung</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" id="content" name="content"
										style="margin: 0px; width: 815px; height: 157px;">${dish.content}</textarea>

								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty dish.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài
											viết
										</button>
									</c:if>
									<c:if test="${empty dish.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
										</button>
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${dish.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	
	<!-- Những gì trong hàm document thì sẽ đucợ thực thi đều tiên-->
	var ckeditor = ""
	$(document).ready(function(){
		ckeditor = CKEDITOR.replace("content"); <!-- bên trong là id--> 
		});

	
	
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    data["content"] = ckeditor.getData(); <!-- get dữ liệu từ Ckeditor vào data-->
	    var id = $('#id').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});

    
    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	
            	window.location.href = "${NewURL1}?id="+result.id+"&page=1&limit=2&message=insert_success";
            	
            },
            error: function (error) {
            	
            	
            	window.location.href = "${NewURL}?message=error_system";
            	
            }
        });
    }
    
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',<!-- URl là cái mà API muốn call và cần thông qua 1 cáu c:url-->
            type: 'PUT', <!-- kiểu dữ liệu mapping vs thang API-->
            contentType: 'application/json', <!-- kiểu dlieu gửi từ client về server , ở đây gửi dạng json-->
            data: JSON.stringify(data), <!-- data : dlieu cần gửi lên; chuyển  từ JavaScrip Object sang Json-->
            dataType: 'json',
            success: function (result) {
            	
            	window.location.href = "${NewURL1}?id="+result.id+"&page=1&limit=2&message=update_success";
            },
            error: function (error) {
            	
            	
            	window.location.href = "${NewURL}?message=error_system";
            }
        });
    }
    
</script>
</body>
</html>
