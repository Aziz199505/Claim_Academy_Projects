import globalAxios from "axios";
import router from '../../router'
import Hashids from 'hashids'

const hash =  new Hashids('',10)

const state =  {
  areas : null,
  cors : "https://cors-anywhere.herokuapp.com/",
  refAreas : "https://reference.craigslist.org/Areas"
}

const mutations = {
  /* setAuth(state,payload) {
     state.idToken = payload.token
     state.userId = payload.userId
   },*/
  storeArea(state,areas){
    state.areas = areas

  },


}
const actions =  {
  fetchAreas({commit,dispatch,state}) {
    globalAxios.get(state.cors + state.refAreas )
      .then(res => {
        //commit('setAuth',{token : res.data.idToken, userId : res.data.localId})
        //console.log(res.data)
        commit('storeArea',res.data)
        //router.push('/thank-you')
        //dispatch('storeData',authData)
      })
      .catch(error => console.log(error))
  }


}
const getters =  {
  /* getAuth(state) {
     return {token: state.idToken,userId : state.userId}
   },*/
  getCors(state) {
    return state.cors
  },
  getRefAreas(state) {
    return state.areas
  }

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
