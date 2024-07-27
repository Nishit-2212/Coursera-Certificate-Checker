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
<script>
    <%
  	if(request.getAttribute("msg")!=null)
  	{
  %>
  	alert(" <% out.print(request.getAttribute("msg"));
  	} %>");
  	</script>


<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="login-form">
                    <h2>Query</h2>
                    <form action="UploadController" method="post">
                        <div class="group-input">
                            <input type="hidden" name="id" value="<%= s.getId() %>">
                            <input type="text" id="name" name="name" required>
                            <div id="email_error"></div>
                        </div>
                        

                        <input type="submit" name="action" class="site-btn login-btn" value="Submit Query" style="color: #ffffff;
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






</body>

</html>


