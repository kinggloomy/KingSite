<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="panel panel-primary">
    <div class="panel-heading">
        Article Edit
    </div>
    <div class="panel-body">

        <form id="article" class="" role="form">
            <div id="hidden_input" style="display: none">
                <input name="id" value="${article.id}"/>
                <input name="publishDate"
                       value="<fmt:formatDate value="${article.publishDate}" pattern="yyyy-MM-dd HH-mm-ss" />"/>
                <input name="authorUserId" value="${article.authorUserId}"/>

            </div>
            <div class="form-group ">
                <label for="title">Title</label>

                <div class="">
                    <input type="text" class="form-control " name="title" value="${article.title}" id="title"
                           placeholder="Please Input Title">
                    <label for="index">Index</label>
                    <input type="text" class="form-control " name="index" value="${article.index}" id="index"
                           placeholder="Please Input Index"
                           onkeyup="value=value.replace(/[^\d]/g,'') "
                           onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                    />
                </div>

                <label for="typeId">Article Type</label>
                <select class="form-control " name="articleTypeId" id="typeId">
                    <c:forEach items="${types}" var="type">
                        <c:if test="${type.id==article.articleTypeId}">
                            <option value="${type.id}" selected="selected">${type.typeName}</option>
                        </c:if>
                        <c:if test="${type.id!=article.articleTypeId}">
                            <option value="${type.id}">${type.typeName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <div class="">
                    <div class="checkbox">
                        <label>
                            <c:if test="${article.privateFlag}">
                                <input name="privateFlag" value="true" type="checkbox" checked="checked"> SelfRead
                            </c:if>
                            <c:if test="${!article.privateFlag}">
                                <input name="privateFlag" value="true" type="checkbox"> SelfRead
                            </c:if>

                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4" for="editor">Article Content</label>
                <br>
            </div>
            <div>
                <textarea id="editor" name="content" style="height:400px">${article.content}</textarea>
            </div>
        </form>
    </div>

    <div class="pull-right ">
        <div class="">
            <br>
            <button id="add_button" type="button" class="btn btn-info" onclick="saveArticle()">Confirm</button>
            <button id="draft_button" type="button" class="btn btn-info">Save Draft</button>
            <button id="cancel_button" type="button" class="btn btn-info" onclick="articleList()">Give Up</button>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body" id="modalBody">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
