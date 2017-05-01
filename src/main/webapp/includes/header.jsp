<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css">

</head>
<body>

<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">
        <img src="../resources/images/logo.png" width="30" height="30" alt="">
    </a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <form class="form-inline my-2 my-lg-0">
            <div class="input-group">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
            </div>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>

        <ul class="navbar-nav navbar-toggler-">
            <li class="nav-item">
                <a class="nav-link" href="#">ENG</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">|</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">LV</a>
            </li>
        </ul>

        <ul class="navbar-nav navbar-toggler-right">
            <li class="nav-item">
                <a class="nav-link" href="#">CHECKOUT</a>
            </li>
            <li class="nav-item" style="margin-top: -5px;">
                <a class="nav-link" href="#"><i class="fa fa-shopping-cart fa-2x" aria-hidden="true">
                    <span class="badge" style="position: absolute; margin-top: -45px; margin-left: 3px;">0</span>
                </i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fa fa-sign-in" aria-hidden="true"></i> LOGIN</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fa fa-user" aria-hidden="true"></i> MY ACCOUNT</a>
            </li>
        </ul>
    </div>
</nav>
