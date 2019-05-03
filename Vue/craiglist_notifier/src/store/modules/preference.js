import globalAxios from "axios";
import router from '../../router'


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

  addPref({commit,dispatch,state},pref) {
      commit('storePref',pref)
  },
  fetchPrefs({commit,dispatch,state}) {

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
