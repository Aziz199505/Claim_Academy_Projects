<template>
  <nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">
            <span data-feather="home"><icon-home></icon-home></span>
            Dashboard <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="file"><file-icon></file-icon></span>
            Orders
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="shopping-cart"><cart-icon></cart-icon></span>
            Products
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="users"><icon-user></icon-user></span>
            Customers
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="bar-chart-2"><icon-bar-chart></icon-bar-chart></span>
            Reports
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="layers"><icon-layer></icon-layer></span>
            Integrations
          </a>
        </li>
      </ul>

      <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
        <span>Saved reports</span>
        <a class="d-flex align-items-center text-muted" href="#">
          <span data-feather="plus-circle"><icon-plus></icon-plus></span>
        </a>
      </h6>
      <ul class="nav flex-column mb-2">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="file-text"><icon-file-text></icon-file-text></span>
            Current month
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="file-text"><icon-file-text></icon-file-text></span>
            Last quarter
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="file-text"><icon-file-text></icon-file-text></span>
            Social engagement
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span data-feather="file-text"><icon-file-text></icon-file-text></span>
            Year-end sale
          </a>
        </li>
      </ul>
    </div>
  </nav>


</template>



<script>
  import {HomeIcon,FileIcon,ShoppingCartIcon,UsersIcon,BarChart2Icon,LayersIcon,FileTextIcon,PlusCircleIcon} from 'vue-feather-icons'

  export default {
    data() {
      return {

      }
    },
    components : {
      iconHome : HomeIcon,
      fileIcon : FileIcon,
      cartIcon : ShoppingCartIcon,
      iconUser : UsersIcon,
      iconBarChart : BarChart2Icon,
      iconLayer : LayersIcon,
      iconFileText : FileTextIcon,
      iconPlus : PlusCircleIcon
    }

  }
</script>

<style scoped>

  .sidebar {
    position: relative;
    top: 0;
    bottom: 0;
    left: 0;
    z-index: 100; /* Behind the navbar */
    padding: 0;
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
  }

  .sidebar-sticky {
    position: -webkit-sticky;
    position: sticky;
    top: 48px; /* Height of navbar */
    height: calc(100vh - 48px);
    padding-top: .5rem;
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
