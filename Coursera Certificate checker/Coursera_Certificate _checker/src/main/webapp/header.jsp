<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Student"%>

<!DOCTYPE html>
<html lang="en">

<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Coursera </title>

<!-- Google Fonts Used -->
<link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>

<!-- Tab Icon -->

<link rel="icon" href="img/coursera-logo.png">

<!-- Css Styles -->
<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css'>
<link rel='stylesheet' href='css/font-awesome.min.css' type='text/css'>
<link rel='stylesheet' href='css/themify-icons.css' type='text/css'>
<link rel='stylesheet' href='css/elegant-icons.css' type='text/css'>
<link rel='stylesheet' href='css/owl.carousel.min.css' type='text/css'>
<link rel='stylesheet' href='css/slicknav.min.css' type='text/css'>
<link rel='stylesheet' href='css/style.css' type='text/css'>


</head>

<%
 response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
%>

<body>

    <!-- Page Pre Load Section-->

    

    <!-- Header Section-->

    <header class="header-section">
        <!-- Top Bar -->
        <div class="header-top" id="top">
            <div class="container">
                <div class="f-left">
                    <div class="top-social">
                        
 						 <span class="title1" style="color: #0044ff; 
  text-decoration: none;
  font-weight: bolder;
  line-height: 0.9; 
  font-size: 34px; 
  font-family:sofia; ">Coursera</span>                   
                    </div>
              
                
   </div>
   
 <%
Student s =null;
if(session.getAttribute("s")!=null){
	s = (Student)session.getAttribute("s");
}
%>
                <div class="f-right">
                    <ul class="nav-right">
                        <li class="user-icon">
                        <% if (s != null) { %>
    						  welcome <%= s.getName() %> !!!
  										 <% } %>
                            <div class="login-panel">
                                <i class="fa fa-user" style="font-size:20px"></i>
                            </div>
                            <div class="login-hover">
                                <div class="insidelog">
								<% if(s!= null) { %>
										<a href='logout.jsp' class='btn logbtn' style='width: 200px; height:40px'>Log Out</a>
									<% }
								else { %>								
                                   <a href='login.jsp' class='btn logbtn' style='width: 200px; height:40px'>Login</a>
								<% } %>
                                </div>
                                
                                
                                <div class='insidelog'>
                                	<% if(s!= null) { %>
                                	 <a href='account.jsp' class='btn btn-dark' style='color:white;margin:4px 0'>My Account</a>
										
									<% }
								 %>								
                                  
                                
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Middle Bar -->

    


        <!-- Lower Bar -->


        <div class="nav-item">
            <div class="container">
            
                          
                <nav class="nav-menu mobile-menu">
               
    
                    <ul>
                 		   <% if (s != null) { %>
                 		   <li class=""><a href="index.jsp" class="hoverb">Home</a></li>
                        <li class=""><a href="checkstatus.jsp" class="hoverb">Check status</a></li>
                        <li class=""><a href="account.jsp" class="hoverb">Profile</a></li>
                        <li class=""><a href="query.jsp" class="hoverb">Query</a></li>                        
                        <% } else { %>
						<li class=""><a href="facultylogin.jsp" class="hoverb">Faculty login</a></li>
						<li class=""><a href="login.jsp" class="hoverb">Student login</a></li>
						<% } %>

                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
    <!-- Header End -->
</body>
</html>

