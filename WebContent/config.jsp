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
    <title>CryptoCap - Inicio</title>
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
                <li class="nav-item"><a class="nav-link" href="/list"><i class="fas fa-coins"></i>&nbsp;Criptomonedas</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i>&nbsp;Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <main class="page project-page">
        <section class="portfolio-block project">
            <div class="container">
                <div class="heading">
                    <h2 class="text-capitalize text-center text-body">CONFIGURAR CRIPTOMONEDAS</h2>
                </div>
                <div class="alerta">

                </div>
                <form>
                    <div class="form-group">
                        <label>Lista de criptomonedas</label> :
                        <textarea id="Resources" name="Resources" form="confirmationForm" rows="10" cols="70"><c:forEach items="${criptos}" var="resource" varStatus="loop">${resource.acronimo}&nbsp;</c:forEach></textarea>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block btn-lg" type="submit" onclick="configurar()">Cambiar</button>
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

    <script>
        var exito =     '<div class="alert alert-success">' 
                      + '¡El scrapeado se ha realizado <strong>con éxito</strong>!'
                      +  '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'
                      +  '<span aria-hidden="true">&times;</span>'
                      +  '</button>'
                      +  '</div>';
  
        function configurar(){
          $.ajax({
              url: "/upload",
              type: 'POST',
              data: {value: document.getElementById("myTextarea").value},
              success: function(){
                  $('#alerta').html(exito);
              }
          });
        }
    </script>
</body>

</html>