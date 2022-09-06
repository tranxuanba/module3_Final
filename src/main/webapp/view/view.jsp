<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 06/09/2022
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>MotorCycle List</title>
  <style>
    *{
      background-color: azure;
    }
    img{
      width: 120px;
      height: 80px;
      padding: 0px;
    }
  </style>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<center>
  <h1>MotorCycle List</h1>
  <h2>
    <a href="/students?action=create">Add New MotorCycle</a>
  </h2>
</center>
<div align="center">
  <caption><h2 style="padding-bottom: 50px; font-style: initial; color: crimson">List of Student</h2></caption>
  <table border="2" cellpadding="5" style="background-color: aqua" class="table" class="shadow p-3 mb-5 bg-body rounded">

    <tr style="margin: auto">
      <th class="table-primary" scope="col">ID</th>
      <th class="table-secondary" scope="col">Name</th>
      <th class="table-success" scope="col">Birthday</th>
      <th class="table-danger" scope="col">Address</th>
      <th class="table-warning" scope="col">Phone</th>
      <th class="table-warning" scope="col">Email</th>
      <th class="table-warning" scope="col">ClassRoom</th>
      <th class="table-info" scope="col">Edit</th>
      <th class="table-light" scope="col">Delete</th>
    </tr>
    <c:forEach items="${listStudent}" var="student">
      <tr style="margin: auto">
        <td class="table-primary">${student.id}</td>
        <td class="table-secondary">${student.name}</td>
        <td class="table-success">${student.birthDay}</td>
        <td class="table-success">${student.address}</td>
        <td class="table-success">${student.phone}</td>
        <td class="table-success">${student.email}</td>
        <td class="table-success">${student.classRoom}</td>
        <td class="table-info"><button type="button" class="btn btn-info"><a style="color: green; text-decoration: none; background-color: darkturquoise" href="/students?action=edit&id=${motor.id}">Edit</a></button></td>
        <td class="table-light"><button type="button" class="btn btn-warning"><a style="color: crimson; text-decoration: none; background-color: gold" href="/students?action=delete&id=${motor.id}">Delete</a></button></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
