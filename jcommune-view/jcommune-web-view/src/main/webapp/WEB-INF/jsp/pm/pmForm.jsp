<%--

    Copyright (C) 2011  JTalks.org Team
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.
    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.
    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="jtalks" uri="http://www.jtalks.org/tags" %>
<html>
<head>
    <title><spring:message code="label.pm_title"/></title>
</head>
<body>
<div class="wrap pm_page">
    <jsp:include page="../../template/topLine.jsp"/>
    <h1>JTalks</h1>

    <div class="all_forums">
        <h2><a class="heading" href="#"><spring:message code="label.new_pm"/></a></h2>

        <div class="forum_misc_info">
        </div>

        <jtalks:breadcrumb breadcrumbList="${breadcrumbList}"/>

        <jsp:include page="pmNavigationMenu.jsp"/>
        <form:form action="${pageContext.request.contextPath}/pm" modelAttribute="privateMessageDto"
                   method="POST"
                   onsubmit="this.getAttribute('submitted')" name="editForm">
            <ul class="forum_table"> <!-- Форма ответа -->
                <li class="forum_row">
                    <div class="forum_answer_left">
                        <spring:message code="label.recipient"/>
                    </div>
                    <div class="forum_answer_right">
                        <form:input path="recipient" size="45" maxlength="60" tabindex="1" class="post"/>
                        <form:errors path="recipient"/>
                    </div>
                </li>
                <li class="forum_row">
                    <div class="forum_answer_left">
                        <spring:message code="label.title"/>
                    </div>
                    <div class="forum_answer_right">
                        <form:input path="title" size="45" maxlength="60" tabindex="1" class="post"/>
                        <form:errors path="title"/>
                    </div>
                </li>
                <li class="forum_row">
                    <div class="forum_answer_left align-top">
                        <spring:message code="label.body"/>
                        <table class="smiles_table">
                            <tbody>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="forum_answer_right">
                        <div class="formatting_buttons">
                            <input id="format_b" type="button" class="button" accesskey="b" name="format_b"
                                   value=" B "/>
                            <input id="format_i" type="button" class="button" accesskey="i" name="format_i"
                                   value=" i "/>
                            <input id="format_u" type="button" class="button" accesskey="u" name="format_u"
                                   value=" u "/>
                            <input id="format_quote" type="button" class="button" accesskey="q" name="format_quote"
                                   value="Quote"/>
                            <input id="format_code" type="button" class="button" accesskey="c" name="format_code"
                                   value="Code"/>
                            <input id="format_list" type="button" class="button" accesskey="l" name="format_list"
                                   value="List"/>
                            <input id="format_listeq" type="button" class="button" accesskey="o" name="format_listeq"
                                   value="List="/>
                            <input id="format_img" type="button" class="button" accesskey="p" name="format_img"
                                   value="Img"/>
                            <input id="format_url" type="button" class="button" accesskey="w" name="format_url"
                                   value="URL"/>
                        </div>
						<span class="genmed">
							<spring:message code="label.topic.font_color"/>
							<select id="select_color" name="select_color">
                                <option><spring:message code="label.topic.font_color.black"/></option>
                                <option><spring:message code="label.topic.font_color.white"/></option>
                            </select>
							<spring:message code="label.topic.font_size"/>
							<select id="select_size" name="select_size">
                                <option><spring:message code="label.topic.font_size.small"/></option>
                                <option><spring:message code="label.topic.font_size.large"/></option>
                                <option><spring:message code="label.topic.font_size.king_size"/></option>
                            </select>
						</span>
                        <a href="#" onmouseover="helpline('a')"><spring:message code="label.topic.close_tags"/></a>

                        <div id="helpline"><spring:message code="label.topic.notify_message"/></div>
                        <form:textarea path="body" rows="15" cols="35" tabindex="3" class="post"/>
                        <form:errors path="body"/>
                    </div>
                </li>
                <li class="forum_row">
                    <div class="forum_answer_left">
                        <spring:message code="label.topic.options"/>
                    </div>
                    <div class="forum_answer_right options">
                        <input id="notify" type="checkbox" name="notify"/> <spring:message
                            code="label.topic.notify_message"/>
                        <br/>
                        <input id="nosmiles" type="checkbox" name="nosmiles"/> <spring:message
                            code="label.topic.no_smiles"/>
                    </div>
                </li>
            </ul>
            <input id="preview" type="submit" class="button" tabindex="5" name="preview"
                   value="<spring:message code="label.preview"/>"/>
            <input id="post" type="submit" class="button" accesskey="s" tabindex="6" name="post"
                   value="<spring:message code="label.send"/>"
                   onclick="document.editForm.action='${pageContext.request.contextPath}/pm'"/>
            <input id="save_pm" type="submit" class="button" name="save_pm" value="<spring:message code="label.save"/>"
                   onclick="document.editForm.action='${pageContext.request.contextPath}/pm/save'"/>
        </form:form>
    </div>
    <div class="footer_buffer"></div>
    <!-- Несемантичный буфер для прибития подвала -->

</div>
</body>
</html>

