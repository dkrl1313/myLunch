<template>
    <div id="app">
        <div id="body">
            <router-view></router-view>
        </div>

        <loading v-show="isLoading"></loading>
    </div>
</template>

<script>
import Loading from "@/components/common/Loading";
import { mapState } from "vuex";
// import axios from "axios";

export default {
    name: "App",

    components: {
        Loading
    },

    created: function() {
        // axios.get("/api/kakao/").then(result => {
        //     console.log(result);
        // });
    },

    computed: mapState({
        isLoading: state => state.isLoading
    })
};
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
