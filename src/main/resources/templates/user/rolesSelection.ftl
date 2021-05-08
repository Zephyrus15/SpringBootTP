<label for="firstname" class="form-label">Role</label>
<select name="roleId" class="form-select">
  <option selected disabled>No role</option>
  <#list roles as key, value>
    <option value="${key}">${value}</option>
  </#list>
</select>