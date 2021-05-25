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
    <title>CryptoCap - Configuración</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
    <link rel='shortcut icon' type='image/x-icon' href='/dist/imgfavicon.ico'/>
    
</header>

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
                    <h2 class="text-capitalize text-center text-body"><i class="fas fa-plus-circle"></i> CONFIGURAR CRIPTOMONEDAS</h2>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <div class="project-card-no-image">
                            <form method="post" action="currency" style="padding: 0px !important;">
                                <input type="text" class="form-control" name="acr" id="acr" aria-describedby="acronimoHelp" placeholder="Introduce el acrónimo">
                                <small id="acronimoHelp" class="form-text text-muted">Formato "XXXX" (max. 10 c)</small>
                                <button type="submit" class="btn btn-warning btn-sm float-right"><i class="fas fa-plus"></i></a>
                            </form>
                        </div>
                    </div>

                    <c:forEach items="${criptos}" var="resource" varStatus="loop">
                        <div class="col-md-6 col-lg-4">
                            <c:if test="${resource.status != 'disabled'}">
                            <div class="project-card-no-image">
                                <h3 style="text-transform: uppercase !important;">${resource.acronimo}&nbsp;</h3>
                                </c:if>

                                <c:if test="${resource.status == 'disabled'}">
                            <div class="project-card-no-image" style="border-top: 4px solid red !important;">
                                <h3 style="text-transform: uppercase !important;"><i class="fas fa-exclamation-circle"></i>&nbsp;${resource.acronimo}&nbsp; </h3>
                                </c:if>
                                <div class="tags">
                                    <a href="/eliminar?id=<c:out value='${resource.acronimo}'/>&entity=currency" class="btn btn-info btn-sm float-right" role="button"><i class="far fa-trash-alt" style="color: white;"></i></a>&nbsp;
                                    <c:if test="${resource.status != 'disabled'}">
                                        <a href="/ficha?id=<c:out value='${resource.acronimo}'/>" class="btn btn-warning btn-sm float-right" role="button"><i class="fas fa-eye" style="color: black;"></i></a>
                                    </c:if>
                                    <c:if test="${resource.status == 'disabled'}">
                                        <a href="/apimetadata?id=<c:out value='${resource.acronimo}'/>" class="btn btn-success btn-sm float-right" role="button"><i class="fas fa-search" style="color: white;"></i></a>
                                    </c:if>
                                    
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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