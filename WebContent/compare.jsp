<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<header>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>CryptoCap - Comparar precios</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
</header>

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
        <div class="container"><img src="/dist/img/small-logo.png"><a class="navbar-brand logo" href="/">&nbsp; cryptocap</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
           <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="nav navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="/list"><i class="fas fa-coins"></i> Criptomonedas</a></li>
                <li class="nav-item"><a class="nav-link" href="/compare"><i class="fas fa-exchange-alt"></i> Comparador</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i> Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <main class="page project-page">
        <section class="portfolio-block project-no-images">
            <div class="container">
                <div class="heading">
                    <h2 class="text-capitalize text-center text-body"><i class="fas fa-plus-circle"></i> CONFIGURAR CRIPTOMONEDAS</h2>
                </div>
                <form method="post" action="compare" style="padding: 0px !important;">
                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="project-card-no-image">
                                <small id="comparationHelp" class="form-text text-muted">Criptomoneda a comparar:</small>
                                <select name="comparation">
                                    <c:forEach items="${criptos}" var="resource1" varStatus="loop">
                                        <option value="${resource1.acronimo}">${resource1.acronimo}</option>
                                    </c:forEach>
                                </select>                        
                                    
                                <button type="submit" class="btn btn-warning btn-sm float-right">COMPARAR</a>
                            </div>
                        </div>

                        <c:forEach items="${criptos}" var="resource2" varStatus="loop">
                            <div class="col-md-6 col-lg-4">
                                <div class="project-card-no-image">
                                    <h3 style="text-transform: uppercase !important;">${resource2.acronimo}&nbsp;</h3>
                                    <div class="tags">
                                        <input class="form-check-input" type="checkbox" name="requestSelect[]" value="${resource2.acronimo}">
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </form>
            </div>
        </section>
    </main>

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