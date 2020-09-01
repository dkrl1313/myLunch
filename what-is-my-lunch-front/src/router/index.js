import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import VueGeolocationApi from 'vue-geolocation-api'
import axios from 'axios'
import VueAxios from 'vue-axios'
 
Vue.use(VueAxios, axios)
Vue.use(VueGeolocationApi)
Vue.use(VueRouter)


  const routes = [
  {
    path: '/main',
    name: 'Main',
    component: Main
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
