<template>
  <div>
    <ul class="list-group">
        <transition-group
          appear
          enter-active-class="animated fadeIn"
          leave-active-class="animated fadeOut"
          mode="out-in"
        >
          <router-link :key="n" tag="li" v-for="n in 3" class="list-group-item" :to="'/user/' + n">User ID: {{n}}</router-link>

        </transition-group>

    </ul>

  </div>

</template>


<script>


</script>


<style scoped>
  li {
    cursor: pointer;
  }

</style>
