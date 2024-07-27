<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
    
    
<!DOCTYPE html>
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="index.jsp"><i class="fa fa-home"></i> Home</a>
                    <span>otp</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="login-form">
                  
                    <form action="LoginController" method="post">
                    
                    	<div class="group-input">
                           
                            <input type="hidden" id="email" name="email" value="<% String email = (String) request.getAttribute("email");
                            		if (email != null) {out.print(email); } %>">
                            <div id="email_error"></div>
                        </div><div class="group-input">
               
                            <input type="hidden" id="cotp" name="otp1" value="<% int otp1 = (Integer) request.getAttribute("otp1");
                            		if (otp1 != 0) {out.print(otp1); } %>">
                            <div id="email_error"></div>
                        </div>
                            
                        <div class="group-input">
                            <label for="username">Enter otp *</label>
                            <input type="text" id="username" name="otp2" required>
                            <div id="email_error"></div>
                        </div>
                        

                        <input type="submit" name="action" class="site-btn login-btn" value="verify otp">
                    </form>
                               
                   
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Register Form Section End -->






</body>

</html>


<%
	String msg = (String) request.getAttribute("msg1");
	if (msg != null) { %>
		<script>
        bootbox.alert({
            message: '<%= msg %>',
            backdrop: true
        });
</script> <%
		
	}
	%>
	
<%
	String msg1 = (String) request.getAttribute("msg2");
	if (msg1 != null) { %>
		<script>
        bootbox.alert({
            message: '<%= msg1 %>',
            backdrop: true
        });
</script> <%
	
	}
	%>