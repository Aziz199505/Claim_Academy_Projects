import Vue from 'vue'
import VueRouter from 'vue-router'

import SignIn from './components/auth/SignIn.vue'
import SignUp from './components/auth/SignUp.vue'
import Home from './components/Home.vue'

import Dashboard from './components/dashboard/dashboard.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', component: Home},
  { path: '/home', component: Home},
  { path: '/sign-in', component: SignIn },
  { path: '/sign-up', component: SignUp},
  { path : '/dashboard',component : Dashboard}
]

export default new VueRouter({mode: 'history', routes})
