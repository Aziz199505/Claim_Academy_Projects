import globalAxios from "axios";
import axios from "axios"
import router from '../../router'
import {mapGetters} from 'vuex'



const state =  {
  preferences : [],
  prefResults : []
}

const mutations = {
  /* setAuth(state,payload) {
     state.idToken = payload.token
     state.userId = payload.userId
   },*/
/*  storeArea(state,areas){
    state.areas = areas

  }*/

  storePref(state,pref) {
    state.preferences = pref
  },

  storePrefResult(state,prefResult) {

    //Note I am here still need update logic in future

    console.log("Pref Index: " + prefResult.index + " Preferences Length: " + state.preferences.length)

    let notFound = true
    //let removeIndex = 0;
    state.prefResults.forEach((e,index) =>  {
      if(JSON.stringify(e) === JSON.stringify(prefResult.data)) {
        notFound = false;
      }
    })


    if(notFound) {


      let tempPrefId = prefResult.data[0].prefId
      let exist = false
      let prefIndex = 0;
      state.prefResults.forEach((e,index) => {
        if(e[0].prefId === tempPrefId) {
          console.log("Found prefID and removing it at " + index)
          prefIndex = index
          exist = true
        }
      })



      if(exist) {

        state.prefResults.splice(prefIndex,1);
        state.prefResults.unshift(prefResult.data)
      }

      else {
        state.prefResults.unshift(prefResult.data)

        if(state.prefResults.length > 0 && state.preferences.length > 0 ) {
          /// BUGGGGGGGG Fix it***
          while(state.prefResults.length > state.preferences.length) {
            console.log("It ran")
            state.prefResults.pop()
            console.log("This is what supposed to be")

          }
          state.prefResults.unshift(prefResult.data)
        }

      }






    }

  },
  removePrefResult(state,prefId) {
    let prefIndex = 0;


   state.prefResults.forEach((e,index) => {
     if(e[0].prefId === prefId) {
       console.log("Found prefID and removing it at " + index)
       prefIndex = index
     }
    })


    state.prefResults.splice(prefIndex,1);

  }


}
const actions =  {
/*  fetchAreas({commit,dispatch,state}) {
    globalAxios.get(state.cors + state.refAreas )
      .then(res => {
        //commit('setAuth',{token : res.data.idToken, userId : res.data.localId})
        //console.log(res.data)
        commit('storeArea',res.data)
        //router.push('/thank-you')
        //dispatch('storeData',authData)
      })
      .catch(error => console.log(error))
  }*/

  addingToPrefResults({commit,state,dispatch,rootGetters},prefIndex) {


    //console.log("My prex index " + prefIndex + " prefs " + this.getPrefs.length)


    console.log("My prefindex : " + prefIndex)
    let eachPref = state.preferences[prefIndex]

    console.log("===========Each Prefs=============")
    console.log(eachPref.search)

    //Some Dispatch every some 1 seconds
    //console.log(this.getPrefs[this.prefIndex])
    console.log("=====PREF ID==== " + eachPref.prefId )
    let options = {
      payload: {
        category: eachPref.category,
        maxPrice: eachPref.maxPrice === 0 ? "" : eachPref.maxPrice,
        minPrice: eachPref.minPrice === 0 ? "" : eachPref.minPrice,
        postedToday: true,
        hasImage: eachPref.hasPic,
        city: eachPref.baseHost
      },
      prefIndex: prefIndex ,
      search : eachPref.search ,
      prefId : eachPref.prefId

    }



    axios.post(rootGetters.getMyCors+"http://localhost:3000/prefSearchPrice",{options : options.payload, search : options.search})
      .then(res => {
        console.log("=====Pref Result Price====")
       // console.log(res.data)
        options.priceReults = res.data

        dispatch('fetchPrefResults', options
        )

        /*.then(() => {
          console.log("This is result")
          console.log(this.getPrefsResults)
        })*/
      } )
      .catch(err => console.log(err) )












  },



  addPref: function ({commit, dispatch, state}, pref) {
    console.log("I sumbitted")
    console.log(pref)
    globalAxios.post('/submitPrefDetails', pref)
      .then(res => {
        dispatch('fetchPrefs',"add")
      })

      .catch(err => {
      console.log(err)
    })


  },
  clearPrefs({commit,dispatch,state,rootGetters}) {
    state.preferences = []
    state.prefResults = []
  },
  fetchPrefs({commit,dispatch,state,rootGetters},status) {
    let userId = rootGetters.getUserHashId.userId

    console.log(userId)

    globalAxios.post('/fetchPrefs', {
      userId
    }).then(res => {
      console.log(res)

      console.log("preference length: " + state.preferences.length)
      let prefLength = state.preferences.length


      commit('storePref',res.data)
      if(prefLength === 0) {
        console.log("Add all cars=============")
        state.preferences.forEach((e,index) => {
          dispatch('addingToPrefResults',index)
        } )
      }else {

        if(status === "add") {
          let existPrefs = [...state.preferences.map(e => {
            return e.prefId
          } )]

          let tempPrefs = [...existPrefs]

          console.log("Add all cars Sumbided=============")
          console.log(state.preferences)
          //dispatch('addingToPrefResults',0)

          console.log(state.prefResults)
          state.prefResults.forEach((e,index) => {
            if(existPrefs.includes(e[0].prefId)) {
              tempPrefs.splice(existPrefs.indexOf(e[0].prefId),1)
            }

            //dispatch('addingToPrefResults',index)
          } )

          dispatch('addingToPrefResults',existPrefs.indexOf(tempPrefs[0]))

          console.log(existPrefs)

        }
      }





    }).catch(err => {
      console.log(err)
    })

  },

  deletePref ({commit, dispatch, state,rootGetters}, prefId) {
    let userId = rootGetters.getUserHashId.userId

    globalAxios.post('/deletePref', {
      prefId,
      userId
    }).then(res =>  {

      dispatch('fetchPrefs').then(() => {
        console.log("Removing from pref results")
        commit('removePrefResult',prefId)
      } )

    })


      .catch(err => {
        console.log(err)
      })


  },
  fetchPrefResults({commit, dispatch, state,rootGetters},pref) {


    axios.post(rootGetters.getMyCors+"http://localhost:3000/prefSearch",{options : pref.payload, search : pref.search})
      .then(res => {
        //console.log(res)
       /* let filterData = res.data.filter(e =>  {
          console.log(e.title + " my search: " + pref.search)
          //console.log()

          if(e.title.toLowerCase().indexOf(pref.search) > -1) return e
        } )
*/



        let prefResult = res.data.map(e => {
          e.prefId = pref.prefId
          let info = pref.priceReults.filter(d => {
            if(e.pid === d.pid) return d
          } )[0]

          e.price = info.price
          e.location = info.location

          return e
        } )

        console.log(prefResult)
        console.log(pref.priceReults)


        commit('storePrefResult',{data : prefResult, index : pref.prefIndex})
      })
      .catch(err => {
        console.log()

      })


    }

}
const getters =  {
  getPrefs(state) {
    return state.preferences
  },
  getPrefsResults(state) {
    return state.prefResults
  }

  /* getAuth(state) {
     return {token: state.idToken,userId : state.userId}
   },*/
/*  getCors(state) {
    return state.cors
  },
  getRefAreas(state) {
    return state.areas
  },
  getStates(state) {
    return state.states
  },
  getCategory(state) {
    return state.category
  }*/

  /*,


  getUser(state) {
    return !(state.user) ? false : state.user;
  }*/
}

export default {
  state,
  mutations,
  actions,
  getters
}
