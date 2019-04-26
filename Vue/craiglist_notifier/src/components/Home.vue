<template>

  <main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">Craigslist Notifier</h1>
      <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
      <p  v-if="getUser !== false">
        <router-link :to="'/user/'+getUserHashId.hashId + '/dashboard'" class="btn btn-primary my-2">Dashboard</router-link>
        <a href="#" class="btn btn-secondary my-2">Secondary action</a>
      </p>
    </div>
  </section>
    <hr>
    <section v-if="getUser !== false" class="jumbotron text-center">
      <div class="container">
        <h1 class="jumbotron-heading">Welcome Back!</h1>
        <h2 class="jumbotron-heading">{{getUser.firstName}} {{getUser.lastName}}</h2>

      </div>
    </section>

  </main>
</template>

<script>
  import {mapGetters} from 'vuex'

  export default {
    computed : {
      ...mapGetters([
        'getUser',
        'getUserHashId'
      ]),

      link() {
        console.log(this.getUserHashId.hashId)
        return {name : 'dashboard', param : {id : this.getUserHashId.hashId}}
      }


    }
  }


</script>

<style scoped>


  :root {
    --jumbotron-padding-y: 3rem;
  }

  .jumbotron {
    padding-top: var(--jumbotron-padding-y);
    padding-bottom: var(--jumbotron-padding-y);
    margin-bottom: 0;
    background-color: #fff;
  }
  @media (min-width: 768px) {
    .jumbotron {
      padding-top: calc(var(--jumbotron-padding-y) * 2);
      padding-bottom: calc(var(--jumbotron-padding-y) * 2);
    }
  }

  .jumbotron p:last-child {
    margin-bottom: 0;
  }

  .jumbotron-heading {
    font-weight: 300;
  }

  .jumbotron .container {
    max-width: 40rem;
  }

  footer {
    padding-top: 3rem;
    padding-bottom: 3rem;
  }

  footer p {
    margin-bottom: .25rem;
  }

  .form-inline > * {
    margin:0px 3px;
  }

  .box-shadow { box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05); }

</style>
