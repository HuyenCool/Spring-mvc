<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/the-loai" />
<c:url var="CategoryURL" value="/admin/the-loai/chinh-sua" />
<c:url var="CategoryURL1" value="/admin/the-loai/danh-sach" />
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
					<li class="active">Chỉnh sửa thể loại/li>
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
								<label class="col-sm-3 control-label no-padding-right">Tên thể loại</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="name" name="name"
										value="${category.name}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mã thể loại</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="code"
										name="code" value="${category.code}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty category.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateCategory">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật thể loại
											
										</button>
									</c:if>
									<c:if test="${empty category.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateCategory">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm thể loại
										</button>
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${category.id}" id="id" name="id" />
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

	
	
	$('#btnAddOrUpdateCategory').click(function (e) {
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
            	
            	window.location.href = "${CategoryURL1}?id="+result.id+"&message=insert_success";
            	
            },
            error: function (error) {
            	
            	
            	window.location.href = "${CategoryURL}?page=1&limit=2&message=update_success";
            	
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
            	
            	window.location.href = "${CategoryURL1}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	
            	
            	window.location.href = "${CategoryURL}?page=1&limit=2&message=update_success";
            }
        });
    }
    
</script>
</body>
</html>
