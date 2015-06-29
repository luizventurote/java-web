<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<a href="#" class="top-bar-item top-bar-box">

    <div class="tb-box-item icon" >
        <i class="fa fa-envelope tb-box-icon"></i>
        <span class="badge">6</span>
    </div>

</a>

<div class="top-bar-item top-bar-box dropdown">

    <div class="tb-box-item" data-toggle="dropdown">
        <div class="user-name">Administrador <i class="fa fa-angle-down icon"></i></div>
        <img src="img/user.png" alt="" class="user-image">
    </div>

    <div class="dropdown-menu">

      <ul class="nav dropdown-menu-list">

        <li class="active">
          <a href="#">Home <i class="fa fa-home fa-fw icon"></i></a>
        </li>
        <li>
          <a href="#">Library <i class="fa fa-book fa-fw icon"></i></a>
        </li>
        <li>
          <a href="#">Applications <i class="fa fa-pencil fa-fw icon"></i></a>
        </li>
        <li>
          <a href="#">Settings <i class="fa fa-cogs fa-fw icon"></i></a>
        </li>

      </ul>

      <a href="logout.jsp" class="btn btn-danger btn-xs loguot">Sair</a>
    
    </div>

</div>