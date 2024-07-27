<%@page import="model.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
    <%@page import="dao.AdminDao"%>
     <%@page import="dao.UploadDao"%>
<%@page import="model.Course"%>
<%@page import="model.Semester"%>
<%@page import="model.Division"%>
<%@page import="model.Student"%>


 <%@ include file="header.jsp" %>
    
    
<!DOCTYPE html>

<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="login-form">
                    <h2> Upload Coursera certificate</h2>
                    <form action="ExcelController" method="post" enctype="multipart/form-data">
                        <div class="group-input">
                            <label for="username">Select Excel file:</label>
                            <input type="file"  name="ExcelFile" accept=".xls,.xlsx" required>
                            
                        </div>
                        <div class="group-input">
                            <label for="pass">Select Department:</label>
                            <select name="dropdown" id="dropdown" onchange="getdepartment()">
								<option> Department </option>
                    <%List<Department> list = AdminDao.getAllDepartment(); %>
         <%for(Department u1:list){ %>
           <option value="<%=u1.getDepartment() %>"><%=u1.getDepartment() %></option>
                   
         <%} %>
               </select>
                        </div>

                        <input type="submit" name="action" class="site-btn login-btn" value="Upload">
                    </form>

                    
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Register Form Section End -->

 <script>
        <%
            String massege = (String) request.getAttribute("msg");
          if(request.getAttribute("msg")!=null)
          {
      %>
          alert(" <% out.print(request.getAttribute("msg"));
          } %>");
          
          
          function getValue() {
        	  var dropdown = document.getElementById("dropdown");
        	  var selectedValue = dropdown;
        	  console.log("Selected value: " + selectedValue);
        	  // You can do whatever you want with the selected value here
        	} 
          </script>





</body>

</html>




