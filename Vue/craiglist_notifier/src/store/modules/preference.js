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

    //Note I am here

    console.log("Pref Index: " + prefResult.index + " Preferences Length: " + state.preferences.length)

    let notFound = true

    state.prefResults.forEach((e,index) =>  {
      if(JSON.stringify(e) === JSON.stringify(prefResult.data)) notFound = false;
    })


    if(notFound) {
      state.prefResults.unshift(prefResult.data)
      while(state.prefResults.length > state.preferences.length) {
        console.log("It ran")
        state.prefResults.pop()
        console.log("This is what supposed to be")
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

  addPref: function ({commit, dispatch, state}, pref) {
    console.log("I sumbitted")
    console.log(pref)
    globalAxios.post('/submitPrefDetails', pref)
      .then(res => {
        dispatch('fetchPrefs')
      })

      .catch(err => {
      console.log(err)
    })


  },
  fetchPrefs({commit,dispatch,state,rootGetters}) {
    let userId = rootGetters.getUserHashId.userId

    console.log(userId)

    globalAxios.post('/fetchPrefs', {
      userId
    }).then(res => {
      console.log(res)
      commit('storePref',res.data)
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
          return e
        } )





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
