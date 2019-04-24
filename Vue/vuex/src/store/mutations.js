import * as types from './types.js'

export default {
    [types.UPDATE_VALUE] : (state,payload) => {
        state.value = payload
    }
}