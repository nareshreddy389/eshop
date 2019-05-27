<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
 <div class="container-fluid">
   <div class="navbar-header">
     <a class="navbar-brand" href="home">Ekart</a>
     <a class="navbar-brand" href="aboutus">Aboutus</a>
     <a class="navbar-brand" href="contactus">Contactus</a>
  
   </div>
   <ul class="nav navbar-nav">
    
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">category <span class="caret"></span></a>
       <ul class="dropdown-menu">
         <li><a href="category">addcategory</a></li>
         <li><a href="showcat">showcategory</a></li>
         </ul>
     </li>
     
      	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
     <ul class="dropdown-menu">
       <li><a href="Supplier">AddSupplier</a></li>
        
       <li><a href="showsup">ShowSupplier</a></li>
       </ul>
       </li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
     <ul class="dropdown-menu">
       <li><a href="addproducts">AddProduct</a></li>
        
       <li><a href="showproducts">ShowProduct</a></li>
       </ul>
       </li>
	</ul>
	</div>
</nav>
</body>
</html>