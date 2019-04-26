import Vue from 'vue'
import VueRouter from 'vue-router'

import SignIn from './components/auth/SignIn.vue'
import SignUp from './components/auth/SignUp.vue'
import Home from './components/Home.vue'
import thankYou from './components/auth/thank-you.vue'
import User from './components/user/User.vue'
import store from './store/store'
import Preference from './components/user/Preference.vue'

import Dashboard from './components/dashboard/dashboard.vue'

Vue.use(VueRouter)

const routerRule = (to,from,next) => {
  /*console.log(store.getters.getUserHashId)
  console.log(to.params.id)*/
  console.log('inside route setup')
  if(store.getters.getUserHashId && to.params.id == store.getters.getUserHashId.hashId) {
    next()
  }else {
    next('/')
  }
}

const routes = [
  { path: '/', component: Home},
  { path: '/home', component: Home},
  { path: '/sign-in', component: SignIn },
  { path: '/sign-up', component: SignUp},
/*
  { path : '/dashboard',component : Dashboard},
*/
  { path : '/thank-you', component : thankYou},
  {path : "/user/:id",name : "user",components : {
      default : User
    }, beforeEnter : routerRule , children : [
      {path : '', component : Preference},
      {path : '/user/:id/dashboard', name : "dashboard", component : Dashboard, beforeEnter : routerRule}
/*      {path : ':id/edit', component : UserEdit, name : 'UserEdit'}*/

    ]},
  {path : '*',redirect: '/'}
]

export default new VueRouter({mode: 'history', routes})
