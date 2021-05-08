<#include "../navbar/navbar.ftl"/>

<div class="container">
	<div class="row p-5">

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
			</div>
		</div>
	</#list>
	</div>
</div>