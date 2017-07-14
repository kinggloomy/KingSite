var editor;
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};


$(function () {

    $("#to_add_article").on('click', function () {
        $.ajax({
            url: "manager/article/toAdd",
            async: true,
            success: function (result) {
                $("#content").html(result);
                editor = new wangEditor('editor');
                editor.create();

            },
            error: function (result) {
                $("#note").html(result)
                $("#note").show();
            }
        });
    });
    $("#article_list").click(function () {
        articleList();
    });
    $("#user_list").click(function () {
        $.ajax({
            url: "manager/user/list",
            async: false,
            success: function (result) {
                $("#content").html(result);
            },
            error: function (result) {
                $("#note").html(result)
                $("#note").show();
            }
        });
    });
    $("#about").click(function () {
        $.ajax({
            url: "manager/global/about",
            type: "POST",
            contentType: "application/json",
            success: function (result) {
                $("#content").html(result);
                globalshow("ABOUT");
            },
            error: function (result) {

            }
        });
    });
    $("#reason").click(function () {
        $.ajax({
            url: "manager/global/about",
            type: "POST",
            contentType: "application/json",
            success: function (result) {
                $("#content").html(result);
                globalshow("REASON");
            },
            error: function (result) {

            }
        });
    });
    $("#global").click(function () {
        $.ajax({
            url: "manager/global/",
            type: "POST",
            contentType: "application/json",
            success: function (result) {
                $("#content").html(result);
                globalshow(-1);
            },
            error: function (result) {

            }
        });
    });


});
function articleList() {
    $.ajax({
        url: "manager/article/list",
        async: false,
        success: function (result) {
            $("#content").html(result);
        },
        error: function (result) {
            $("#note").html(result)
            $("#note").show();
        }
    });
}
function saveArticle() {
    var article = $("#article").serializeObject();
    var data0 = JSON.stringify(article);
    $.ajax({
        url: "manager/article/save",
        data: data0,
        type: "POST",
        contentType: "application/json",
        success: function (data) {
            console.log(data)
            if (data.code == 2000) {
                $("#modalBody").html(data.content);
                $('#addModal').modal("show");
                $('#addModal').on('hidden.bs.modal', function (e) {
                    articleList();
                })
            } else {
                $("#modalBody").html(data.content);
                $('#addModal').modal("show");
                $('#addModal').on('hidden.bs.modal', function (e) {
                    articleList();
                })
            }
        },
        error: function (data) {
            $("#modalBody").html(data.responseText);
            $('#addModal').modal("show");
        }
    });
}
function addUser() {
    $.ajax({
        url: "manager/user/toAdd",
        type: "POST",
        success: function (result) {
            $("#content").html(result);
        },
        error: function (result) {
            $("#note").html(result)
            $("#note").show();
        }
    });
}
function toAddArticle(id) {
    $.ajax({
        url: "manager/article/edit/" + id,
        type: "POST",
        contentType: "application/json", //contentType很重要
        success: function (result) {
            $("#content").html(result);
            editor = new wangEditor('editor');
            editor.create();

            /*   editor.$txt.html(content);*/

        },
        error: function (result) {
            $("#modalBody").html(result.responseText)
            $("#note").modal('show');
        }
    });

}

function saveImage(type) {
    $.ajax({
        url: "manager/global/upload/image/" + type,
        type: "POST",
        contentType: "multipart/form-data", //contentType很重要
        data: {
            'file': $("#banner_input").val()
        },
        success: function (result) {
            console.log(result);
        },
        error: function (result) {
            $("#modalBody").html(result)
            $("#note").modal('show');
        }
    });
}

/*
 * Global
 * */

