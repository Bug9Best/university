const express = require('express')
const router = express.Router()
var article = require('../public/json/article-db.json')

router.get('/', function (req, res) {
    var result = article;
    var searchFilter = req.query.search;

    if (searchFilter) {
        result = article.filter(item => {
            return item.title.toLowerCase().includes(searchFilter.toLowerCase()) || item.author.toLowerCase().includes(searchFilter.toLowerCase());
        });
    }

    var data = { article: result };
    res.render("index", data);
})

router.get('/blog/:id', (req, res) => {
    var id = req.params.id;
    var result = article.find(function (article) {
        return article.id == id;
    });
    var data = { article: result };
    res.render("detail", data);
})

module.exports = router