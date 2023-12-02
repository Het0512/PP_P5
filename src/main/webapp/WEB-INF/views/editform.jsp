<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.board.BoardDAO, com.example.board.BoardVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
<c:set var="u" value="${u}" />
<c:out value="${u.seq}" />
 <h1>Edit Form</h1>
 <form action="../editok" method="post">
  <input type="hidden" name="seq" value="${u.seq}" />
  <table>
   <tr><td>Name:</td><td><input type="text" name="name" value=${u.name} /></td></tr>
   <tr><td>PhoneNumber:</td><td><input type="tel" name="phoneNumber" value="${u.phoneNumber}" /></td></tr>
   <tr><td>Email:</td><td><input type="email" name="email" value=${u.email} /></td></tr>
   <tr><td>Category:</td><td><input type="text" name="category" value=${u.category} /></td></tr>
   <tr><td colspan="2"><input type="submit" value="Edit Post"/>
    <input type="button" value="Cancel" onclick="history.back()"/></td></tr>
  </table>
 </form>
</body>
</html>