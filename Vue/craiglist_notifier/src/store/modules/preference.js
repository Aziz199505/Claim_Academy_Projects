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
    if(this.prefIndex >= state.preferences.length - 1) {state.prefResult.pop()}


    state.prefResults.push(prefResult.data)
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
      dispatch('fetchPrefs')
    })


      .catch(err => {
        console.log(err)
      })


  },
  fetchPrefResults({commit, dispatch, state,rootGetters},pref) {

    axios.post(rootGetters.getMyCors+"http://localhost:3000/prefSearch",pref.payload)
      .then(res => {
        console.log(res)
        commit('storePrefResult',{data : res.data, index : pref.prefIndex})
      })
      .catch(err => {
        console.log()

      })


    }

}
const getters =  {
  getPrefs(state) {
    return state.preferences
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
