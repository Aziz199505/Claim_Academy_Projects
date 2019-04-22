<template>
  <div>
    <app-dashboard-nav></app-dashboard-nav>

    <div class="container-fluid">
      <div class="row">
        <app-side-bar-nav></app-side-bar-nav>

        <app-dashboard-header></app-dashboard-header>



      </div>

    </div>
  </div>

</template>

<script>
  import dashboardNav from './dashboard_components/dashboardNav.vue'
  import sideBarNav from './dashboard_components/sideBarNav.vue'
  import dashboardHeader from './dashboard_components/dashboardHeader.vue'
  export default
  {
    components : {
      appDashboardNav : dashboardNav,
      appSideBarNav : sideBarNav,
      appDashboardHeader : dashboardHeader
    }
  }

</script>

<style scoped>


</style>
