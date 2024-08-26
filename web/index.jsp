

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.helper.Connectionprovider" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--css -->
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mycss.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


        
    </head>
    <body>
        <!-- navbar -->
        <%@include file="navbar.jsp" %>
        
        
        
        
        <!-- banner -->
        
        <div class="container-fluid m-0 p-0">
            
            
            
            
            <div class="jumbotron primary-background text-white">
                <div class="container">
                <h3 class="display-3">Welcome to TechBlog</h3>
                <h3>Tech  Blog</h3>
                <p>Welcome to technical blog,world of technology
                     programming language is a system of notation for writing computer programs.[1]

Programming languages are described in terms of their syntax (form) and semantics (meaning), usually defined by a formal language. Languages usually provide features such as a type system, variables and mechanisms for error handling. An implementation of a programming language in the form of a compiler or interpreter allows programs to be executed, either directly or by producing what's known in programming as an executable.
                </p>
                
                
                <button class="btn btn-outline-light btn-lg"><span class="fa fa-user-plus	
	
"></span> Start  !  its Free</button>
                <a  href="login.jsp"class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin
"></span> Login</a>

                </div>
            </div>
            
            
        </div>
        
        <!-- card -->
        
        
        <div class="continer">
            
            
            <div class="row mb-2">
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">Java Programming</h5>
                             <p class="card-text">It is a simple programming language. Java makes writing, compiling, and debugging programming easy. It helps to create reusable code and modular programs. Java is a class-based, object-oriented programming language and is designed to have as few implementation dependencies as possible.</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">Python Programming</h5>
                             <p class="card-text">Python is a high-level, interpreted, and general-purpose dynamic programming language that focuses on code readability. It has fewer steps when compared to Java and C. It was founded in 1991 by developer Guido Van Rossum.</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">C++ Programming</h5>
                             <p class="card-text">C++ is an object-oriented programming language which gives a clear structure to programs and allows code to be reused, lowering development costs. C++ is portable and can be used to develop applications that can be adapted to multiple platforms. C++ is fun and easy to learn</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                
                
                
                
               
                
            </div>
            <div class="row">
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">C Programming</h5>
                             <p class="card-text">C is a general-purpose programming language created by Dennis Ritchie at the Bell Laboratories in 1972. It is a very popular language, despite being old. The main reason for its popularity is because it is a fundamental language in the field of computer science.</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">JavaScript Programming</h5>
                             <p class="card-text">JavaScript was initially created to “make web pages alive”. The programs in this language are called scripts. They can be written right in a web page's HTML and run automatically as the page loads. Scripts are provided and executed as plain text.</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                <div class="col-md-4">
                    <div class="card" >
  
                     <div class="card-body">
                             <h5 class="card-title">Spring Boot </h5>
                             <p class="card-text">Spring Boot is the combination of Spring Framework and Embedded Servers. In Spring Boot, there is no requirement for XML configuration (deployment descriptor). It uses convention over configuration software design paradigm that means it decreases the effort of the developer.</p>
                             <a href="#" class="btn primary-background text-white">Read more</a>
                    </div>
                    </div>
                    
                </div>
                
                
                
                
                
               
                
            </div>
        </div>
        
        
        
           <!-- js -->
        
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>

    </body>
</html>
