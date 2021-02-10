<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");	
		cn = DriverManager.getConnection("jdbc:log4jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&serverTimezone=Asia/Seoul","ttk_dev","ttk_dev");
		ps = cn.prepareStatement("SELECT sysdate() FROM dual");
		rs = ps.executeQuery();
		if (rs.next()){
		out.println("연결되었습니다. "+ rs.getString("sysdate()"));
		}
	} catch(Exception e) {
		out.println(e);
	} finally {
		if (rs != null) try {rs.close();}catch (Exception e) {}
		if (ps != null) try {ps.close();}catch (Exception e) {}
		if (cn != null) try {cn.close();}catch (Exception e) {}
	}
%>
</body>
</html>