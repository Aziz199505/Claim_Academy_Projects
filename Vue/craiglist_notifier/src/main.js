import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/store'
import axios from 'axios'

import VueGeolocation from 'vue-browser-geolocation';
import VueTagsInput from '@johmun/vue-tags-input';


Vue.use(VueGeolocation);
Vue.use(VueTagsInput);

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


Vue.component('time-picker', {
  props:["value"],
  data(){
    return {
      selectedTime: this.value
    }
  },
  template: "<input size='6' type='text' v-model='selectedTime' @input='onInput'>",
  methods:{
    onInput(){
      this.$emit('input', this.selectedTime)
    }
  },
  mounted () {
    new flatpickr(this.$el, {
      enableTime: true,
      noCalendar: true,
      dateFormat: "h:i K",
      time_24hr: false
    })
  }
})


Vue.config.productionTip = false


new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
