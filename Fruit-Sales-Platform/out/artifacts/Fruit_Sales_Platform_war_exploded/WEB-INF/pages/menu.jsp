<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="menuContent" style="background-color:#173e65;color:#ffffff;height:100px;">
   <h1 style="margin-left: 20px;margin-top:20px;">
           水果网络销售平台</h1><br/>
     <div style="margin-left: 20px;">
     <a href="${pageContext.request.contextPath}/commodities/list.action">货物管理</a>|||
     <a href="${pageContext.request.contextPath}/retailer/list.action?status=-1">零售商管理</a>|||
     <a href="${pageContext.request.contextPath}/contract/list.action?type=-1">购销合同</a>|||
     <a>用户设置</a></div>
</div>
<div style="background-color:#cccccc">
     <span style="margin-left: 20px;">welcome...${sessionScope.user.name} </span>
</div>
