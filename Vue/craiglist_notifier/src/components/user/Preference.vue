<template>


  <div class="container-fluid">
    <div class="row">

      <app-side-bar v-if="hideList">
        <li v-for="i in 4" class="nav-item">
          <app-listed-item></app-listed-item>
        </li>
      </app-side-bar>

      <main role="main" :class="adjustMain" class=" ml-sm-auto pt-3 px-4">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
          <h1 class="h2">Preferences</h1>
          <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">
              <button @click="prefState = !prefState" data-toggle="modal" data-target="#modalAddCarForm" class="btn btn-sm btn-outline-primary">Add</button>
              <button class="btn btn-sm btn-outline-danger">Remove</button>
            </div>
            <div class="dropdown">
              <button class="btn btn-sm btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown">Preferences
                <span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#">HTML</a></li>
                <li><a href="#">CSS</a></li>
                <li><a href="#">JavaScript</a></li>
              </ul>
            </div>
            <button @click="hideList = !hideList" class="btn btn-sm btn-outline-info">Hide Listed</button>



          </div>
        </div>
        <h2>Section title</h2>


      </main>


    </div>

    <app-pref-modal v-if="prefState"></app-pref-modal>

  </div>



</template>

<script>
  import SideBarItem from './SideBarItem.vue'
  import ListedItem from './ListedItem.vue'
  import PrefModal from './PreferenceModal.vue'

  export default {
    data() {
      return {
        prefState : false,
        hideList : true
      }
    },
    components : {
      appSideBar : SideBarItem,
      appListedItem : ListedItem,
      appPrefModal : PrefModal
    },
    computed : {


      adjustMain() {
        return {
          "col-md-9 col-xs-8 col-lg-10" : this.hideList,
          "col-md-12 col-xs-12 col-lg-12" : !this.hideList
        }
      }
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


</style>
