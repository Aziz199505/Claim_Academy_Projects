<template>
  <header>
    <div class="collapse bg-dark" id="navbarHeader">
      <div class="container">
        <div class="row">
          <div class="col-sm-8 col-md-7 py-4">
            <h4 class="text-white">About</h4>
            <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
          </div>
          <div class="col-sm-4 offset-md-1 py-4">
            <h4 class="text-white">Contact</h4>
            <ul class="list-unstyled">
              <li><a href="#" class="text-white">Follow on Twitter</a></li>
              <li><a href="#" class="text-white">Like on Facebook</a></li>
              <li><a href="#" class="text-white">Email me</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <nav class="navbar navbar-dark bg-dark box-shadow sticky-top justify-content-between">


      <form class="form-inline">
        <router-link class="btn btn-outline-success" to="/">Main</router-link>
        <router-link v-if="getUser !== false" class="btn btn-outline-success" :to="'/user/' + getUserHashId.hashId ">Home</router-link>
        <router-link v-if="getUser === false" class="btn btn-outline-success" to="/sign-in">Sign In</router-link>
        <button v-if="getUser !== false" @click="$store.dispatch('signOut')" class="btn btn-outline-success" >Sign Out</button>

        <router-link v-if="getUser === false" class="btn btn-outline-success" to="/sign-up">Sing Up</router-link>
      </form>




        <!--
                        <button class="btn btn-sm btn-outline-secondary" type="button">Smaller button</button>
                -->


      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>




    </nav>
  </header>
</template>

<script>
  import {mapGetters} from 'vuex'
  export default {
    computed : {
      ...mapGetters([
          'getUser',
        'getUserHashId'
      ])
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
