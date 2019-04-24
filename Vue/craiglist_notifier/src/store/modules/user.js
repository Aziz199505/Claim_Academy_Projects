import globalAxios from "axios";
import router from '../../router'


const state =  {
    user : null
}

const mutations = {
 /* setAuth(state,payload) {
    state.idToken = payload.token
    state.userId = payload.userId
  },*/
  storeUser(state,user){
    state.user = user
  }

}
const actions =  {
  signUp({commit,dispatch},authData) {
    globalAxios.post('/submitUserDetails', {
      email : authData.email,
      password : authData.password,
      username : authData.username,
      firstName : authData.firstName,
      lastName : authData.lastName,
      cellPhone : authData.cellPhone
    })
      .then(res => {
        //commit('setAuth',{token : res.data.idToken, userId : res.data.localId})
        console.log(res)
        router.push('/thank-you')
        //dispatch('storeData',authData)
      })
      .catch(error => console.log(error))
  },
  signIn({commit},authData) {
    globalAxios.post("/login", {
      email : authData.email,
      password : authData.password
    }).then(res => {
      commit('storeUser',res.data)
      router.push('/')
      console.log(res.data)
    }).catch(error => {
      console.log(error)
    })
  },
  fetchUser({commit,state}) {
    if(!(state.idToken)) return;
    globalAxios.get('/users.json?auth=' + state.idToken + "&uid=" + state.userId)
      .then(res => {
        console.log(res)
        const data = res.data
        const users = []
        for (let key in data) {
          const user = data[key]
          user.id = key
          users.push(user)
        }
        console.log(users)
        //this.email = users[0].email
        commit('storeUser',users[0])
      })
      .catch(error => console.log(error))
  },
  storeData({commit,state},formData){
    /*if(!(state.idToken)) return;
    globalAxios.post('/users.json?auth=' + state.idToken,formData).
    then(res => {
      commit('storeUser',formData)
    }).
    catch(error => {
      console.log(error)
    })*/

  }


}
const getters =  {
 /* getAuth(state) {
    return {token: state.idToken,userId : state.userId}
  },*/
  getUser(state) {
    return !(state.user) ? false : state.user;
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}
