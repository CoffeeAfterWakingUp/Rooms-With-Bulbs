<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Комнаты с лампочками</title>
</head>
<body class="text-white" style="background-color: #0D0D0D;">
    <div class="w-100 border-1" style="height: 3px;background-color: #067302"></div>
    <div class="container pt-5">
        <h1><c:out value = "${requestScope.message}" default=""/></h1>
        <%@ include file="userDetails.jsp" %>
    </div>
    <div class="container pt-5">
        <div class="row row-cols-lg-2">
            <div class="col col-lg-8">
                <%@ include file="allRooms.jsp" %>
            </div>
            <div class="col col-lg-4">
                <%@ include file="createRoom.jsp" %>
            </div>
        </div>
    </div>

    <div class="w-100 border-1 mt-5" style="height: 3px;background-color: #067302"></div>



<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>