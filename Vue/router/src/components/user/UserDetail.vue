<template>
  <div class="row">
    <div class="col-md-12">
      <h1>Users Detail</h1>

    </div>



    <div class="col-md-6 ">
      <p>User ID:   {{$route.params.id}}</p>
    </div>


      <div class="col-md-6">
        <router-link tag="button" to="/user" class="btn btn-primary">Back</router-link>
      </div>
      <hr>
      <div class="col-md-12">
        <router-link tag="button" :to="link" class="btn btn-primary">Edit</router-link>
      </div>



  </div>

</template>


<script>
  export default {
    data() {
      return {
        link : {name : 'UserEdit',
        param : {id : this.$route.params.id},
        query : {local : 'en', q : 100},
        hash : '#data'
        },

      }
    },
    beforeRouteEnter(to,from,next) {
      next()
    }
  }


</script>


<style>

</style>
