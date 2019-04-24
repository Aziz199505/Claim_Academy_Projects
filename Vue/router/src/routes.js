import Home from './components/Home.vue'
import Header from './components/Header.vue'

//You can group as like this to combine into 1 bundle to optimize application
/*const User = resolve => {
  require.ensure(['./components/user/User.vue'], () => {
    resolve(require('./components/user/User.vue'))
  },'user' )
}


const UserDetail = resolve => {
  require.ensure(['./components/user/UserDetail.vue'], () => {
    resolve(require('./components/user/UserDetail.vue'))
  },'user' )
}*/



const User = resolve => {
  require.ensure(['./components/user/User.vue'], () => {
    resolve(require('./components/user/User.vue'))
  } )
}


const UserDetail = resolve => {
  require.ensure(['./components/user/UserDetail.vue'], () => {
    resolve(require('./components/user/UserDetail.vue'))
  } )
}


const UserEdit = resolve => {
  require.ensure(['./components/user/UserEdit.vue'], () => {
    resolve(require('./components/user/UserEdit.vue'))
  } )
}


const UserStart = resolve => {
  require.ensure(['./components/user/UserStart.vue'], () => {
    resolve(require('./components/user/UserStart.vue'))
  } )
}


export const routes = [
  {path : "/", name : 'Home', components : {
    default : Home,
      'header-top' : Header
    } },
  {path : "/user",name : "user",components : {
    default : User,
     'header-bottom' : Header
    }, beforeEnter : (to,from,next) => {
      console.log('inside route setup')
      next()
    } , children : [
      {path : '', component : UserStart},
      {path : ':id', component : UserDetail},
      {path : ':id/edit', component : UserEdit, name : 'UserEdit'}

    ]},
  {path : '*',redirect: '/'}
]
