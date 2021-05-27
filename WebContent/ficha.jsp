<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>CryptoCap - ${criptos.acronimo}</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
    <link rel="icon" type="image/png"  href='/dist/img/icon.png'/>

    <style>
        .portfolio-block .heading h2 {
            text-transform: capitalize !important;
        }
    </style>
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
    <c:if test="${criptos.acronimo != null}">
        <main class="page cv-page">
            <section class="portfolio-block cv">
                <div class="container">
                    <div class="work-experience group">

                        <div class="heading" style="display: inline !important">
                            <h2 class="text-center text-body">
                                <a href="/list"><i class="fas fa-arrow-left float-left"></i></a>
                                <img class="responsive" src="${criptos.imagen}"/> ${criptos.nombre}
                            </h2>
                            
                        </div>

                        <div class="item">
                            <div class="row">
                                <fmt:parseNumber var = "pc24h" type = "number" value = "${criptos.variacion24}" />
                                <fmt:parseNumber var = "pc7d" type = "number" value = "${criptos.variacion7}" />
                                <fmt:parseNumber var = "pc30d" type = "number" value = "${criptos.variacion30}" />

                                <c:if test="${not empty criptos.precio && pc24h > 0}">
                                    <div class="col-md-6">
                                        <h3>Precio: </h3> <h4 class="organization" style="background-color: green;"><i class="fas fa-arrow-up" style="color: white;"></i> ${criptos.precio}$</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.precio && pc24h < 0}">
                                    <div class="col-md-6">
                                        <h3>Precio: </h3> <h4 class="organization" style="background-color: red;"><i class="fas fa-arrow-down" style="color: white;"></i> ${criptos.precio}$</h4>
                                    </div>
                                </c:if>

                                <c:if test="${criptos.total_market_cap != 0}">
                                    <div class="col-md-6">
                                        <h3>Capitalización de mercado total: </h3> <h4 class="organization" style="background-color: gray;">${criptos.total_market_cap}</h4>
                                    </div>
                                </c:if>
                                <c:if test="${criptos.total_volume_24h != 0}">
                                    <div class="col-md-6">
                                        <h3>Volumen ultimas 24 horas: </h3> <h4 class="organization" style="background-color: gray;">${criptos.total_volume_24h}</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.percent_change_24h && pc24h > 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio ultimas 24 horas: </h3> <h4 class="organization" style="background-color: green;">${criptos.percent_change_24h}%</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.percent_change_24h && pc24h < 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio ultimas 24 horas: </h3> <h4 class="organization" style="background-color: red;" >${criptos.percent_change_24h}%</h4>
                                    </div>
                                </c:if>
                                
                                <c:if test="${not empty criptos.percent_change_7d && pc7d > 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio ultimos 7 días: </h3> <h4 class="organization" style="background-color: green;">${criptos.percent_change_7d}%</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.percent_change_7d && pc7d < 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio ultimos 7 días: </h3> <h4 class="organization" style="background-color: red;">${criptos.percent_change_7d}%</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.percent_change_30d && pc30d > 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio últimos 30 días: </h3> <h4 class="organization" style="background-color: green;">${criptos.percent_change_30d}%</h4>
                                    </div>
                                </c:if>

                                <c:if test="${not empty criptos.percent_change_30d && pc30d < 0}">
                                    <div class="col-md-6">
                                        <h3>Cambio últimos 30 días: </h3> <h4 class="organization" style="background-color: red;">${criptos.percent_change_30d}%</h4>
                                    </div>
                                </c:if>

                                <c:if test="${criptos.total_supply != 0}">
                                    <div class="col-md-6">
                                        <h3>Suministro total: </h3> <h4 class="organization" style="background-color: gray;">${criptos.total_supply}</h4>
                                    </div>
                                </c:if>

                                <c:if test="${criptos.num_market_pairs != 0}">
                                <div class="col-md-6">
                                    <h3>Total de parejas de mercado: </h3> <h4 class="organization" style="background-color: gray;">${criptos.num_market_pairs}</h4>
                                </div>
                                </c:if>
                            </div>

                            Si considera que el precio puede estar desactualizado: 
                                <a href="/apicrypto?case=single&id=<c:out value='${criptos.acronimo}'/>" class="btn btn-danger btn-sm" role="button"><i class="fas fa-redo"></i></a>
                        </div>

                        <p class="text-muted">${criptos.desc}</p>
                        
                    
                        <div class="heading" style="display: inline !important">
                            <h2 class="text-center text-body"><i class="fas fa-history"></i> Historial de precio</h2>
                        </div>

                        <div class="col-md-12">
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
                                        <td>${historial.valor}$</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        
                        <div class="heading" style="display: inline !important">
                            <h2 class="text-center text-body"><i class="fas fa-history"></i> Gráfica</h2>
                        </div>

                        <div class="col-md-12">
                            <div id="mychart"></div>
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
    <script src="https://cdn.jsdelivr.net/npm/cryptocharts"></script>

    <script>
        CryptoCharts.roiComparison({
            chart_id: "mychart",
            cryptocompare_tickers: ["${criptos.acronimo}"],
            iconomi_tickers: ["USD"],
            last_days: 90
        });
    </script>
</body>

</html>