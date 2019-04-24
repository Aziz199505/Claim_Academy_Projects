import Vue from 'vue'
import VueRouter from 'vue-router'

import SignIn from './components/auth/SignIn.vue'
import SignUp from './components/auth/SignUp.vue'
import Home from './components/Home.vue'
import thankYou from './components/auth/thank-you.vue'
import User from './components/user/User.vue'
import store from './store/store'

import Dashboard from './components/dashboard/dashboard.vue'

Vue.use(VueRouter)

const routerRule = (to,from,next) => {
  console.log(store.getters.getUserHashId)
  console.log('inside route setup')
  if(store.getters.getUserHashId) {
    next()
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
  {path : "/user",name : "user",components : {
      default : User
    }, beforeEnter : routerRule , children : [
      {path : '/:id/dashboard', name : "dashboard", component : Dashboard, beforeEnter : routerRule}
/*      {path : ':id/edit', component : UserEdit, name : 'UserEdit'}*/

    ]},
  {path : '*',redirect: '/'}
]

export default new VueRouter({mode: 'history', routes})
