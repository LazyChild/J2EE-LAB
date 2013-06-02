<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/labfinal/include/header.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/labfinal/include/navbar.jsp" flush="true">
    <jsp:param name="active" value="index"/>
</jsp:include>
<div class="container">
    <div class="modal hide fade" id="upload-modal" data-keyboard="false">
        <form id="upload-form" enctype="multipart/form-data" method="post" action="file">
            <div class="modal-header">
                <button class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3>上传文件</h3>
            </div>
            <div class="modal-body">
                <p>你可以上传不超过 <strong>1MB</strong> 的任何文件并获取一个提取码与他人分享你的文件。</p>
                <input name="file" class="class-input" type="file"/>
            </div>
            <div class="modal-footer">
                <span id="uploading" class="pull-left hide"><img src="img/loading.gif"/> 上传中，请稍后...</span>
                <input class="btn btn-primary" value="上传" type="submit"/>
            </div>
        </form>
    </div>
    <div class="modal hide fade" id="download-modal" tabindex="-1">
        <form id="download-form" action="file">
            <input type="hidden" name="download"/>

            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>

                <h3>下载文件</h3>
            </div>
            <div class="modal-body">
                <label>提取码：</label>
                <input type="text" name="key" id="token-input" maxlength="10" autocomplete="off"><br>

                <p class="help-block">请不要省略开头和末尾的0！</p>
            </div>
            <div class="modal-footer">
                <span id="downloading" class="pull-left hide">下载中，请稍后...</span>
                <input class="btn btn-primary" type="submit" value="下载">
            </div>
        </form>
    </div>
    <div class="row">
        <div class="span8 offset2 well">
            <h3>FDisk - 复旦云</h3>
            <br>

            <p>U盘插拔<strong>不方便</strong>？还容易<strong>感染病毒</strong>？</p>

            <p>论文？课件？试题？图片？策划案？</p>

            <p>FDisk - <strong>复旦云</strong>！上传，提取码，下载。<strong>高效传输</strong>小文件！</p>
            <hr>
            <p>复旦云是高效的校园内网文件传输、文件共享的解决方案。</p>

            <p>登录更可享受<strong>文件管理</strong>、<strong>打印递送</strong>等更多功能。</p>
        </div>
    </div>
    <div class="row">
        <div class="span2 offset3">
            <a type="button" class="btn btn-primary index-button" data-toggle="modal" href="#upload-modal">上传</a>
        </div>
        <div class="span2 offset2">
            <a type="button" class="btn btn-primary index-button" data-toggle="modal" href="#download-modal">下载</a>
        </div>
    </div>
</div>
</body>
</html>