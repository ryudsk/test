<%@ page import="spms.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% Member member = (Member)session.getAttribute("member"); %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-color:#00008b;color:#ffffff;height:20px;padding:5px;">
	SPMS(Simple Project Management System)
 
	<%-- <c:if test="${member.email != null}"> --%> 
	<span style="float:right;"> 
	${member.name}
	<%-- <%=member.getName() %> --%>
	 <a href="<%=request.getContextPath() %>/auth/logout.do" style="color:white;">로그아웃</a>
	</span>
	<%-- </c:if> --%>
</div>