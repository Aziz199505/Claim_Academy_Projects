import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/store'
import axios from 'axios'
import VueGeolocation from 'vue-browser-geolocation';


Vue.use(VueGeolocation);


axios.defaults.baseURL = 'http://localhost:8080'
//axios.defaults.headers.common['Authorization'] = 'fasfdsa'
axios.defaults.headers.get['Accepts'] = 'application/json'
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'
axios.defaults.headers.get['Access-Control-Allow-Methods'] = 'DELETE, POST, GET, OPTIONS'
axios.defaults.headers.get['Access-Control-Allow-Headers'] = 'Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With'



const reqInterceptor = axios.interceptors.request.use(config => {
  console.log('Request Interceptor', config)
  return config
})
const resInterceptor = axios.interceptors.response.use(res => {
  console.log('Response Interceptor', res)
  return res
})

axios.interceptors.request.eject(reqInterceptor)
axios.interceptors.response.eject(resInterceptor)


new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
