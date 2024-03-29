import Vue from 'vue'
import Vuex from 'vuex'
import counter from './modules/counter'
import * as getters from './getters.js'
import actions from './actions.js'
import mutations from './mutations.js'
Vue.use(Vuex)

export const store = new Vuex.Store({
    state : {
        value : 0
    },
    getters,
    mutations,
    actions,
    modules : {
        counter
    }

})