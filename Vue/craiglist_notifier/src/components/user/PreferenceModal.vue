<template>
  <div class="modal fade" id="modalAddCarForm" role="dialog" aria-labelledby="myModalLabel"
       aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">

        <div>



          <div class="modal-header text-center">
            <h4 class="modal-title w-100 font-weight-bold">Preferences</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>


          <div class="modal-body mx-3">

            <div class="md-form mb-4">

              <select name="category"  class="form-control selectpicker">
                <option v-for="(v,key) in category" :value="key">{{v}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">Category</label>

            </div>


            <div class="md-form mb-4">

              <select @change="onStateChange" name="states" v-model="selectedState"  class="form-control selectpicker">
                <option v-for="(v,key) in states" :value="key">{{v}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">State</label>

            </div>




            <div class="md-form mb-4">

              <select v-model="city" name="city"   class="form-control selectpicker capitalize">
                <option class="capitalize" v-for="(item,index) in onAreas" :value="item.Description">{{item.Description}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">City</label>
            </div>





            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input v-model="search" name="search" type="text" placeholder="Search anything..." id="orangeForm" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm">Search</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="maxPrice" v-model="minPrice" type="number"  min="0"  class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm">Min Price</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="minPrice" type="number" v-model="maxPrice"  min="0" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm">Max Price</label>
            </div>

            <div class="md-form mb-5 form-group">
              <input v-model="options" type="checkbox" name="hasImage" id="hasImage" value="hasImage" />
              <div class="btn-group">
                <label for="hasImage" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="hasImage" class="btn btn-outline-secondary active">
                  Has Image
                </label>
              </div>

              <input v-model="options" type="checkbox" name="notifyEmail" id="notifyEmail" value="notifyEmail" />
              <div class="btn-group">
                <label for="notifyEmail" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="notifyEmail" class="btn btn-outline-secondary active">
                  Notify Email
                </label>
              </div>

              <input v-model="options" type="checkbox" name="notifyText" id="notifyText" value="notifyText" />
              <div class="btn-group">
                <label for="notifyText" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="notifyText" class="btn btn-outline-secondary active">
                  Notify Text
                </label>
              </div>

            </div>


            <div v-if="options.includes('notifyEmail')" class="md-form mb-5 weekDays-selector">
              <h3>Email Options</h3>
              <hr>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="SUNDAY" id="weekday-sun-email"  class="weekday" />
              <label for="weekday-sun-email">S</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="MONDAY" id="weekday-mon-email"  class="weekday" />
              <label  for="weekday-mon-email">M</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="TUESDAY" id="weekday-tue-email"  class="weekday" />
              <label for="weekday-tue-email" >T</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="WEDNESDAY" id="weekday-wed-email"  class="weekday" />
              <label for="weekday-wed-email">W</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="THURSDAY"  id="weekday-thu-email" class="weekday" />
              <label for="weekday-thu-email">T</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="FRIDAY"  id="weekday-fri-email"   class="weekday" />
              <label for="weekday-fri-email">F</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="SATURDAY" id="weekday-sat-email"  class="weekday" />
              <label for="weekday-sat-email">S</label>
            </div>

            <div v-if="options.includes('notifyEmail')" class="md-form mb-5">
              <div v-for="(item,index) in optionsEmail">
                <p>{{item}} - From: <time-picker v-model="timeFrom"></time-picker> To: <time-picker v-model="timeTo"></time-picker>  <span><button @click="tags.push(timeFrom)" class="btn btn-sm btn-primary" >Add</button></span> </p>
                <vue-tags-input
                  v-model="tag"
                  :tags="tags"
                  @tags-changed="newTags => tags = newTags"
                />
              </div>
            </div>

            <div v-if="options.includes('notifyText')" class="md-form mb-5 weekDays-selector">
              <h3>Text Options</h3>
              <hr>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="SUNDAY" id="weekday-sun-text"  class="weekday" />
              <label for="weekday-sun-text">S</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="MONDAY" id="weekday-mon-text" class="weekday" />
              <label for="weekday-mon-text">M</label>
              <input v-model="optionsText"  type="checkbox" name="weekday-text" value="TUESDAY" id="weekday-tue-text" class="weekday" />
              <label for="weekday-tue-text" >T</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="WEDNESDAY" id="weekday-wed-text" class="weekday" />
              <label  for="weekday-wed-text">W</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="THURSDAY" id="weekday-thu-text" class="weekday" />
              <label for="weekday-thu-text">T</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="FRIDAY" id="weekday-fri-text" class="weekday" />
              <label for="weekday-fri-text">F</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="SATURDAY" id="weekday-sat-text"  class="weekday" />
              <label for="weekday-sat-text">S</label>
            </div>

            <div v-if="options.includes('notifyText')" class="md-form mb-5">

            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <textarea name="descp" class="form-control validate" rows="5" id="comment"></textarea>

              <label data-error="wrong" data-success="right" for="orangeForm">Description</label>
            </div>





<!--            <div class="md-form mb-5 text-center">
              <div class="checkbox">
                <label>
                  <input type="checkbox" onclick="ChangeShip()" href="#moreabout" data-toggle="collapse" aria-expanded="false" aria-controls="moreabout" class="form-control" id="chShipAdd" name="isNewSeller" value="newSeller">
                  New Seller
                </label>
              </div>

            </div>-->

          </div>
          <div class="modal-footer d-flex justify-content-center">
            <input type="submit" class="btn btn-deep-orange">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import {mapGetters} from 'vuex'
  import {CheckIcon} from 'vue-feather-icons'
  import VueTagsInput from '@johmun/vue-tags-input';

  export default {
    data() {
      return {
        timeTo : '12:00 AM',
        timeFrom : '12:00 PM',
        tag: '',
        tags: [],
        detailEmailOpt : [],
        detailTextOpt : [],
        optionsEmail : [],
        optionsText : [],
        options : [],
        search : "",
        maxPrice : 0,
        minPrice : 0,
        myCoords : {},
        selectedState : "AK",
        isLocation : false,
        city : "anchorage / mat-su",
        StreetAddress : "",
        State : "",
        Zip : "",
        ZipPlus : "",
        category : {
          'sss' : 'all',
          'ata' : 'antiques',
          'ppa' : 'appliances',
          'ara' : 'arts+crafts',
          'sna' : 'atvs/utvs/snow',
          'pta' : 'auto parts',
            'baa' : 'baby+kids',
          'bar' : 'barter',
          'haa' : 'beauty+hlth',
          'bip' : 'bike parts',
            'bia' : 'bikes',
          'bpa' : 'boat parts',
            'boo' : 'boats',
          'bka' : 'books',
          'bfa' : 'business',
          'cta' : 'cars+trucks',
          'ema' : 'cds/dvd/vhs',
          'moa' : 'cell phones',
            'cla' : 'clothes+acc',
          'cba' : 'collectibles',
          'syp' : 'computer parts',
            'sya' : 'computers',
          'ela' : 'electronics',
          'gra' : 'farm+garden',
          'zip' : 'free stuff',
            'fua' : 'furniture',
          'gms' : 'garage sales',
            'foa' : 'general',
          'hva' : 'heavy equipment',
            'hsa' : 'household',
          'jwa' : 'jewelry',
          'maa' : 'materials',
          'mpa' : 'motorcycle parts',
            'mca' : 'motorcycles',
          'msa' : 'music instr',
            'pha' : 'photo+video',
          'rva' : 'RVs',
          'sga' : 'sporting',
          'tia' : 'tickets',
          'tla' : 'tools',
          'taa' : 'toys+games',
          'vga' : 'video gaming',
            'waa' : 'wanted'
        },
        states : {
          'AK': 'Alaska',
          'AL': 'Alabama',
          'AR': 'Arkansas',
          'AZ': 'Arizona',
          'CA': 'California',
          'CO': 'Colorado',
          'CT': 'Connecticut',
          'DC': 'District of Columbia',
          'DE': 'Delaware',
          'FL': 'Florida',
          'GA': 'Georgia',
          'HI': 'Hawaii',
          'IA': 'Iowa',
          'ID': 'Idaho',
          'IL': 'Illinois',
          'IN': 'Indiana',
          'KS': 'Kansas',
          'KY': 'Kentucky',
          'LA': 'Louisiana',
          'MA': 'Massachusetts',
          'MD': 'Maryland',
          'ME': 'Maine',
          'MI': 'Michigan',
          'MN': 'Minnesota',
          'MO': 'Missouri',
          'MP': 'Northern Mariana Islands',
          'MS': 'Mississippi',
          'MT': 'Montana',
          'NA': 'National',
          'NC': 'North Carolina',
          'ND': 'North Dakota',
          'NE': 'Nebraska',
          'NH': 'New Hampshire',
          'NJ': 'New Jersey',
          'NM': 'New Mexico',
          'NV': 'Nevada',
          'NY': 'New York',
          'OH': 'Ohio',
          'OK': 'Oklahoma',
          'OR': 'Oregon',
          'PA': 'Pennsylvania',
          'PR': 'Puerto Rico',
          'RI': 'Rhode Island',
          'SC': 'South Carolina',
          'SD': 'South Dakota',
          'TN': 'Tennessee',
          'TX': 'Texas',
          'UT': 'Utah',
          'VA': 'Virginia',
          'VI': 'Virgin Islands',
          'VT': 'Vermont',
          'WA': 'Washington',
          'WI': 'Wisconsin',
          'WV': 'West Virginia',
          'WY': 'Wyoming'
        }
      }
    },
    methods : {
      onStateChange() {
        //console.log(this.selectedState)
      },
      distance(lat1, lon1, lat2, lon2) {
        let radlat1 = Math.PI * lat1/180
        let radlat2 = Math.PI * lat2/180
        let theta = lon1-lon2
        let radtheta = Math.PI * theta/180
        let dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
        if (dist > 1) {
          dist = 1;
        }
        dist = Math.acos(dist)
        dist = dist * 180/Math.PI
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344
        //if (unit=="N") { dist = dist * 0.8684 }
        return dist
      }
    },
    computed : {
    ...mapGetters([
        'getCors',
        'getRefAreas'
      ]),

      onAreas() {


          return this.getRefAreas.filter(e => {
            if(e.Region === this.selectedState) return e;
          })
      }

    },
    created() {
      this.$getLocation()
        .then(coor => {
          this.myCoords = coor
          //console.log(coor);
          axios.get(`${this.getCors}https://geoservices.tamu.edu/Services/ReverseGeocoding/WebService/v04_01/Rest/?lat=${coor.lat}&lon=${coor.lng}&apikey=6c436e1250d34ec9b621e9d30eee2c9a&format=json&notStore=false&version=4.10`).then((res) => {
            try {
              let addr = res.data.StreetAddresses[0]


              //console.log(addr)
              //this.city = addr.City
              this.StreetAddress = addr.StreetAddress
              this.State = addr.State
              this.selectedState = addr.State
              this.Zip = addr.Zip

              this.isLocation = true;

              //console.log(this.city);
            }
            catch(error) {
              console.error(error);
              // expected output: ReferenceError: nonExistentFunction is not defined
              // Note - error messages will vary depending on browser
            }
          })
            .catch((err) =>  {
              console.log(err)
            })
        });
    },
    components : {
      okIcon : CheckIcon
    },
    watch : {
      timeFrom(value) {
        console.log("Time changed! to: " + value)
      },
      selectedState(value) {

        if(this.isLocation) {
          //console.log("Location is working!")
          let myArea = this.getRefAreas.filter(e => {
            if (e.Region === value) return e;
          })

          //console.log(this.myCoords)
          let closest = myArea.map(e => {

            return this.distance(this.myCoords.lat, this.myCoords.lng, e.Latitude, e.Longitude)
          })
          //console.log(closest)
          let closestIndex = closest.indexOf(Math.min(...closest))
          this.city = myArea[closestIndex].Description

        }
      }
    }
  }
</script>

<style scoped>
  .capitalize { text-transform: capitalize; }
  .form-group input[type="checkbox"] {
    display: none;
  }

  .form-group input[type="checkbox"] + .btn-group > label span {
    width: 20px;
  }

  .form-group input[type="checkbox"] + .btn-group > label span:first-child {
    display: none;
  }
  .form-group input[type="checkbox"] + .btn-group > label span:last-child {
    display: inline-block;
  }

  .form-group input[type="checkbox"]:checked + .btn-group > label span:first-child {
    display: inline-block;
  }
  .form-group input[type="checkbox"]:checked + .btn-group > label span:last-child {
    display: none;
  }

  .weekDays-selector input {
    display: none!important;
  }

  .weekDays-selector input[type=checkbox] + label {
    display: inline-block;
    border-radius: 6px;
    background: #dddddd;
    height: 40px;
    width: 30px;
    margin-right: 3px;
    line-height: 40px;
    text-align: center;
    cursor: pointer;
  }

  .weekDays-selector input[type=checkbox]:checked + label {
    background: #2AD705;
    color: #ffffff;
  }

</style>
