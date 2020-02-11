<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<pre>
<h1> Employee Registaion PAGE</h1>
<form action="save" method="POST">
Employee NAME::<input type="text" name="empName">
Employee SAL::<input type="text" name="empSal">
   <input type="submit" value="Register"> 
</form>
      ${msg}
</pre>