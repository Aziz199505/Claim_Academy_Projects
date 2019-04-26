<template>
  <div style="width: 100%;"  class="card user-card col-md-12">
    <div class="card-block">
      <div class="user-card-image d-inline-block"><img src="http://placehold.it/150x150" class="img-circle"></div>
      <div class="user-card-content text-nowrap  d-inline-block">
        <h5 class="card-title">Chris Lnrd</h5>
        <div class="card-text">Free User</div>
        <div class="card-text dental-text font-weight-bold">Dental Medicine</div>
        <div class="card-text">Generation 2016 - Group 11</div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {

  }

</script>


<style scoped>

  .card.user-card {
    display: table;



  }
  .card-block {
    display: table-row;
  }
  .user-card-image {
    display: table-cell;
    vertical-align: middle;
    padding: 0px;

  }
  .user-card-content {
    display: table-cell;
    vertical-align: middle;
    padding: 0px;

  }

</style>
