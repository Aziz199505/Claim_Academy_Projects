<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>Album example for Bootstrap</title>
	
	<link rel="stylesheet" type="text/css"  href="style.css">
	
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="album.css" rel="stylesheet">

	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>	
	
	<script>
	 $('#chShipAdd').change(function() {
		    if ($('#chShipAdd').prop('checked')) {
		        $('#shipadddiv').show();
		    } else {
		        $('#shipadddiv').hide();
		    }
		});
	
	 $('#chShipAdd').prop('checked', false);

	</script>
	
    <!-- Custom styles for this template -->
  </head>

  <body>

    <header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="#" class="text-white">Follow on Twitter</a></li>
                <li><a href="#" class="text-white">Like on Facebook</a></li>
                <li><a href="#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
			<img src="./images/icon.png"  alt="Icon">
			&nbsp;
            <strong>AutoSale</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">AutoSale</h1>
          <p class="lead text-muted">Finding the perfect car is all about matching yourself with the best type of car for you. Search millions of cars by style at Auto.com by selecting to view cars of your favorite body style.  From sedans to pick-up trucks or convertibles to minivans, your perfect new ride is one click away.</p>
          <p>
            <!-- <a href="#" class="btn btn-primary my-2 open-button" onclick="openForm()">Add Car</a> -->
            <button class="btn btn-primary" data-toggle="modal" data-target="#modalAddCarForm">Sell Car</button>
            
            
            
            <!-- <a href="#" class="btn btn-secondary my-2">Secondary action</a> -->
          </p>
        </div>
      </section>

      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
           
           <c:forEach var="seller" items="${inventory.sellers}" varStatus="lop">
           	  <c:forEach var="car" items="${seller.cars}" varStatus="loop">
             	
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
	                <img class="card-img-top" src="<c:out value="${car.imgUrl}" />"  alt="Card image cap">
	                <c:if test="${car.discount}">
	                  <div class="top-left">
	                  		<div class="discount-label red"> <span>-${car.discountPercent}%</span> </div>
	                  </div>
	                </c:if>
	                <div class="card-body">
	                
	                
	                  <h5 class="card-title">Price: <span style="color:red;">$<c:out value="${car.price}"/></span></h5>
	                  <hr>
	                  <h5 class="card-title"><c:out value="${car.make} ${car.model} ${car.year}"/></h5>
	                  
	                  <p class="card-text"><c:out value="${car.descp}" /></p>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" data-target=<c:out value="#modaShowCarInfo${lop.index}${loop.index}"/> data-toggle="modal" class="btn btn-sm btn-outline-secondary">View</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Sell</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
	                      
	                    </div>
	                    <small class="text-muted">Posted: <c:out value="${car.dateOfAdded}" /></small>
	                  </div>
	                </div>
	              </div>
	            </div>
	            
	            <div class="modal fade bd-example-modal-lg" id=<c:out value="modaShowCarInfo${lop.index}${loop.index}"/> tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				 		<div class="modal-dialog modal-lg">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h4 class="modal-title" id="myModalLabel"><c:out value="${car.make} ${car.model} ${car.year}"/></h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <h3 style="text-align:center">Car Info</h3>
					        <table class=   "table table-user-information">
					       	<thead class="thead-dark">
						      <tr>
						      	<th>Seller</th>
						        <th>Make</th>
						        <th>Model</th>
						        <th>Year</th>
						        <th>Odometer</th>
						        <th>Date</th>
						   		<th>Price</th>
						   		<th>Contact</th>
						      </tr>
						    </thead>
			                <tbody>
			                  <tr>
			                  	<td><c:out value="${seller.firstName} ${seller.lastName}"/></td>
			                  	<td><c:out value="${car.make}"/></td>
			                  	<td><c:out value="${car.model}"/></td>
			                 	<td><c:out value="${car.year}"/></td>
			                  	<td><c:out value="${car.odometer}"/></td>
			                 	<td><c:out value="${car.dateOfAdded}"/></td>
			                 	<td><c:out value="${car.price}"/></td>
			                 	<td><c:out value="${seller.contact.email}"/></td>
			                  </tr>
			               </tbody>
			              </table>  
					        <hr>
					        <h3 style="text-align:center">Car Image</h3>
					        
					        <div class="image-frame" style="text-align:center">
							  <img style="max-width:75%; text-align:center" class="img-responsive" src="<c:out value="${car.imgUrl}" />"  alt="test"/>
							 </div>
					        
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
<!-- 					        <button type="button" class="btn btn-primary">Save changes</button>
 -->					      </div>
					    </div>
					  </div>
				</div>
				
				
				
             </c:forEach>
           </c:forEach>
            
          </div>
        </div>
      </div>

    </main>

    <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
      </div>
    </footer>





