import globalAxios from "axios";
import router from '../../router'
import Hashids from 'hashids'

const hash =  new Hashids('',10)

const state =  {
  areas : null,
  cors : "https://cors-anywhere.herokuapp.com/",
  myCors : "http://localhost:8082/",
  refAreas : "https://reference.craigslist.org/Areas",
  states : {
    'AK': 'Alaska',
    'AL': 'Alabama',
    'AR': 'Arkansas',
    'AZ': 'Arizona',
    'CA': 'California',
    'CO': 'Colorado',
    'CT': 'Connecticut',
    'DC': 'District of Columbia',
    'DE': 'Delaware',
    'FL': 'Florida',
    'GA': 'Georgia',
    'HI': 'Hawaii',
    'IA': 'Iowa',
    'ID': 'Idaho',
    'IL': 'Illinois',
    'IN': 'Indiana',
    'KS': 'Kansas',
    'KY': 'Kentucky',
    'LA': 'Louisiana',
    'MA': 'Massachusetts',
    'MD': 'Maryland',
    'ME': 'Maine',
    'MI': 'Michigan',
    'MN': 'Minnesota',
    'MO': 'Missouri',
    'MP': 'Northern Mariana Islands',
    'MS': 'Mississippi',
    'MT': 'Montana',
    'NA': 'National',
    'NC': 'North Carolina',
    'ND': 'North Dakota',
    'NE': 'Nebraska',
    'NH': 'New Hampshire',
    'NJ': 'New Jersey',
    'NM': 'New Mexico',
    'NV': 'Nevada',
    'NY': 'New York',
    'OH': 'Ohio',
    'OK': 'Oklahoma',
    'OR': 'Oregon',
    'PA': 'Pennsylvania',
    'PR': 'Puerto Rico',
    'RI': 'Rhode Island',
    'SC': 'South Carolina',
    'SD': 'South Dakota',
    'TN': 'Tennessee',
    'TX': 'Texas',
    'UT': 'Utah',
    'VA': 'Virginia',
    'VI': 'Virgin Islands',
    'VT': 'Vermont',
    'WA': 'Washington',
    'WI': 'Wisconsin',
    'WV': 'West Virginia',
    'WY': 'Wyoming'
  },
  category : {
    'sss' : 'all',
    'ata' : 'antiques',
    'ppa' : 'appliances',
    'ara' : 'arts+crafts',
    'sna' : 'atvs/utvs/snow',
    'pta' : 'auto parts',
    'baa' : 'baby+kids',
    'bar' : 'barter',
    'haa' : 'beauty+hlth',
    'bip' : 'bike parts',
    'bia' : 'bikes',
    'bpa' : 'boat parts',
    'boo' : 'boats',
    'bka' : 'books',
    'bfa' : 'business',
    'cta' : 'cars+trucks',
    'ema' : 'cds/dvd/vhs',
    'moa' : 'cell phones',
    'cla' : 'clothes+acc',
    'cba' : 'collectibles',
    'syp' : 'computer parts',
    'sya' : 'computers',
    'ela' : 'electronics',
    'gra' : 'farm+garden',
    'zip' : 'free stuff',
    'fua' : 'furniture',
    'gms' : 'garage sales',
    'foa' : 'general',
    'hva' : 'heavy equipment',
    'hsa' : 'household',
    'jwa' : 'jewelry',
    'maa' : 'materials',
    'mpa' : 'motorcycle parts',
    'mca' : 'motorcycles',
    'msa' : 'music instr',
    'pha' : 'photo+video',
    'rva' : 'RVs',
    'sga' : 'sporting',
    'tia' : 'tickets',
    'tla' : 'tools',
    'taa' : 'toys+games',
    'vga' : 'video gaming',
    'waa' : 'wanted'
  }

}

const mutations = {
  /* setAuth(state,payload) {
     state.idToken = payload.token
     state.userId = payload.userId
   },*/
  storeArea(state,areas){
    state.areas = areas

  }


}
const actions =  {
  fetchAreas({commit,dispatch,state}) {
    globalAxios.get(state.myCors + state.refAreas )
      .then(res => {
        //commit('setAuth',{token : res.data.idToken, userId : res.data.localId})
        //console.log(res.data)
        commit('storeArea',res.data)
        //router.push('/thank-you')
        //dispatch('storeData',authData)
      })
      .catch(error => console.log(error))
  }


}
const getters =  {
  /* getAuth(state) {
     return {token: state.idToken,userId : state.userId}
   },*/
  getCors(state) {
    return state.cors
  },
  getRefAreas(state) {
    return state.areas
  },
  getStates(state) {
    return state.states
  },
  getCategory(state) {
    return state.category
  },
  getMyCors(state) {
    return state.myCors
  }

  /*,


  getUser(state) {
    return !(state.user) ? false : state.user;
  }*/
}

export default {
  state,
  mutations,
  actions,
  getters
}
