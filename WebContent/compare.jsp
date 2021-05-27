<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>CryptoCap - Comparar precios</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
    <link rel="icon" type="image/png"  href='/dist/img/icon.png'/>
</head>

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
        <div class="container"><img src="/dist/img/small-logo.png"><a class="navbar-brand logo" href="/">&nbsp; cryptocap</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
           <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="nav navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="/list"><i class="fas fa-coins"></i> Criptomonedas</a></li>
                <li class="nav-item"><a class="nav-link" href="/compare"><i class="fas fa-exchange-alt"></i> Conversor</a></li>
                <li class="nav-item"><a class="nav-link" href="/market"><i class="fas fa-search-dollar"></i> Mercado</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i> Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <main class="page project-page">
        <section class="portfolio-block project-no-images">
            <div class="container">
                <div class="heading">
                    <h2 class="text-capitalize text-center text-body"><i class="fas fa-random"></i> CONVERSOR</h2>
                </div>
                <form method="post" action="compare2" style="padding: 0px !important;">
                    <c:if test="${not empty result}">
                        <div class="alert alert-primary" role="alert">
                            El resultado está calculado con la API de <a href="#" class="alert-link">CoinmarketCap</a>.<br> ${amount} ${acron1} <b>>></b> ${result} ${acron2}
                        </div>

                    </c:if>

                    <c:if test="${not empty error}">
                        <div class="alert alert-danger" role="alert">
                            ${error}
                          </div>
                    </c:if>
                    <div class="row">
                        <div class="col-md-4 col-lg-4">
                            <div class="input-group mb-3">
                                <input type="number" class="form-control" name="cantidad" id="cantidad" aria-describedby="acronimoHelp" placeholder="Introduce cantidad">
                                <select name="compIzq">
                                    <option disabled>Criptomonedas</option>
                                    <c:forEach items="${criptos}" var="resource1" varStatus="loop">
                                        <option value="${resource1.acronimo}">${resource1.acronimo}</option>
                                    </c:forEach>
                                    <option disabled>Monedas</option>
                                    <c:forEach items="${notcriptos}" var="resource2" varStatus="loop">
                                        <option value="${resource2}">${resource2}</option>
                                    </c:forEach>
                                </select>    
                            </div>                     
                        </div>

                        <div class="col-md-4 col-lg-4">
                            <button type="submit" class="btn btn-warning btn-sm float-right"><i class="fas fa-exchange-alt"></i></a>
                        </div>


                        <div class="col-md-4 col-lg-4">
                            <div class="input-group mb-3">
                                <select name="compDer">
                                    <option disabled>Criptomonedas</option>
                                    <c:forEach items="${criptos}" var="resource1" varStatus="loop">
                                        <option value="${resource1.acronimo}">${resource1.acronimo}</option>
                                    </c:forEach>
                                    <option disabled>Monedas</option>
                                    <c:forEach items="${notcriptos}" var="resource2" varStatus="loop">
                                        <option value="${resource2}">${resource2}</option>
                                    </c:forEach>
                                </select>   
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </main>

    <footer class="page-footer">
        <div class="container">
            <div class="links"><a href="#">ISI 2021</a><a href="https://github.com/acanojaen/isi_cryptocap">Github</a></div>
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