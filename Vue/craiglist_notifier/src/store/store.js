import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import stat from './modules/static'
import createPersistedState from 'vuex-persistedstate'



Vue.use(Vuex)

export default new Vuex.Store({
  modules : {
    user,
    stat
  },
  plugins: [createPersistedState({
    //paths: ['user','hashId']
    storage: window.sessionStorage

  }) ]
})
