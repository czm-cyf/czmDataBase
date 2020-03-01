<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="nclg.book.domain.UserInfo Image">
			</div>
			<div class="pull-left info">
				<security:authentication property="principal.username"></security:authentication>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>

				<ul class="treeview-menu">
					<security:authorize access="hasRole('ADMIN')">
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					</security:authorize>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>

				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>图书页面</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/book/findAll.do?page=1&size=4">
							<i class="fa fa-circle-o"></i> 图书
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/orders/findAllReserve.do?page=1&size=4">
						<i class="fa fa-circle-o"></i> 借出图书
					</a></li>
					<security:authorize access="hasRole('ADMIN')">
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>
					</security:authorize>
				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>