<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cryptocap.Criptomoneda"
%>
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
                <li class="nav-item"><a class="nav-link" href="/compare"><i class="fas fa-exchange-alt"></i> Conversor</a></li>
                <li class="nav-item"><a class="nav-link" href="/market"><i class="fas fa-search-dollar"></i> Mercado</a></li>
                <li class="nav-item"><a class="nav-link" href="/config"><i class="fas fa-wrench"></i> Configuración</a></li>
              </ul>
          </div>
        </div>
    </nav>
    <main class="page project-page">
        <section class="contacto">
            <span class="col">
                <h5>Dónde nos encontramos</h5>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12712.534612799356!2d-3.633304238319409!3d37.19705479275817!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd71fc55025f928b%3A0x4dbbca09efdcad08!2sEscuela%20T%C3%A9cnica%20Superior%20de%20Ingenier%C3%ADas%20Inform%C3%A1tica%20y%20de%20Telecomunicaci%C3%B3n%20de%20la%20Universidad%20de%20Granada!5e0!3m2!1ses!2ses!4v1620065386999!5m2!1ses!2ses" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </span>

            <span class="col">
                <h5>Formulario de contacto</h5>

                <form method="post">
                    <fieldset id="formulario">
                        <input type="text" name="nom" placeholder="Introduce tu nombre" required></input><br><br>
                        <input type="email" name="email" placeholder="Introduce tu correo" required></input><br><br>
                        <textarea type="textarea" name="mens" rows="9" cols="60" placeholder="Introduce tu consulta" required></textarea><br>
                        <br>
                        <input type = "submit" id = "button1" value = "Enviar" formaction="index.html"/> 

                    </fieldset>
                </form>
            </span>

            <span class="col">
                <h5>Síguenos</h5>
                <a class="enlace" href="https://www.instagram.com/canalugr/?hl=es">
                    <img src = "imagenes/siguenos2.png" alt = "Instagram" class="logo-red-social"/>
                </a>
                
                <a class="enlace" href="https://twitter.com/CanalUGR?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor">
                    <img src = "imagenes/siguenos4.png" alt = "Twitter" class="logo-red-social"/>
                </a>
            </span>

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