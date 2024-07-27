<%@page import="model.Division"%>
<%@page import="model.Semester"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.AdminDao"%>
    <%@page import="model.Department"%>
     <%@page import="model.Student"%>
          <%@page import="model.Query"%>
    <%@page import="java.util.List"%>
<!--Design by foolishdeveloper.com-->
<html lang="en">
   <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <style>
         @import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
         *{
         list-style: none;
         text-decoration: none;
         margin: 0;
         padding: 0;
         box-sizing: border-box;
         font-family: 'Open Sans', sans-serif;
         }
         body{
         background:#fff;
         }
         .wrapper .sidebar{
         background:  #ecf0f3;
         position: fixed;
         top: 0;
         left: 0;
         width: 225px;
         height: 100%;
         padding: 20px 0;
         transition: all 0.5s ease;
         box-shadow: 13px 13px 20px #cbced1,
         -13px -13px 20px #ffffff;
         }
         .wrapper .sidebar .profile{
         margin-bottom: 30px;
         text-align: center;
         }
         .wrapper .sidebar .profile img{
         display: block;
         width: 100px;
         height: 100px;
         border-radius: 50%;
         margin: 0 auto;
         border: 3px solid #222;
         }
         .wrapper .sidebar .profile h3{
         color: #fff;
         margin: 10px 0 5px;
         }
         .wrapper .sidebar .profile p{
         color: #222;
         font-size: 14px;
         }
         *{
         list-style: none;
         text-decoration: none;
         margin: 0;
         padding: 0;
         box-sizing: border-box;
         font-family: 'Open Sans', sans-serif;
         }
         .box{
         display:flex;
         align-items:center;
         justify-content:center;
         }
         .wrapper .section{
         width: calc(100% - 225px);
         margin-left: 225px;
         transition: all 0.5s ease;
         }
         .wrapper .section .top_navbar{
         background: #404040;
         height: 50px;
         display: flex;
         align-items: center;
         padding: 0 30px;
         border-left: 2px solid #fff;
         }
         .wrapper .section .top_navbar .hamburger a{
         font-size: 28px;
         color: #f4fbff;
         }
         .wrapper .section .top_navbar .hamburger a:hover{
         color: #a2ecff;
         }
         .wrapper .section .container{
         margin: 30px;
         background: #ecf0f3;;
         padding: 50px;
         line-height: 28px;
         }
         body.active .wrapper .sidebar{
         left: -225px;
         }
         body.active .wrapper .section{
         margin-left: 0;
         width: 100%;
         }
         .form-wrapper {
         width: 320px;
         height: 230px;
         margin: 20px;
         padding: 20px;
         border-radius: 40px;
         background: #ecf0f3;
         box-shadow: 13px 13px 20px #cbced1,
         -13px -13px 20px #ffffff;
         position:relative;
         align-items:center;
         justify-content:center;
         }
         .heading {
         text-align: center;
         font-size: 27px;
         padding-top: 23px;
         letter-spacing: 0.6px;
         }
         .form-wrapper{
         display: block;
         flex-flow: row wrap;
         align-content: space-between;
         justify-content: space-between;
         }
         .form-wrapper:nth-child(2n){
         line-break: after;   
         }
         .sign-btn {
         outline: none;
         border: none;
         cursor: pointer;
         width: 99.9%;
         height: 40px;
         border-radius: 29.9px;
         font-size: 15px;
         font-weight: 699.9;
         font-family: monospace;
         color: #fff;
         text-align: center;
         background: #a146f6;
         box-shadow: 3px 3px 8px #b1b1b1,
         -3px -3px 8px #ffffff;
         transition: 0.5s;
         }
         .sign-btn:hover {
         background: #7b0ce4;
         }
         .sign-btn:active {
         background: #7b0ce4;
         }
         .button{
         background-color:transparent;
         border:none;
         display: block;
         padding: 13px 30px;
         border-bottom: 1px solid #222;
         font-size: 20px;
         color: #222;
         text-transform: uppercase;
         position: relative;
         width: 100%;
         table-layout: fixed;
         display: flex;
         align-items: left;
         }
         .button:hover,:active{
         color: #a146f6;
         background-color:#fff;
         border-right: 2px solid #a146f6;
         }
         .form-wrapper {
         width: 320px;
         height: 420px;
         padding-top: 20px;
         padding: 30px 17px 17px 17px;
         border-radius: 40px;
         background: #ecf0f3;
         box-shadow: 13px 13px 20px #cbced1,
         -13px -13px 20px #ffffff;
         }
         .circle {
         width: 81px;
         height: 81px;
         border-radius: 50%;
         background: #a146f6;
         margin: 0 auto;
         box-shadow:
         0px 0px 2px #5f5f5f,
         0px 0px 0px 5px #ecf0f3,
         8px 8px 15px #a7aaaf,
         -8px -8px 15px #ffffff;
         overflow: hidden;
         }
         .heading {
         text-align: center;
         font-size: 21px;
         padding-top: 23px;
         letter-spacing: 0.6px;
         }
         .sm-text {
         text-align: center;
         font-size: 10px;
         padding-top: 6px;
         letter-spacing: 3.1px;
         }
         .input-text {
         width: 99%;
         padding: 30px 5.1px 5.1px 5.1px;
         }
         .input-text input {
         border: none;
         outline: none;
         background: none;
         font-size: 16px;
         color: #555;
         padding: 15px 5px 10px 2px;
         }
         .username,
         .password {
         margin-bottom: 25px;
         border-radius: 25px;
         box-shadow: inset 8px 8px 8px #cbced1,
         inset -8px -8px 8px #ffffff;
         }
         .input-text svg {
         height: 25px;
         margin: 0 10px -3px 25px;
         }
         .sign-btn {
         outline: none;
         border: none;
         cursor: pointer;
         width: 99.9%;
         height: 40px;
         border-radius: 29.9px;
         font-size: 15px;
         font-weight: 699.9;
         font-family: monospace;
         color: #fff;
         text-align: center;
         background: #a146f6;
         box-shadow: 3px 3px 8px #b1b1b1,
         -3px -3px 8px #ffffff;
         transition: 0.5s;
         }
         .sign-btn:hover {
         background: #7b0ce4;
         }
         .sign-btn:active {
         background: #7b0ce4;
         }
         .link {
         padding-top: 30px;
         text-align: center;
         }
         .link a {
         color: #818af8;
         font-size: 15px;
         font-weight: 500;
         }
         .circle img{
         width: 100%;
         height: 100%;
         object-fit: cover;
         border-radius: 50%;
         }
         .table{
         position:absolute;
         align-items:center;
         justify-content:center;
         margin-top:50px;
         }
      </style>
   </head>
   <body>
  
      <div class="wrapper">
         <div class="section">
            <div class="container">
          
                  
                  
                        
                       
                      
                          
                           
                          
                       
                        
                      
                         
                           
                 
                  
                  <div class="table">
                  <table style="align-items:center;" class="table">
                 
  <thead>
    <tr>
     
      <th scope="col"> Query</th>
      <th scope="col">Student Name</th>
       <th scope="col">Department Name</th>
        <th scope="col">Semester Name</th>
         <th scope="col">Division Name</th>
    
     
    </tr>
  </thead>
  <tbody>
  
  <%List<Query> list = AdminDao.getAllquery(); %>
  <%for(Query u1:list){ 
	  Student s = AdminDao.getStudentById(u1.getStu_id()); 
	  Department f = AdminDao.getDepartmentById(s.getDept_id());
	  Semester d = AdminDao.getSemesterById(s.getSem_id());
	  Division di = AdminDao.getDivisionById(s.getDiv_id());
  %>
    <tr>
    	
    	<td><%=u1.getQuery() %></td>
    	<td><%=s.getName() %></td>
    	<td><%=f.getDepartment() %></td>
    	<td><%=d.getSemester() %></td>
    	<td><%=di.getDivision() %></td>
    	
    	
    	
    	<td>
    		<form action="AdminController" method="post">
    			<input type="hidden" name="id" value="<%=u1.getId()%>">
    			<input type="hidden" name="action" value="query_delete">
    			<input type="submit" value="delete">
    		</form>
    	</td>
    </tr>
  <%} %>
  </tbody>
