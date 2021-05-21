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
        <div class="container"><img src="/dist/img/small-logo.png"><a class="navbar-brand logo" href="#">&nbsp; cryptocap</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navbarNav">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="/list">Criptomonedas</a></li>
                    <li class="nav-item"><a class="nav-link" href="cv.html">Administracion</a></li>
                    <li class="nav-item"><a class="nav-link" href="hire-me.html">Informacion</a></li>
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
                <form>
                    <c:set var="xv"></c:set>
                    <c:forEach items="${criptos}" var="x">
                        <c:choose>
                            <c:when test="${empty x}">
                                <c:set var="xv" value="${xv} ${x.acronimo}"></c:set>
                            </c:when>    
                            <c:otherwise>
                                <c:set var="xv" value="${x.acronimo}"></c:set>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <div class="form-group">
                        <textarea id="Resources" name="Resources" rows="10" cols="70">
                            ${xv}
                        </textarea>

                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block btn-lg" type="submit">Cambiar</button>
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