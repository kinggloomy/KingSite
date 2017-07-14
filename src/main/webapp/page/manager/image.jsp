<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<div class="panel panel-primary">
    <div class="panel-heading">
        Image manager
    </div>
    <div class="panel-body">
        <div id="banner">
            <form id="image_form" class="form-horizontal required-validate"  enctype="multipart/form-data"  >

                <div class="form-group">
                    <input id="image_input" name="file" class="file" type="file" multiple data-min-file-count="1">
                </div>
            </form>

        </div>

    </div>
</div>
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
            </div>
        </div>
    </div>
</div>
