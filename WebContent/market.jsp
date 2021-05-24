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
    <title>CryptoCap - Mercado</title>
    <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="/dist/bootstrap/css/style.css">
    <style>
        .colorred {
            color: red;
        }

        .colorgreen {
            color: green;
        }
    </style>
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
                <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <div class="project-card-no-image">
                        Total de criptomonedas activas<br>
                        <span>${stats[0]}</span>
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-4">
                        <div class="project-card-no-image">
                            Total de criptomonedas<br>
                            <span>${stats[1]}</span>
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-4">
                        <div class="project-card-no-image">
                            Intercambios activos/totales<br>
                            <span>${stats[2]}/${stats[3]}</span>
                        </div>
                    </div>
                </div>

                <div class="heading">
                    <h2 class="text-capitalize text-center text-body"><a href="/market"><i class="fas fa-globe"></i></a> Todas las criptomonedas</h2>
                </div>

                <table class="table">
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Market Cap</th>
                        <th scope="col">Volume (24h)</th>
                        <th scope="col">7d %</th>
                        <th scope="col"></th>
                    </tr>
                    
                    <c:forEach items="${criptos}" var="c">
                        <tr>
                            <td><img class="responsive" src="${c.imagen}"/> <b>${c.nombre}</b> <span>${c.acronimo}</span></td>
                            <td>${c.precio}</td>
                            <td>${c.total_market_cap}</td>
                            <td>${c.total_volume_24h}</td>
                            <td>${c.variacion7}</td>
                            <td><a href="/ficha?id=<c:out value='${c.acronimo}'/>" class="btn btn-success btn-sm float-right" role="button" target="_blank"><i class="fas fa-eye" style="color:white;"></i></a></td>
                        </tr>
                    </c:forEach>
                </table>



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

    <script>
        $(document).ready(function(){
                $('td').each(function(){
                    var cellvalue= $(this).html();
                    if(cellvalue.substring(0,1) == '-') {
                        $(this).wrapInner('<strong class="colorred"></strong>');
                    }
                });

                $('td').each(function(){
                    var cellvalue= $(this).html();
                    if(cellvalue.substring(0,1) == '+') {
                        $(this).wrapInner('<strong class="colorgreen"></strong>');
                    }
                });
        });
    </script>
</body>

</html>