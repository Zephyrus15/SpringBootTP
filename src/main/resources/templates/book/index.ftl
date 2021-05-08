<#include "../navbar/navbar.ftl"/>

<div class="container">

	<div class="py-3">
		<a class="btn btn-success btn-small" href="/book/create"><i class="bi bi-plus-square"></i><span class="ps-2">Create</span></a>
	</div>
		<div class="row">
			<form method="post" action="search">
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="inputName" placeholder="Name">
					</div>
					<div class="col">
						<input type="number" class="form-control" name="inputnbPageMin" placeholder="Nombre de Page minimum">
					</div>
					<div class="col">
						<input type="number" class="form-control" name="inputnbPageMax" placeholder="Nombre de Page maximum">
					</div>
					<div class="col">
						<input type="text" class="form-control" name="inputPriceMin" placeholder="Price Maximum">
					</div>
					<div class="col">
						<input type="text" class="form-control" name="inputPriceMax" placeholder="Price Minimum">
					</div>
					<div class="col">
						<input class="btn btn-primary btn-small" type="submit" value="Submit">
					</div>
				</div>
			</form>
		</div>

	<div class="row">
	<#list items as item>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://picsum.photos/200/100" alt="Card image cap">
			  <div class="card-header">
			  	<h6 class="card-title fw-bold">${item.name}</h6>
			  </div>
			  <div class="card-body d-flex justify-content-between">
			    <span class="card-text">Pages : ${item.nbPage}</span>
			    <span class="card-text">Price : ${item.price}</span>
			  </div>
			  <div class="card-footer">
			  	<a class="btn btn-outline-primary btn-small" href="/book/details/${item.id}"><i class="bi bi-info-square"></i><span class="ps-2">Details</span></a>
			  </div>
			</div>
		</div>
	</#list>
	
	</div>

</div>