<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Vuex</h1>
                <app-result></app-result>
                <app-new-result></app-new-result>
                <hr>
                <app-counter></app-counter>
                <app-another-counter></app-another-counter>
                <hr>
                <input @input="updateValue" :value="getValue" type="text">
                <p>Value: {{getValue}}</p>


            </div>
        </div>
    </div>
</template>

<script>
    import Counter from './components/Counter.vue';
    import AnotherCounter from './components/AnotherCounter.vue';

    import Result from './components/Result.vue';
    import NewResult from './components/AnotherResult.vue'

    import {mapGetters} from 'vuex'

    export default {

        methods : {
            updateValue() {
                this.$store.dispatch('updateValue',event.target.value)
            }
        },

        computed : {
            ...mapGetters({
                getValue : 'value'
            })
        },
        components: {
            appCounter: Counter,
            appResult: Result,
            appNewResult : NewResult,
            appAnotherCounter : AnotherCounter
        }
    }
</script>

