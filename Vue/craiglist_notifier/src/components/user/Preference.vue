<template>


  <div class="container-fluid">
    <div class="row">

      <app-side-bar v-if="hideList">

          <app-listed-item  v-for="(item,index) in allResults" :info="item"  :id="index"></app-listed-item>


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


        <div  class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom row">
          <div class="col-md-1">
            #
          </div>
          <div class="col-md-3">
            <span style="cursor: pointer" @click="switchSort('city','asc')" class="capitalize"> City </span> <span style="cursor: pointer" @click="sortedOrder == 'asc' ? switchSort('city','desc') : switchSort('city','asc') " v-if="selectedSort == 'city'" class="fa fa-fw fa-sort"></span>
          </div>
          <div class="col-md-3">
            <span style="cursor: pointer" @click="switchSort('search','asc')"> Search </span>  <span style="cursor: pointer" @click="sortedOrder == 'asc' ? switchSort('search','desc') : switchSort('search','asc') "  v-if="selectedSort == 'search'" class="fa fa-fw fa-sort"></span>
          </div>
          <div class="col-md-4">
            <span style="cursor: pointer" @click="switchSort('descp','asc')"> Description </span>  <span style="cursor: pointer" @click="sortedOrder == 'asc' ? switchSort('descp','desc') : switchSort('descp','asc') "   v-if="selectedSort == 'descp'"class="fa fa-fw fa-sort"></span>
          </div>
          <div class="col-md-1">

          </div>
        </div>

        <div  v-for="(item,index) in sortedPref" class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom row">
          <div class="col-md-1">
            {{index + 1}}
          </div>
          <div class="col-md-3">
            <span class="capitalize"> {{item.city}} </span>
          </div>
          <div class="col-md-3">
            <span> {{item.search}} </span>
          </div>
          <div class="col-md-4">
            <span> {{item.descp}} </span>
          </div>
          <div class="col-md-1">
            <button @click="removePref(item.prefId)" type="button" class="close" aria-label="Close">
              <span  aria-hidden="true">&times;</span>
            </button>
          </div>
        </div>

      </main>


    </div>

    <app-pref-modal v-if="prefState"></app-pref-modal>

  </div>



</template>

<script>
  import SideBarItem from './SideBarItem.vue'
  import ListedItem from './ListedItem.vue'
  import PrefModal from './PreferenceModal.vue'
  import {mapGetters, mapState} from 'vuex'

  export default {
    data() {
      return {
        selectedSort : 'search',
        prefIndex : 0,
        prefState : false,
        hideList : true,
        sortedOrder : 'asc',
        sortedPref : {}
      }
    },
    components : {
      appSideBar : SideBarItem,
      appListedItem : ListedItem,
      appPrefModal : PrefModal
    },
    methods : {
      switchSort (sortby,order) {
        this.selectedSort = sortby

        if(order == 'desc') {
          this.sortedPref = this.getPrefs.sort(this.compareValues(sortby,'desc'))
          this.sortedOrder = 'desc'
        } else {
          this.sortedPref = this.getPrefs.sort(this.compareValues(sortby))
          this.sortedOrder = 'asc'
        }




      },
      resultFetcher() {
        setInterval(() => {
          if(this.getPrefs.length > 0) {

            console.log("My prefindex : " + this.prefIndex)
            let eachPref = this.getPrefs[this.prefIndex]
            //Some Dispatch every some 1 seconds
            //console.log(this.getPrefs[this.prefIndex])

            this.$store.dispatch('fetchPrefResults', {
                payload: {
                  category: eachPref.category,
                  maxPrice: eachPref.maxPrice === 0 ? "" : eachPref.maxPrice,
                  minPrice: eachPref.minPrice === 0 ? "" : eachPref.minPrice,
                  postedToday: true,
                  hasImage: eachPref.hasPic,
                  city: eachPref.baseHost
                },
                prefIndex: this.prefIndex ,
                search : eachPref.search

              }
            ).then(() => {
              console.log("This is result")
              console.log(this.getPrefsResults)
            })


            this.prefIndex += 1;
            console.log("My prefindex : " + this.prefIndex + " Pref Length: " + this.getPrefs.length)
            if (this.prefIndex >= this.getPrefs.length) {
              this.prefIndex = 0
            }


          } else {
            console.log("Preference is zero")
          }


        },30000 )
      },
      removePref(prefId) {
        console.log("My prefId: " + prefId)
        this.$store.dispatch('deletePref',prefId)
      },
      compareValues(key, order='asc') {
        return function(a, b) {
          if(!a.hasOwnProperty(key) || !b.hasOwnProperty(key)) {
            // property doesn't exist on either object
            return 0;
          }

          const varA = (typeof a[key] === 'string') ?
            a[key].toUpperCase() : a[key];
          const varB = (typeof b[key] === 'string') ?
            b[key].toUpperCase() : b[key];

          let comparison = 0;
          if (varA > varB) {
            comparison = 1;
          } else if (varA < varB) {
            comparison = -1;
          }
          return (
            (order == 'desc') ? (comparison * -1) : comparison
          );
        };
      }

    },
    computed : {
      ...mapGetters([
        'getPrefs',
        'getPrefsResults'
      ]),

      ...mapState(['preferences']),

      allResults() {
        let results = []
        this.getPrefsResults.forEach(e => {
          results = [...results, ...e]
        } )

        return results

      },

      adjustMain() {
        return {
          "col-md-7 col-xs-6 col-lg-6" : this.hideList,
          "col-md-12 col-xs-12 col-lg-12" : !this.hideList
        }
      }
    },
    created() {
      this.$store.dispatch('fetchPrefs')
        .then(() => {
          this.sortedPref = this.getPrefs.sort(this.compareValues('search'))
        } )

      this.resultFetcher()
    },
    watch : {
      getPrefs : {
        handler(val){
          console.log("changed")
          this.sortedPref = val

          //this.sortedPref = val.sort(this.compareValues('search'))



          /*          console.log("Changed")
                    console.log(val)*/
          /*Object.entries(val).map((k,i) => {
           // console.log(k[0] + "," + k[1])
            k[1].forEach(e => {

              let parsed = e.split('-')
              let timeFrom = parsed[0]
              let timeTo = parsed[1]
              timeFrom = moment(timeFrom,'HH:mm A')._d
              timeTo = moment(timeTo,'HH:mm A')._d
             // console.log(timeFrom + " " + timeTo)



            })


          } )*/
        },
        deep: true
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

  .capitalize { text-transform: capitalize; }

  .close:focus, .close:active:focus, .close.active:focus{
    outline:none;
    box-shadow:none;
  }


</style>
