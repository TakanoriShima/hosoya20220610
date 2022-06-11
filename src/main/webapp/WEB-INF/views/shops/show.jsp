<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdit" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>ショップ　詳細ページ</h2>

        <table>
            <tbody>
            <tr>
                <th>ショップID</th>
                    <td><c:out value="${shop.id}"/></td>
                </tr>
                <tr>
                    <th>登録者氏名</th>
                    <td><c:out value="${shop.user.name}"/></td>
                </tr>
                <tr>
                    <th>ショップ名</th>
                    <td><c:out value="${shop.name}"/></td>
                </tr>
				<tr>
                    <th>優先度</th>
                    <td><c:out value="${shop.priorityflag}"/></td>
                </tr>
            </tbody>
        </table>
        <c:if test="${sessionScope.login_user.id == shop.user.id}">
            <p><a href="<c:url value='?action=Shop&command=edit&name=${shop.name}' />">このショップを編集する</a></p>
        </c:if>

        <p><a href="<c:url value='?action=Shop&command=index' />">一覧に戻る</a></p>

    </c:param>

</c:import>
