<template>
    <div>
        <button @click="geofind">위치찾기</button>
        <p>{{ textContent }}</p>
    </div>
</template>

<script>
export default {
    created() {},
    data() {
        return {
            latitude: "",
            longitude: "",
            // gettingLocation: false,
            errorStr: null,
            textContent: null,
            api: ""
        };
    },
    methods: {
        geofind() {
            // var kakaoGeocoder = new kakao.maps.services.Geocoder();

            if (!("geolocation" in navigator)) {
                this.textContent = "Geolocation is not available.";
                return;
            }
            this.textContent = "Locating...";
            // this.gettingLocation = true;

            // var me = this;
            this.$store.commit("changeIsLoading", true);
            // get position
            navigator.geolocation.getCurrentPosition(
                pos => {
                    this.$store.commit("changeIsLoading", false);
                    // this.gettingLocation = false;
                    this.latitude = pos.coords.latitude;
                    this.longitude = pos.coords.longitude;
                    this.textContent =
                        "Your location data is " +
                        this.latitude +
                        ", " +
                        this.longitude;
                },
                err => {
                    this.$store.commit("changeIsLoading", false);
                    // this.gettingLocation = false;
                    this.textContent = err.message;
                }
            );
        }
    },
    mounted() {}
};
</script>

<style scoped>
/* @import './../components/css/styles.css'; */
</style>
