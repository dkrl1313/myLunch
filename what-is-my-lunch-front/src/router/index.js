import Vue from "vue";
import VueGeolocationApi from "vue-geolocation-api";
import VueRouter from "vue-router";
import Main from "../views/Main.vue";
import Sub001 from "../views/Sub001.vue";


// Vue.use(VueAxios, axios);
Vue.use(VueGeolocationApi);
Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Main",
        component: Main
    },
    {
        path: "/sub001",
        component: Sub001
    }
];

const router = new VueRouter({
    mode: "history",
    routes,
    scrollBehavior(to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition;
        } else {
            return { x: 0, y: 0 };
        }
    }
});

export default router;