</table>


                  </div>
                 
              
            </div>
         </div>
       <div class="sidebar">
	 <div class="profile">
                <img src="img/coursera-logo.png" alt="profile_picture">
                <h3 style="color:#222;">Admin Login</h3>
           Hello 
		
            </div>
	<hr style="height:2px; color:#222;"></hr>
  <div id="v-pills-tab" role="tablist" aria-orientation="vertical">
  <button class="button" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
</svg>&nbsp;<a href="adminhome.jsp">Home</a></button>
<form action="logout.jsp" method="post">
            <button type="submit" class="button" style="color: red;">Logout</button>
        </form>
             
  </div>
 	<hr style="height:2px; color:#222;"></hr>

</div>


</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
			
          
</body>
   <script>
      var hamburger = document.querySelector(".hamburger");
      hamburger.addEventListener("click", function(){
      document.querySelector("body").classList.toggle("active");
      })
      
   </script>
   <script>
      function changeStyle(){
          var element = document.getElementById("myDiv");
          element.style.opacity = "1";
      }
      
   </script>
   <script>
    <%
  	if(request.getAttribute("msg")!=null)
  	{
  %>
  	alert(" <% out.print(request.getAttribute("msg"));
  	} %>");
  	</script>
    
</html>
 <%@ include file="footer.jsp" %>