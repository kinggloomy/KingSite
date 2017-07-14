<%@ page language="java" pageEncoding="UTF-8" %>
<div class="panel panel-primary">
    <div class="panel-heading">
        Article Edit
    </div>
    <div class="panel-body">

        <form id="article" class="" role="form">
            <div class="form-group ">
                <label for="title" class=" ">Title</label>
                <div class="">
                    <input type="text" class="form-control " name="title" id="title" placeholder="Please Input Title">
                </div>

                <label for="typeId">Article Target</label>
                <select class="form-control " name="articleTypeId" id="typeId">
                    <option value="1">Alabama</option>
                    <option value="2">Wyoming</option>
                </select>
            </div>
            <div class="form-group">
                <div class="">
                    <div class="checkbox">
                        <label>
                            <input name = "privateFlag" value="true" type="checkbox"> SelfRead
                        </label>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="pull-right ">
        <div class="">
            <br>
            <button id="add_button" type="button" class="btn btn-info" onclick="addArticle()">Confirm</button>
            <button id="draft_button" type="button" class="btn btn-info">Save Draft</button>
            <button id="cancel_button" type="button" class="btn btn-info">Give Up</button>
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
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
