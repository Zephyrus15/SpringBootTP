<#include "../navbar/navbar.ftl"/>

<div class="container">
<form method="POST" class="pt-2">
  <label for="name" class="form-label">Name</label>
  <input type="text" class="form-control" id="name" name="name"/>
  
  <label for="name" class="form-label">Price</label>
  <input type="text" class="form-control" id="price" name="price"/>
  
  <label for="name" class="form-label">Nombre de page</label>
  <input type="number" class="form-control" id="nbPage" name="nbPage"/>
  
  <input class="btn btn-primary btn-small mt-2" type="submit" value="Create"/>
</form>
</div>