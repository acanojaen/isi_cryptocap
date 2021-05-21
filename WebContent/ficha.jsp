<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<header>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>CryptoCap - Inicio</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
    <style>
        .h3.h4{display: inline !important;}
    </style>
</header>

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
        <div class="container"><img src="/dist/img/small-logo.png"><a class="navbar-brand logo" href="/">&nbsp; cryptocap</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
           <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="nav navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="/list"><i class="fas fa-coins"></i> Criptomonedas</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i> Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <c:if test="${criptos.acronimo != null}">
        <main class="page cv-page">
            <section class="portfolio-block cv">
                <div class="container">
                    <div class="work-experience group">

                        <div class="heading" style="line-height: 20%;">
                            <h2 class="text-capitalize text-center text-body" style="text-transform: capitalize;"><a href="/list"><i class="fas fa-arrow-left float-left"></i></a> ${criptos.nombre}</h2>
                            <h4 class="organization text-center">${criptos.acronimo}</h4> 
                          </div>

                        <div class="item">
                            <c:if test="${criptos.precio != null}">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h3>Precio: </h3> <h4 class="organization">${criptos.precio}</h4>
                                    </div>
                                </div>
                            </c:if>
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Capitalizacion: </h3> <h4 class="organization">${criptos.capMercado}</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Volumen ultimas 24 horas: </h3> <h4 class="organization">${criptos.volumen24}</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Volumen ultimos 7 dias: </h3> <h4 class="organization">${criptos.volumenTotal}</h4>
                                </div>
                            </div>
                            <c:if test="${criptos.variacion24 != null}">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h3>Cambio ultimas 24 horas: </h3> <h4 class="organization">${criptos.variacion24}</h4>
                                    </div>
                                </div>
                            </c:if>
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Cambio ultima semana: </h3> <h4 class="organization">${criptos.variacion7}</h4>
                                </div>
                            </div>
                            <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget velit ultricies, feugiat est sed, efficitur nunc, vivamus vel accumsan dui.</p>
                        
                            <table class="table">
                                <tr>
                                <th scope="col">Fecha</th>
                                <th scope="col">Acrónimo</th>
                                <th scope="col">Valor</th>
                                </tr>
                                <c:forEach items="${hist}" var="historial">
                                <tr>
                                    <td>${historial.fecha}</td>
                                    <td>${historial.acronimo}</td>
                                    <td>${historial.valor}</td>
                                </tr>
                                </c:forEach>
                              </table>
                        </div>
                    </div>
                    
                </div>
            </section>
        </main>
    </c:if>
    <c:if test="${criptos.acronimo == null}">


    </c:if>
    <footer class="page-footer">
        <div class="container">
            <div class="links"><a href="#">ISI 2021</a><a href="#">Contáctanos</a><a href="#">Github</a></div>
            <div class="social-icons"></div>
        </div>
    </footer>
    <script src="/dist/js/jquery.min.js"></script>
    <script src="/dist/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
    <script src="/dist/js/script.min.js"></script>
    <script src="https://kit.fontawesome.com/7a8b17dfb3.js" crossorigin="anonymous"></script>
</body>

</html>