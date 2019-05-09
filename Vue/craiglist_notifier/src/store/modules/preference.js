import globalAxios from "axios";
import router from '../../router'
import {mapGetters} from 'vuex'



const state =  {
  preferences : []
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
    state.preferences.push(pref)
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
    globalAxios.post('/submitPrefDetails', pref).catch(err => {
      console.log(err)
    })

    dispatch('fetchPrefs')
  },
  fetchPrefs({commit,dispatch,state,rootGetters}) {
    let userId = rootGetters.getUserHashId()

    console.log(userId)

    ""

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
