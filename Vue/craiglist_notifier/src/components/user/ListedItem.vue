<template>
  <div style="width: 100%;"  class="card  user-card col-md-12 col-lg-4 col-xs-12">
    <div class="card-block">
      <div class="user-card-image d-inline-block"><!--<img src="http://placehold.it/150x150" class="img-circle">-->
        <div :id="'carouselExampleFade'+id"  class="carousel slide carousel-fade" data-ride="carousel">
          <div class="carousel-inner">
            <div v-for="(image,index) in info.images" class="carousel-item" :class="{active : index === 0}">
              <img width="100%" height="225" focusable="false" preserveAspectRatio="xMidYMid slice" class="d-block w-100" :src="image.replace('600x450','300x300')"
                   alt="First slide">
            </div>


          </div>
          <a class="carousel-control-prev" :href="'#carouselExampleFade'+id" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" :href="'#carouselExampleFade'+id" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>


      </div>
      <div class="user-card-content text-nowrap  d-inline-block">
        <h5 class="card-title d-inline-flex">{{info.title.length < 25 ? info.title :  info.title.substring(0,20) + "..."}}</h5>
        <div class="card-text">{{info.location === "" ? "(Nearby areas)" : info.location}}</div>
        <div class="card-text dental-text font-weight-bold">{{info.price}}</div>
        <div class="card-text">{{getTime(info.postedAt)}}</div>
        <div class="card-text">{{getTotalTime(info.postedAt)}}</div>
        <hr>
        <button class="btn btn-primary" @click="openNewWindow(info.url)"

          >Learn More</button>
      </div>
    </div>
  </div>
</template>

<script>
  import moment from 'moment'

  export default {
    props : ["id","info"],
    methods : {
      openNewWindow (url) {
        console.log(url)
        let w = 600
        let h = 600
        let left = (screen.width - w) / 2;
        let top = (screen.height - h) / 4;

        console.log(left)
        console.log(top)

        window.open(url,
        'newwindow',
          'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left
        );
          return false;

      },
      getTime(time) {
        return moment(time).format('DD-MM-YYYY HH:mm A')
      },
      getTotalTime(time) {
        return this.msToTime(new Date() - moment(time))
      },
       msToTime(duration) {
          let milliseconds = parseInt((duration % 1000) / 100),
            seconds = Math.floor((duration / 1000) % 60),
            minutes = Math.floor((duration / (1000 * 60)) % 60),
            hours = Math.floor((duration / (1000 * 60 * 60)) % 24);

          hours = (hours < 10) ? "0" + hours : hours;
          minutes = (minutes < 10) ? "0" + minutes : minutes;
          seconds = (seconds < 10) ? "0" + seconds : seconds;

    return hours + " hour " + minutes + " minutes ago";
  }

    }

  }

</script>


<style scoped>

  .card:hover {
    background-color: #eaeeff;
  }



  .card.user-card {
    display: table;




  }
  .card-block {
    display: table-row;
  }
  .user-card-image {
    display: table-cell;
    vertical-align: middle;
    padding: 0px;

  }
  .user-card-content {
    display: table-cell;
    vertical-align: middle;
    padding: 0px;

  }

</style>
