<#include "../navbar/navbar.ftl"/>
<div class="container">
	<div class="row pt-2 pb-5">
		<p>Information du livre : </p>
		<div>
		  <label>Name</label>
		  <label>${item.name}<label/>
		</div></br>

		<div>
		  <label>Price</label>
		  <label>${item.price}<label/>
		</div></br>
		
		<div>
		  <label>Nombre de page</label>
		  <label>${item.nbPage}<label/>
		</div></br>
	</div>
	<div class="row">
		<p>Liste des Seller : </p>
	
		<#list users as user>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://eu.ui-avatars.com/api/?name=${user.firstname}+${user.lastname}&size=512" alt="Card image cap">
			  <div class="card-header">
			  	<h5 class="card-title">${user.firstname} ${user.lastname}</h5>
			  </div>
			  <div class="card-body">
			    <p class="card-text">Role : ${user.role.name}</p>
			  </div>
			  <div class="card-footer">
			  	<a class="btn btn-primary btn-small" href="/book/buy/${item.id}/${user.id}">Buy</a>
			  </div>
			</div>
		</div>
	</#list>
	</div>
	</div>
</div>