<template>
  <div>
    <h1>Users</h1>

    <button @click="$router.push('/')" class="btn btn-primary">Home</button>
    <hr>

    <transition
      appear
      enter-active-class="animated slideInLeft"
      leave-active-class="animated slideOutRight"
      mode="out-in"
    >
    <router-view></router-view>
    </transition>
  </div>

</template>


<script>


</script>


<style>

</style>
