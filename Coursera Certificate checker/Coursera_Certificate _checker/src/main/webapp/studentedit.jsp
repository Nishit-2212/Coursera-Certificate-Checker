<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.AdminDao"%>
    <%@page import="model.Department"%>
        <%@page import="model.Student"%>
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
         height: 2100px;
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
  <%Student s =(Student)request.getAttribute("student"); %>
      <div class="wrapper">
         <div class="section">
            <div class="container">
               <div class="box" id="myDiv">
                  <form action="AdminController" method="post">
                     <div class="form-wrapper">
                        <div class="circle">
                           <img src="logo.jpeg" alt="cat">
                        </div>
                        <div class="heading">Edit Student</div>
                        <div class="input-text">
                          
                           <div class="username">
                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="18" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                 <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                 <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                              </svg>
                            <input type="hidden" name="id" value="<%=s.getId()%>">
                              <input type="text" name="name"  id="name"  value="<%= s.getName() %>" />
                         
                           </div>
                           <div class="username">
                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="18" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                 <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                 <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                              </svg>
                            
                              <input type="text" name="email"  id="name"  value="<%= s.getEmail() %>" />
        
                           </div>
                           <div class="username">
                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="18" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                 <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                 <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                              </svg>
                            
                              <input type="text" name="password"  id="name"  value="<%= s.getPassword() %>" />
                    
                           </div>
                           <div class="username">
                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="18" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                 <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                 <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                              </svg>
                            
                              <input type="text" name="enrollment_no"  id="name"  value="<%= s.getEnrollment_no() %>" />
                           </div>
                           
                          
                        </div>
                        <br>
                        <a>
                           <input type="submit" name="action" class="sign-btn" value="Update Student">
                           <div class="link">
                        
                        </div>
                  </form>
                  <br><br><br>
                  <div class="table">
                 


                  </div>
                  </div>   
               </div>
            </div>
         </div>
         <div class="sidebar">
            <div class="profile">
               <img src="img/coursera-logo.png" alt="profile_picture">
               <h3 style="color:#222;">Admin Login</h3>
            </div>
            <hr style="height:2px; color:#222;">
            </hr>
            <div id="v-pills-tab" role="tablist" aria-orientation="vertical">
               <button class="button" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true">
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                     <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
                  </svg>
                  &nbsp;<a href="adminhome.jsp">Home </a>
               </button>
               <button class="button" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false">
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-laptop" viewBox="0 0 16 16">
                     <path d="M13.5 3a.5.5 0 0 1 .5.5V11H2V3.5a.5.5 0 0 1 .5-.5h11zm-11-1A1.5 1.5 0 0 0 1 3.5V12h14V3.5A1.5 1.5 0 0 0 13.5 2h-11zM0 12.5h16a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 12.5z"/>
                  </svg>
                  &nbsp;Dashboard
               </button>
               <button class="button" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-graph-up-arrow" viewBox="0 0 16 16">
                     <path fill-rule="evenodd" d="M0 0h1v15h15v1H0V0Zm10 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4.9l-3.613 4.417a.5.5 0 0 1-.74.037L7.06 6.767l-3.656 5.027a.5.5 0 0 1-.808-.588l4-5.5a.5.5 0 0 1 .758-.06l2.609 2.61L13.445 4H10.5a.5.5 0 0 1-.5-.5Z"/>
                  </svg>
                  &nbsp;Reports
               </button>
               <button class="button" id="v-pills-settings-tab" data-bs-toggle="pill" data-bs-target="#v-pills-settings" type="button" role="tab" aria-controls="v-pills-settings" aria-selected="false" >
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-bounding-box" viewBox="0 0 16 16">
                     <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
                     <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                  </svg>
                  &nbsp;people
               </button>
            </div>
            <hr style="height:2px; color:#222;">
            </hr>
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