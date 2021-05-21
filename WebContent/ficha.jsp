<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

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
                <li class="nav-item"><a class="nav-link" href="/list"><i class="fas fa-coins"></i> Criptomonedas</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i> Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <main class="page project-page">
        <section class="portfolio-block project">
            <h2 class="text-capitalize text-center text-body">cHANGE LIST</h2>
            <div class="container">
                <div class="group">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="skills portfolio-info-card">
                                <h2>Skills</h2>
                                <h3>HTML</h3>
                                <div class="progress">
                                    <div class="progress-bar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"><span class="sr-only">100%</span></div>
                                </div>
                                <h3>PHP</h3>
                                <div class="progress">
                                    <div class="progress-bar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;"><span class="sr-only">90%</span></div>
                                </div>
                                <h3>JavaScript</h3>
                                <div class="progress">
                                    <div class="progress-bar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"><span class="sr-only">80%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="contact-info portfolio-info-card">
                                <h2>Contact Info</h2>
                                <div class="row">
                                    <div class="col-1"><i class="icon ion-android-calendar icon"></i></div>
                                    <div class="col-9"><span>10/10/1990</span></div>
                                </div>
                                <div class="row">
                                    <div class="col-1"><i class="icon ion-person icon"></i></div>
                                    <div class="col-9"><span>John Smith</span></div>
                                </div>
                                <div class="row">
                                    <div class="col-1"><i class="icon ion-ios-telephone icon"></i></div>
                                    <div class="col-9"><span>+235 3217 424</span></div>
                                </div>
                                <div class="row">
                                    <div class="col-1"><i class="icon ion-at icon"></i></div>
                                    <div class="col-9"><span>lorem@email.com</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
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