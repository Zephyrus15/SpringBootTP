<#include "../navbar/navbar.ftl"/>

<div class="container">

<form method="POST" class="pt-2">
  <label for="firstname" class="form-label">Firstname</label>
  <input type="text" class="form-control" id="firstname" name="firstname"/>
  <label for="lastname" class="form-label">Lastname</label>
  <input type="text" class="form-control" id="lastname" name="lastname"/>

  <#include "./rolesSelection.ftl">

  <input class="btn btn-primary btn-small mt-2" type="submit" value="Create"/>
</form>
</div>