<template>
  <div>
    <h1>User Edit</h1>
    <p>Local : {{$route.query.local}}</p>
    <p>Q : {{$route.query.q}}</p>
    <hr>
    <button class="btn btn-primary" @click="confirmed = true">Confirm</button>
    <div style="height: 700px"></div>
    <p id="data">Some extra Data</p>
  </div>

</template>


<script>
  export default {
    data() {
      return {
        confirmed : false
      }
    },
    beforeRouteLeave(to,from,next) {
      if(this.confirmed) {
        next()
      } else {
        if(confirm('Are you sure?')){
          next()
        }else {
          next(false)
        }
      }

    }

  }

</script>


<style>

</style>
