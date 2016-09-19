<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/jspf/left_menu.jspf" %>
<%@include file="/WEB-INF/jspf/letters.jspf" %>
<link href="resources/css/style_main.css" rel="stylesheet" type="text/css">


<div class="book_list">
    <h3>${genre.title}</h3>
 
 <c:forEach items="${books}" var="book">
	 <div class="book_info">  
	 	<div class="book_title">
          	<p>${book.title}</p>
        </div>
                
        <div class="book_image">
           	<img src="<%=request.getContextPath()%>/ShowImage.as?index=${book.id}" height="250" width="190" alt="Обложка"/>
        </div>
                
	    		<div class="book_details">
	                <br><strong>ISBN:</strong>${book.isbn}
	                <br><strong>Издательство:</strong>${book.publisher.name}
	               
	                <br><strong>Количество страниц:</strong>  ${book.pageCount}
	                <br><strong>Год издания:</strong> ${book.publishYear}
	                <br><strong>Автор:</strong>${book.author.name}
	                <p style="margin:10px;"> 
	                <a href="<%=request.getContextPath()%>/content.jsp?index=${book.id }">Читать</a></p>
                </div>
        
       </div>  
 </c:forEach>

</div>

    
