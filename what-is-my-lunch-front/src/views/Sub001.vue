<template>
    <div class="all_wrap">
    <div class="wrap">
        <div class="header_wrap">
            <div class="header">
                <div class="hd_left">
                    <a v-on:click="home"><i class="la la-home"></i></a>
                </div>       
            </div>            
        </div>
        <div class="content_wrap01">           
            <div class="content">
                <div class="con_top">
                    <p class="res_name01 txt_red">청년다방</p>
                    <p class="res_point01">송파점</p>
                    <div class="ranking_box">
                        <span class="star_icon"><i class="la la-star"></i></span>
                        <span class="star_icon"><i class="la la-star"></i></span>
                        <span class="star_icon"><i class="la la-star"></i></span>
                        <span class="star_icon"><i class="la la-star-o"></i></span>
                        <span class="star_icon"><i class="la la-star-o"></i></span>
                    </div>
                    <div class="res_info01">
                        <span><i class="la la-crosshairs"></i>500M</span>
                        <span><i class="la la-cutlery"></i>분식</span>
                    </div>
                </div>
                
                <div class="map_box">

                </div>
                
            </div>      
        </div>
    </div>
</div>
</template>

<script>
export default {
    mounted() {
        window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
    },
    methods: {
        home() {
            this.$router.push('/');
        },
         addKakaoMapScript() {
            const script = document.createElement("script");
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
                // "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=" + constants1.APIKEY;
            document.head.appendChild(script);
        },
        initMap() {
            var container = document.getElementById("map_box"); //지도를 담을 영역의 DOM 레퍼런스
            var options = {
                //지도를 생성할 때 필요한 기본 옵션
                center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
                level: 3 //지도의 레벨(확대, 축소 정도)
            };
            var map_box = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        }
    }
};
</script>

<style scoped>
@import "../components/css/layout.css";
</style>
