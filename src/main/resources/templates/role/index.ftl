<#include "../navbar/navbar.ftl"/>
<div class="container">

</br>
<a class="btn btn-success btn-small" href="/role/create"><i class="bi bi-plus-square"></i><span class="ps-2">Create</span></a>
	</br>
	</br>
	<div class="row">
	<#list items as item>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://fakeimg.pl/200x100/" alt="Card image cap">
			  <div class="card-header">
			  	<h5 class="card-title">${item.name}</h5>
			  </div>
			   <div class="card-footer">
			  	<a class="btn btn-primary btn-small" href="/role/details/${item.id}"><i class="bi bi-info-square"></i><span class="ps-2">Details</span></a>
			  </div>
			</div>
		</div>

	</#list>
	</div>
</div>