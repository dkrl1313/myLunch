<template type="text/x-template" id="modal-template">
    <transition name="modal">
        <div class="modal-mask" @mousedown="close">
            <div class="modal-wrapper">
                <div class="modal-container" @mousedown.stop>
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
                        <div class="modal_btn_box">
                            <button class="wh_btn w_40" @click="callKakaoApi">
                                <a>다시!</a>
                            </button>
                            <button class="red_btn w_40" @click="openPlace">
                                <a>자세히</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>

<script>
export default {
    
    props: ['data'],

    data: function () {
        return { 
            local: this.data,
        }
    },

    methods: {
        callKakaoApi() {
            this.$emit('callKakaoApi');
        },

        close() {
            this.$emit('toggleModal');
        },

        openPlace() {
            window.open(
                this.local.place_url,
                '_blank' 
            );
        }
    }
};
</script>

<style></style>