function globalshow(id) {
    $("#global_edit").hide("slow");
    $("#image").html("");
    var file_input = $("<input />");
    var img_id = $("<input />");
    file_input.attr("id", "image_input");
    file_input.attr("name", "file");
    file_input.attr("type", "file");
    file_input.attr("class", "file");
    img_id.attr("id", "global_img_id");
    img_id.attr("name", "imageId");
    img_id.attr("type", "text");
    img_id.hide();
    $("#image").html(file_input);
    $("#image_input").after(img_id);
    var urls = [];
    var previewConfigs = [];
    if (id != -1) {
        $.ajax({
            url: "manager/global/show/" + id,
            type: "POST",
            async: false,
            success: function (result) {
                if (id == "REASON" || id == "ABOUT") {
                    $("#global_select").append("<option value='" + result.globalKey + "'>" + result.globalKey + "<option>");
                    $("#image").hide();
                } else {
                    urls.push("manager/image/show/" + result.imageId+".jpg");
                    var config = Object();
                    config.url = "manager/image/deleteById/" + result.imageId;
                    config.key = result.imageId;
                    previewConfigs.push(config);
                    $("#title_input").attr("value", result.title);
                }
                $("#content_input").html(result.content);
                $("#key_input").attr("value", result.globalKey);
                $("#key_input").attr("readonly", "");

            },
            error: function (result) {
                $("#modalBody").html(result)
                $("#note").modal('show');
            }
        });
    } else {
        $("#key_input").attr("value", "");
        $("#key_input").removeAttr("readonly");
        $("#title_input").attr("value", "");
        $("#content_input").html("");
    }
    if (id != "REASON" || id != "ABOUT") {
        $("#image_input").fileinput({
            uploadUrl: "manager/image/upload/GLOBAL",//上传图片的url
            allowedFileExtensions: ['jpg', 'png', 'gif'],
            overwriteInitial: false,
            maxFileSize: 10240,//上传文件最大的尺寸
            maxFilesNum: 10,//上传最大的文件数量
            initialPreviewAsData: true,
            initialPreview: urls,
            initialPreviewConfig: previewConfigs,
            initialCaption: "please select global img",//文本框初始话value
            slugCallback: function (filename) {
                return filename.replace('(', '_').replace(']', '_');
            }
        });
        $('#image_input').on('fileuploaded', function (event, data) {
            var img_id = data.response.content[0];
            $("#global_img_id").attr("value", img_id);

        });
        $('#image_input').on('filedeleted', function (event, key) {
            $("#global_img_id").attr("value", "");
        });
    }
    $("#global_edit").show("slow");


}


function saveGlobal() {
    var data = $("#global_form").serializeObject();
    var data_json = JSON.stringify(data);
    $.ajax({
        url: "manager/global/save",
        type: "POST",
        contentType: "application/json", //contentType很重要
        data: data_json,
        success: function (result) {
            if (result.code == 2000) {
                $("#modalBody").html(result.content);
                $("#note").modal('show');

            } else {
                $("#modalBody").html(result.code + ";" + result.content);
                $("#note").modal('show');
            }
        },
        error: function (result) {
            $("#modalBody").html(result)
            $("#note").modal('show');
        }
    });

}

function image(type) {
    var urls = [];
    var previewConfigs = [];
    $.ajax({
        url: "manager/image/edit/" + type,
        type: "POST",
        async: false,
        contentType: "application/json",
        success: function (result) {
            $.ajax({
                url: "manager/image/ids/" + type,
                type: "POST",
                async: false,
                contentType: "application/json",
                success: function (data) {
                  $.each(data,function (index,item) {
                        urls.push("manager/image/show/" + item+".jpg");
                        var config = Object();
                        config.url = "manager/image/deleteById/" + item;
                        config.key = item;
                        previewConfigs.push(config);
                    });
                }
            });
            $("#content").html(result);

            $("#image_input").fileinput({
                uploadUrl: "manager/image/upload/" + type,//上传图片的url
                allowedFileExtensions: ['jpg', 'png', 'gif'],
                overwriteInitial: false,
                maxFileSize: 40960,//上传文件最大的尺寸
                maxFilesNum: 10,//上传最大的文件数量
                initialPreviewAsData: true,
                initialPreview: urls,
                initialPreviewConfig: previewConfigs,
                initialCaption: "please select " + type + " image",//文本框初始话value
                slugCallback: function (filename) {
                    return filename.replace('(', '_').replace(']', '_');
                }
            });
            $('#banner_input').on('fileuploaded', function (data) {
                console.log(data);//打印出返回的json
            });
        }


    });
}