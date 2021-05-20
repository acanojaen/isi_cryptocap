<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<header>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>CryptoCap | Inicio</title>
  <link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
</header>

<body>
  <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
      <div class="container"><img src="/dist/img/small-logo.png"><a class="navbar-brand logo" href="#">&nbsp; cryptocap</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="nav navbar-nav ml-auto">
              <li class="nav-item"><a class="nav-link" href="/list">Criptomonedas</a></li>
              <li class="nav-item"><a class="nav-link" href="cv.html">Administracion</a></li>
              <li class="nav-item"><a class="nav-link" href="hire-me.html">Informacion</a></li>
            </ul>
        </div>
      </div>
  </nav>
  <main class="page cv-page">
      <section class="portfolio-block cv">
          <div class="container">
              <div class="work-experience group">
                  <div class="heading">
                      <h2 class="text-capitalize text-center text-body">PRECIOS ACTUALIZADOS DE CRIPTOMONEDAS</h2>
                  </div>

                  <!-- Mostramos las criptomonedas con JSP -->
                  <c:forEach items="${criptos}" var="criptomoneda">
                    <div class="item">
                        <div class="row">
                            <div class="col-md-6">
                                <h3 id="nombre">${criptomoneda.nombre}</h3>
                                <h4 class="organization">${criptomoneda.acronimo}</h4>
                                <h4 class="organization" style="background: #c6a00c;">${criptomoneda.volumen}</h4>
                            </div>
                            <div class="col-md-6"><span class="period">${criptomoneda.ultAct}</span></div>
                            <div class="col-md-6">
                                <p class="text-muted">descripción de la criptomoneda</p>
                            </div>
                            <div class="col-md-6">
                                    <a href="/eliminar?id=<c:out value='${criptomoneda.acronimo}' />" class="btn btn-info btn-sm float-right" role="button">remove</a>
                                    <a href="${criptomoneda.urlDatos}" class="btn btn-warning btn-sm float-right" role="button" target="_blank">see</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
              </div>
              <div class="education group">
                  <div class="heading">ACTUALIZACIAR DATOS</h2>
                  </div>
                  <div class="item">
                      <div class="row">
                          <div class="col-md-6">
                              <h3>Coinranking</h3>
                              <h4 class="organization">Webscraping</h4>
                          </div>
                          <div class="col-6"><span class="period">https://coinranking.com/</span></div>
                      </div>
                      <div class="row">
                        <div class="col-md-6"><p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget velit ultricies, feugiat est sed, efficitur nunc, vivamus vel accumsan dui.</p></div>
                        <div class="col-md-6"><button class="btn btn-secondary btn-sm float-right" data-target="#scrap" data-toggle="modal" type="button" data-whatever="coinranking.com">Invocar</button></div>
                      </div>
                  </div>
                <div class="item">
                    <div class="row">
                        <div class="col-md-6">
                            <h3>Coinmarketcap</h3>
                            <h4 class="organization">API</h4>
                        </div>
                        <div class="col-6"><span class="period">https://coinmarketcap.com/</span></div>
                    </div>
                    <div class="row">
                    <div class="col-md-6"><p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget velit ultricies, feugiat est sed, efficitur nunc, vivamus vel accumsan dui.</p></div>
                    <div class="col-md-6"><button class="btn btn-secondary btn-sm float-right" type="button">Invocar</button></div>
                    </div>
                </div>
            </div>
          </div>
      </section>
  </main>
  

  <div class="modal" id="scrap" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Resultado del webscraping</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="scrap()">Actualizar</button>
        </div>
      </div>
    </div>
  </div>



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

  <script>
      function scrap(){
        $.ajax({
            type: 'GET',
            url: "/cm",
            success: function(msg){
                $('#scrap').modal('show');
                document.getElementByClass("modal-body").innerHTML = msg;
            },
            error: function() {
                $('#scrap').modal('show');
                document.getElementByClass("modal-body").innerHTML = "error";               
            }
        });
      }

  </script>


</body>

</html>