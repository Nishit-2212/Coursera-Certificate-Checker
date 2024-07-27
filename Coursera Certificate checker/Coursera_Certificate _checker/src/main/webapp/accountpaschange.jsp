<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
    <%
  	if(request.getAttribute("msg")!=null)
  	{
  %>
  	alert(" <% out.print(request.getAttribute("msg"));
  	} %>");
  	</script>
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text product-more">
                    <a href="index.jsp"><i class="fa fa-home"></i> Home</a>
                    <span>Account</span>
                </div>
            </div>
        </div>
    </div>
</div>




<div class="container">
    <div class="insider row">
        <div class="col-md-3 col-8" style="padding: 20px 0;">
            
            
            
            <div class="card">
        
        <h4 style="text-align: center;padding:15px 0">
        <?php echo $cname ?>
        </h4>

        <div class="card-body" style="border-top:0.2px solid #e9e9e9 ;">

            <ul class="list-group">
                <li class="list-group-item">

                    <a href="account.php?orders">

                        <i class="fa fa-list"></i> My Details

                    </a>

                </li>

                <li class="list-group-item">

                    <a href="account.php?details">

                        <i class="fa fa-bolt"></i> check status

                    </a>

                </li>
                
            </ul>

        </div>
    </div>




        </div>

        <div class="col-md-8 col-10" style="padding:20px 0">


            <div class='col-md-6 col-12' style='margin:0px auto'>
            <div class='bg-light text-dark' style='border:solid #e5e5e5 0.2px; padding: 10px 40px'> 
            <div class='ci-text'>
              <form action="UserController" method="post">
              <input type='hidden' name='id' value='<%= s.getEmail() %>'>
              <input type='hidden' name='pass' value='<%= s.getPassword() %>'>
                <span style='font-size:large;font-weight:600'>Enter old password:</span>
                <p style='text-align:center'><input type='text' name='op' value=''>
                  </p>
            </div>
            <div class='ci-text'>
                <span style='font-size:large;font-weight:600'>Enter new password:</span>
               <p style='text-align:center'><input type='text' name='np' value=''>
            </div>
            <div class='ci-text'>
                <span style='font-size:large;font-weight:600'>Confirm password:</span>
               <p style='text-align:center'><input type='text' name='cp' value=''>
            </div>
            
            <div class="insidelog">
            <input type="hidden" name="action" value="Update_password">
           <a href='accountedit.jsp' class='btn logbtn' style='width: 200px; height:40px'> <input type="submit"  value="Update Password"></a></form>
        <a href='account.jsp' class='btn logbtn' style='width: 200px; height:40px'>Cancel</a>
          
            <div class="insidelog">     
         </div>
    </div>


        </div>
    </div>
</div>




</div>
</div>







</body>
</html>