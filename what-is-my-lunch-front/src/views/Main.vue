<template>
    <div>
        <button @click="callKakaoApi">위치찾기</button>
        <p>{{ textContent }}</p>

        <div class="all_wrap">
            <div class="wrap">
                <div class="content_wrap">
                    <div class="content">
                        <div class="main_tit">
                            오늘<br />뭐<br />먹을까?
                        </div>
                        <div class="main_con">
                            <p>너의 한끼.<br />내가 책임질게.</p>
                            <div class="main_btn_box">
                                <div class="circle_box wobble-hor-bottom">
                                    <a><button class="random_btn" @click="showModal">랜덤<br />선택</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="ex1" class="modal" v-show="isShow">
            <div class="modal_tit_box">
                <h2>오늘의 식사는!</h2>
            </div>
            <div class="modal_con_box">
                <p>송파점</p>
                <p class="txt_red">청년다방</p>
                <div>
                    <span><i class="la la-crosshairs"></i>500M</span>
                    <span><i class="la la-cutlery"></i>분식</span>
                </div>
            </div>
            <div class="modal_btn_box">
                <a href="#" rel="modal:close"><button class="">싫어요</button></a>
                <a href="#" rel="modal:close"><button class="">좋아요</button></a>
            </div>

        </div>

    </div>
</template>
<script src="../components/js/jquery.min.js"></script>
<script src="../components/js/jquery.modal.min.js"></script>
<script>
    import axios from "axios";

    export default {
        created() {

        },
        data() {
            return {
                latitude: "",
                longitude: "",
                errorStr: null,
                textContent: null,
                api: "",
                isShow: false
            };
        },
        methods: {

            // 위치찾기 btn click event
            findLocation() {
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
            },
            callKakaoApi() {

                this.findLocation();

                // localhost:8080/kakao/?
                // xLng=126.87880659999999&yLat=37.4730911&page=5&size=15&
                // sort=accuracy&cateCode=FD6&rad=500&query=맛집 

                var vm = this;
                var url = '/api/kakao/?';
                url += 'xLng' + vm.longitude + '&yLat' + vm.latitude;
                url += '&page=5&size=15&sort=accuracy&cateCode=FD6&rad=500&query=맛집';

                axios.get(url)
                    .then((res) => {
                        console.log(res);
                        vm.textContent = res;
                    })
            },
            showModal() {
                this.isShow = !this.isShow;
            }
        },
        mounted() {}
    };
</script>

<style scoped>
    @import '../components/css/layout.css';
</style>
