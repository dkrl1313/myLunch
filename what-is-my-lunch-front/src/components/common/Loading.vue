<template>
    <div class="modal">
        <!-- line-size: 테두리두께, size: 원크기 -->
        <spinner class="spinner" :line-size="9" :size="90">
        </spinner>
    </div>
</template>

<script>
    import Spinner from 'vue-simple-spinner';

    export default {
        components: {
            Spinner,
        },
    };
</script>

<style>
    .modal {
        z-index: 99999;
    }
</style>
