<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <title>零售商管理</title>
    <style>
        *{margin:0; padding:0;} #menuContent a{text-decoration:none;color:#ffffff}
    </style>

    <script type="text/javascript">

       function changeStatus(){
           var status = document.getElementById("indexStatus").value;
           document.getElementById("status").value=status;
       }
    </script>
  </head>


  <body>
      <%@ include file="../menu.jsp" %><br/>

      <form id="listForm" action="list.action" method="post">
            姓名：<input type="text" name="name" style="width:120px"/>
            手机：<input type="text" name="telphone" style="width:120px"/>
            地址：<input type="text" name="address" style="width:120px"/><br/><br/>
            状态：<select id="indexStatus" onchange="changeStatus()">
            <option value="-1" selected="selected">全部</option>
            <option value="1">启用</option>
            <option value="0">停用</option>
         </select>


         <input type="hidden" name="status" id="status" value="-1">
            创建日期：<input type="text" name="createTime"/>
         <input type="submit" value="搜索" style="background-color:#173e65;color:#ffffff;width:70px;"/> <br/>
         <!-- 显示错误信息 -->
         <c:if test="${errorMsg}">
             <font color="red">${errorMsg}</font><br/>
         </c:if>


         <input type="hidden" name="startPage" id="startPage" value="${startPage}"/>
         <input type="hidden" name="currentPage" id="currentPage" value="${currentPage}"/>
         <input type="hidden" name="pageSize" id="pageSize" value="${pageSize}"/>
         <input type="hidden" name="sumPageNumber" id="sumPageNumber" value="${sumPageNumber}"/>
         <input type="hidden" name="countNumber" id="countNumber" value="${countNumber}"/>
      </form>


  <hr style="margin-top: 10px;"/> 
  <button onclick="showAddMask('true')" style="background-color:#173e65;color:#ffffff;width:70px;">添加</button>

      <c:if test="${list!=null}">
	  <table style="margin-top: 10px;width:700px;text-align:center;" border=1>  
            <tr>
              <td>序号</td><td>姓名</td><td>手机号</td><td>地址</td>
              <td>状态</td><td>创建日期</td><td>操作</td>
            </tr>

          <c:forEach items="${list}" var="item" varStatus="status">
             <tr>
               <td>${status.index+1}</td><td>${item.name }</td>
               <td>${item.telphone}</td><td>${item.address }</td>
               <td>
                   <c:if test="${item.status==1}">
                       <font color="blue">启用</font>
                   </c:if>
                   <c:if test="${item.status==0}">
                       <font color="red">停用</font>
                   </c:if>
               </td>


               <td>${item.createTime}</td>
               <td>
                    <a>编辑</a>|
                    <a>删除</a>
               </td>
             </tr>
            </c:forEach>
	  </table>
   </c:if>


   <c:if test="${list==null}">
       <b>搜索结果为空！</b>
   </c:if>


   <div style="margin-top: 10px;">
       <a>上一页</a>
       <a>下一页</a>
       <input type="text" id="pageNumber" style="width:50px">
       <button>GO</button>
   </div>
  </body>
</html>
