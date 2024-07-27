 <%@page import="model.Faculty"%>
<%
 Faculty s =null;
if(session.getAttribute("s")!=null){
	s = (Faculty)session.getAttribute("s");
}
%>