<template>
  <div class="container">

    <div class="row">
    <div class="col-xs-12 cold-sm-8 offset-sm-2  col-md-6 md-offset-3">
      <h1>Router</h1>
      <hr>
      <router-view name="header-top"></router-view>
      <transition
          appear
          enter-active-class="animated fadeInDown"
          leave-active-class="animated fadeOutUp"
          mode="out-in"
      >
        <router-view></router-view>
      </transition>


      <router-view name="header-bottom"></router-view>

      </div>
    </div>
  </div>
</template>

<script>

  export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      myList : []
    }
  }
}
</script>

<style>

  .animated {
    -webkit-animation-duration: 0.35s;
    animation-duration: 0.35s;
    -webkit-animation-fill-mode: both;
    animation-fill-mode: both;
  }

</style>
