<%@ page language="java" pageEncoding="UTF-8" %>
<div class="panel panel-primary">
    <div class="panel-heading">
        User List
    </div>
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                    <th>Table heading</th>
                </tr>
                </thead>
                <tbody>
                <tr class="active">
                    <th scope="row">1</th>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                </tr>
                <tr class="success">
                    <th scope="row">2</th>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                    <td>Table cell</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="panel-footer">
        Total Article qty : ${articles.qty}
    </div>
    <div class="pull-right ">
        <div class="">
            <br>
            <button id="add_button" type="button" class="btn btn-info" onclick="addUser()">Add User</button>
        </div>

    </div>
</div>
