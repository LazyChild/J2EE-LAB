<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container">
    <div class="modal hide fade" id="upload-modal" data-keyboard="false" style="display: none;" aria-hidden="true">
        <form id="upload-form" enctype="multipart/form-data" method="post">
            <div class="modal-header">
                <button class="close" data-dismiss="modal" aria-hidden="true">x</button>
                <h3>上传文件</h3>
            </div>
            <div class="modal-body">
                <p>你可以上传不超过 <strong>2MB</strong> 的任何文件并获取一个分享码与他人分享你的文件。</p>
                <input name="file" class="class-input" type="file"/>
            </div>
            <div class="modal-footer">
                <span id="uploading" class="pull-left hide"><img src="img/loading.gif"/> 上传中，请稍后...</span>
                <input class="btn btn-primary" value="上传" type="submit"/>
            </div>
        </form>
    </div>
    <a type="button" class="btn btn-primary" data-toggle="modal" href="#upload-modal">上传</a>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#upload-form").submit(function (e) {
            $("#uploading").fadeIn();
        });
    });
</script>
</body>
</html>