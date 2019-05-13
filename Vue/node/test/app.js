
var express = require("express");
const craigslist = require('node-craigslist');



var app = express();

var bodyParser = require('body-parser');
app.use(bodyParser.json()); // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true })); // support encoded bodies


app.post("/prefSearch", (req, res, next) => {
    const list = [];

    console.log(req.body)

    var
        craigslist = require('node-craigslist'),
        client = new craigslist.Client({
        }),
        options = req.body.options
        /*{
            baseHost : '', // defaults to craigslist.org
            category : 'cta', // defaults to sss (all)
            maxPrice : '3000',
            minPrice : '2000',
            postedToday : true,
            hasImage : true,
            city: 'stlouis'
        }*/;

    client
        .search(options, req.body.search)
        .then((listings) => listings.forEach(   (l) => {
                list.push(
             client.details(l).then((r) => {
               // console.log(r)
                return r;
             }))

        } )).then(() => {
        Promise.all(list).then(values => {
            //console.log(values);
            res.json(values);
        });
        })

        .catch((err) => {
            console.error(err);
        });





});


app.post("/prefSearchPrice", (req, res, next) => {
    const list = [];

    console.log(req.body)

    var
        craigslist = require('node-craigslist'),
        client = new craigslist.Client({
        }),
        options = req.body.options
        /*{
            baseHost : '', // defaults to craigslist.org
            category : 'cta', // defaults to sss (all)
            maxPrice : '3000',
            minPrice : '2000',
            postedToday : true,
            hasImage : true,
            city: 'stlouis'
        }*/;

    client
        .search(options, req.body.search)
        .then((listings) => {
            // filtered listings (by price)
            res.json(listings)
        })
        .catch((err) => {
            console.error(err);
        });





});

app.listen(3000, () => {
    console.log("Server running on port 3000");
});
