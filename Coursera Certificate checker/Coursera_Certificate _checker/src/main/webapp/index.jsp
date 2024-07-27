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
                    <form action="UploadController" method="post" enctype="multipart/form-data">
                        <div class="group-input">
                            <label for="username">Select PDF file:</label>
                            <input type="file"  name="pdfFile" required>
                            
                        </div>
                        <div class="group-input">
                            <label for="pass">Select Course:</label>
                            <select name="dropdown" id="dropdown">
			
                    <%List<Course> list = UploadDao.getCourse(s.getSem_id()); %>
         <%for(Course u1:list){ %>
           <option value="<%=u1.getCourse() %>"><%=u1.getCourse() %></option>
                   
         <%} %>
                       
               </select>
                        </div>

                        <input type="submit" name="action" class="site-btn login-btn" value="Upload" style="color: #ffffff;
  background: #0044ff;
  border: 1px solid #0044ff;
  font-size: 14px;
  font-weight: 700;
  text-transform: uppercase;
  padding: 13px 45px 11px;
  cursor: pointer;">
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
          </script>





</body>

</html>


