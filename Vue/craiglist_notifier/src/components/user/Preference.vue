<template>


  <div class="container-fluid">
    <div class="row">

      <app-side-bar>
        <li v-for="i in 4" class="nav-item">
        <div  class="card user-card">
          <div class="card-block">
            <div class="user-card-image d-inline-block"><img src="http://placehold.it/150x150" class="img-circle"></div>
            <div class="user-card-content text-nowrap d-inline-block">
              <h5 class="card-title">Chris Lnrd</h5>
              <div class="card-text">Free User</div>
              <div class="card-text dental-text font-weight-bold">Dental Medicine</div>
              <div class="card-text">Generation 2016 - Group 11</div>
            </div>
          </div>
        </div>
        </li>
      </app-side-bar>




    </div>

  </div>



</template>

<script>
  import SideBarItem from './SideBarItem.vue'
  export default {
    components : {
      appSideBar : SideBarItem
    }
  }

</script>

<style scoped>

  .list-group{
      text-align: center;
      max-height: 200px;
      max-width: 500px;
      margin-bottom: 10px;
      overflow:scroll;
      -webkit-overflow-scrolling: touch;
    }

  .card.user-card {
    display: table;

  }
  .card-block {
    display: table-row;

  }
  .user-card-image {
    display: table-cell;
    vertical-align: middle;
    padding: 20px;
    border: 1px solid #e6e6e6;
  }
  .user-card-content {
    display: table-cell;
    vertical-align: middle;
    padding: 20px;

    border: 1px solid #e6e6e6;
  }
</style>
