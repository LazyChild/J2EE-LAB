$(document).ready(function () {
    $("#upload-form").submit(function (e) {
        $("#uploading").fadeIn();
    });
    $("#download-form").submit(function (e) {
        $("#downloading").fadeIn();
    });
    $(".close").click(function() {
        $(this).parent(".alert").fadeOut();
    });
});