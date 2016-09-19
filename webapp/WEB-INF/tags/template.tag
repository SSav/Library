
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Онлайн библиотека</title>
        <link href="resources/css/style_main.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div class="container">

            <div class="header">
                
                <div class="logo">
                    <img src="resources/images/library.png" alt="Логотип" name="logo" />
                </div>
                
                <div class="descr">
                    <h3>Онлайн библиотека проекта javabegin.ru</h3>
                </div>
                
                <div class="search_form">
                    <form name="search_form" method="POST">
                        <input type="text" name="search_String" value="" size="110" />
                        <input class="search_button" type="submit" value="Поиск" name="search_button" />
                        <select name="search_option">
                            <option>Название</option>
                            <option>Автор</option>
                        </select>
                    </form>
                </div>
             </div>   
			<jsp:doBody />
	</div>
</body>
</html>
