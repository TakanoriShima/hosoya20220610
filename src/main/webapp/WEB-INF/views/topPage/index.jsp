<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actShop" value="${ForwardConst.ACT_SHOP.getValue()}" />
<c:set var="actSh" value="${ForwardConst.ACT_SHOP.getValue()}" />

<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ようこそ</h2>
        <c:choose>
        	<c:when test="${shops == null}">
        		<p>ショップがありません</p>
        	</c:when>
        	<c:otherwise>
        	<h3>ショップ一覧</h3>
            <ul>
	            <c:forEach var="shop" items="${shops}" varStatus="status">
	                 <li><a href="?action=${actShop}&command=${commShow}&name=${shop.name}">${shop.name}</a></li>
	            </c:forEach>
            </ul>
        	</c:otherwise>        </c:choose>

        <p><a href="<c:url value='?action=${actShop}&command=${commNew}' />">新規ショップ登録</a></p>

    </c:param>
</c:import>