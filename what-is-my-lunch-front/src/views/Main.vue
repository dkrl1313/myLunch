<template>
    <div>
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
                                    <a><button class="random_btn" @click="toggleModal">랜덤<br />선택</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <modal 
            :data="data" 
            v-show="isShow" 
            @callKakaoApi="callKakaoApi" 
            @toggleModal="toggleModal"/>
    </div>
</template>

<script>
import axios from "axios";
import Modal from "./Modal";

export default {

    name: "Main",

    components: {
        Modal
    },

    created() {
        this.findLocation();
    },

    data() {
        return {
            latitude: "",
            longitude: "",
            errorStr: null,
            textContent: null,
            api: "",
            isShow: false,  
            documents: [],
            status: "",
            data: {
                place_name: "",
                address_name: "",
                distance: "",
                category_name: ""
            }
        };
    },

    methods: {
        toggleModal() {
            this.isShow = !this.isShow;
            if (this.isShow) this.callKakaoApi();
        },

        findLocation() {
            if (!("geolocation" in navigator)) {
                this.textContent = "Geolocation is not available.";
                return;
            }
            this.textContent = "Locating...";
            navigator.geolocation.getCurrentPosition(
                pos => {
                    this.latitude = pos.coords.latitude;
                    this.longitude = pos.coords.longitude;
                    this.textContent =
                        "lat: " + this.latitude + ", lng: " + this.longitude;

                    this.callKakaoApi();
                },
                err => {
                    alert(this.textContent = err.message);
                }
            );
        },

        callKakaoApi() {
            var vm = this;
            var ranNum = Math.floor(Math.random() * 16);

            axios({
                method: "GET",
                url: "/api/kakao/",
                params: {
                    xLng: vm.longitude,
                    yLat: vm.latitude,
                    page: 5,
                    size: 15,
                    sort: "accuracy",
                    cateCode: "FD6",
                    rad: "500",
                    query: "맛집"
                }
            })
                .then(res => {
                    vm.status = res.data.status;
                    vm.documents = res.data.documents[ranNum];
                    vm.data.address_name = vm.documents.address_name;
                    vm.data.place_name = vm.documents.place_name;
                    vm.data.category_name = vm.documents.category_name;
                    vm.data.distance = vm.documents.distance + "M";
                    vm.data.place_url = vm.documents.place_url;
                })
                .catch(e => {
                    console.log("ERR: ", e);
                });
        }
    },
    
    mounted() {}
};
</script>

<style scoped>
@import "../components/css/layout.css";
</style>
