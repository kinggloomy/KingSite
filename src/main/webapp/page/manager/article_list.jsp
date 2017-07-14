<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://harlanking.com/tag/otj" prefix="json"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="note" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            Article List
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Index</th>
                        <th>Title</th>
                        <th>Publish Date</th>
                        <th>Type</th>
                        <th>Auth User</th>
                        <th>Self Read</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${list}" varStatus="status">
                        <c:if test="${item.privateFlag}">
                            <tr class ="danger">
                        </c:if>
                        <c:if test="${!item.privateFlag}">
                            <tr class ="info">
                        </c:if>
                            <th scope="row">${status.index+1}</th>
                            <td>${item.index}</td>
                            <td>${item.title}</td>
                            <td>
                                <fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd HH-mm-ss" />
                            </td>
                            <td>${item.title}</td>
                            <td>${item.title}</td>
                            <td>
                                <c:if test="${item.privateFlag}">

                                    <span class="label label-primary">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        Private
                                    </span>
                                </c:if>
                                <c:if test="${!item.privateFlag}">
                                    <span class="label label-info">
                                        <span class="glyphicon glyphicon-unchecked" aria-hidden="true"></span>
                                        Public
                                    </span>
                                </c:if>
                            </td>
                            <td>
                                <div>
                                     <%--<json:jsvar value="${item}" var="_${item.id}"/>--%>

                                    <button id="edit_button" type="button" class="btn btn-info" onclick="toAddArticle(${item.id})">Edit</button>
                                    <button id="delete_button" type="button" class="btn btn-info">Delete</button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="panel-footer">
            Total Article qty : ${fn:length(list)}
        </div>
        <div class="pull-right ">
            <div class="">
                <br>
                <button id="to_add_article_down" type="button" class="btn btn-info" onclick="toAddArticle(null)">Add</button>
            </div>

        </div>
    </div>
