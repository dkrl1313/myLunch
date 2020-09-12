import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        isLoading: false
    },
    mutations: {
        changeIsLoading: (state, payload) => {
            state.isLoading = payload;
        }
    },
    actions: {},
    modules: {}
});

export default store;
