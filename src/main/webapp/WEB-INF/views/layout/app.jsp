<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actUs" value="${ForwardConst.ACT_USER.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_GOODS.getValue()}" />
<c:set var="actAuth" value="${ForwardConst.ACT_AUTH.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commOut" value="${ForwardConst.CMD_LOGOUT.getValue()}" />

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title><c:out value="Ikuthu？"/></title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="header_menu">
                    <h1><a href="<c:url value='?action=${actTop}&command=${commIdx}' />">Ikuthu？</a></h1>&nbsp;&nbsp;&nbsp;
                </div>
            <c:if test="${sessionScope.login_user != null}">
                     <div id="user_name">
                         <c:out value="${sessionScope.login_user.name}"/>
                         &nbsp;さん&nbsp;&nbsp;&nbsp;
                                                 <a href="<c:url value='?action=${actAuth}&command=${commOut}' />">ログアウト</a>&nbsp;
                    </div>
            </c:if>
            </div>
            <div id="content">${param.content}</div>
            <div id="footer">by taro kirameki.</div>
        </div>
    </body>
</html>