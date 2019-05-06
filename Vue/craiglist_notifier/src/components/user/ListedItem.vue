<template>
  <div style="width: 100%;"  class="card  user-card col-md-12 col-lg-4 col-xs-12">
    <div class="card-block">
      <div class="user-card-image d-inline-block"><!--<img src="http://placehold.it/150x150" class="img-circle">-->
        <div :id="'carouselExampleFade'+id"  class="carousel slide carousel-fade" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img width="100%" height="225" focusable="false" preserveAspectRatio="xMidYMid slice" class="d-block w-100" src="https://images.craigslist.org/00A0A_401JdhXQqem_300x300.jpg"
                   alt="First slide">
            </div>
            <div class="carousel-item">
              <img width="100%" height="225" focusable="false" preserveAspectRatio="xMidYMid slice" class="d-block w-100" src="https://images.craigslist.org/00r0r_5Q6KpjYMf7V_300x300.jpg"
                   alt="Second slide">
            </div>
            <div class="carousel-item">
              <img width="100%" height="225" focusable="false" preserveAspectRatio="xMidYMid slice" class="d-block w-100" src="https://images.craigslist.org/00101_eauvCPgt1l_300x300.jpg"
                   alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" :href="'#carouselExampleFade'+id" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" :href="'#carouselExampleFade'+id" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>


      </div>
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
    props : ["id"]
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
