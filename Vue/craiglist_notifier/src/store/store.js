import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import stat from './modules/static'
import pref from './modules/preference'
import createPersistedState from 'vuex-persistedstate'



Vue.use(Vuex)

export default new Vuex.Store({
  modules : {
    user,
    stat,
    pref
  },
  plugins: [createPersistedState({
    //paths: ['user','hashId']
    storage: window.sessionStorage

  }) ]
})
