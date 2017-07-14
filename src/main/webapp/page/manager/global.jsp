<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://harlanking.com/tag/otj" prefix="json" %>
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
        Global Config
    </div>
    <div class="panel-body">
        <form id="global_form">
            <div id="form_body">
                <div id="global_list">
                    <c:if test="${globals!=null}">
                        <select id="global_select" class="form-control"
                                onchange="globalshow(this.options[this.options.selectedIndex].value)">
                            <option value="-1">Please selected one item to edit</option>
                            <c:forEach var="global" items="${globals}" varStatus="status">
                                <option value="${global.globalKey}">${global.globalKey}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                    <c:if test="${globals==null}">
                    <select id="global_select" class="form-control" disabled>

                    </select>
                    </c:if>

                </div>
                <div id="global_edit" style="display: none">
                    <div id="global_key">
                        <div class="form-group">
                            <label for="key_input">Key</label>
                            <input type="text" class="form-control" id="key_input" name="globalKey" placeholder="key"
                                   value="">
                        </div>
                    </div>
                    <div id="global_title">
                        <div class="form-group">
                            <label for="title_input">Title</label>
                            <input type="text" class="form-control" name="title" id="title_input" placeholder="Title"
                                   value="">
                        </div>
                    </div>
                    <div id="global_content">
                        <div class="form-group">
                            <label for="content_input">Content</label>
                            <textarea class="form-control" id="content_input" name="content" rows="3"></textarea>
                        </div>
                    </div>
                    <div id="image">
                        <input id="image_input" name="file" class="file" type="file" multiple data-min-file-count="1">
                        <input type="text" id="global_img_id" name="imageId" value="" style="display: none"/>
                    </div>
                </div>
            </div>
            <div class="pull-right ">
                <div class="">
                    <br>
                    <button id="save_global_button" type="button" class="btn btn-info" onclick="saveGlobal()">Save
                    </button>
                </div>

            </div>

        </form>
    </div>
    <div class="panel-footer">
    </div>

</div>
