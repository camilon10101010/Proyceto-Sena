<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<meta charset="UTF-8">
	<link rel="shortcut icon" href="Imagen/icono.ico" />
        
	<link rel="stylesheet" href="css/main.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.2.min.js"><\/script>')</script>
	<script src="js/sweetalert2.min.js" ></script>
	<script src="js/main.js" ></script>
        
        <script  type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/paginacion.js"></script>
       
     
        
        
  <!--codigo de paginacion-->
  <style>
  
ulll {
  list-style: none;
  margin-top: 10px;
  padding-top: 20px;
}

liii {
  border-radius: 3px;
  color: black;
  background: #Ecda51;
  cursor: pointer;
  display: inline;
  font-weight: 200;
  margin: 10px 5px 0px 2px;
  padding: 10px;
  text-align: center;
  width: 10px;
}

.activeee {
  background: teal;
  color: white;
}
</style>


	<script type="text/javascript">
	$(function(){
		$("#datos").pagination();
	});
        </script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>   



