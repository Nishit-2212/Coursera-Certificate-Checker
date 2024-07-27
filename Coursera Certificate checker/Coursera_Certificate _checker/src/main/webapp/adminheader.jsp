<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Faculty"%>    
    
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
    }
.heading {
      text-align: center;
      font-size: 27px;
      padding-top: 23px;
      letter-spacing: 0.6px;
    }
.box{
 display: flex;
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
    </style>
</head>
    
 <%
 Faculty s =null;
if(session.getAttribute("s")!=null){
	s = (Faculty)session.getAttribute("s");
}
%>