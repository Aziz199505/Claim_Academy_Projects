<template>
  <div id="app">


    <app-header></app-header>



    <router-view></router-view>


  </div>
</template>

<script>

import header from './components/header/header.vue'

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components : {
    appHeader : header
  },
  created() {
    this.$store.dispatch('fetchAreas')
  }
}
</script>

<style>

</style>
