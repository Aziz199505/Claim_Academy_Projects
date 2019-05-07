<template>
  <nav class="col-md-5 col-lg-6 col-xs-6 d-none d-md-block bg-light sidebar text-center">
    <div class="sidebar-sticky">
      <ul class="nav row">
        <slot></slot>
        <!--<li class="nav-item">

        </li>-->

      </ul>
    </div>
  </nav>


</template>



<script>

  export default {
    data() {
      return {

      }
    }

  }
</script>

<style scoped>



  .sidebar {
    position: relative;
    top: 0;
    bottom: 0;
    left : 0;
    z-index: 100; /* Behind the navbar */
    padding: 0;
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);

  }

  .sidebar-sticky {
    position: -webkit-sticky;
    position: sticky;
    top: 35px; /* Height of navbar */
    height: calc(100vh - 48px);
    padding-top: 0rem;
    overflow-x: hidden;
    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
  }

  .sidebar .nav-link {
    font-weight: 500;
    color: #333;
  }

  .sidebar .nav-link .feather {
    margin-right: 4px;
    color: #999;
  }

  .sidebar .nav-link.active {
    color: #007bff;
  }

  .sidebar .nav-link:hover .feather,
  .sidebar .nav-link.active .feather {
    color: inherit;
  }

  .sidebar-heading {
    font-size: .75rem;
    text-transform: uppercase;
  }

  /*
     * Utilities
     */

  .border-top { border-top: 1px solid #e5e5e5; }
  .border-bottom { border-bottom: 1px solid #e5e5e5; }

</style>
