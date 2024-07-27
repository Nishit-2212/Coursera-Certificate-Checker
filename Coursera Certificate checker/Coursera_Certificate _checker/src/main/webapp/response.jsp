<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, org.apache.pdfbox.pdmodel.*, org.apache.pdfbox.text.PDFTextStripper" %>
<!DOCTYPE html>
<html>
<head><title>Name Extracted</title></head>
<body>
  <h1>Extracted Name:</h1>
  <% String name = (String) session.getAttribute("extractedName"); %>
  <p><%= name %></p>

  <hr>

  <form>
    <input type="text" name="firstName" value="<%= name %>">
    </form>
</body>
</html>