<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestUser</title>
</head>
<script src="../js/jquery-3.2.1.js"></script>
<%--<script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>--%>
<body>
<input type="button" onclick="getFun()" value="get"/>
<input type="button" onclick="insertFun()" value="insert"/>
<input type="button" onclick="updateFun()" value="update"/>
<input type="button" onclick="deleteFun()" value="delete"/>
</body>
</html>
<script>
    function getFun() {

        $.ajax({
            type: "get",
            url: "user/16.action",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (e) {
                console.log( e.responseText);
            }
        });


    }
    function insertFun() {
        var user={

            username:"insertName",
            password:"insertPassWord"
        };
        console.log(user);
        $.ajax({
            type: "post",
            url: "addUser.action",
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (e) {
                console.log( e.responseText);
            }
        });
        
    }
    function updateFun() {
        var user =
            {
                id:2,
                username:"updateUser",
                password:"updatePassWord"
            }
        console.log(user);
        $.ajax({
            type: "put",
            url: "updateUser.action",
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (e) {
                console.log(e.responseText);
            }
        });
       
    }
    function deleteFun() {
        $.ajax({
            type: "delete/4",
            url: "deleteUser.action",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                console.log(data);
            },
            error: function (e) {
                console.log(e.responseText);
            }
        });
        
    }

</script>