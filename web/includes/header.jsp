<%--
  Created by IntelliJ IDEA.
  User: Vijai3D
  Date: 04.03.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">
        <img src="/images/logo.png" width="30" height="30" alt="">
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="btn-group">
            <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Shop By Cathegory
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Books</a>
                <a class="dropdown-item" href="#">DVD's</a>
                <a class="dropdown-item" href="#">Games</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Shelves</a>
            </div>
        </div>
        <style> #search-icon{
            margin-left: 120px;
        }
        </style>
        <form class="form-inline my-2 my-lg-0" id="search-icon">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Sign in |</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log in</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Cart<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
