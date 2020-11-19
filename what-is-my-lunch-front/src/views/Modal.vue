<template type="text/x-template" id="modal-template">
    <transition name="modal">
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">
                    <div class="modal-header">
                        <slot name="header">
                            <h2>오늘의 식사는!</h2>
                        </slot>
                    </div>

                    <div class="modal-body">
                        <slot name="body">
                            <p class="res_name txt_red">{{local.place_name}}</p>
                            <div class="res_info">
                                <span><i class="la la-crosshairs"></i>{{local.distance}}</span>
                                <span><i class="la la-cutlery"></i>{{local.category_name}}</span>
                            </div>
                        </slot>
                    </div>

                    <div class="modal-footer ">
                        <!-- <slot name="footer"> -->
                        <div class="modal_btn_box">
                            <button class="wh_btn w_40" @click="callKakaoApi">
                                <a>다시!</a>
                            </button>
                            <button class="red_btn w_40">
                                <a href="sub_001.html">자세히</a>
                            </button>
                        </div>
                        <!-- </slot> -->
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>
<!--<template>
    <div id="ex1" class="modal">
        <div class="modal_tit_box">
            <h2>오늘의 식사는!</h2>
        </div>
        <div class="modal_con_box">
            <p class="res_name txt_red">청년다방</p>
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
</template>-->

<script>
export default {
    props: ['data'],
    data: function () {
        return { 
            local: this.data,
        }
    },
    methods: {
        callKakaoApi: function() {
            this.$emit('callKakaoApi');
        }
    }
};
</script>

<style></style>