<div class="modal fade" id="modalAddCarForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
     <form action="CarServlet" method="post" enctype="multipart/form-data">
     
	      <div class="modal-header text-center">
	        <h4 class="modal-title w-100 font-weight-bold">Car Registration</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body mx-3">
	      
	        <div class="md-form mb-4">
	        
	        <select name="seller" id="makeTitle" class="form-control selectpicker">
	       	  <c:forEach var="seller" items="${inventory.sellers}">
	        	
			  	<option value="${seller.contact.email}">${seller.firstName} ${seller.lastName}</option>
			  
			  </c:forEach>
			</select>
			
			<label data-error="wrong" data-success="right" for="orangeForm-name">Sellers</label>
			
			</div>
	        
	        
	       <div class="md-form mb-4">
	        
	        <input id="makeTitle" name="make" list="makes">

			
			<label data-error="wrong" data-success="right" for="orangeForm-name">Make</label>
			
			</div>
			
			
					
 
 			<div class="md-form mb-4">
 			
			 <input id="results" name="model" list="models">
			
		     <label data-error="wrong" data-success="right" for="orangeForm-name">Model</label>
		    </div>
		    
		    <datalist id="models">
            <c:forEach var="mycarType" items="${inventory.carTypes}">
					
						<%-- <option value="${m}">${mycarType.make}</option> --%>
					
						<c:forEach var="m" items="${mycarType.model}">
			  					<option value="${m}">${mycarType.make}</option>
					        
						</c:forEach>
		  		</c:forEach>
        	</datalist>
        	
        	<datalist id="makes">
            <c:forEach var="mycarType" items="${inventory.carTypes}">
			  		<option value="${mycarType.make}"></option>		
		  		</c:forEach>
        	</datalist>
        	
        	
		    
		    
		    <div class="md-form mb-5">
	          <i class="fas fa-user prefix grey-text"></i>
	          <input name="year" type="number" value="2010" min="1990" id="orangeForm-name" class="form-control validate">
	          <label data-error="wrong" data-success="right" for="orangeForm-name">Year</label>
	        </div>
	        
	        <div class="md-form mb-5">
	          <i class="fas fa-user prefix grey-text"></i>
	          <input name="odometer" type="number" value="1" min="0" id="orangeForm-name" class="form-control validate">
	          <label data-error="wrong" data-success="right" for="orangeForm-name">Odometer</label>
	        </div>
	        
	         <div class="md-form mb-5">
	          <i class="fas fa-user prefix grey-text"></i>
	          <input name="price" type="number" value="1" min="1" id="orangeForm-name" class="form-control validate">
	          <label data-error="wrong" data-success="right" for="orangeForm-name">Price</label>
	        </div>
	        
	        <div class="md-form mb-5">
	          <i class="fas fa-user prefix grey-text"></i>
	          <textarea name="descp" class="form-control validate" rows="5" id="comment"></textarea>
	          
	          <label data-error="wrong" data-success="right" for="orangeForm-name">Description</label>
	        </div>
	        
	        
	        
	        <div class="md-form mb-5">
	          <div class="input-group">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
			  </div>
			  <div class="custom-file">
			    <input name="imageFile" type="file" accept="image/*" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
			    <label class="custom-file-label" for="inputGroupFile01">Choose Image (Optional)</label>
			  </div>
			</div>
	        </div>
			  
	       <div class="md-form mb-5 text-center">
	        <div class="checkbox">
			  <label>
    			<input type="checkbox" onclick="ChangeShip()" href="#moreabout" data-toggle="collapse" aria-expanded="false" aria-controls="moreabout" class="form-control" id="chShipAdd" name="isNewSeller" value="newSeller">
			    New Seller
			  </label>
			</div>
	        
	        
	        </div>
	        <div id="shipadddiv">
	        	<div class="collapse" id="moreabout" >
	        
		         <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="firstName" type="text" id="orangeForm-name" class="form-control validate">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">First name</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="lastName" type="text" id="orangeForm-name" class="form-control validate">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">Last name</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-envelope prefix grey-text"></i>
		          <input name="email" type="email" id="orangeForm-email" class="form-control validate">
		          <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="cellPhone" type="text" id="orangeForm-name" class="form-control validate w-50">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">Cell Phone</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="street" type="text" id="orangeForm-name" class="form-control validate">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">Street</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="city" type="text" id="orangeForm-name" class="form-control validate w-50">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">City</label>
		        </div>
		        
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <select name="state">
		          <c:forEach var="state" items="${inventory.states}">
	        	
			  		<option value="${state}">${state}</option>
			  
			 	 </c:forEach>
			 	 
			 	 </select>
		          
		          <label data-error="wrong" data-success="right" for="orangeForm-name">State</label>
		        </div>
		        
		        <div class="md-form mb-5">
		          <i class="fas fa-user prefix grey-text"></i>
		          <input name="zipCode" type="text" id="orangeForm-name" class="form-control validate w-25">
		          <label data-error="wrong" data-success="right" for="orangeForm-name">Zip Code</label>
		        </div>
		         
		      
	        
	        </div>
	        
			</div>
	      </div>
	      <div class="modal-footer d-flex justify-content-center">
	        <input type="submit" class="btn btn-deep-orange">
	      </div>
      </form>
    </div>
  </div>
</div>
	

  </body>
  
 
  
</html>
