import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import {routes} from './routes.js'

Vue.use(VueRouter)

var router = new VueRouter({
  routes,
  mode : 'history'

})



router.beforeEach((to,from,next) => {
  console.log('global beforeEach')
  next()
} )



new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
