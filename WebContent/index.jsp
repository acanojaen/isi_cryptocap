<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
    import="cryptocap.ControllerServlet"
%>
<html>
    <header>
        <link href="/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="/dist/css/style.css" rel="stylesheet">
        <title></title>
    </header>

    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
          <a class="navbar-brand" href="#">Cryptocap</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
    
          <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#">Inicio</a>
              </li>
            </ul>
          </div>
        </nav>
    
        <main role="main" class="container">
    
          <div class="starter-template">
            <h1>Cryptocap</h1>
            <img src="dist/img/coin.png"/>
          </div>
    
        </main><!-- /.container -->
    
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
        <script src="${pageContext.request.conextPath}/dist/js/bootstrap.min.js"></script>
      
    
    </body>
</html>
